package ui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import model.CountDown;
import model.MathChallenge;
import model.Player;
import thread.CountDownThread;

public class MathChallengeGUI {
	
	// StartPane
	@FXML
    private Pane startPane;

    @FXML
    private TextField tfName;
    
    @FXML
    private Button btnStart;

	
	// GamePane
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
    
    
    // ScorePane
    @FXML
    private TextField tfNameSearch;
    
    @FXML
    private Button btnCloseGame;
    
    @FXML
    private Label labInfoPlayer;
    
    @FXML
    private TableColumn<Player, String> tcName;

    @FXML
    private TableColumn<Player, Integer> tcPosition;

    @FXML
    private TableColumn<Player, Integer> tcScore;

    @FXML
    private TableView<Player> tvScores;
	
	
	
	private MathChallenge mc;
	
    public MathChallengeGUI(MathChallenge mc) {
		this.mc = mc;
	}
    
    public void initialize() {
    }
    
	@FXML
    private void start(ActionEvent event) throws IOException, InterruptedException {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Math Challenge");
		if(tfName.getText().equals("")) {
			alert.setContentText("Please, type a name");
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
	        thread.setDaemon(true);
	        thread.start();
	        
		}
    }
	
	private void updateQuestions() {
		mc.createNewQuestion();
		labQuestion.setText(mc.getQuestion());
		
		int[] answers = mc.getAllAnswers();
		
		btnAnswer1.setText(String.valueOf(answers[0]));
		btnAnswer2.setText(String.valueOf(answers[1]));
		btnAnswer3.setText(String.valueOf(answers[2]));
		btnAnswer4.setText(String.valueOf(answers[3]));
	}
	
	private void validAnswer(int answer) {
		if(answer == mc.getCorrectAnswer()) {
			mc.getCurrentPlayer().plusScore();
		}else {
			mc.getCurrentPlayer().subtractScore();
		}
		labScore.setText(String.valueOf(mc.getCurrentPlayer().getScore()));
		updateQuestions();
	}
	
	@FXML
	private void nextQuestionButton1(ActionEvent event) {
		validAnswer(Integer.parseInt(btnAnswer1.getText()));
    }

    @FXML
    private void nextQuestionButton2(ActionEvent event) {
    	validAnswer(Integer.parseInt(btnAnswer2.getText()));
    }

    @FXML
    private void nextQuestionButton3(ActionEvent event) {
    	validAnswer(Integer.parseInt(btnAnswer3.getText()));
    }

    @FXML
    private void nextQuestionButton4(ActionEvent event) {
    	validAnswer(Integer.parseInt(btnAnswer4.getText()));
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
    
    
    public void endGame() throws IOException {
    	Stage stage = (Stage) this.btnAnswer1.getScene().getWindow();
        stage.close();
        
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ScoresPane.fxml"));
		fxmlLoader.setController(this);
		Parent mainPane = fxmlLoader.load();

		Stage stage2 = new Stage();
        stage2.setTitle("Math Challenge");
        stage2.setScene(new Scene(mainPane));
        stage2.show();
        mc.addUserToABB();
        labInfoPlayer.setText("Position - "+ mc.getCurrentPlayer().getPosition() + "   Name: " + mc.getCurrentPlayer().getName() + "   Score: " + mc.getCurrentPlayer().getScore());
        initializeScoreBoard();
    }
    
    public void initializeScoreBoard() {
    	if (mc.getPlayer() != null) {
    		initializeTableView();
    	}
    }
    
    private void initializeTableView() {
    	ArrayList<Player> playerList = (ArrayList<Player>) mc.getListPlayers();
    	
    	ObservableList<Player> observableList;
    	observableList = FXCollections.observableArrayList(playerList);
    	
    	tvScores.setItems(observableList);
    	tcPosition.setCellValueFactory(new PropertyValueFactory<Player, Integer>("position"));
    	tcName.setCellValueFactory(new PropertyValueFactory<Player, String>("name"));
    	tcScore.setCellValueFactory(new PropertyValueFactory<Player, Integer>("score"));
	}
    
    @FXML
    private void closeGame(ActionEvent event) throws FileNotFoundException, IOException {
    	mc.exportData();
    	Stage stage = (Stage) this.btnCloseGame.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void deleteScore(ActionEvent event) {
    	mc.deletePlayer();
    	labInfoPlayer.setText("- - - - -");
    	initializeScoreBoard();
    }

    @FXML
    private void playAgain(ActionEvent event) throws FileNotFoundException, IOException  {
    	mc.exportData();
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("StartPane.fxml"));
		fxmlLoader.setController(this);
		Parent mainPane = fxmlLoader.load();

		Stage stage = new Stage();
        stage.setTitle("Math Challenge");
        stage.setScene(new Scene(mainPane));
        stage.show();
        
        Stage stage2 = (Stage) this.btnCloseGame.getScene().getWindow();
        stage2.close();
    }
    
    @FXML
    private void searchPlayer(ActionEvent event) {
    	Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Math Challenge");
		alert.setHeaderText("Player:");
    	Player player = mc.searchPlayer(tfNameSearch.getText());
    	if(player != null) {
    		alert.setContentText("Name: " + player.getName() + "   Score: " + player.getScore());
    		alert.showAndWait();
    	}else {
    		alert.setContentText("Player not found");
    		alert.showAndWait();
    	}
    }
	
}
