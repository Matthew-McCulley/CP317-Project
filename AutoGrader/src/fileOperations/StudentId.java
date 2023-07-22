package fileOperations;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class StudentId {
	
	public static String getStudentId() {
		boolean found = false;
		String id = "";
		String[] files = new String[5];
		files[0] = System.getProperty("user.dir") + File.separatorChar + "src" +File.separatorChar+ "cp213" +File.separatorChar+"Palindrome.java";
		files[1] = System.getProperty("user.dir") + File.separatorChar + "src" +File.separatorChar+ "cp213" +File.separatorChar+"Device.java";
		files[2] = System.getProperty("user.dir") + File.separatorChar + "src" +File.separatorChar+ "cp213" +File.separatorChar+"LeapYear.java";
		files[3] = System.getProperty("user.dir") + File.separatorChar + "src" +File.separatorChar+ "cp213" +File.separatorChar+"Encipher.java";
		files[4] = System.getProperty("user.dir") + File.separatorChar + "src" +File.separatorChar+ "cp213" +File.separatorChar+"Valid.java";


		for (int i = 0; i < 5; i++) {
			try (FileReader fileReader = new FileReader(files[i])) {
				try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
					String line;
					while ((line = bufferedReader.readLine()) != null) {
						if (line.startsWith("//id: ")) {
							for (Character c : line.toCharArray()) {
								if (Character.isDigit(c)) {
									id += c;
								}
							}
							found = true;
							break;
						}
					}
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
			if(found) {
				break;
			}
		}
		return id;
	}
	
	public static boolean checkIfFileExists() {
		boolean flag = true;
		String filePath = System.getProperty("user.dir") + File.separatorChar + "src" +File.separatorChar+ "cp213" +File.separatorChar+"Palindrome.java";
		try (FileReader fileReader = new FileReader(filePath)) {
			try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
			} catch (IOException e) {

				flag = false;
			}
		} catch (IOException e) {
			flag = false;
		}
		return flag;
	}

}
