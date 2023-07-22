package cp213;

//id: 200621370
public class LeapYear {

	public static void main(String args[]) {
		int year = 366; // Test year
		System.out.println("Enter a year: " + year);
		if (isLeapYear(year)) {
			System.out.println(year + " is a leap year.");
		} else {
			System.out.println(year + " is not a leap year.");
		}
	}

	/**
	 * Determines whether or not a year is a leap year.
	 *
	 * @param year The year to test (int > 0)
	 * @return true is year is a leap year, false otherwise.
	 */
	public static boolean isLeapYear(final int year) {
		return false;
	}

}