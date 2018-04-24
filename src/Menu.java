import java.util.Scanner;

public class Menu {//TODO 1)seed randomizer, 2) swap letter accordingly
    private String encryptedAlphabet = "lvxswdfguhjknbiopearycqztm";
    private final String alphabet = "abcdefghijklmnopqrstuvwxyz";
    private Scanner scan;

    public static void main(String[] args) {
        new Menu();
    }
    private Menu() {
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
        System.out.println("The encoded message is: \n"+ converter(code, alphabet, encryptedAlphabet)+"\n");
    }

    private String converter(String code, String input, String algorithm) { //TODO enigma doesn't behave that way, because encryptedAlphabet changes on each letter input
        StringBuilder outputBuilder = new StringBuilder();
        for(int i = 0; i < code.length(); i++) {
            char chara = code.toLowerCase().charAt(i);
            if(Character.isLetter(chara)) {
                int letterArray = input.indexOf(chara);
                char convertedChar = algorithm.charAt(letterArray);
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
        System.out.print("What message do you want to decode: ");
        String code = scan.nextLine();
        System.out.println("The decoded message is: \n"+ converter(code, encryptedAlphabet, alphabet)+"\n");
    }
}
