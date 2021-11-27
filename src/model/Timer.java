package model;

public class Timer {
	private int minutes;
	private int seconds;
	private boolean start;
	
	public Timer(int minutes, int seconds, boolean start) {
		this.minutes = minutes;
		this.seconds = seconds;
		this.start = start;
	}
	
	public void start() {
		while(start) {
			if(seconds != 0) {
				seconds--;                               
			}else{
				if(minutes != 0){
					seconds = 59;
					minutes--;
				}
			}
		}
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

	public int getMinutes() {
		return minutes;
	}

	public int getSeconds() {
		return seconds;
	}
	
}
