package vigenere;

import java.util.Scanner;

public class vigenere {

    private static final String ALPHABET = "ABCÇDEFGĞHIİJKLMNOÖPRSŞTUÜVYZ0123456789";

    public static String encrypt(String message, String key) {
        StringBuilder encryptedText = new StringBuilder();
        int keyIndex = 0;

        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            if (ALPHABET.contains(String.valueOf(Character.toUpperCase(c)))) {
                int charIndex = ALPHABET.indexOf(Character.toUpperCase(c));
                int keyCharIndex = ALPHABET.indexOf(Character.toUpperCase(key.charAt(keyIndex)));
                int newIndex = (charIndex + keyCharIndex) % ALPHABET.length();
                if (Character.isUpperCase(c)) {
                    encryptedText.append(ALPHABET.charAt(newIndex));
                } else {
                    encryptedText.append(Character.toLowerCase(ALPHABET.charAt(newIndex)));
                }
                keyIndex = (keyIndex + 1) % key.length();
            } else {
                encryptedText.append(c);
            }
        }

        return encryptedText.toString();
    }

    public static String decrypt(String encryptedText, String key) {
        StringBuilder decryptedText = new StringBuilder();
        int keyIndex = 0;

        for (int i = 0; i < encryptedText.length(); i++) {
            char c = encryptedText.charAt(i);
            if (ALPHABET.contains(String.valueOf(Character.toUpperCase(c)))) {
                int charIndex = ALPHABET.indexOf(Character.toUpperCase(c));
                int keyCharIndex = ALPHABET.indexOf(Character.toUpperCase(key.charAt(keyIndex)));
                int newIndex = (charIndex - keyCharIndex + ALPHABET.length()) % ALPHABET.length();
                if (Character.isUpperCase(c)) {
                    decryptedText.append(ALPHABET.charAt(newIndex));
                } else {
                    decryptedText.append(Character.toLowerCase(ALPHABET.charAt(newIndex)));
                }
                keyIndex = (keyIndex + 1) % key.length();
            } else {
                decryptedText.append(c);
            }
        }

        return decryptedText.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Mesajı girin: ");
        String message = scanner.nextLine();

        System.out.print("Anahtar kelimeyi girin: ");
        String key = scanner.nextLine();

        String encryptedText = encrypt(message, key);
        System.out.println("Şifrelenmiş metin: " + encryptedText);

        String decryptedText = decrypt(encryptedText, key);
        System.out.println("Deşifrelenmiş metin: " + decryptedText);
    }
}