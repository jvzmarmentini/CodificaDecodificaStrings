package Codificadores;

/**
 * Encryption algorithm based on Feistel Cipher
 * 
 * @see https://en.wikipedia.org/wiki/Feistel_cipher
 * @see https://www.youtube.com/watch?v=FGhj3CGxl8I&ab_channel=Computerphile
 */
public class Codifica20103144 implements Codifica {
    private static final int ROUND = 8;
    private char[] left, right, temp;
    private int key = 1;

    @Override
    public String codifica(String str) {
        String enc = "";

        left = str.substring(0, str.length() / 2).toCharArray();
        right = str.substring(str.length() / 2).toCharArray();

        for (int i = 1; i <= ROUND; i++) {
            for (int j = 0; j < right.length; j++) {
                left[j] ^= applyKey(right[j], key, i);
            }
            temp = left;
            left = right;
            right = temp;
        }

        for (char c : left) {
            enc += c;
        }
        for (char c : right) {
            enc += c;
        }

        return enc;
    }

    @Override
    public String decodifica(String str) {
        String dec = "";

        left = str.substring(0, str.length() / 2).toCharArray();
        right = str.substring(str.length() / 2).toCharArray();

        for (int i = ROUND; i >= 1; i--) {
            temp = left;
            left = right;
            right = temp;
            for (int j = 0; j < right.length; j++) {
                left[j] ^= applyKey(right[j], key, i);
            }
        }

        for (char c : left) {
            dec += c;
        }
        for (char c : right) {
            dec += c;
        }

        return dec;
    }

    private char applyKey(char c, int key, int round) {
        return (char) (c + key);
    }

    @Override
    public String getNomeAutor() {
        return "João Victor Zucco Marmentini";
    }

    @Override
    public String getMatriculaAutor() {
        return "20103144-0";
    }
}