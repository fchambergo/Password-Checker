
/**This class determines whether the password contains an uppercase alphabetic character or not
 * @author frank chambergo
 *
 */
public class NoUpperAlphaException extends Exception{
	
	/**
	 * This constructor is the exception message
	 */

	public NoUpperAlphaException(){
			super("The password must contain at least one uppercase alphabetic letter");
		}

	/** This method determines whether the password contains an uppercase alphabetic character or not
	 * 
	 * @param pw  - string that needs to be checked for an uppercase character
	 * @return true if password contains uppercase character, false if it does not
	 */
	public static boolean checkForUppercase(String pw){
			boolean upper = false;
			for (int i = 0; i<pw.length(); i++){
				if (Character.isUpperCase(pw.charAt(i))){
					upper = true;
				}
			}
			return upper;
		}
		
	/**This method returns password with the uppercase character error
	 * 
	 * @param pw - string that needs to be checked for uppercase character
	 * @return string with password and uppercase error message
	 */
	public static String ExceptionMessage(String pw){
		return pw + " The password must contain at least one uppercase alphabetic letter";
	}
	
}
