package unzip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import com.spire.doc.*;
import com.spire.doc.documents.*;
 

public class Unzip {

	public static void main(String[] args) {
        String zipFilePath = args[0]; // Destination directory for the
        String targetDirectory = System.getProperty("user.dir") +  File.separatorChar + "src" + File.separatorChar + "cp213";
        

        System.out.println(zipFilePath);
        System.out.println(targetDirectory);
        // Proceed with the rest of the code
        unzipJavaProject(zipFilePath, targetDirectory);

        int index = zipFilePath.indexOf("testPackage" + File.separatorChar) + ("testPackage" + File.separatorChar).length();
        String markedFileName = zipFilePath.substring(index);
        markedFileName += " marked";
        System.out.println(markedFileName);
        Document document = new Document();
        Section section = document.addSection();
        Paragraph paragraph = section.addParagraph();
		document.saveToFile(System.getProperty("user.dir") + File.separatorChar+ "markedFiles"+ File.separatorChar + markedFileName + ".docx", FileFormat.Docx);
    }

    public static void unzipJavaProject(String zipFilePath, String targetDirectory) {
        byte[] buffer = new byte[1024];

        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(zipFilePath))) {
            ZipEntry zipEntry = zipInputStream.getNextEntry();
            System.out.println(zipEntry.toString());
            while (zipEntry != null) {
                String fileName = new File(zipEntry.getName()).getName();
                if (fileName.contains("Device.java") || fileName.contains("Encipher.java")
                        || fileName.contains("LeapYear.java") || fileName.contains("Palindrome.java")
                        || fileName.contains("Valid.java")) {
                    File newFile = new File(targetDirectory + File.separator + fileName);
                    System.out.println(fileName);

                    // Create directories if the entry is a directory
                    if (zipEntry.isDirectory()) {
                        newFile.mkdirs();
                    } else {
                        // Create parent directories if they don't exist
                        // new File(newFile.getParent()).mkdirs();

                        // Extract the file
                        try (FileOutputStream outputStream = new FileOutputStream(newFile)) {
                            int length;
                            while ((length = zipInputStream.read(buffer)) > 0) {
                                outputStream.write(buffer, 0, length);
                            }
                        }
                    }
                }
                zipEntry = zipInputStream.getNextEntry();
            }
            System.out.println("Java project extracted successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
