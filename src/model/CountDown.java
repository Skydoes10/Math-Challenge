package model;

public class CountDown {
	private int seconds;
	private String count;

	public CountDown() {
		this.seconds = 50;
	}
	
	public void startCountDown() {
		seconds--;
	}

	public String getCount() {
		return count;
	}
	
	public void setCount(String count) {
		this.count = count;
	}

	public int getSeconds() {
		return seconds;
	}
	
	
}
