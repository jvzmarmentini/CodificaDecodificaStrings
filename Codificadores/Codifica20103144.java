package Codificadores;

/**
 * Encryption algorithm based on Feistel Cipher
 * 
 * @see https://en.wikipedia.org/wiki/Feistel_cipher
 * @see https://www.youtube.com/watch?v=FGhj3CGxl8I&ab_channel=Computerphile
 */
public class Codifica20103144 implements Codifica {
    /**
     * TODO - optimize code - add javadoc
     */

    private static final int ROUNDS = 8;
    private String left, right, temp;
    private int[] key = { 1, 0, 1, 0, 0, 0, 1, 1 };

    @Override
    public String codifica(String str) {

        /**
         * todo improve: adding a character after the string to fix the odd-length issue
         * isnt the best way, but was the only i could think in the moment. can and must
         * be improved. tried to split the string into two, same length, bit arrays, but
         * didnt worked was expected...
         */
        if (str.length() % 2 != 0) {
            str += " ";
        }
        int strMid = str.length() / 2;
        left = str.substring(0, strMid);
        right = str.substring(strMid);

        for (int i = 1; i <= ROUNDS; i++) {
            temp = right;
            right = XOR(left, function(right, i));
            left = temp;
        }

        return left + "" + right;
    }

    @Override
    public String decodifica(String str) {
        int strMid = str.length() / 2;
        left = str.substring(0, strMid);
        right = str.substring(strMid);

        for (int i = ROUNDS; i >= 1; i--) {
            temp = left;
            left = XOR(right, function(left, i));
            right = temp;
        }

        if (str.substring(str.length() - 1) == "*") {
            right = right.substring(0, str.length() - 1);
        }

        return left + "" + right;
    }

    private String XOR(String a, String b) {
        String tempStr = "";
        for (int i = 0; i < a.length(); i++) {
            tempStr += (char) (a.charAt(i) ^ b.charAt(i));
        }
        return tempStr;
    }

    private String function(String str, int round) {
        String tempStr = "";
        for (int i = 0; i < str.length(); i++) {
            tempStr += (char) (str.charAt(i) + key[round - 1]);
        }
        return tempStr;
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