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
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import model.CountDown;
import model.MathChallenge;
import thread.CountDownThread;

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
    private Rectangle rectangleBar;
	
	
	
	private MathChallenge mc;
	
    public MathChallengeGUI(MathChallenge mc) {
		this.mc = mc;
	}
    
    public void initialize() {
    	
    }

	@FXML
    private void start(ActionEvent event) throws IOException, InterruptedException {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Math Challenge");
		if(tfName.getText().equals("")) {
			alert.setContentText("Por favor ingrese un nombre valido.");
			alert.showAndWait();
		}else {
			mc.createPlayer(tfName.getText());
			
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
	        rectangleBar.setWidth(0);
	        updateQuestions();
	        
	        CountDown cd = new CountDown();
	        CountDownThread thread = new CountDownThread(cd, this);
	        thread.start();
	        
//	        if(cd.getSeconds() == -1) {		//Alerta para cuando se acabe el tiempo (NO FUNCIONA :/ )
//	        	Alert alert2 = new Alert(AlertType.INFORMATION);
//	        	alert2.setTitle("Math Challenge");
//	        	alert2.setContentText("Se termino el tiempo");
//	        	alert2.showAndWait();
//	        }
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

	public Label getLabTime() {
		return labTime;
	}

	public Rectangle getRectangleBar() {
		return rectangleBar;
	}

	public void setRectangleBar(Rectangle rectangleBar) {
		this.rectangleBar = rectangleBar;
	}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

	
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
