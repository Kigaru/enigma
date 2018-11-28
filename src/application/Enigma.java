package application;
import java.util.Random;

public class Enigma {
    private long seed;
    private final String alphabet = "`~!@#$%^&*_+-=1234567890;':\"|,./<>?abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ ";
    private Random random;
    private String code;

    public Enigma(long seed, String code) {
    	this.seed = seed;
    	this.code = code;
    }
    
    public String encrypter() {
    	random = new Random();
    	return converter(code, seed,true);
    }

    public String decrypter() {
    	random = new Random();
        return converter(code, seed,false);
    }
    
    private String converter(String input, long seed, boolean encrypt) {
        StringBuilder outputBuilder = new StringBuilder();
        random.setSeed(seed);
        for(int i = 0; i < input.length(); i++) {
            char chara = input.charAt(i);
            if(alphabet.matches("(.*)"+Character.toString(chara)+"(.*)")) {
                int letterArray = alphabet.indexOf(chara);
                char convertedChar = 'a';
                convertedChar = replacer(letterArray,encrypt);
                String convertedLetter = String.valueOf(convertedChar);
                outputBuilder.append(convertedLetter);
            }
            else {
                String convertedLetter = String.valueOf(chara);
                outputBuilder.append(convertedLetter);
            }
        }
        return outputBuilder.toString();
    }
    
    private char replacer(int number,boolean encrypt) {
        int randomnumber = random.nextInt();        
        number += encrypt ? randomnumber : -randomnumber;
        number = number % alphabet.length();
        if (number < 0) number += alphabet.length();
        return alphabet.charAt(number);
    }
}
