package thread;

import java.io.IOException;

import javafx.application.Platform;
import model.CountDown;
import ui.MathChallengeGUI;

public class CountDownThread extends Thread{
	private CountDown cd;
	private MathChallengeGUI mcGUI;
	
	public CountDownThread(CountDown cd, MathChallengeGUI mcGUI) {
		this.cd = cd;
		this.mcGUI = mcGUI;
	}

	public void run() {
		while(cd.getSeconds() >= 0) {
			cd.setCount(String.valueOf(cd.getSeconds()));
			Platform.runLater(() ->  mcGUI.getLabTime().setText(cd.getCount()));
			cd.startCountDown();
			Platform.runLater(() ->  mcGUI.getRectangleBar().setWidth(mcGUI.getRectangleBar().getWidth()+9));
			
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		Platform.runLater(() ->  {
			try {
				mcGUI.endGame();
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}

}
