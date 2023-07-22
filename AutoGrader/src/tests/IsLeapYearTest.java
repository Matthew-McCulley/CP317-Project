package tests;


import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import cp213.LeapYear;

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
public class IsLeapYearTest {
	
	private static int input;
	private boolean expected;
	
	public IsLeapYearTest(int input, boolean expected) {
		this.input = input;
		this.expected = expected;
	}
	public int getInput() {
		return input;
	}
	@BeforeClass
	public static void beforeClass() {
		System.out.println();
		System.out.println("Testing isLeapYear: ");
		System.out.println();

	}
	@Parameterized.Parameters
	public static Collection<Object[]> variablesName() {
		return  Arrays.asList(new Object[][] {
			{1212, true},
			{1700, false},
			{1997, false},
			{2000, true}
		});
	}
    // Your test methods go here
    @Test
    public void checkLeapYear() {
        System.out.println("  Test: isLeapyear("  +  input + ")" );
    	assertEquals(expected, LeapYear.isLeapYear(input));
	}
}

