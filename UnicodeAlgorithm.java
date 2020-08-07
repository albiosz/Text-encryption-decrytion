public class UnicodeAlgorithm implements Algorithm {
    @Override
    public String decrypt(String toDecrypt, int key) {
        char[] decrypted = toDecrypt.toCharArray();
        for (int i = 0; i < decrypted.length; i++) {
            decrypted[i] = (char) (decrypted[i] - key);
        }
        return String.valueOf(decrypted);
    }

    @Override
    public String encrypt(String toEncrypt, int key) {
        char[] encrypted = toEncrypt.toCharArray();
        for (int i = 0; i < encrypted.length; i++) {
            encrypted[i] = (char) (encrypted[i] + key);
        }
        return String.valueOf(encrypted);
    }
}
