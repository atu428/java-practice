package practice.methodization;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public classLibraryLendingApp.java  {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] books = new String[10];
		boolean[] isBorrowed = new boolean[10];

		int bookCount = loadBooks(books, isBorrowed);

		while (true) {
			showMenu();

			int menu;

			if (scanner.hasNextInt()) {
				menu = scanner.nextInt();
			} else {
				System.out.println("数字を入力してください");
				scanner.nextLine();
				System.out.println();
				continue;
			}
			if (menu == 1) {
				scanner.nextLine();

				if (bookCount < books.length) {
					System.out.println("登録する本のタイトルを入力してください");
					String title = scanner.nextLine();

					books[bookCount] = title;
					bookCount++;

					System.out.println("本を登録しました");
				} else {
					System.out.println("これ以上、本を登録できません");
				}
			} else if (menu == 2) {
				System.out.println("本の一覧を見ます");

				if (bookCount == 0) {
					System.out.println("本がまだ登録されていません");

				} else {

					showBooks(books, isBorrowed, bookCount);

				}
			} else if (menu == 3) {
				System.out.println("本の貸出処理をします");
				if (bookCount == 0) {
					System.out.println("まだ本が登録されていません");
				} else {
					showBooks(books, isBorrowed, bookCount);

					System.out.println("貸出する本の番号を入力してください");
					int bookNumber = scanner.nextInt();
					int index = bookNumber - 1;

					if (index < 0 || index >= bookCount) {
						System.out.println("正しい本の番号を入力してください");
					} else if (isBorrowed[index]) {
						System.out.println("その本は貸出中です");
					} else {
						isBorrowed[index] = true;
						System.out.println(books[index] + "を貸出しました");
					}
				}

			} else if (menu == 4) {
				System.out.println("本の返却処理をします");

				if (bookCount == 0) {
					System.out.println("まだ本が登録されていません");
				} else {
					showBooks(books, isBorrowed, bookCount);

					System.out.println("返却する本の番号を入力してください");
					int bookNumber = scanner.nextInt();
					int index = bookNumber - 1;

					if (index < 0 || index >= bookCount) {
						System.out.println("正しい本の番号を入力してください");
					} else if (!isBorrowed[index]) {
						System.out.println("その本は貸出されていません");
					} else {
						isBorrowed[index] = false;
						System.out.println(books[index] + "を返却しました");
					}
				}
			} else if (menu == 5) {
				saveBooks(books, isBorrowed, bookCount);
				System.out.println("アプリを終了します");
				break;
			} else if (menu == 6) {
				System.out.println("本の削除処理をします");

				if (bookCount == 0) {
					System.out.println("本がまだ登録されていません");

				} else {
					showBooks(books, isBorrowed, bookCount);

					System.out.println("削除する本の番号入力してください");
					int bookNumber = scanner.nextInt();
					int index = bookNumber - 1;
					if (index < 0 || index >= bookCount) {
						System.out.println("正しい本の番号を入力してください");
					} else {
						String deletedTitle = books[index];

						for (int i = index; i < bookCount - 1; i++) {
							books[i] = books[i + 1];
							isBorrowed[i] = isBorrowed[i + 1];

						}
						books[bookCount - 1] = null;
						isBorrowed[bookCount - 1] = false;
						bookCount--;
						System.out.println(deletedTitle + "を削除しました");
					}

				}
			} else if (menu == 7) {
				System.out.println("本の検索処理をします");

				if (bookCount == 0) {
					System.out.println("本がまだ登録されていません");
				} else {
					scanner.nextLine();

					System.out.println("検索する文字を入力してください");
					String keyword = scanner.nextLine();

					boolean found = false;

					for (int i = 0; i < bookCount; i++) {
						if (books[i].contains(keyword)) {
							if (isBorrowed[i]) {
								System.out.println((i + 1) + "." + books[i] + "[貸出中]");
							} else {
								System.out.println((i + 1) + "." + books[i] + "[貸出可能]");

							}
							found = true;
						}
					}

					if (!found) {
						System.out.println("該当する本がありません");

					}
				}
			} else if (menu == 8) {
				System.out.println("貸出中の本を表示します");

				if (bookCount == 0) {
					System.out.println("本がまだ登録されていません");
				} else {
					boolean found = false;

					for (int i = 0; i < bookCount; i++) {
						if (isBorrowed[i]) {
							System.out.println((i + 1) + "." + books[i] + "[貸出中]");
							found = true;
						}
					}
					if (!found) {
						System.out.println("貸出中の本はありません");
					}

				}
			} else if (menu == 9) {
				System.out.println("貸出可能な本を表示します");

				if (bookCount == 0) {
					System.out.println("本がまだ登録されていません");
				} else {
					boolean found = false;

					for (int i = 0; i < bookCount; i++) {
						if (!isBorrowed[i]) {
							System.out.println((i + 1) + "." + books[i] + "[貸出可能]");
							found = true;
						}
					}
					if (!found) {
						System.out.println("貸出可能な本はありません");
					}
				}
			} else if (menu == 10) {
				System.out.println("登録されている本は" + bookCount + "冊です");
			} else if (menu == 11) {
				int borrowedCount = 0;

				for (int i = 0; i < bookCount; i++) {
					if (isBorrowed[i]) {
						borrowedCount++;
					}
				}
				System.out.println("貸出中の本は" + borrowedCount + "冊です");
			} else if (menu == 12) {
				int availableCount = 0;

				for (int i = 0; i < bookCount; i++) {
					if (!isBorrowed[i]) {
						availableCount++;
					}

				}
				System.out.println("貸出可能な本は" + availableCount + "冊です");
			} else {
				System.out.println("1から12までの番号を入力してください");

			}
			System.out.println();

		}
		scanner.close();

	}

	public static void showMenu() {
		System.out.println("=====図書館貸出管理アプリ=====");
		System.out.println("1.本を登録します");
		System.out.println("2.本の一覧を見る");
		System.out.println("3.本の貸出");
		System.out.println("4.本の返却");
		System.out.println("5.終了");
		System.out.println("6.本を削除する");
		System.out.println("7.本を検索する");
		System.out.println("8.貸出中の本を見る");
		System.out.println("9.貸出可能な本を見る");
		System.out.println("10.登録冊数を表示する");
		System.out.println("11.貸出中の冊数を表示する");
		System.out.println("12.貸出可能な冊数を表示する");
		System.out.println("番号を入力してください");
	}

	public static void showBooks(String[] books, boolean[] isBorrowed, int bookCount) {
		for (int i = 0; i < bookCount; i++) {
			if (isBorrowed[i]) {
				System.out.println((i + 1) + "." + books[i] + "[貸出中]");

			} else {
				System.out.println((i + 1) + "." + books[i] + "[貸出可能]");
			}
		}
	}

	public static void saveBooks(String[] books, boolean[] isBorrowed, int bookCount) {
		try {
			PrintWriter writer = new PrintWriter(new FileWriter("books.csv"));

			for (int i = 0; i < bookCount; i++) {
				writer.println(books[i] + "," + isBorrowed[i]);
			}

			writer.close();
			System.out.println("データを保存しました");

		} catch (IOException e) {
			System.out.println("保存中にエラーが発生しました");
		}
	}

	public static int loadBooks(String[] books, boolean[] isBorrowed) {
		int count = 0;

		try {
			File file = new File("books.csv");

			if (!file.exists()) {
				return 0;
			}

			Scanner fileScanner = new Scanner(file);

			while (fileScanner.hasNextLine() && count < books.length) {
				String line = fileScanner.nextLine();
				String[] data = line.split(",");

				if (data.length >= 2) {
					books[count] = data[0];
					isBorrowed[count] = Boolean.parseBoolean(data[1]);

					count++;
				}
			}

			fileScanner.close();
			System.out.println("データを読み込みました");

		} catch (Exception e) {
			System.out.println("読み込み中にエラーが発生しました");
		}

		return count;
	}
}
