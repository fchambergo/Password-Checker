
/** This class determines whether the password contains a lowercase alphabetic character or not
 * 
 * @author frank chambergo
 *
 */
public class NoLowerAlphaException extends Exception{
	
	/**
	 * This constructor is the exception message
	 */
		public NoLowerAlphaException(){
			super("The password must contain at least one lowercase alphabetic letter");
	}
		/**This method determines whether the password contains a lowercase alphabetic character or not
		 * 
		 * @param pw - string that needs to be checked for lowercase alphabetic character
		 * @return true if it contains a lowercase character, false if it does not
		 */
		public static boolean checkForLowercase(String pw){
			boolean lower = false;
			for (int i = 0; i<pw.length(); i++){
				if (Character.isLowerCase(pw.charAt(i))){
					lower = true;
				}
			}
			return lower;
		}
		
		/**This method returns password with lowercase character error message
		 * 
		 * @param pw - password
		 * @return string with password and lowercase character error message
		 */
		public static String ExceptionMessage(String pw){
			return pw + " The password must contain at least one lowercase alphabetic letter";
		}

}
