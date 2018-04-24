import java.util.Scanner;

public class Menu {//TODO 1)seed randomizer, 2) swap letter accordingly
    private String gibberish = "lvxswdfguhjknbiopearycqztm";
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
        System.out.println("The encoded message is: \n"+ a2g(code)+"\n");
    }
    private String a2g(String code) {
        String output = "";
        System.out.println("String length: " + code.length());
        output = avoidDupes(code, output, alphabet, gibberish);
        return output;
    }

    private String avoidDupes(String code, String output, String alphabet, String gibberish) {
        StringBuilder outputBuilder = new StringBuilder(output);
        for(int i = 0; i < code.length(); i++) {
            char chara = code.toLowerCase().charAt(i);
            if(Character.isLetter(chara)) {
                int letterArray = alphabet.indexOf(chara);
                char convertedChar = gibberish.charAt(letterArray);
                String convertedLetter = String.valueOf(convertedChar);
                outputBuilder.append(convertedLetter);
            }
            else {
                String convertedLetter = String.valueOf(chara);
                outputBuilder.append(convertedLetter);
            }
        }
        output = outputBuilder.toString();
        return output;
    }

    private void decoder() {
        scan.nextLine();
        System.out.print("What message do you want to decode: ");
        String code = scan.nextLine();
        System.out.println("The decoded message is: \n"+ g2a(code)+"\n");
    }
    private String g2a(String code) {
        String output = "";
        System.out.println("String length: " + code.length());
        output = avoidDupes(code, output, gibberish, alphabet);
        return output;
    }
}
