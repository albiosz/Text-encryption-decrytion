public class ShiftAlgorithm implements Algorithm {
    @Override
    public String decrypt(String toDecrypt, int key) {
        char[] decrypted = toDecrypt.toCharArray();
        for (int i = 0; i < decrypted.length; i++) {
            if (decrypted[i] >= 'a' && decrypted[i] <= 'z') {
                decrypted[i] = (char) (Math.floorMod(decrypted[i] - 'a' - key, 26) + 'a');
            }
            else if (decrypted[i] >= 'A' && decrypted[i] <= 'Z') {
                decrypted[i] = (char) (Math.floorMod(decrypted[i] - 'A' - key, 26) + 'A');
            }
        }
        return String.valueOf(decrypted);
    }

    @Override
    public String encrypt(String toEncrypt, int key) {
        char[] encrypted = toEncrypt.toCharArray();
        for (int i = 0; i < encrypted.length; i++) {
            if (encrypted[i] >= 'a' && encrypted[i] <= 'z') {
                encrypted[i] = (char) ((encrypted[i] - 'a' + key) % 26 + 'a');
            }
            else if (encrypted[i] >= 'A' && encrypted[i] <= 'Z') {
                encrypted[i] = (char) ((encrypted[i] - 'A' + key) % 26 + 'A');
            }
        }
        return String.valueOf(encrypted);
    }
}
