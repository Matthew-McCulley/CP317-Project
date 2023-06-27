package cp213;

public class Valid {

    public static void main(String args[]) {
        String name = "WoW!";
        System.out.println("Valid? " + isValid(name));
    }

    /**
     * Determines if name is a valid Java variable name. Variables names must
     * start with a letter or an underscore, but cannot be an underscore alone.
     * The rest of the variable name may consist of letters, numbers and
     * underscores.
     *
     * @param name
     *            a string to test as a Java variable name
     * @return true if name is a valid Java variable name, false otherwise
     */
    public static boolean isValid(final String name) {

    	boolean validName = true; //Assume the name is valid 
    	int i = 0; //Used to access elements of string. 
    	
    	if (name.length() == 0) {
    		validName = false;
    	}
    	
    	while (i < name.length() && validName != false) {
    		//Check if underscore is only value, or if the string starts with a digit. 
    		if ((name.charAt(0) == '_' && name.length() <= 1) || (Character.isDigit(name.charAt(0)))) {
    			validName = false; 
    		}
    		else {
    			//Check if the remaining characters are numbers, letters, and underscores. 
    			if (name.charAt(0) == '_' || Character.isLetter(name.charAt(0))) {
    				if (!(Character.isLetterOrDigit(name.charAt(i)) || name.charAt(i) == '_')) {
    					validName = false;
    				}
    			}
    		}
    		i += 1;
     	}
    	return validName;
    }
}