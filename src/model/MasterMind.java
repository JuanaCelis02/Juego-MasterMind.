package model;

import java.util.Arrays;

public class MasterMind {
	public static final int ROW_SIZE = 10;
	public static final int COLUMN_SIZE = 4;
	public static final int FIJAS_SIZE = 10;
	public static final int PICAS_SIZE = 10;
	private static final int HIDDEN_NUMBER_SIZE = 4;
	private int [][] board;
	private int [] fijas;
	private int [] picas;
	private int [] hiddenNumber;
	private int[] move;
	private int lives;
	private String name;
	private int [][] matriz;
	
	public MasterMind() {
		
		board = new int[ROW_SIZE][COLUMN_SIZE];
		fijas = new int[FIJAS_SIZE];
		picas = new int[PICAS_SIZE];
		hiddenNumber = new int[HIDDEN_NUMBER_SIZE];
		move = new int[4];
		lives = 10;
		
		matriz = new int[5][5];
		for (int i = 0; i < 5; i++) 
			for (int j = 0; j < 5; j++) 
				matriz[i][j] = (int)(Math.random()*40+1);
		
		for (int i = 0; i < ROW_SIZE; i++) 
			for (int j = 0; j < COLUMN_SIZE; j++) 
				board[i][j] = 0;
		
		for (int i = 0; i < fijas.length; i++) 
			fijas[i]=0;
		
		for (int i = 0; i < picas.length; i++) 
			picas[i]=0;
		
		for (int i = 0; i < hiddenNumber.length; i++) 
			hiddenNumber[i]=0;
		
	}
	
	
	public int[][] getMatriz() {
		return matriz;
	}


	public void setMatriz(int[][] matriz) {
		this.matriz = matriz;
	}


	public void toPrintBoardMastermind(){
		for (int i = 0; i < ROW_SIZE; i++) {
			for (int j = 0; j < COLUMN_SIZE; j++) {
				System.out.print(board[i][j]);
			}
			System.out.print(" "+fijas[i]);
			System.out.println("|"+picas[i]);
		}
		
	}
	

	public int[] generateHiddenNumber() {
	    int index = 0;
	    while(index < hiddenNumber.length) {
	        int propuesto = (int)(Math.random()*8+1);
	        boolean repetido = false;
	        while(!repetido) {
	            for(int i=0; i<index; i++) {
	                if(propuesto == hiddenNumber[i]) {
	                    repetido = true;
	                    break;
	                }
	            }
	            if(!repetido) {
	                hiddenNumber[index] = propuesto;
	                index++;
	            }
	        }

	    }
	    
	    System.out.print(Arrays.toString(hiddenNumber));
		return hiddenNumber;
	}
	public void generateMatriz() {
		
	}
	public int convertNumberStringToNumericValue(String numberString) {
		char caracter;
		int number = 0;
		int x = 0;
		int count = 0;
		for(int i = numberString.length()-1; i >= 0; i--) {
			caracter = numberString.charAt(i);
			x = caracter - 48;
			number += x*(int)miExponente(10,count);
			count++;
		}
		return number;
	}
	public void fillMove(String num) {
		for (int i = 0; i < num.length(); i++) 
			move[i] = num.charAt(i) - 48;
		lives--;
		fillMatrix();
		compareFijas();
		comparePicas();
		
	}
	public void fillMatrix() {
		for (int j = 0; j < board[0].length; j++) {
			if (board[lives][j]==0) {
				board[lives][j]=move[j];
			}
		}
	}
	public boolean compareFijas() {
		int count = 0;
		boolean win = false;
		for (int i = 0; i < move.length; i++) {
			for (int j = 0; j < hiddenNumber.length; j++) 
				if (move[i] == hiddenNumber[j] && i == j) {
					count++;
					if (count == 4) {
						lives = 0;
						win = true;
					}
				}	
			fijas[lives] = count;
		}
		return win;
	}
	public void comparePicas() {
		int count = 0;
		for (int i = 0; i < move.length; i++) {
			for (int j = 0; j < hiddenNumber.length; j++) 
				if (move[i] == hiddenNumber[j] && i != j) 
					count++;
			picas[lives] = count;
		}
	}
	
	public String showResult() {
		String result = "";
		for (int i = 0, k = 10; i < board.length; i++,k--) {
			result+= "Intento: " + k + "       ";
			for (int j = 0; j < board[0].length; j++) 
				result+= board[i][j] + " ";
			result += "Fijas ---> " + fijas[i]+ " y picas ---> "  +  picas[i]+ "\n";
		}
		return result;
	}
	
	public float miExponente(double number,int pow) {
		float result = 1;
		for (int i = 1; i<=pow; i++) 
			result = (float) (result * number);	
		return result;
	}
	
	/*public void convertNumPlayerToArray() {
		convertNumberStringToNumericValue(numberPlayer);
		for(int i = 0; i < numberPlayer.length();i++) {
			
		}
		
		System.out.println(numberPlayer);
	}*/
	
	public int getLives() {
		return lives;
	}
	public int[][] getBoard() {
		return board;
	}

	public void setBoard(int[][] board) {
		this.board = board;
	}

	public int[] getMove() {
		return move;
	}
	public void setMove(int[] move) {
		this.move = move;
	}
	public void setLives(int live) {
		this.lives = live;
	}


	public int[] getFijas() {
		return fijas;
	}
	public void setFijas(int[] fijas) {
		this.fijas = fijas;
	}
	public int[] getPicas() {
		return picas;
	}
	public void setPicas(int[] picas) {
		this.picas = picas;
	}
	public int[] getHiddenNumber() {
		return hiddenNumber;
	}
	public void setHiddenNumber(int[] hiddenNumber) {
		this.hiddenNumber = hiddenNumber;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
