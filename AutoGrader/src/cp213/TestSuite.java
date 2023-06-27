package cp213;
import java.util.ArrayList;

import org.junit.runner.Description;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

//import cp213.ValidTest.TestResultListener;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ DayToYearTest.class, ShiftTest.class,SubstituteTest.class, IsLeapYearTest.class, IsPalindromeTest.class, IsValidTest.class})

public class TestSuite {
    public static void main(String[] args) {
    	JUnitCore junit = new JUnitCore();
        TestResultListener listener = new TestResultListener();
        junit.addListener(listener);
    	// Run the test suite
        Result result = junit.run(TestSuite.class); 
        listener.printTestResults(result);
    }
    
    
    
    public static class TestResultListener extends RunListener {
        private int totalTests;
        private int passedTests;
        private int failedTests;
    	public ArrayList<Failure> failures;
        @Override
        public void testStarted(Description description) throws Exception {
        }

        @Override
        public void testFailure(Failure failure) throws Exception {
        	if(failures == null) {
        		failures = new ArrayList<Failure>();
        	}
        	failures.add(failure);
        	failedTests++;
        	System.out.println("    " + failure.getMessage());
        }
        @Override
        public void testFinished(Description description) throws Exception {
        	boolean flag = true;
        	
        	if(failures != null) {
	        	for (Failure failure : failures) {
	        		if(failure.getDescription().equals(description)) {
	        			flag = false;
	        		}
	        	}
        	}
        	
        	if(flag) {
        		System.out.println("	 Ok");
        	}
        	totalTests++;
        }

        public void printTestResults(Result result) {
        	passedTests = totalTests-failedTests;
        	System.out.println();
        	System.out.println("Total: " + passedTests + "/" + totalTests);
        }
    } 
}