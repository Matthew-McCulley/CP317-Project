package unzip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
public class TestUnzip {

	public static void main(String[] args) {
		String zipFilePath = System.getProperty("user.dir") + "/test/Assignment_Submissions.zip"; // Destination directory for the
		String targetDirectory = System.getProperty("user.dir") + "/testPackage/";
		unzipJavaProject(zipFilePath, targetDirectory);
	}
	
	public static void unzipJavaProject(String zipFilePath, String targetDirectory) {
		byte[] buffer = new byte[1024];

		try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(zipFilePath))) {
			ZipEntry zipEntry = zipInputStream.getNextEntry();
			System.out.println(zipEntry.toString());
			while (zipEntry != null) {
				String fileName = new File(zipEntry.getName()).getName();
				if(fileName.endsWith("a01.zip"))
				{
					System.out.println(fileName);
					File newFile = new File(targetDirectory + File.separator + fileName);
					System.out.println(fileName);
					

					// Extract the file
					try (FileOutputStream outputStream = new FileOutputStream(newFile)) {
					int length;
					while ((length = zipInputStream.read(buffer)) > 0) {
							outputStream.write(buffer, 0, length);
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
