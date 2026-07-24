package quizapp;

public class TrueFalseQuestion extends Question {
	
	private boolean correctAnswer;
	
	public TrueFalseQuestion(
			int id, String text, int point,boolean correctAnswer) {
		
		super(id,text,point);
		this.correctAnswer =correctAnswer;
	}
	@Override
	public  boolean checkAnswer(String answer) {
		return Boolean.parseBoolean(answer) == correctAnswer;
	}
		@Override
		public String getCorrectAnswer() {
			return String.valueOf(correctAnswer);
			
			}
		
		}
	


