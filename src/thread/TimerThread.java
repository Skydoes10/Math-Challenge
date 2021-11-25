package thread;

public class TimerThread extends Thread{
	private int minutes;
	private int seconds;
	private boolean start;
	
	public TimerThread(int minutes, int seconds, boolean start) {
		this.minutes = minutes;
		this.seconds = seconds;
		this.start = start;
	}
	
	public void run() {
		try {
			while(start) {
				if(seconds != 0) {
					seconds--;                               
				}else{
					if(minutes != 0){
						seconds = 59;
						minutes--;
					}else{                         
						break; 
					}
				}
				sleep(1000);
			}
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public boolean stopTimer() {
		if(seconds == 0 && minutes == 0) {
			return true;
		}
		return false;
	}
	
	public String toString() {
		if(seconds < 10 && minutes < 10) {
			return "0" + minutes + ":0" + seconds;
		}else if(seconds < 10) {
			return minutes + ":0" + seconds;
		}else {
			return "0" + minutes + ":" + seconds;
		}
	}
	
}
