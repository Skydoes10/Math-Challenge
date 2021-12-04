package thread;

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
			
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
