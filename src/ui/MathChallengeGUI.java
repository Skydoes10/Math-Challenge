package ui;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
import model.Player;
import model.Timer;

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
	private Player player;
	private Timer timer;
	
    public MathChallengeGUI(MathChallenge mc) {
		this.mc = mc;
	}
    
    public void initialize() {
//    	timer = new Timer(2, 0, true);
    }

	@FXML
    private void start(ActionEvent event) throws IOException, InterruptedException {
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
	        
	        labScore.setText("0");
	        updateQuestions();
	        
//	        new TimerThread(timer, this).start();
		}
    }

	private void updateQuestions() {
		mc.createNewQuestion();
		labQuestion.setText(mc.getQuestion());
		
		List<String> answers = Arrays.asList(mc.getCorrectAnswer(), mc.getAnswer1(), mc.getAnswer2(), mc.getAnswer3());
		Collections.shuffle(answers);
		
		btnAnswer1.setText(answers.get(0));
		btnAnswer2.setText(answers.get(1));
		btnAnswer3.setText(answers.get(2));
		btnAnswer4.setText(answers.get(3));
	}
	
	@FXML
	private void nextQuestionButton1(ActionEvent event) {
		updateQuestions();
		if(btnAnswer1.getText().equals(mc.getCorrectAnswer())) {
			labScore.setText(mc.updateScore(1));
		}else {
			labScore.setText(mc.updateScore(-1));
		}
    }

    @FXML
    private void nextQuestionButton2(ActionEvent event) {
    	updateQuestions();
		if(btnAnswer1.getText().equals(mc.getCorrectAnswer())) {
			labScore.setText(mc.updateScore(1));
		}else {
			labScore.setText(mc.updateScore(-1));
		}
    }

    @FXML
    private void nextQuestionButton3(ActionEvent event) {
    	updateQuestions();
		if(btnAnswer1.getText().equals(mc.getCorrectAnswer())) {
			labScore.setText(mc.updateScore(1));
		}else {
			labScore.setText(mc.updateScore(-1));
		}
    }

    @FXML
    private void nextQuestionButton4(ActionEvent event) {
    	updateQuestions();
		if(btnAnswer1.getText().equals(mc.getCorrectAnswer())) {
			labScore.setText(mc.updateScore(1));
		}else {
			labScore.setText(mc.updateScore(-1));
		}
    }
    
	
//	public void updateTimer() {
//		labTime.setText(timer.toString());
//	}
	
//	private void finishGame() throws IOException {
//		if(mc.stopTimer()) {
//			Alert alert = new Alert(AlertType.INFORMATION);
//			alert.setTitle("Math Challenge");
//			alert.setHeaderText("Se ha acabado el tiempo");
//			alert.setContentText("Tu puntaje es: " + labScore);
//			alert.showAndWait();
//			if(!alert.isShowing()) {
//				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ScoresPane.fxml"));
//				fxmlLoader.setController(this);
//				Parent mainPane = fxmlLoader.load();
//
//				Stage stage = new Stage();
//		        stage.setTitle("Math Challenge");
//		        stage.setScene(new Scene(mainPane));
//		        stage.show();
//		        
//		        Stage stage2 = (Stage) this.btnAnswer1.getScene().getWindow();
//		        stage2.close();
//			}
//		}
//		
//	}
//	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
