package Decrypt;

import java.util.Scanner;

public class CaesarCipher {
    private static final String LETTERS = "abcçdefgğhıijklmnoöpqrsştuüvwxyz";

    public static String decrypt(String ciphertext, int shift) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < ciphertext.length(); i++) {
            char c = ciphertext.charAt(i);
            if (LETTERS.contains(String.valueOf(Character.toLowerCase(c)))) {
                int index = LETTERS.indexOf(Character.toLowerCase(c));
                int newIndex = (index - shift) % LETTERS.length();
                if (newIndex < 0) {
                    newIndex += LETTERS.length();
                }
                if (Character.isUpperCase(c)) {
                    result.append(Character.toUpperCase(LETTERS.charAt(newIndex)));
                } else {
                    result.append(LETTERS.charAt(newIndex));
                }
            } else if (Character.isDigit(c)) {
            	int asciiValue = (int) c - shift;
            	result.append((char) ((asciiValue - 48) % 123 + 48));
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Şifreli metni girin: ");
        String ciphertext = scanner.nextLine();

        System.out.print("Kaydırma miktarını girin: ");
        int shift = scanner.nextInt();

        String plaintext = decrypt(ciphertext, shift);
        System.out.println("Düz metin: " + plaintext);
    }
}