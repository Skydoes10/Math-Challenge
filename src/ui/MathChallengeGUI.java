package ui;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.MathChallenge;

public class MathChallengeGUI {
	
	// StartPane
	@FXML
    private Pane startPane;

    @FXML
    private TextField tfName;
    
    @FXML
    private Button btnStart;

	
	
	//GamePane
    @FXML
    private Pane gamePane;
    
    @FXML
    private Button btnAnswer1;

    @FXML
    private Button btnAnswer2;

    @FXML
    private Button btnAnswer3;

    @FXML
    private Button btnAnswer4;

    @FXML
    private Label labQuestion;

    @FXML
    private Label labScore;

    @FXML
    private Label labTime;

    @FXML
    private ProgressBar progressBar;
	
	
	
	private MathChallenge mc;
	
    public MathChallengeGUI(MathChallenge mc) {
		this.mc = mc;
	}

	@FXML
    private void start(ActionEvent event) throws IOException {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Math Challenge");
		if(tfName.getText().equals("")) {
			alert.setContentText("Por favor ingrese un nombre valido.");
			alert.showAndWait();
		}else {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GamePane.fxml"));
			fxmlLoader.setController(this);
			Parent mainPane = fxmlLoader.load();

			Stage stage = new Stage();
	        stage.setTitle("Math Challenge");
	        stage.setScene(new Scene(mainPane));
	        stage.show();
	        
	        Stage stage2 = (Stage) this.btnStart.getScene().getWindow();
	        stage2.close();
	        update();
		}
    }

	private void update() {
		mc.createNewQuestion();
		labQuestion.setText(mc.getQuestion());
		
		Random rand = new Random();
		List<String> answers = Arrays.asList(mc.getCorrectAnswer(), mc.getAnswer1(), mc.getAnswer2(), mc.getAnswer3());
		
		String[] randomAnswer = new String[answers.size()];
		for (int i = 0; i < 4; i++) {
            int randomNum = rand.nextInt(answers.size());
            randomAnswer[i] = answers.get(randomNum);
        }
		btnAnswer1.setText(randomAnswer[0]);
		btnAnswer2.setText(randomAnswer[1]);
		btnAnswer3.setText(randomAnswer[2]);
		btnAnswer4.setText(randomAnswer[3]);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
