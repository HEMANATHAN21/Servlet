package Temp;

import org.apache.pdfbox.pdmodel.PDDocument;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.nio.file.Files;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class PdfEncryptionExample {

    public static void main(String[] args) {
        // Paths
        String pdfFilePath = "D:\\STUDY MATERIALS\\JAVA\\FileHandling\\epfo.pdf";
        String encryptedFilePath = "D:\\STUDY MATERIALS\\JAVA\\FileHandling\\encrypted.pdf";
        String decryptedFilePath = "D:\\STUDY MATERIALS\\JAVA\\FileHandling\\decrypted.pdf";

        // Encryption key (you should use a more secure method to generate and manage your keys)
        String encryptionKey = "ThisIsASecretKey";

        // Encrypt PDF file
        encryptPdf(pdfFilePath, encryptedFilePath, encryptionKey);

        // Decrypt encrypted PDF file
        decryptPdf(encryptedFilePath, decryptedFilePath, encryptionKey);
    }

    private static void encryptPdf(String inputFilePath, String outputFilePath, String encryptionKey) {
        try {
            // Read PDF file into bytes
            byte[] pdfBytes = Files.readAllBytes(new File(inputFilePath).toPath());

            // Initialize cipher for encryption
            Cipher cipher = Cipher.getInstance("AES");
            SecretKeySpec secretKey = new SecretKeySpec(encryptionKey.getBytes(), "AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            // Encrypt PDF bytes
            byte[] encryptedPdfBytes = cipher.doFinal(pdfBytes);

            // Save encrypted bytes to file
            try (FileOutputStream fos = new FileOutputStream(outputFilePath)) {
                fos.write(encryptedPdfBytes);
                System.out.println("PDF file encrypted and saved successfully.");
            }

        } catch (IOException | NoSuchAlgorithmException | NoSuchPaddingException |
                InvalidKeyException | BadPaddingException | IllegalBlockSizeException e) {
            e.printStackTrace();
        }
    }

    private static void decryptPdf(String inputFilePath, String outputFilePath, String encryptionKey) {
        try {
            // Read encrypted bytes from file
            byte[] encryptedPdfBytes = Files.readAllBytes(new File(inputFilePath).toPath());

            // Initialize cipher for decryption
            Cipher cipher = Cipher.getInstance("AES");
            SecretKeySpec secretKey = new SecretKeySpec(encryptionKey.getBytes(), "AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);

            // Decrypt encrypted PDF bytes
            byte[] decryptedPdfBytes = cipher.doFinal(encryptedPdfBytes);

            // Save decrypted bytes to file
            try (FileOutputStream fos = new FileOutputStream(outputFilePath)) {
                fos.write(decryptedPdfBytes);
                System.out.println("Encrypted PDF file decrypted and saved successfully.");
            }

        } catch (IOException | NoSuchAlgorithmException | NoSuchPaddingException |
                InvalidKeyException | BadPaddingException | IllegalBlockSizeException e) {
            e.printStackTrace();
        }
    }
}

