package Codificadores;

/**
 * Encryption algorithm based on Feistel Cipher
 * 
 * @see https://en.wikipedia.org/wiki/Feistel_cipher
 * @see https://www.youtube.com/watch?v=FGhj3CGxl8I&ab_channel=Computerphile
 */
public class Codifica20103144 implements Codifica {
    private static final int ROUNDS = 8;
    private String left, right, temp;
    private final int[] key = { 1, 0, 1, 0, 0, 0, 1, 1 };

    /**
     * Return a decrypted string using a Feistel Cipher based algorithm with a key
     * and number of rounds pre-determinated in the encrypted function.
     * 
     * @param String str to be encrypted
     * @return String encrypted
     */
    @Override
    public String codifica(String str) {
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

    /**
     * Return a encrypted string using a Feistel Cipher based algorithm. The key and
     * the number of rounds are final.
     * 
     * @param String str encrypted
     * @return String decrypted
     */
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

    /**
     * Return the logic operation XOR of two strings. Since the XOR is commutative,
     * doesnt matter the param order.
     * 
     * @param a First string
     * @param b Second string
     * @return XOR over First and Second strings
     */
    private String XOR(String a, String b) {
        String tempStr = "";
        for (int i = 0; i < a.length(); i++) {
            tempStr += (char) (a.charAt(i) ^ b.charAt(i));
        }
        return tempStr;
    }

    /**
     * Return a string applied on a key based scramble.
     * 
     * @param str   to be scrambled
     * @param round of encryption or decryption
     * @return String scrambled
     */
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