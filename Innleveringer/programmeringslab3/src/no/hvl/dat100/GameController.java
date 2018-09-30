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
		char[] hor = new char[TicTacToe.SIZE];
		// Array for horizontal player values that equals victory
		for (int i=0; i<TicTacToe.SIZE; i++) {
			hor[i] = player;
		}
		if (Arrays.equals(board[y],hor)) {
			return true;
		} else {
			return false;
		}
		// TODO - SLUTT
	}

	private boolean checkVertical(int x, char player) {

		// TODO - START
		char[] ver = new char[TicTacToe.SIZE];
		char[] ver_Test = new char[TicTacToe.SIZE];
		// Array for vertical player values that equals victory
		for (int i=0; i<TicTacToe.SIZE; i++) {
			ver[i] = player;
		}
		// Array for [x] index player values going through y=j in the board array
		for (int j=0; j<TicTacToe.SIZE; j++) {
			ver_Test[j] = board[j][x];
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

		while( i < TicTacToe.SIZE) {
			checksum_lr += (board[j++][i++] == player) ? 1 : 0;
		}
		int k = 0;
		int l = TicTacToe.SIZE-1;
		while( k < TicTacToe.SIZE && l >= 0) {
			checksum_rl += (board[k++][l--] == player) ? 1 : 0;
		}
		if (checksum_lr == TicTacToe.SIZE || checksum_rl == TicTacToe.SIZE) {
			return true;
		} else {
			return false;
		}
		// TODO - SLUTT
	}
}
