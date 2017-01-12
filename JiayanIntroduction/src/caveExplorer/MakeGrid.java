package caveExplorer;

import java.util.Scanner;

public class MakeGrid {
	private static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);

		int cols = 5;
		int rows = 5;
		int y = 1; 
		int x = 2;

		while (true) {
			System.out.println("You are in room " + y + " " + x + ". What do u want to do? Enter:");
			System.out.println("w, a, s, d");
			draw(cols, rows, y, x);
			String input = scanner.nextLine();

			if (input.equals("s") && y + 1 < cols) {
				y++;
			} else if (input.equals("a") && x > 0) {
				x--;
			} else if (input.equals("w") && y > 0) {
				y--;
			} else if (input.equals("d") && x + 1 < rows) {
				x++;
			}
		}
	}

	public static void draw(int rows, int cols, int r, int c) {
		for (int i = 0; i != rows; i++) {
			System.out.print("____");
		}
		System.out.println();

		for (int j = 0; j != cols; j++) {
			for (int i = 3; i > 0; i--) {
				for (int k = 0; k != rows; k++) {
					if (i == 1) {
						System.out.print("|___");
					} else {
						if (i == 2 && j == r && k == c) {
							System.out.print("| X ");
						} else {
							System.out.print("|   ");
						}
					}
				}
				System.out.println("|");
			}
		}
	}

}

