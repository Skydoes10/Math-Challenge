package model;

import thread.TimerThread;

public class MathChallenge {
	public final int MINUTES = 2;
	public final int SECONDS = 0;
	
	private String question;
	private String correctAnswer;
	private String answer1;
	private String answer2;
	private String answer3;
	private TimerThread timerT;
	
	public MathChallenge() {
		
	}
	
	public void createNewQuestion() {
		int num1;
		int num2;
		char operator = assignOperator();
		
		do {
			num1 = (int)(Math.random()*99);
			num2 = (int)(Math.random()*99);
			
		}while(!areDivisible(num1, num2, operator));
		setCorrectAnswer(createCorrectAnswer(num1, num2, operator));
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
		if(operator == '/' && num1 % num2 != 0) {
			return false;
		}
		return true;
	}
	
	private String createCorrectAnswer(int num1, int num2, char operator) {
		String correctAnswer;
		if(operator == '+') {
			correctAnswer = String.valueOf(num1 + num2);
			createIncorrectAnswer(num1 + num2);
		}else if(operator == '-') {
			correctAnswer = String.valueOf(num1 - num2);
			createIncorrectAnswer(num1 - num2);
		}else if(operator == '*') {
			correctAnswer = String.valueOf(num1 * num2);
			createIncorrectAnswer(num1 * num2);
		}else {
			correctAnswer = String.valueOf(num1 / num2);
			createIncorrectAnswer(num1 / num2);
		}
		return correctAnswer;
	}
	
	private void createIncorrectAnswer(int correctA) {
		int answer1 = (int)(Math.random() * ((correctA + 10) - (correctA - 10)));
		setAnswer1(String.valueOf(answer1));
		int answer2 = (int)(Math.random() * ((correctA + 10) - (correctA - 10)));
		setAnswer1(String.valueOf(answer2));
		int answer3 = (int)(Math.random() * ((correctA + 10) - (correctA - 10)));
		setAnswer1(String.valueOf(answer3));
	}
	
	public void settingTimer() {
		TimerThread t = new TimerThread(MINUTES, SECONDS, true);
		t.run();
	}
	
	
	
	
	
	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	
	public String getAnswer1() {
		return answer1;
	}

	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}

	public String getAnswer2() {
		return answer2;
	}

	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}

	public String getAnswer3() {
		return answer3;
	}

	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}
	
	
	
	
}
