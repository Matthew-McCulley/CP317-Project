package cp213;
//id: 200621370

public class Device {
	public static final int ORIGINYEAR = 1980;

	public static void main(String args[]) {
		int days = 1; // Test number of days here
		int badYear = badCode(days);
		int goodYear = goodCode(days);
		System.out.println("badCode - Days: " + days + " Year: " + badYear);
		System.out.println("goodCode - Days: " + days + " Year: " + goodYear);
	}

	/**
	 * Supposedly calculates the year given days since ORIGINYEAR. Fails on a leap
	 * year.
	 * 
	 * @param days number of days since January 1, 1980 (int >= 0)
	 * @return the year given days
	 */
	public static int badCode(int days) {
		int year = ORIGINYEAR;

		while (days > 365) {
			if (cp213.LeapYear.isLeapYear(year)) {
				if (days > 366) {
					days -= 366;
					year += 1;
				}
			} else {
				days -= 365;
				year += 1;
			}
		}
		return year;
	}

	/**
	 * Correctly calculates the year given days since ORIGINYEAR.
	 * 
	 * @param days number of days since January 1, 1980 (int >= 0)
	 * @return the year
	 */
	public static int goodCode(int days) {
		int year = ORIGINYEAR;

		while (days > 365) {
			if (cp213.LeapYear.isLeapYear(year)) {
				if (days >= 366) { // Added equal sign here to ensure when days = 366 the year will increment.
					days -= 366;
					year += 1;
				}
			} else {
				days -= 365;
				year += 1;
			}
		}
		return year;
	}
}