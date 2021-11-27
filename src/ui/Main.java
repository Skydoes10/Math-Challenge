package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.MathChallenge;

public class Main extends Application{
	private MathChallenge mc;
	private MathChallengeGUI mcgui;
	
	public Main() {
		mc = new MathChallenge(null);
		mcgui = new MathChallengeGUI(mc);
	}

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("StartPane.fxml"));
		fxmlLoader.setController(mcgui);
		
		Parent root = fxmlLoader.load();
		Scene scene = new Scene(root); 
		primaryStage.setScene(scene);
		primaryStage.setTitle("Math Challenge");
		primaryStage.show();
	}

}
