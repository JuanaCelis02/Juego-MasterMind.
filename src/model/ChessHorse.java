package model;

public class ChessHorse {
	private char[][] board;
	private int[] posHorse;

	public ChessHorse() {
		board = new char[8][8];
		posHorse = new int[2];
	}

	public void fillMatrix() {
		for (int i = 0; i < board.length; i++)
			for (int j = 0; j < board[0].length; j++)
				board[i][j] = '*';
	}

	public void putPiece() {
		int count = 0;
		posHorse[0] = getRandomBetweenRange(0, 7);
		posHorse[1] = getRandomBetweenRange(0, 7);
		board[posHorse[0]][posHorse[1]] = 'C';
		while (count < 4) {
			assing('x');
			assing('o');
			count++;
		}
	}

	public void assing(char piece) {
		int pos1 = getRandomBetweenRange(0, 7);
		int pos2 = getRandomBetweenRange(0, 7);
		while (!comprobateNoRepeat(pos1, pos2)) {
			pos1 = getRandomBetweenRange(0, 7);
			pos2 = getRandomBetweenRange(0, 7);
		}
		board[pos1][pos2] = piece;
	}

	public boolean comprobateNoRepeat(int pos1, int pos2) {
		boolean result = false;
		if (board[pos1][pos2] == '*')
			result = true;
		return result;
	}

	public int getRandomBetweenRange(int min, int max) {
		int x = (int) ((Math.random() * ((max - min) + 1)) + min);
		return x;
	}

	public String showMatrix() {
		fillMatrix();
		putPiece();
		String result = "Amigas: o\n Enemigas: x\n\n     0    1    2     3    4     5    6     7    \n";
		for (int i = 0; i < board.length; i++) {
			result += i + "   ";
			for (int j = 0; j < board[0].length; j++)
				result += board[i][j] + "     ";
			result += "\n";
		}
		return result;
	}

	public String generatePlays() {
		String plays = "\nJugadas: |";
		String topPlays = "\n\nMejores jugadas: |";
		String result ="";
		int posx = posHorse[0];
		int posy = posHorse[1];
		if (posx - 1 >= 0 && posx - 1 < 8 && posy - 2 >= 0 && posy - 2 < 8 && board[posx - 1][posy - 2] != 'o') {
			if (board[posx - 1][posy - 2] == 'x')
				topPlays += (posx - 1) + ", " + (posy - 2) + " | ";
			else
				plays += (posx - 1) + ", " + (posy - 2) + " | ";
		}
		if (posx + 1 >= 0 && posx + 1 < 8 && posy - 2 >= 0 && posy - 2 < 8 && board[posx + 1][posy - 2] != 'o') {
			if (board[posx + 1][posy - 2] == 'x')
				topPlays += (posx + 1) + ", " + (posy - 2) + " | ";
			else
				plays += (posx + 1) + ", " + (posy - 2) + " | ";
		}
		if (posx - 1 >= 0 && posx - 1 < 8 && posy + 2 >= 0 && posy + 2 < 8 && board[posx - 1][posy + 2] != 'o') {
			if (board[posx - 1][posy + 2] == 'x')
				topPlays += (posx - 1) + ", " + (posy + 2) + " | ";
			else
				plays += (posx - 1) + ", " + (posy + 2) + " | ";
		}
		if (posx + 1 >= 0 && posx + 1 < 8 && posy + 2 >= 0 && posy + 2 < 8 && board[posx + 1][posy + 2] != 'o') {
			if (board[posx + 1][posy + 2] == 'x')
				topPlays += (posx + 1) + ", " + (posy + 2) + " | ";
			else
				plays += (posx + 1) + ", " + (posy + 2) + " | ";
		}
		if (posx - 2 >= 0 && posx - 2 < 8 && posy - 1 >= 0 && posy - 1 < 8 && board[posx - 2][posy - 1] != 'o') {
			if (board[posx - 2][posy - 1] == 'x')
				topPlays += (posx - 2) + ", " + (posy - 1) + " | ";
			else
				plays += (posx - 2) + ", " + (posy - 1) + " | ";
		}
		if (posx - 2 >= 0 && posx - 2 < 8 && posy + 1 >= 0 && posy + 1 < 8 && board[posx - 2][posy + 1] != 'o') {
			if (board[posx - 2][posy + 1] == 'x')
				topPlays += (posx - 2) + ", " + (posy + 1) + " | ";
			else
				plays += (posx - 2) + ", " + (posy + 1) + " | ";
		}
		if (posx + 2 >= 0 && posx + 2 < 8 && posy - 1 >= 0 && posy - 1 < 8 && board[posx + 2][posy - 1] != 'o') {
			if (board[posx + 2][posy - 1] == 'x')
				topPlays += (posx + 2) + ", " + (posy - 1) + " | ";
			else
				plays += (posx + 2) + ", " + (posy - 1) + " | ";
		}
		if (posx + 2 >= 0 && posx + 2 < 8 && posy + 1 >= 0 && posy + 1 < 8 && board[posx + 2][posy + 1] != 'o') {
			if (board[posx + 2][posy + 1] == 'x')
				topPlays += (posx + 2) + ", " + (posy + 1) + " | ";
			else
				plays += (posx + 2) + ", " + (posy + 1) + " | ";
		}
		return result + plays + topPlays;
	}
	
	public char[][] getBoard() {
		return board;
	}
}
