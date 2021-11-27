package thread;

import javafx.application.Platform;
import model.Timer;
import ui.MathChallengeGUI;

public class TimerThread extends Thread{
	private Timer timer;
	private MathChallengeGUI mcGUI;
	
	public TimerThread(Timer timer, MathChallengeGUI mcGUI) {
		this.timer = timer;
		this.mcGUI = mcGUI;
	}
	
	public void run() {
		while(timer.getMinutes() != 0 && timer.getSeconds() != 0) {
			timer.start();
			
			Platform.runLater(new Thread() {
				public void run() {
					mcGUI.updateTimer();
				}
			});
			
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
