package quizapp;

public abstract class Question {
	
	private int id;
	private String text;
	private int point;
	
	public Question(int id,String text, int point) {
		this.id = id;
		this.text = text;
		this.point =point;
	}
	public int getId() {
		return id;
	}
	
	public String getText() {
		return text;
	}
	
	public int getPoint() {
		return point;
	}
	public abstract boolean checkAnswer(String answer);
	public abstract String getCorrectAnswer();
}
