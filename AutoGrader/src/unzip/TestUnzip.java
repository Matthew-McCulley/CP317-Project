package unzip;


import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class TestUnzip extends JFrame {
    private JLabel label;
    private JButton browseButton;
    private String zipFilePath;
    private String targetDirectory;

    public TestUnzip() {
        label = new JLabel("Please select a zip file that has 'Testing_Assignment' Substring in it.");
        browseButton = new JButton("Browse");

        browseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    zipFilePath = selectedFile.getAbsolutePath();
                    targetDirectory = System.getProperty("user.dir") + File.separatorChar + "testPackage" + File.separatorChar;

                    // Check if the selected file is named "Assignment_Submission.zip"
                    if (selectedFile.getName().contains("Testing_Assignment")) {
                        unzipJavaProject(zipFilePath, targetDirectory);
                        displayMessage("Java project extracted successfully.");

                        // Close the GUI window after processing
                        dispose();
                    } else {
                        displayMessage("File must contain a string of characters saying 'Testing_Assignment'.");
                    }
                }
            }
        });

        setLayout(new FlowLayout());
        add(label);
        add(browseButton);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Unzip Program");
        setSize(500, 120);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TestUnzip();
            }
        });
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
	
	public void displayMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

}
