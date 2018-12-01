import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class GUIFX extends Application{
	
	TextField pwBox, pwBox2;
	Button checkPW, checkFile, exitButton, closeButton;
	String pass, passConfirm;
	
	public static void main(String[] args){
		launch(args);
	}	
	
	/** This class forms the outline displays the text, password entries and buttons on the screen when the program starts
	 * 
	 */
@Override
	public void start(Stage firstStage){
	GridPane grid = new GridPane();
	grid.setAlignment(Pos.CENTER);
	grid.setHgap(10);
	grid.setVgap(10);
	grid.setPadding(new Insets(25, 25, 25, 25));
	
	
	
	//Rules and description text
	Text sceneDescription = new Text("Use the following rules when creating your passwords");
	grid.add(sceneDescription, 0, 0, 2, 1);
	Text rule1 = new Text("1. Length must be greater than 6, a strong password will contain at least 10 characters.");
	grid.add(rule1, 1,1);
	Text rule2 = new Text("2. Must contain at least one upper case alpha character");
	grid.add(rule2, 1, 2);
	Text rule3 = new Text("3. Must contain at least one lower case alpha character");
	grid.add(rule3, 1, 3);
	Text rule4 = new Text("4. Must contain at least one numeric character");
	grid.add(rule4, 1, 4);
	Text rule5 = new Text("5. May not have more than 2 of the same character in sequence");
	grid.add(rule5, 1, 5);
	
	//Password label and first Password textfield
	Label password = new Label("Password");
	pwBox = new TextField();
	
	//Put password label and first password textfield in the center 
	HBox passPanel = new HBox(10);
	passPanel.getChildren().addAll(password, pwBox);
	passPanel.setPadding(new Insets(10));
	passPanel.setAlignment(Pos.CENTER);
	grid.add(passPanel, 1, 6);
	
	//Retype Password label and second Password textfield
	Label retypePW = new Label("Re-type\nPassword");
	pwBox2 = new TextField();
	
	//Put Retype Password label and second password textfield in the center under the first label and password
	HBox confirmPanel = new HBox(10);
	confirmPanel.getChildren().addAll(retypePW, pwBox2);
	confirmPanel.setPadding(new Insets(10));
	confirmPanel.setAlignment(Pos.CENTER);
	grid.add(confirmPanel, 1, 7);
	
	//Check Password box
	checkPW = new Button("_Check Password");
	checkPW.setMnemonicParsing(true);
	checkPW.setTooltip(new Tooltip("Select to print username and password"));
	
	//Check File box
	checkFile = new Button("Check Passwords in _File");
	checkFile.setMnemonicParsing(true);
	checkFile.setTooltip(new Tooltip("Select to check password in passwords file"));
	
	//Exit Button box
	exitButton = new Button("_Exit");
	exitButton.setMnemonicParsing(true);
	exitButton.setTooltip(new Tooltip("Select to close the application"));
	
	//Add all buttons to the bottom of the message box
	HBox hPane = new HBox(10);
	hPane.getChildren().addAll(checkPW,checkFile,exitButton);
	hPane.setPadding(new Insets(10));
	hPane.setAlignment(Pos.BOTTOM_CENTER);
	grid.add(hPane, 1, 8);
	
	//Perform action when button selected
	exitButton.setOnAction(new ButtonEventHandler());
	checkPW.setOnAction(new ButtonEventHandler());
	checkFile.setOnAction(new ButtonEventHandler());
	
	//Show on screen
	firstStage.setScene(new Scene(grid, 700, 500));
	firstStage.setTitle("Password Checker");
	firstStage.show();
	}

/** This class determines the action done for each button that is selected
 * 
 * @author frank chambergo
 *
 */
class ButtonEventHandler implements EventHandler<ActionEvent>{
	
	public void handle(ActionEvent e){
		if (e.getSource() == exitButton)
			System.exit(0);
		else if (e.getSource() == checkPW){
			pass = pwBox.getText();
			passConfirm = pwBox2.getText();
				try {
					if (UnmatchedException.checkMatch(pass, passConfirm) && WeakPasswordException.checkWeakness(passConfirm) && PasswordCheckerUtility.isValidPassword(pass)){
						AlertBox.display("Password Status", "Password is OK but weak");
						}
					else if(UnmatchedException.checkMatch(pass, passConfirm) && PasswordCheckerUtility.isValidPassword(pass)){
						AlertBox.display("Password Status", "Password is valid");
						}
					else if(!(UnmatchedException.checkMatch(pass, passConfirm))){
						AlertBox.display("Password Status", "The passwords do not match");
						}
				} catch (LengthException e1) {
					AlertBox.display("Password Error", e1.getMessage());
				} catch (NoDigitException e1) {
					AlertBox.display("Password Error", e1.getMessage());
				} catch (NoUpperAlphaException e1) {
					AlertBox.display("Password Error", e1.getMessage());
				} catch (NoLowerAlphaException e1) {
					AlertBox.display("Password Error", e1.getMessage());
				} catch (InvalidSequenceException e1) {
					AlertBox.display("Password Error", e1.getMessage());
				}
			}
		else if (e.getSource() == checkFile){
				try {
					readFile();
				} catch (FileNotFoundException | LengthException | NoDigitException | NoUpperAlphaException
						| NoLowerAlphaException | InvalidSequenceException e1) {
					System.out.println("An exception was thrown");
					}
			}
		
	}

	/** This method reads a chosen password file and reads it line by line. Then it passes each line/password to be checked for validity and
	 * that it meets each password requirement.
	 * 
	 * @throws FileNotFoundException - thrown if file is not found
	 * @throws LengthException - thrown if length is less than 6 characters
	 * @throws NoDigitException - thrown if no digit
	 * @throws NoUpperAlphaException - thrown if no uppercase alphabetic
	 * @throws NoLowerAlphaException - thrown if no lowercase alphabetic
	 * @throws InvalidSequenceException - thrown if more than 2 of same character
	 */
	public void readFile() throws FileNotFoundException, LengthException, NoDigitException, NoUpperAlphaException, NoLowerAlphaException, InvalidSequenceException{
	
	File selectedFile;
	Scanner input;
	String line, invalidPasswords = "";
	ArrayList<String> array = new ArrayList<String>();
	ArrayList<String> passwordArray = new ArrayList<String>();
	FileChooser chooser = new FileChooser();
	chooser.setTitle("Choose the file of invalid passwords");
	selectedFile = chooser.showOpenDialog(null);
	if (selectedFile != null){
		input = new Scanner(selectedFile);
		while(input.hasNextLine()){
			line = input.nextLine();
			array.add(line);
			}
		passwordArray = PasswordCheckerUtility.validPasswords(array);
		
			for(String a: passwordArray){
				invalidPasswords += a + "\n";
			}
			AlertBox.display("Illegal Passwords", invalidPasswords);
		}
	}
}
}
