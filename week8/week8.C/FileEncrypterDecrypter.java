import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import java.io.*;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
public class FileEncrypterDecrypter {
    private final SecretKey secretKey;
    private final Cipher cipher;
    FileEncrypterDecrypter(SecretKey secretKey, String transformation) throws NoSuchPaddingException, NoSuchAlgorithmException {
        this.secretKey = secretKey;
        this.cipher = Cipher.getInstance(transformation);
    }
    void encrypt(String content, String fileName) throws IOException, InvalidKeyException {
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] iv = cipher.getIV();
        try (
                FileOutputStream fileOut = new FileOutputStream(fileName);
                CipherOutputStream cipherOut = new CipherOutputStream(fileOut, cipher);
                ) {
            fileOut.write(iv);
            cipherOut.write(content.getBytes());
        }
    }
    String decrypt(String fileName) throws IOException, InvalidAlgorithmParameterException, InvalidKeyException {
        String content = "";

        try (FileInputStream fileIn = new FileInputStream(fileName)) {
            byte[] fileIv = new byte[16];
            fileIn.read(fileIv);
            cipher.init(Cipher.DECRYPT_MODE, secretKey, new IvParameterSpec(fileIv));
            try (
                    CipherInputStream cipherIn = new CipherInputStream(fileIn, cipher);
                    InputStreamReader inputReader = new InputStreamReader(cipherIn);
                    BufferedReader reader = new BufferedReader(inputReader);
                    ) {
                StringBuilder object = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    object.append(line);
                }
                content = object.toString();
            }
        }
        return content;
    }
    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, IOException,InvalidKeyException, InvalidAlgorithmParameterException {
            String originalContent = "foobar";
            SecretKey secretKey = KeyGenerator.getInstance("AES").generateKey();

            FileEncrypterDecrypter fileEncrypterDecrypter = new FileEncrypterDecrypter(secretKey, "AES/CBC/PKCS5Padding");
            fileEncrypterDecrypter.encrypt(originalContent, "baz.enc");

            String decryptedContent = fileEncrypterDecrypter.decrypt("baz.enc");
            System.out.println("Decrypted content is: " + decryptedContent);
            new File("baz.enc").delete();
    }
}
