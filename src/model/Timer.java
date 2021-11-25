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
			seconds--;
			if(seconds == 0) {
				minutes--;
			}
		}
	}
	
	public String toString() {
		return minutes + ":" + seconds;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public int getSeconds() {
		return seconds;
	}

	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}
	
	

}
