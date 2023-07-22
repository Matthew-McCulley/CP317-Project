package exportResults;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFeedback {
	public static void main(String[] args) {
		ZipOutputStream zos;
		String feedbackFolder = System.getProperty("user.dir") + File.separatorChar + "markedFiles"  + File.separatorChar;
		String destinationDirectory = System.getProperty("user.dir") + File.separatorChar + "Assignment 1 Bulk Feedback.zip";
		File folder = new File(feedbackFolder);

		try {
			zos = new ZipOutputStream(new FileOutputStream(destinationDirectory));
			for (File file : folder.listFiles()) {
				byte[] buffer = new byte[1024];
				try (FileInputStream fis = new FileInputStream(file)) {
					zos.putNextEntry(new ZipEntry(file.getName()));
					int length;
					while ((length = fis.read(buffer)) > 0) {
						zos.write(buffer, 0, length);
					}
					fis.close();
				}
				zos.closeEntry();
			}
			zos.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
