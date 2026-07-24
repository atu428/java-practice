package quizapp;

public class MultipleChoiceQuestion  extends Question{
	
	private String[] choices;
	private int correctChoice;
	
	public MultipleChoiceQuestion(
			int id,
			String text,
			int point,
			String[] choices,
			int correctChoice) {
		
		super(id,text,point);
		this.choices = choices;
		this.correctChoice = correctChoice;
	}
	@Override
	public boolean checkAnswer(String answer) {
		int selectedChoice = Integer.parseInt(answer);
		return selectedChoice == correctChoice;
	}
	public void showChoices() {
		for(int i = 0; i <  choices.length;i++) {
			System.out.println((i + 1) + "." + choices[i]);
			
			
			}
		}
		public int getChoiceCount() {
			return choices.length;
		}
			@Override
			public String getCorrectAnswer() {
				return correctChoice + ". " + choices[correctChoice - 1];
	}

}
