
/**This class determines whether the password contains a digit or not
 * 
 * @author frank chambergo
 *
 */
public class NoDigitException extends Exception{
	
	/**This method determines whether the password contains a digit or not
	 * 
	 * @param pw - string that needs to be checked for digit
	 * @return true if string has digit, false if it does not
	 */

	public static boolean checkForDigits(String pw){
		boolean digit = false;
		for (int i = 0; i<pw.length(); i++){
			if (Character.isDigit(pw.charAt(i))){
				digit = true;
			}
		}
		return digit;
	}
	
	/**
	 * This constructor is the exception message
	 */
		public NoDigitException(){
			super("The password must contain at least one digit");
	}
		
		/** This method returns the password with digit error message
		 * 
		 * @param pw - password
		 * @return string with password and digit error message 
		 */
		public static String ExceptionMessage(String pw){
			return pw + " The password must contain at least one digit";
		}

		
}
