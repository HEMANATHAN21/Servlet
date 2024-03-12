package Temp;

import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.io.ByteArrayInputStream;

public class PdfToBytes {
    public static void main(String[] args) {
        File pdfFile = new File("D:\\STUDY MATERIALS\\JAVA\\FileHandling\\epfo.pdf");

        try {
            byte[] pdfBytes = Files.readAllBytes(pdfFile.toPath());
            System.out.println("PDF file read into bytes successfully.");

            
            try (PDDocument document = PDDocument.load(new ByteArrayInputStream(pdfBytes))) {
                document.save("D:\\STUDY MATERIALS\\JAVA\\FileHandling\\epfobytes.pdf");
                System.out.println("PDF bytes converted back to file successfully.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
