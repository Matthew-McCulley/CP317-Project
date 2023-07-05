package tests;


import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import cp213.Valid;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Test;

@RunWith(Parameterized.class)
public class IsValidTest {
	
	private static String input;
	private boolean expected;
	@BeforeClass
	public static void beforeClass() {
		System.out.println();
		System.out.println("Testing isValid: ");
		System.out.println();

	}
	public IsValidTest(String input, boolean expected) {
		this.input = input;
		this.expected = expected;
	}
	public String getInput() {
		return input;
	}
	@Parameterized.Parameters
	public static Collection<Object[]> variablesName() {
		return  Arrays.asList(new Object[][] {
			{"", false},
			{"9startWithNumber", false},
			{"_startWithUnderscore", true},
			{"specialCharacter!", false},
			{"s", true},
			{"numberInVariableName1", true},
			{"UnderscoreInName_", true}
		});
	}


    // Your test methods go here
    @Test
    public void checkValid() {
        System.out.println("  Test: isValid(" + '"' +  input + '"' + ")" );
    	assertEquals(expected, Valid.isValid(input));
	}
    
}

