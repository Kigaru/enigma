import java.util.Scanner;
import java.util.Random;

public class Menu {//TODO 1)seed randomizer, 2) swap letter accordingly
    private long seed;
    private final String alphabet = "abcdefghijklmnopqrstuvwxyz";
    private Scanner scan;
    private Random random;

    public static void main(String[] args) {
        new Menu();
    }
    private Menu() {
        random = new Random();
        scan = new Scanner(System.in);
        while(true) {
            switch (display()) {
                case 1:
                    encoder();
                    break;
                case 2:
                    decoder();
                    break;
                default:
                    System.out.println("why not?");
                    break;
                case 0:
                    System.exit(0);
            }
        }
    }
    private int display() {
        System.out.println("choose:\n1)encode\n2)decode");
        return scan.nextInt();
    }

    private void encoder() {
        scan.nextLine();
        System.out.print("What message do you want to encode: ");
        String code = scan.nextLine();
        long seed = random.nextInt();
        System.out.println("\nYour seed is:\n"+seed+"\nKEEP IT SAFE IF YOU WANT TO DECODE LATER\nThe encoded message is: \n"+ converter(code, seed,true)+"\n");
    }

    private String converter(String input, long seed, boolean encode) { //TODO enigma doesn't behave that way, because encryptedAlphabet changes on each letter input
        StringBuilder outputBuilder = new StringBuilder();
        random.setSeed(seed);
        for(int i = 0; i < input.length(); i++) {
            char chara = input.toLowerCase().charAt(i);
            if(Character.isLetter(chara)) {
                int letterArray = alphabet.indexOf(chara);
                char convertedChar = 'a';
                if(encode == true)
                    convertedChar = replacer(letterArray,true);//NEXT INT WHAT IS BOUND DUDE
                if(encode == false)
                    convertedChar = replacer(letterArray,false);//NEXT INT WHAT IS BOUND DUDE
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

    private char replacer(int number,boolean encode) {
        System.out.println("a "+number);
        int randomnumber = random.nextInt();
        System.out.println("b "+randomnumber);
        if(encode==true)
            number = number + randomnumber;
        System.out.println("c "+number);
        if(encode==false)
            number = number - randomnumber;
        System.out.println("d "+number);
        ///////////fixme get better collection
        while(number>25 || number<0) {
            if (number > 25) {
                while (number > 25) {
                    number = number - 26;
                }
            }
            if (number<0) {
                while(number<0) {
                    number = number + 26;
                }
            }
        }
        ///////////////end
        return alphabet.charAt(number);
    }

    private void decoder() {
        scan.nextLine();
        System.out.print("Enter seed: ");
        random.setSeed(scan.nextLong());
        scan.nextLine();
        System.out.print("What message do you want to decode: ");
        String code = scan.nextLine();
        System.out.println("The decoded message is: \n"+ converter(code, seed,false)+"\n");//random to level with master
    }
}
