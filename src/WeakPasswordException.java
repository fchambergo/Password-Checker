
/**This class determines whether the given password by user is weak or not
 * @author frank
 *
 */
public class WeakPasswordException extends Exception{

	/**
	 * This constructor is the exception message
	 */
		public WeakPasswordException(){
			super("Password is OK but weak");
		}
		
	/**This method determines whether the password is weak or not
	 * 
	 * @param pw - string the needs to be checked for weakness
	 * @return true if password is greater than 5 characters but less than 10, false if it is not
	 */
		public static boolean checkWeakness(String pw){
			boolean weakness = false;
			
			if (pw.length()>5 && pw.length()<11){
				weakness = true;
			}
			return weakness;
		}
}
