package model;

public class MathChallenge {
	private String question;
	private String correctAnswer;
	private String answer1;
	private String answer2;
	private String answer3;
	
	private Player player;
	
	public MathChallenge() {
		
	}
	
	public void createPlayer(String name, int score) {
		Player player = new Player(name, score);
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
		int max_value = correctA + 10;
		int min_value = correctA - 10;
		
//		Set<Integer> answers = new TreeSet<Integer>();
//		boolean aux = true;
//		while(aux) {
//			int randomNum = (int)(Math.random() * (max_value - min_value));
//			
//			if(randomNum != correctA) {
//				if(answers.size() <= 3) {
//					answers.add(randomNum);
//				}else{
//					aux = false;
//				}
//			}
//		}
//		ArrayList<>
//		setAnswer1();
		
		int answer1 = (int)(Math.random() * (max_value - min_value));
		setAnswer1(String.valueOf(answer1));
		int answer2 = (int)(Math.random() * (max_value - min_value));
		setAnswer2(String.valueOf(answer2));
		int answer3 = (int)(Math.random() * (max_value - min_value));
		setAnswer3(String.valueOf(answer3));
	}
	
	public String updateScore(int num) {
		if(num < 0) {
			player.subtractScore();
		}else {
			player.plusScore();
		}
		return String.valueOf(player.getScore());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


	public Player getPlayer() {
		return player;
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
