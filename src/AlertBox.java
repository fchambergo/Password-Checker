import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

/**
 * 
 */

/**This class makes a message box display whether the password given by user passes the requirements or fails and displays the requirement it didnt meet
 * @author frank chambergo
 *
 */
public class AlertBox {

	public static void display(String title, String message){
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(500);
		
		Label label = new Label();
		label.setText(message);
		Button exitButton = new Button("OK");
		exitButton.setOnAction(e -> window.close());
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label, exitButton);
		layout.setPadding(new Insets(10));
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.show();
		
	}
}
