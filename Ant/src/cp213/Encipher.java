package cp213;

public class Encipher {

    public static final String ALPHA = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final int ALPHA_LENGTH = ALPHA.length();

    public static void main(String[] args) {
        final String CIPHERTEXT = "AVIBROWNZCEFGHJKLMPQSTUXYD"; // for testing substitute method
        // test code here
        String s = "&&&***abc"; //Test string. 
        int shift = 26;
        System.out.println("Substitute method result: " + substitute(s, CIPHERTEXT));
        System.out.println("Shift method result: " + shift(s, shift));
    }

    /**
     * Encipher a string using a shift cipher.
     * 
     * @param s
     *            string to encipher
     * @param n
     *            the number of letters to shift
     * @return the enciphered string
     */
    public static String shift(String s, int n) {
    	s = s.toUpperCase(); //Set string to all caps 
    	String shiftString = ""; 
    	int numChar; //Numeric value of the character. 
    	char valueChar; //Shifted character. 
    	int shiftedCharVal; //Numeric value of the shifted character. 
    	
    	for (int i = 0; i < s.length(); ++i) { 
    		valueChar = s.charAt(i);
    		if (Character.isLetter(s.charAt(i))) {
    			numChar = (int) s.charAt(i); //determine the numeric value of the letter
    			//capital letters run from 65 to 90 
    			//Shift the letter by the value of n. 
    			shiftedCharVal = numChar + n;
    			
    			//If the value of shiftedCharVal is > 90 OR < 65. Need to have the value in this range. 
    			while (shiftedCharVal > 90 || shiftedCharVal < 65) {
    				if (shiftedCharVal > 90) {
    					shiftedCharVal -= 26;
    				}
    				else if (shiftedCharVal < 65) {
    					shiftedCharVal += 26;
    				}
    			}
    			valueChar = (char) shiftedCharVal; //Turn the value back into a character.
    		}
    		shiftString = shiftString + valueChar; //Add the value to the string. 
    	}
    	
        return shiftString; 
    }

    /**
     * Encipher a string using the letter positions in ciphertext.
     * 
     * @param s
     *            string to encipher
     * @param ciphertext
     *            ciphertext alphabet
     * @return the enciphered string
     */
    public static String substitute(String s, String ciphertext) {
    	String subString = "";
    	boolean charFound;
    	int alphaPosition; 
    	
    	s = s.toUpperCase();
    	
    	if (s.length() == 0) {
    		subString = ""; 
    	}
    	else {
    		for (int i = 0; i < s.length(); ++i) { 
    			//Determine if the character at position i is a letter
    			if (Character.isLetter(s.charAt(i))) {
    				charFound = false; //Set charFound as false.
    				alphaPosition = 0; //Track moving through ALPHA. 
    				while (charFound == false && alphaPosition < ALPHA.length()) {
    					if (s.charAt(i) != ALPHA.charAt(alphaPosition)) {
    						alphaPosition += 1; 
    					} 
    					else { 
    						charFound = true; 
    					}
    				}
    				
    				subString = subString + ciphertext.charAt(alphaPosition); 
    			}
    			else {
    				subString = subString + s.charAt(i); //Add characters that are not ciphered to the ciphered string. 
    			}
    		}
    			
    	}
    	
    	return subString;
    }

}