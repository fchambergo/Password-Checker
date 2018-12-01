import java.util.ArrayList;
import java.util.Arrays;

/**This class checks the password given by the user or checks the passwords from a file and determines its validity by
 * passing the password requirements.
 * 
 * @author frank chambergo
 *
 */
public class PasswordCheckerUtility {
	
	/**This constructor is implemented based on provided javadoc
	 * 
	 */
	public PasswordCheckerUtility(){
		
	}
	
	/**This method checks if the given password passes each password requirement and returns true if it do so.
	 * It returns false if the given password fails one password requirement and throws the exception of the failed requirement
	 * 
	 * @param passwordString - string to be checked for validity
	 * @return true if valid password (follows all rules from above), false if an invalid password
	 * @throws LengthException - thrown if length is less than 6 characters
	 * @throws NoDigitException - thrown if no digit
	 * @throws NoUpperAlphaException - thrown if no uppercase alphabetic
	 * @throws NoLowerAlphaException - thrown if no lowercase alphabetic
	 * @throws InvalidSequenceException - thrown if more than 2 of same character
	 */
	public static boolean isValidPassword(String passwordString)throws LengthException, NoDigitException, NoUpperAlphaException,
	NoLowerAlphaException, InvalidSequenceException {
	
		boolean valid = false;
		String pw = passwordString;
		
			if (LengthException.checkLength(pw)){
				throw(new LengthException());
			}
			else if (!(NoDigitException.checkForDigits(pw))){
				throw (new NoDigitException());
			}
			else if (!(NoUpperAlphaException.checkForUppercase(pw))){
				throw (new NoUpperAlphaException());
			}
			else if (!(NoLowerAlphaException.checkForLowercase(pw))){
				throw(new NoLowerAlphaException());
			}
			else if ((InvalidSequenceException.checkSequence(pw))){
				throw (new InvalidSequenceException());
			}
			else
				valid = true;
			
		return valid;
	}
		
	/**This method determines if the given password by user is a weak password or not.
	 * A password is weak if its length is between 6 and 10 characters. 
	 * 
	 * @param passwordString - string to be checked if weak password
	 * @return true if length of password is greater than 5 but less than 10
	 */
	public static boolean isWeakPassword(String passwordString) {
		
		boolean length;
	
			if (passwordString.length()>5 && passwordString.length()<11){
				length = true;
			}
			else
				length = false;
			
		return length;
		
	}
	
	/**This method reads an arraylist and determines if each password/line is an invalid password and adds
	 * it to this arraylist and then returns it. 
	 * 
	 * @param passwords - arraylist of passwords to check for validity
	 * @return arraylist of invalid passwords. It will return weak passwords in the ArrayList with the message "Password is OK but weak"
	 */
	public static ArrayList<String> validPasswords(ArrayList<String> passwords){
		
		ArrayList<String> list = new ArrayList<String>();

		for (String password: passwords){
			
			try {
				isValidPassword(password);
			} catch (LengthException e) {
				list.add(LengthException.ExceptionMessage(password));
			} catch (NoDigitException e) {
				list.add(NoDigitException.ExceptionMessage(password));
			} catch (NoUpperAlphaException e) {
				list.add(NoUpperAlphaException.ExceptionMessage(password));
			} catch (NoLowerAlphaException e) {
				list.add(NoLowerAlphaException.ExceptionMessage(password));
			} catch (InvalidSequenceException e) {
				list.add(InvalidSequenceException.ExceptionMessage(password));
			}
			
		}
		
		return list;
	}

	
}
