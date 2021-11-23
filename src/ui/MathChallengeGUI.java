package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import model.MathChallenge;

public class MathChallengeGUI {
	
	// StartPane
	@FXML
    private Pane startPane;

    @FXML
    private TextField tfName;
	
	
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
    private void start(ActionEvent event) {
		
    }

}
