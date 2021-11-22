package ui;

import javafx.application.Application;
import javafx.stage.Stage;
import model.MathChallenge;

public class Main extends Application{
	private MathChallenge mc;
	private MathChallengeGUI mcgui;
	
	public Main() {
		mc = new MathChallenge();
		mcgui = new MathChallengeGUI();
	}

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		
	}

}
