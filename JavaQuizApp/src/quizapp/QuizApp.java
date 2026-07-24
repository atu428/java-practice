package quizapp;
import java.util.ArrayList;
import java.util.Scanner;

public class QuizApp {

	public static void main(String[] args) {
		int score = 0;
		ArrayList<Question> questions = new ArrayList<>();
		ArrayList<String> userAnswers = new ArrayList<>();
		
		Scanner scanner = new Scanner(System.in);

		TrueFalseQuestion question = new TrueFalseQuestion(
				1,
				"Javaはクラス継承ができる",
				10,
				true
				);
		questions.add(question);
		
		System.out.println("問題番号:" + question.getId());
		System.out.println("問題文:"+ question.getText());
		System.out.println("配点:" + question.getPoint() + "点");
		
		boolean result = false;
		boolean validAnswer = false;
		
		while(!validAnswer) {
			System.out.print("回答を入力してください(true / false):");
				String answer =scanner.nextLine().trim();
			if(answer.equalsIgnoreCase("true")
			|| answer.equalsIgnoreCase("false")){
				
				result =question.checkAnswer(answer);
				userAnswers.add(answer);
				validAnswer = true;
			}else {
				System.out.println(
						"trueまたはfalseを入力してください");
			}
		}
		
		if(result) {
			System.out.println("正解です。");
			score += question.getPoint();
		}else {
			System.out.println("不正解です。");
		}
		
		System.out.println();
		String[] choices = {
				"import",
				"extends",
				"return"
				  		};
		MultipleChoiceQuestion choiceQuestion =
				new MultipleChoiceQuestion(
				2,
				"Javaで継承に使うキーワードは？",
				10,
				choices,
				2
				);
		questions.add(choiceQuestion);
		System.out.println("問題番号:" + choiceQuestion.getId());
		System.out.println("問題文:" +choiceQuestion.getText());
		System.out.println("配点:" + choiceQuestion.getPoint() + "点");
		
		choiceQuestion.showChoices();
		
		boolean choiceResult = false;
		boolean validInput = false;

		while (!validInput) {
			System.out.print("回答番号を入力してください：");
			String choiceAnswer = scanner.nextLine();

			try {
				int selectedChoice = Integer.parseInt(choiceAnswer);

				if (selectedChoice < 1
						|| selectedChoice > choiceQuestion.getChoiceCount()) {

					System.out.println(
							"1～" + choiceQuestion.getChoiceCount()
							+ "の番号を入力してください。");

					continue;
				}

				choiceResult =
						choiceQuestion.checkAnswer(choiceAnswer);
				userAnswers.add(choiceAnswer);

				validInput = true;

			} catch (NumberFormatException e) {
				System.out.println("数字を入力してください。");
			}
		}

		

		if (choiceResult) {
			System.out.println("正解です。");
			score += choiceQuestion.getPoint();
		}else {
			System.out.println("不正解です。");
		}
		
		System.out.println();
		
		
		
		

		TrueFalseQuestion question3 = new TrueFalseQuestion(
				3,
				"足利尊氏は室町幕府の初代征夷大将軍である",
				10,
				true
		);

		questions.add(question3);

		System.out.println("問題番号:" + question3.getId());
		System.out.println("問題文:" + question3.getText());
		System.out.println("配点:" + question3.getPoint() + "点");

		boolean result3 = false;
		boolean validAnswer3 = false;

		while (!validAnswer3) {
			System.out.print(
					"回答を入力してください(true / false):");

			String answer3 = scanner.nextLine().trim();

			if (answer3.equalsIgnoreCase("true")
					|| answer3.equalsIgnoreCase("false")) {

				result3 = question3.checkAnswer(answer3);
				userAnswers.add(answer3);
				validAnswer3 = true;

			} else {
				System.out.println(
						"trueまたはfalseを入力してください");
			}
		}

		if (result3) {
			System.out.println("正解です。");
			score += question3.getPoint();
		} else {
			System.out.println("不正解です。");
		}

		String[] choices4 = {
				"織田信長",
				"豊臣秀吉",
				"徳川家康"
		};

		
		
		
		
		
		MultipleChoiceQuestion question4 =
				new MultipleChoiceQuestion(
						4,
						"室町幕府を滅ぼした人物は誰か？",
						10,
						choices4,
						1
				);
		questions.add(question4);

		System.out.println();
		System.out.println("問題番号:" + question4.getId());
		System.out.println("問題文:" + question4.getText());
		System.out.println("配点:" + question4.getPoint() + "点");

		question4.showChoices();

		boolean result4 = false;
		boolean validInput4 = false;

		while (!validInput4) {
			System.out.print("回答番号を入力してください：");
			String answer4 = scanner.nextLine().trim();

			try {
				int selectedChoice4 = Integer.parseInt(answer4);

				if (selectedChoice4 < 1
						|| selectedChoice4 > question4.getChoiceCount()) {

					System.out.println(
							"1～" + question4.getChoiceCount()
							+ "の番号を入力してください。");

					continue;
				}

				result4 = question4.checkAnswer(answer4);
				userAnswers.add(answer4);
				validInput4 = true;

			} catch (NumberFormatException e) {
				System.out.println("数字を入力してください。");
			}
		}

		if (result4) {
			System.out.println("正解です。");
			score += question4.getPoint();
		} else {
			System.out.println("不正解です。");
		}
		
		
		
		System.out.println();

		TrueFalseQuestion question5 = new TrueFalseQuestion(
				5,
				"カモノハシは哺乳類である",
				10,
				true
		);
		questions.add(question5);

		System.out.println("問題番号:" + question5.getId());
		System.out.println("問題文:" + question5.getText());
		System.out.println("配点:" + question5.getPoint() + "点");

		boolean result5 = false;
		boolean validAnswer5 = false;

		while (!validAnswer5) {
			System.out.print(
					"回答を入力してください(true / false):");

			String answer5 = scanner.nextLine().trim();

			if (answer5.equalsIgnoreCase("true")
					|| answer5.equalsIgnoreCase("false")) {

				result5 = question5.checkAnswer(answer5);
				userAnswers.add(answer5);
				validAnswer5 = true;

			} else {
				System.out.println(
						"trueまたはfalseを入力してください");
			}
		}

		if (result5) {
			System.out.println("正解です。");
			score += question5.getPoint();
		} else {
			System.out.println("不正解です。");
		}
		
		
		String[] choices6 = {
				"ウシ",
				"クジラ",
				"ウマ"
		};

		MultipleChoiceQuestion question6 =
				new MultipleChoiceQuestion(
						6,
						"現代の分類で、この中で偶蹄目ではないものはどれか？",
						10,
						choices6,
						3
				);
		questions.add(question6);

		System.out.println();
		System.out.println("問題番号:" + question6.getId());
		System.out.println("問題文:" + question6.getText());
		System.out.println("配点:" + question6.getPoint() + "点");

		question6.showChoices();

		boolean result6 = false;
		boolean validInput6 = false;

		while (!validInput6) {
			System.out.print("回答番号を入力してください：");
			String answer6 = scanner.nextLine().trim();

			try {
				int selectedChoice6 = Integer.parseInt(answer6);

				if (selectedChoice6 < 1
						|| selectedChoice6 > question6.getChoiceCount()) {

					System.out.println(
							"1～" + question6.getChoiceCount()
							+ "の番号を入力してください。");

					continue;
				}

				result6 = question6.checkAnswer(answer6);
				userAnswers.add(answer6);
				validInput6 = true;

			} catch (NumberFormatException e) {
				System.out.println("数字を入力してください。");
			}
		}

		if (result6) {
			System.out.println("正解です。");
			score += question6.getPoint();
		} else {
			System.out.println("不正解です。");
		}
		
		
		System.out.println();

		TrueFalseQuestion question7 = new TrueFalseQuestion(
				7,
				"東京駅は日本で最初に開業した駅である",
				10,
				false
		);
		
		questions.add(question7);

		System.out.println("問題番号:" + question7.getId());
		System.out.println("問題文:" + question7.getText());
		System.out.println("配点:" + question7.getPoint() + "点");

		boolean result7 = false;
		boolean validAnswer7 = false;

		while (!validAnswer7) {
			System.out.print(
					"回答を入力してください(true / false):");

			String answer7 = scanner.nextLine().trim();

			if (answer7.equalsIgnoreCase("true")
					|| answer7.equalsIgnoreCase("false")) {

				result7 = question7.checkAnswer(answer7);
				userAnswers.add(answer7);
				validAnswer7 = true;

			} else {
				System.out.println(
						"trueまたはfalseを入力してください");
			}
		}

		if (result7) {
			System.out.println("正解です。");
			score += question7.getPoint();
		} else {
			System.out.println("不正解です。");
		}
		
		
		System.out.println();

		String[] choices8 = {
				"新宿～立川間",
				"新橋～横浜間",
				"大阪～神戸間"
		};

		MultipleChoiceQuestion question8 =
				new MultipleChoiceQuestion(
						8,
						"日本で最初に開業した鉄道路線は、どの区間か？",
						10,
						choices8,
						2
				);
		questions.add(question8);

		System.out.println("問題番号:" + question8.getId());
		System.out.println("問題文:" + question8.getText());
		System.out.println("配点:" + question8.getPoint() + "点");

		question8.showChoices();

		boolean result8 = false;
		boolean validInput8 = false;

		while (!validInput8) {
			System.out.print("回答番号を入力してください：");
			String answer8 = scanner.nextLine().trim();

			try {
				int selectedChoice8 = Integer.parseInt(answer8);

				if (selectedChoice8 < 1
						|| selectedChoice8 > question8.getChoiceCount()) {

					System.out.println(
							"1～" + question8.getChoiceCount()
							+ "の番号を入力してください。");

					continue;
				}

				result8 = question8.checkAnswer(answer8);
				userAnswers.add(answer8);
				validInput8 = true;

			} catch (NumberFormatException e) {
				System.out.println("数字を入力してください。");
			}
		}

		if (result8) {
			System.out.println("正解です。");
			score += question8.getPoint();
		} else {
			System.out.println("不正解です。");
		}
		
		
		System.out.println();

		TrueFalseQuestion question9 = new TrueFalseQuestion(
				9,
				"地球の中心にある内核は液体である",
				10,
				false
		);
		questions.add(question9);

		System.out.println("問題番号:" + question9.getId());
		System.out.println("問題文:" + question9.getText());
		System.out.println("配点:" + question9.getPoint() + "点");

		boolean result9 = false;
		boolean validAnswer9 = false;

		while (!validAnswer9) {
			System.out.print(
					"回答を入力してください(true / false):");

			String answer9 = scanner.nextLine().trim();

			if (answer9.equalsIgnoreCase("true")
					|| answer9.equalsIgnoreCase("false")) {

				result9 = question9.checkAnswer(answer9);
				userAnswers.add(answer9);
				validAnswer9 = true;

			} else {
				System.out.println(
						"trueまたはfalseを入力してください");
			}
		}

		if (result9) {
			System.out.println("正解です。");
			score += question9.getPoint();
		} else {
			System.out.println("不正解です。");
		}
		
		
		System.out.println();

		String[] choices10 = {
				"約46億年前",
				"約138億年前",
				"約256億年前"
		};

		MultipleChoiceQuestion question10 =
				new MultipleChoiceQuestion(
						10,
						"地球が誕生したのは約何年前か？",
						10,
						choices10,
						1
				);
		questions.add(question10);

		System.out.println("問題番号:" + question10.getId());
		System.out.println("問題文:" + question10.getText());
		System.out.println("配点:" + question10.getPoint() + "点");

		question10.showChoices();

		boolean result10 = false;
		boolean validInput10 = false;

		while (!validInput10) {
			System.out.print("回答番号を入力してください：");
			String answer10 = scanner.nextLine().trim();

			try {
				int selectedChoice10 = Integer.parseInt(answer10);

				if (selectedChoice10 < 1
						|| selectedChoice10 > question10.getChoiceCount()) {

					System.out.println(
							"1～" + question10.getChoiceCount()
							+ "の番号を入力してください。");

					continue;
				}

				result10 = question10.checkAnswer(answer10);
				userAnswers.add(answer10);
				validInput10 = true;

			} catch (NumberFormatException e) {
				System.out.println("数字を入力してください。");
			}
		}

		if (result10) {
			System.out.println("正解です。");
			score += question10.getPoint();
		} else {
			System.out.println("不正解です。");
		}
		
		
		
		
		System.out.println();
		System.out.println("最終得点：" + score + "点");
		System.out.println("登録問題数:" +  questions.size() + "問");
		
		System.out.println();
		System.out.println("[登録問題一覧]");
		
		for(Question q : questions) {
			System.out.println(
					q.getId() + ":" + q.getText());
		}
		System.out.println();
	    System.out.println("[正解一覧]");
	    for (Question q : questions) {
	    	System.out.println(
	    			"問題" + q.getId()
	    			+ ":" + q.getCorrectAnswer());
	    }

	    System.out.println();
	    System.out.println("[回答結果]");

	    for (int i = 0; i < questions.size(); i++) {
	    	Question q = questions.get(i);
	    	String userAnswer = userAnswers.get(i);

	    	System.out.println(
	    			"問題" + q.getId() + ":" + q.getText());

	    	System.out.println(
	    			"あなたの回答:" + userAnswer);

	    	System.out.println(
	    			"正解:" + q.getCorrectAnswer());

	    	if (q.checkAnswer(userAnswer)) {
	    		System.out.println("結果:正解");
	    	} else {
	    		System.out.println("結果:不正解");
	    	}

	    	System.out.println();
	    }

	    scanner.close();
	}
}
	    
