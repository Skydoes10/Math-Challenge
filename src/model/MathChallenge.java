package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MathChallenge implements Serializable{

	private static final long serialVersionUID = 1L;
	private String question;
	private int correctAnswer;
	private int[] allAnswers;
	
	private Player player;
	private Player currentPlayer;
	
	public MathChallenge() {
		try {
			importData();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public void createPlayer(String name) {
		Player newPlayer = new Player(name);
		currentPlayer = newPlayer;
	}
	
	public void createNewQuestion() {
		int num1;
		int num2;
		char operator = assignOperator();
		do {
			num1 = (int)(Math.random()*(100 + 1));
			num2 = (int)(Math.random()*(100 + 1));
			
		}while(!areDivisible(num1, num2, operator));
		createCorrectAnswer(num1, num2, operator);
		
		String strNum1 = String.valueOf(num1);
		String strNum2 = String.valueOf(num2);
		String newQuest = strNum1 + " " + operator + " " + strNum2;
		setQuestion(newQuest);
	}
	
	private char assignOperator() {
		char[] operators = new char[4];
		operators[0] = '+';
		operators[1] = '-';
		operators[2] = '*';
		operators[3] = '/';
		int aux = (int)(Math.random()*4);
		char operator = operators[aux];
		
		return operator;
	}
	
	private boolean areDivisible(int num1, int num2, char operator) {
		if(operator == '/' && num1 % num2 != 0 || num2 == 0) {
			return false;
		}else {
			return true;
		}
	}
	
	private void createCorrectAnswer(int num1, int num2, char operator) {
		int correctAnswer;
		if(operator == '+') {
			correctAnswer = num1 + num2;
		}else if(operator == '-') {
			correctAnswer = num1 - num2;
		}else if(operator == '*') {
			correctAnswer = num1 * num2;
		}else {
			correctAnswer = num1 / num2;
		}
		setCorrectAnswer(correctAnswer);
		createIncorrectAnswer(correctAnswer);
	}
	
	private void createIncorrectAnswer(int correctA) {
		int[] options = new int[4];
		int aux = (int)(Math.random()*4);
		options[0] = correctA - (int)(Math.random()*(6 + 1));
		options[1] = correctA - (int)(Math.random()*(10 + 6));
		options[2] = correctA + (int)(Math.random()*(6 + 1));
		options[3] = correctA + (int)(Math.random()*(10 + 6));
		options[aux]  = correctA;
		setAllAnswers(options);
	}
	
	public void addUserToABB() {
		if (player == null ) {
			if (currentPlayer != null) {
				player = currentPlayer;
			}
		}else {
			player.add(currentPlayer);
		}
	}
	
	public void deletePlayer() {
		 if (currentPlayer != null) {
			 if (currentPlayer == player) {
				 player = null;
				 currentPlayer = null;
			 }else {
				 player.remove(currentPlayer);
			 }
		 }
	}
	
	public Player searchPlayer(String namePlayer) {
		ArrayList<Player> playerList = (ArrayList<Player>) getListPlayers();
		for(int i = 0; i < playerList.size(); i++) {
			if(playerList.get(i).getName().equalsIgnoreCase(namePlayer)) {
				return playerList.get(i);
			}
		}
		return null;
	}
	
	public List<Player> getListPlayers() {
		ArrayList<Player> playerList = new ArrayList<>();
		if (player != null) {
			playerList = (ArrayList<Player>)player.listPlayers(playerList);
			Collections.sort(playerList, new Comparator<Player>() {

				@Override
				public int compare(Player o1, Player o2) {
					if (o1.getScore() > o2.getScore()) {
						return -1;
					}
					else if (o1.getScore() < o2.getScore()) {
						return 1;
					}
					return 0;
				}
			});
			
			for (int i = 0; i < playerList.size(); i++) {
				playerList.get(i).setPosition(i+1);
			}
		}
		return playerList;
	}
	
	public void importData() throws FileNotFoundException, IOException, ClassNotFoundException {
		File source = new File("data/players.pl");
		if (source.exists()) {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(source));
			MathChallenge mc = (MathChallenge) ois.readObject();
			player = mc.player;
			currentPlayer= mc.currentPlayer;
			ois.close();
		}else {
			player = null;
			currentPlayer = null;
		}
	}
	
	public void exportData() throws FileNotFoundException, IOException {
		File source = new File("data/players.pl");
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(source));
		oos.writeObject(this);
		oos.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public int getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(int correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public int[] getAllAnswers() {
		return allAnswers;
	}

	public void setAllAnswers(int[] allAnswers) {
		this.allAnswers = allAnswers;
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}
	
	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
	
}
