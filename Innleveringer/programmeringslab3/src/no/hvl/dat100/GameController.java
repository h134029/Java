package no.hvl.dat100.tictactoe;

import java.util.Arrays;

public class GameController {

	private char[][] board;
	private char turn;

	public GameController() {
		turn = TicTacToe.X_PLAYER_CHR; // Player 'X' starts the game
		board = new char[TicTacToe.SIZE][TicTacToe.SIZE];
	}

	public char getTurn() {
		return turn;
	}

	public void nextTurn() {
		switch (turn) {
		case TicTacToe.X_PLAYER_CHR:
			turn = TicTacToe.O_PLAYER_CHR;
			break;
		case TicTacToe.O_PLAYER_CHR:
			turn = TicTacToe.X_PLAYER_CHR;
			break;
		}
	}

	// check board given that field (x,y) has been selected by player
	public char checkGameBoard(int x, int y, char player) {
		char winner = ' ';

		System.out.println("Updating Gameboard (" + x + "," + y + ") = " + player);
		board[y][x] = player;

		System.out.println("Checking Gameboard");

		if (checkGameBoardPlayer(TicTacToe.X_PLAYER_CHR)) {
			winner = TicTacToe.X_PLAYER_CHR;
		} else if (checkGameBoardPlayer(TicTacToe.O_PLAYER_CHR)) {
			winner = TicTacToe.O_PLAYER_CHR;
		}

		System.out.println("Winner = " + winner);

		return winner;
	}

	public boolean checkGameBoardPlayer(char player) {

		boolean gameover = false;

		// check all rows on the board (horizontal)
		int y = 0;
		while (!gameover && y < TicTacToe.SIZE) {

			gameover = checkHorizontal(y, player);
			y++;
		}

		// check all columns on the board (vertical)
		int x = 0;
		while (!gameover && x < TicTacToe.SIZE) {

			gameover = checkVertical(x, player);
			x++;
		}
		if (!gameover) {
			gameover = checkDiagonals(player);
		}
		return gameover;
	}

	private boolean checkHorizontal(int y, char player) {

		// TODO - START
		char[] hor_Test = new char[TicTacToe.SIZE];

		for (int i=0; i<TicTacToe.SIZE; i++) {
			hor_Test[i] = player;		// {player, player, ...n=i} Array
		}
		if (Arrays.equals(board[y],hor_Test)) {
			return true;
		} else {
			return false;
		}
		// TODO - SLUTT
	}

	private boolean checkVertical(int x, char player) {

		// TODO - START
		char[] ver_Test = new char[TicTacToe.SIZE];
		char[] ver = new char[TicTacToe.SIZE];

		for (int i=0; i<TicTacToe.SIZE; i++) {
			ver_Test[i] = player;		// {player, player, ...n=i} Array
			ver[i] = board[i][x];		// {player value from [y=1,2,..SIZE-1] in x index [x]
		}
		if (Arrays.equals(ver, ver_Test)) {
			return true;
		} else {
			return false;
		}
		// TODO - SLUTT
	}

	private boolean checkDiagonals(char player) {

		// TODO - START
		int checksum_lr = 0;
		int checksum_rl = 0;
		int i = 0;
		int j = 0;
		int k = TicTacToe.SIZE-1;

		while( i < TicTacToe.SIZE || k >= 0) {
			checksum_lr += (board[j][i++] == player) ? 1 : 0;
			checksum_rl += (board[j++][k--] == player) ? 1 : 0;
		}
		if (checksum_lr == TicTacToe.SIZE || checksum_rl == TicTacToe.SIZE) {
			return true;
		} else {
			return false;
		}
		// TODO - SLUTT
	}
}
