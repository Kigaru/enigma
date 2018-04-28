import java.util.Scanner;
import java.util.Random;

public class Menu {
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
                    encrypter();
                    break;
                case 2:
                    decrypter();
                    break;
                default:
                    break;
                case 0:
                    System.exit(0);
            }
        }
    }
    private int display() {
        try {
            System.out.println("choose:\n1)encrypt\n2)decrypt");
            return scan.nextInt();
        }
        catch (Exception e) {
            System.out.println("Invalid input\n");
            scan.nextLine();
        }
        return 5;
    }

    private void encrypter() {
        scan.nextLine();
        System.out.print("What message do you want to encrypt: ");
        String code = scan.nextLine();
        long seed = random.nextInt();
        System.out.println("\nYour seed is:\n"+seed+"\nKEEP IT SAFE IF YOU WANT TO DECRYPT LATER\nThe encrypted message is: \n"+ converter(code, seed,true)+"\n");
    }

    private String converter(String input, long seed, boolean encrypt) {
        StringBuilder outputBuilder = new StringBuilder();
        random.setSeed(seed);
        for(int i = 0; i < input.length(); i++) {
            char chara = input.toLowerCase().charAt(i);
            if(Character.isLetter(chara)) {
                int letterArray = alphabet.indexOf(chara);
                char convertedChar = 'a';
                if(encrypt == true)
                    convertedChar = replacer(letterArray,true);
                if(encrypt == false)
                    convertedChar = replacer(letterArray,false);
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
        if(encrypt==true)
            number = number + randomnumber;
        if(encrypt==false)
            number = number - randomnumber;
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
        return alphabet.charAt(number);
    }

    private void decrypter() {
        scan.nextLine();
        boolean validInput = false;
        while(!validInput) {
            try {
                System.out.print("Enter seed: ");
                seed = scan.nextLong();
                validInput=true;
            } catch (Exception e) {
                System.out.println("Invalid input, try again");
                scan.nextLine();
            }
        }
        scan.nextLine();
        System.out.print("What message do you want to decode: ");
        String code = scan.nextLine();
        System.out.println("The decoded message is: \n"+ converter(code, seed,false)+"\n");
    }
}
