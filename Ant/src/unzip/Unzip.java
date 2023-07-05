package unzip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Unzip {

	public static void main(String[] args) {
		String zipFilePath = System.getProperty("user.dir") + "/testPackage/mccu4290_a01.zip"; // Destination directory for the
		String targetDirectory = System.getProperty("user.dir") + "/src/cp213";
		unzipJavaProject(zipFilePath, targetDirectory);
	}
	
	public static void unzipJavaProject(String zipFilePath, String targetDirectory) {
		byte[] buffer = new byte[1024];

		try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(zipFilePath))) {
			ZipEntry zipEntry = zipInputStream.getNextEntry();

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
