public interface Algorithm {

    String decrypt(String toDecrypt, int key);

    String encrypt(String toDecrypt, int key);
}
