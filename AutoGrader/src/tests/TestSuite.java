package tests;
import fileOperations.StudentId;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.runner.Description;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.spire.doc.documents.*;

import exportResults.CsvOutput;

import com.spire.doc.*;

@RunWith(Suite.class)
@SuiteClasses({ DayToYearTest.class, ShiftTest.class, SubstituteTest.class, IsLeapYearTest.class,
		IsPalindromeTest.class, IsValidTest.class })

public class TestSuite {
	public static void main(String[] args) {
		String studentId = "";
		JUnitCore junit = new JUnitCore();
		TestResultListener listener = new TestResultListener();
		
		//get student id
		boolean flag = StudentId.checkIfFileExists();
		if (flag) {
			studentId = StudentId.getStudentId();
		}

		Document document = new Document();
		
		//outputStream to capture output to console
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

		//printStream that writes to output stream
		PrintStream printStream = new PrintStream(outputStream);

		//put System.out.print to customePrint Stream
		System.setOut(printStream);

		//start running tests
		junit.addListener(listener);
		Result result = junit.run(TestSuite.class);
		listener.printTestResults(result);

		// put System.out.print back to original setting
		System.setOut(System.out);

		//get that ByteArray to String
		String consoleOutput = outputStream.toString();

		// append to the Word document
		Section section = document.addSection();
		Paragraph paragraph = section.addParagraph();
		paragraph.setText(consoleOutput);

		//save
		int index = args[0].indexOf("testPackage" + File.separatorChar) + ("testPackage" + File.separatorChar).length();
		String markedFileName = args[0].substring(index);
		markedFileName += " marked";
		document.saveToFile(System.getProperty("user.dir") +File.separatorChar +"markedFiles" + File.separatorChar + markedFileName + ".docx",
				FileFormat.Docx);

		//writing to csv
		if (flag) {
			try {
				System.out.println(studentId);
				CsvOutput.writeMarkToFile(listener.passedTests, studentId);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static class TestResultListener extends RunListener {
		private int totalTests;
		private int passedTests;
		private int failedTests;
		public ArrayList<Failure> failures;
		
		
		@Override
		public void testFailure(Failure failure) throws Exception {
			
			if (failures == null) {
				failures = new ArrayList<Failure>();
			}
			
			failures.add(failure);
			failedTests++;
			
			System.out.println("    " + failure.getMessage());
		}

		@Override
		public void testFinished(Description description) throws Exception {
			boolean flag = true;

			if (failures != null) {
				for (Failure failure : failures) {
					if (failure.getDescription().equals(description)) {
						flag = false;
					}
				}
			}

			if (flag) {
				System.out.println("	 Ok");
			}
			totalTests++;
		}

		public void printTestResults(Result result) {
			passedTests = totalTests - failedTests;
			System.out.println(" ");
			System.out.println("Total: " + passedTests + "/" + totalTests);
		}
	}
}