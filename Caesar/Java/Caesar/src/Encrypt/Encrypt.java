package Encrypt;
import java.util.Scanner;

public class Encrypt {
    private static final String LETTERS = "abcçdefgğhıijklmnoöpqrsştuüvwxyz";

    public static String encrypt(String plaintext, int shift) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < plaintext.length(); i++) {
            char c = plaintext.charAt(i);
            if (LETTERS.contains(String.valueOf(Character.toLowerCase(c)))) {
                int index = LETTERS.indexOf(Character.toLowerCase(c));
                int newIndex = (index + shift) % LETTERS.length();
                if (Character.isUpperCase(c)) {
                    result.append(LETTERS.charAt(newIndex));
                } else {
                    result.append(LETTERS.charAt(newIndex));
                }
            } else if (Character.isDigit(c)) {
                int asciiValue = (int) c + shift;
                result.append((char) ((asciiValue - 48) % 123 + 48));
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Düz metni girin: ");
        String plaintext = scanner.nextLine();

        System.out.print("Kaydırma miktarını girin: ");
        int shift = scanner.nextInt();

        String ciphertext = encrypt(plaintext, shift);
        System.out.println("Şifrelenmiş metin: " + ciphertext);
    }
}