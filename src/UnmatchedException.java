
/**This class determines whether the passwords given by the users match or not
 * @author frank
 *
 */
public class UnmatchedException extends Exception{
	
	/**
	 * This constructor is the exception message
	 */
	public UnmatchedException(){
			super("The passwords do not match");
	}
	
	/**This method determines whether the passwords match or not
	 * 
	 * @param pass - first password 
	 * @param passConfirm - second password
	 * @return true if passwords match, false if they do not
	 */
	public static boolean checkMatch(String pass, String passConfirm) {
		boolean match = false;
		
		if (pass.equals(passConfirm)){
			match = true;
		}
		
		return match;
	}

}
