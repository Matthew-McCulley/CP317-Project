package tests;


import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import cp213.Palindrome;

import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.Description;
import org.junit.runners.JUnit4;

@RunWith(Parameterized.class)
public class IsPalindromeTest {
	
	private static String input;
	private boolean expected;
	@BeforeClass
	public static void beforeClass() {
		System.out.println();
		System.out.println("Testing isPalindrome: ");
		System.out.println();

	}
	public IsPalindromeTest(String input, boolean expected) {
		this.input = input;
		this.expected = expected;
	}
	public String getInput() {
		return input;
	}
	@Parameterized.Parameters
	public static Collection<Object[]> variablesName() {
		return  Arrays.asList(new Object[][] {
			{"", true},
			{"racecar", true},
			{"A man, a plan, a canal, Panama!", true},
			{"atTa", true},
			{"s", true},
			{"not palindrome", false},
		});
	}

    // Your test methods go here
    @Test
    public void checkPalindrome() {
        System.out.println("  Test: isPalindrome(" + '"' +  input + '"' + ")" );
    	assertEquals(expected, Palindrome.isPalindrome(input));
	}
}
