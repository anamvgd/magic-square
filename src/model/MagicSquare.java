package model;

import customExceptions.BigNumberException;
import customExceptions.EvenNumberException;

public class MagicSquare {
	
	public static final String TOP_ROW = "TP";
	public static final String LAST_ROW = "LR";
	public static final String FIRST_COLUMN = "FC";
	public static final String LAST_COLUMN = "LC";
	
	/**
	 * This attribute defines the position of the number one 
	 */
	private String position;
	
	/**
	 * This attribute is the number that defines the size of the square
	 */
	private int num;
	
	/**
	 * This attribute is the matrix that is going to fill the magic square
	 */
	private int[][] square;
	
	/**
	 * This method initializes the attributes of the class
	 * @param num
	 */
	public MagicSquare(int num) {
		this.num = num;
		this.square = new int[num][num];
	}
	


	public MagicSquare() {
		
	}



	/**
	 * This method calculates the magic constant that it's the number that
	 * has to sum in every row and column of the matrix
	 * @return an integer that is the magic constant
	 */
	public int magicConstant() {
		int mc = num*(num*num + 1)/2;
		return mc;
	}
	

	/**
	 * This method fills all the positions of the square so each column and each row
	 * can sum the magic constant when the number One is on the top row
	 * @param num
	 * @return a matrix that is the magic square with number one on the top row
	 */
	public int[][] fillMagicSquare(int num) throws ArrayIndexOutOfBoundsException, NegativeArraySizeException, EvenNumberException, BigNumberException{
	
		if(num%2 == 0) {
			throw new EvenNumberException(num);
		} else if(num > 31){
			throw new BigNumberException(num);
		}else {
		int lastCol = 0, lastRow = 0;
		
		int[][] magicS = new int[num][num];
		
		int fCol = (num - 1) / 2;
		int fRow = 0;
		int one = 1;

		for(int i=0; i<num; i++) {
			for(int j=0; j<num; j++) {
				magicS[fRow][fCol] = one;
				
				lastCol = fCol;
				lastRow = fRow;
				
				fRow = lastRow - 1;
				fCol = lastCol + 1;
				
				if(fRow < 0) {
					fRow = num-1;
				}
				
				if(fCol>=num) {
					fRow = lastRow - 1;
					fCol = 0;
				}
				
				if(fRow==-1 || magicS[fRow][fCol]!=0) {
					fRow = lastRow + 1;
					fCol = lastCol;
				}
				one++;
			}
		}
		return magicS;
	}
	}

	/**
	 * This method allows to access to the magic square
	 * @return a matrix of integer that is the magic square
	 */
	
	
	/**
	 * This method prints the magic square
	 * @return a String that is the magic square
	 */
	public String printMagicSquare() {
		String printM = "";
		for(int i=0; i<num; i++) {
			for(int j=0; j<num;j++) {
				printM += square[i][j] +"\t";
			}
			printM +="\n";
		}
		return printM;
	}
	
	public int[][] getSquare(){
		return square;
	}
	
	public int getNum() {
		return num;
	}
	
	/**
	 * This method allows to modify the square
	 * @param square
	 */
	public void setSquare(int[][] square) {
		this.square = square;
	}
	
	public String getPosition() {
		return position; 
	}
	public void setPosition(String position) {
		this.position = position;
	}
	

}
