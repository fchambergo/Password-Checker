
/**This class determines whether the password passes the length requirement or not
 * 
 * @author frank chambergo
 *
 */
public class LengthException extends Exception{
	
		/**
		 * This constructor is the exception message
		 */
		public LengthException(){
			super("The password must be at least 6 characters long");
		}
		
		/** This method returns password with the length error message
		 *
		 * @param pw - password
		 * @return string with password and length error message
		 */
		public static String ExceptionMessage(String pw){
			return pw + " The password must be at least 6 characters long";
		}
		
		/** This method determines whether the password passes the length requirement or not
		 * 
		 * @param pw - string that needs to be checked for length requirement
		 * @return true if password is less than 6 characters, false if not
		 */
		public static boolean checkLength(String pw){
			boolean length = false;
			
			if (pw.length() < 6){
				length = true;
			}
			
			return length;
		}

}
