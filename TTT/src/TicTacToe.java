import java.util.Iterator;
import java.util.Scanner;

public class TicTacToe {
	
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		String [][] board = intializeBoard();
		int player = 1;
		int winner = 0;
		int moveCount = 0;
		
		//printBoard(board);
		while(winner == 0 && moveCount < 9)
		{
			printBoard(board);
			makeMove(player, board);
			moveCount++;
			winner = checkWinner(board);
			player = player % 2 + 1;
		}
		printBoard(board);
		if(winner == 0)
		{
			System.out.println("Cat's game!");
		}else
		{
			System.out.println("Player " + winner + " wins!");
		}
		input.close();
	}

	private static int checkWinner(String[][] board) {
		for (int i = 0; i < 3; i++) {
			String row = board[i][0] + board[i][1] + board[i][2];
			String col = board[0][i] + board[1][i] + board[2][i];
			
			if(row.equals("XXX") || col.equals("XXX")) return 1;
			if(row.equals("OOO") || col.equals("OOO")) return 2;
		}
		String diag1 = board[0][0] + board[1][1] + board[2][2];
		String diag2 = board[0][2] + board[1][1] + board[2][0];
		
		if(diag1.equals("XXX") || diag2.equals("XXX")) return 1;
		if(diag1.equals("OOO") || diag2.equals("OOO")) return 2;
		
		return 0;
	}

	private static void makeMove(int player, String[][] board) {
		int pick = 0;
		boolean valid = false;
		while(!valid)
		{
			System.out.println("Player " + player + ", please make your move."
					+ "Choose a number between 1 and 9");
			if(!input.hasNextInt())
			{
				System.out.println("Invalid input, please use a number between 1 and 9");
				input.next();
				continue;
			}
			pick = input.nextInt();
			if(pick >= 1 && pick <= 9)
			{
				int row = (pick -1) / 3;
				int col = (pick -1) % 3;
				if(board[row][col].equals(String.valueOf(pick)))
				{
					board[row][col] = (player == 1) ? "X" : "O";
					valid = true;
				}else
				{
					System.out.println("That spot is taken");
				}
			}else
			{
				System.out.println("Input out of bounds! Choose 1-9");
			}			
		}
		
	}

	private static void printBoard(String[][] board) {
		System.out.println("╔═══╦═══╦═══╗");
		for(int i = 0; i < 3; i++)
		{
			System.out.println("║ " + board[i][0] + " ║ " + board[i][1] +" ║ " + board[i][2] +" ║");
			if(i < 2)
			{
				System.out.println("╠═══╬═══╬═══╣");
			}
		}
		System.out.println("╚═══╩═══╩═══╝");
	}

	private static String[][] intializeBoard() {
		String[][] board = new String[3][5];
		int index = 1;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = String.valueOf(index++);
			}
		}
		
		return board;
	}

}
