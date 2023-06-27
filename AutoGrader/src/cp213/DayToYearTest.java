package cp213;


import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
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
public class DayToYearTest {
	
	private static int input;
	private int expected;
	@BeforeClass
	public static void beforeClass() {
		System.out.println();
		System.out.println("Testing dayToYear: ");
		System.out.println();
	}
	public DayToYearTest(int input, int expected) {
		this.input = input;
		this.expected = expected;
	}
	public int getInput() {
		return input;
	}
	@Parameterized.Parameters
	public static Collection<Object[]> variablesName() {
		return  Arrays.asList(new Object[][] {
			{730, 1981},
			{10000,2007},
			{0, 1980}
		});
	}

    // Your test methods go here
    @Test
    public void checkOriginYear() {
        System.out.println("  Test: daysToYear(" +  input  + ")" );
    	assertEquals(expected, Device.goodCode(input));
	}

}

