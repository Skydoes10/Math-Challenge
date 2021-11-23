package model;

public class MathChallenge {
	private String question;
	private String answer1;
	private String answer2;
	private String answer3;
	private String answer4;
	
	public MathChallenge() {
		
	}
	
	public String createNewQuestion() {
		int num1;
		int num2;
		char operator = assignOperator();
		
		do {
			num1 = (int)(Math.random()*99);
			num2 = (int)(Math.random()*99);
			
		}while(!areDivisible(num1, num2, operator));
		
		String strNum1 = String.valueOf(num1);
		String strNum2 = String.valueOf(num2);
		String newQuest = strNum1 + " " + operator + " " + strNum2;
		
		return newQuest;
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
	
	
	

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
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

	public String getAnswer4() {
		return answer4;
	}

	public void setAnswer4(String answer4) {
		this.answer4 = answer4;
	}
	
	
	
}
