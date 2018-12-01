
/**This class checks the password for validity of an invalid sequence
 * 
 * @author frank chambergo
 *
 */
public class InvalidSequenceException extends Exception{
	
	/** This method determines whether the password has an invalid sequence or not
	 * 
	 * @param pw - string that needs to be checked for invalid sequence
	 * @return return true if string has invalid sequence, false if it does not
	 */

	public static boolean checkSequence(String pw){
		boolean seq = false;
		String[] letter = pw.split("");
			for(int i=0; i<letter.length-2;i++){
				if(letter[i].equals(letter[i+1]) && letter[i+1].equals(letter[i+2])){
					seq = true;
				}
			}
			return seq;
	}

	/**This constructor is the exception message
	 * 
	 */
		public InvalidSequenceException(){
			super("The password must contain more than two of the same character in sequence");
		}
		
		/** This method returns the password with the invalid sequence error message
		 * 
		 * @param pw - password
		 * @return string with password and invalid sequence error message
		 */
		public static String ExceptionMessage(String pw){
			return pw + " The password cannot contain more than two of the same character in sequence";
		}
}
