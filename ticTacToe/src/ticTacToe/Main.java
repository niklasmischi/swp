package ticTacToe;

import java.util.Scanner;

public class Main {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 char[][] field = new char[3][3];
	        field[0][0]='\u0000';
	        field[1][0]='\u0000';
	        field[2][0]='\u0000';
	        field[0][1]='\u0000';
	        field[1][1]='\u0000';
	        field[2][1]='\u0000';
	        field[0][2]='\u0000';
	        field[1][2]='\u0000';
	        field[2][2]='\u0000';

	        Scanner sc = new Scanner(System.in);
	       
			System.out.println("New Game");
			printState(field);
			System.out.println("Choose who is first: ");
			int actualPlayer = sc.nextInt();	
		
		int x = 0;
		int y = 0;
		
		while(true) {
			boolean isValid = false;
			while (!isValid) {
				System.out.println("Enter your choice Player " + actualPlayer);
				String input = sc.next();
				String[] values = input.split(",");
				x = Integer.parseInt(values[0]);
				y = Integer.parseInt(values[1]);
				if (field[x][y] == '\u0000') {
					isValid = true;
				} else {
					System.out.println("Element already chosen");
				}
			}
			if (actualPlayer == 1 ) {
				field[x][y] = 'o';
				actualPlayer = 2;
			} else {
				field[x][y] = 'x';
				actualPlayer = 1;
			}
			
			printState(field);
			
			checkIfWinner(field);	
		}
	}
	
	public static void printState(char[][] field) {
		System.out.println("");
        System.out.println(field[0][0]+ " | " +field[0][1]+ " | " +field[0][2]);
        System.out.println("----------");
        System.out.println(field[1][0]+ " | " +field[1][1]+ " | " +field[1][2]);
        System.out.println("----------");
        System.out.println(field[2][0]+ " | " +field[2][1]+ " | " +field[2][2]);
        System.out.println("");

	}
	
	public static void clearGame(char[][] field) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				field[i][j] = '\u0000';
			}
		}
		System.out.println("New Game");
		printState(field);
	}
	
	public static void checkIfWinner(char[][] field) {
//		CHECK FOR PLAYER ONE
		if((field[0][0] == 'X' && field[0][1] == 'X' && field[0][2] == 'X') ||
			(field[1][0] == 'X' && field[1][1] == 'X' && field[1][2] == 'X') ||
			(field[2][0] == 'X' && field[2][1] == 'X' && field[2][2] == 'X') ||
			(field[0][0] == 'X' && field[1][0] == 'X' && field[2][0] == 'X') ||
			(field[0][1] == 'X' && field[1][1] == 'X' && field[2][2] == 'X') ||
			(field[0][2] == 'X' && field[1][2] == 'X' && field[2][2] == 'X') ||
			(field[0][0] == 'X' && field[1][1] == 'X' && field[2][2] == 'X') ||
			(field[0][2] == 'X' && field[1][1] == 'X' && field[2][0] == 'X')) {
			System.out.println("Winner: Player Two");
			clearGame(field);
		} else if ((field[0][0] == 'o' && field[0][1] == 'o' && field[0][2] == 'o') ||
				(field[1][0] == 'o' && field[1][1] == 'o' && field[1][2] == 'o') ||
				(field[2][0] == 'o' && field[2][1] == 'o' && field[2][2] == 'o') ||
				(field[0][0] == 'o' && field[1][0] == 'o' && field[2][0] == 'o') ||
				(field[0][1] == 'o' && field[1][1] == 'o' && field[2][2] == 'o') ||
				(field[0][2] == 'o' && field[1][2] == 'o' && field[2][2] == 'o') ||
				(field[0][0] == 'o' && field[1][1] == 'o' && field[2][2] == 'o') ||
				(field[0][2] == 'o' && field[1][1] == 'o' && field[2][0] == 'o')) {
			System.out.println("Winner: Player One");
			clearGame(field);
		}
	
	}

}
