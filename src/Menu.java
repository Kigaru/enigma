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
        int seed = random.nextInt();
        System.out.println("\nYour seed is:\n"+seed+"\nKEEP IT SAFE IF YOU WANT TO DECODE LATER\nThe encoded message is: \n"+ converter(code, alphabet, seed)+"\n");
    }

    private String converter(String input, long seed) { //TODO enigma doesn't behave that way, because encryptedAlphabet changes on each letter input
        StringBuilder outputBuilder = new StringBuilder();
        random.setSeed(seed);
        for(int i = 0; i < input.length(); i++) {
            char chara = input.toLowerCase().charAt(i);
            if(Character.isLetter(chara)) {
                int letterArray = alphabet.indexOf(chara);
                char convertedChar = alphabet.charAt(letterArray+random.nextInt());//NEXT INT WHAT IS BOUND DUDE
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

    private void decoder() {
        scan.nextLine();
        System.out.print("Enter seed: ");
        long seed = scan.nextLong();
        System.out.print("What message do you want to decode: ");
        String code = scan.nextLine();
        System.out.println("The decoded message is: \n"+ converter(code, seed)+"\n");//random to level with master
    }
}
