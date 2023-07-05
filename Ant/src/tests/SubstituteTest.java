package tests;


import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import cp213.Encipher;

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
public class SubstituteTest {
	
	private static String s;
	private static String cipherText;
	private String expected;
	@BeforeClass
	public static void beforeClass() {
		System.out.println();
		System.out.println("Testing substitute: ");
		System.out.println();

	}
	
	public SubstituteTest(String s, String cipherText, String expected) {
		SubstituteTest.s= s;
		SubstituteTest.cipherText = cipherText;
		this.expected = expected;
	}
	
	@Parameterized.Parameters
	public static Collection<Object[]> variablesName() {
		return  Arrays.asList(new Object[][] {
			{"@#%^$%^#$", "ABCDEFGHIJKLMCOPQRSTUV", "@#%^$%^#$"},
			{"ABC123", "ABCDEFGHIJKLMCOPQRSTUV", "ABC123"}
		});
	}

    // Your test methods go here
    @Test
    public void checkShift() {
        System.out.println("  Test: shift("+  s + ", " + cipherText +  ")" );
    	assertEquals(expected, Encipher.substitute(s, cipherText));
	}
}



