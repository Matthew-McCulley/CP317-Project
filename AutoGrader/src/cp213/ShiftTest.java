//package cp213;
//
//import static org.junit.Assert.*;
//
//import org.junit.Test;
//
//public class EncipherTest {
//
//	@Test
//	public void checkShiftABC0() {
//		assertEquals("ABC", Encipher.shift("ABC", 0));
//	}
//	
//	@Test
//	public void checkShiftABC3() {
//		assertEquals("DEF", Encipher.shift("ABC", 3));
//	}
//	
//	@Test
//	public void checkShiftABC30() {
//		assertEquals("EFG", Encipher.shift("ABC", 30));
//	}
//	
//	@Test
//	public void checkSubstituteABC() {
//		assertEquals("AVI", Encipher.substitute("ABC", "AVIBROWNZCEFGHJKLMPQSTUXYD"));
//	}
//	
//	@Test
//	public void checkSubstituteXYZ() {
//		assertEquals("XYD", Encipher.substitute("XYZ", "AVIBROWNZCEFGHJKLMPQSTUXYD"));
//	}
//
//}

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
public class ShiftTest {
	
	private static String firstInput;
	private static int secondInput;
	private String expected;
	@BeforeClass
	public static void beforeClass() {
		System.out.println();
		System.out.println("Testing shift: ");
		System.out.println();

	}
	public ShiftTest(String firstInput, int secondInput, String expected) {
		ShiftTest.firstInput = firstInput;
		ShiftTest.secondInput = secondInput;
		this.expected = expected;
	}
	@Parameterized.Parameters
	public static Collection<Object[]> variablesName() {
		return  Arrays.asList(new Object[][] {
			{"B2", 12, "N2"},
			{"ABC", 3, "DEF"},
			{"Z", 1, "A"},
		});
	}

    // Your test methods go here
    @Test
    public void checkShift() {
        System.out.println("  Test: shift("+  firstInput + ", " + secondInput +  ")" );
    	assertEquals(expected, Encipher.shift(firstInput, secondInput));
	}
}


