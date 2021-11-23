package model;

public class Player {
	private String name;
	private int score;
	private Player left;
	private Player right;
	
	public Player(String name, int score) {
		this.name = name;
		this.score = score;
		this.left = null;
		this.right = null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Player getLeft() {
		return left;
	}

	public void setLeft(Player left) {
		this.left = left;
	}

	public Player getRight() {
		return right;
	}

	public void setRight(Player right) {
		this.right = right;
	}
	
	
}
