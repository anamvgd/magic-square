package model;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

import customExceptions.BigNumberException;
import customExceptions.EvenNumberException;

public class MagicSquareTest {
	
	private MagicSquare ms;

	private void setupScenary1() {
		
	}
	
	private void setupScenary2() {

		ms = new MagicSquare();
		
	}

	
	@Test
	public void testMagicSquare() {
		setupScenary1();
		
		int num = 3;
		
		MagicSquare ms = new MagicSquare(num); 
		
		assertNotNull("the new contact is null", ms);
		
		assertTrue("The contact name have the wrong value", num==ms.getNum());
		
	
	}
	
	@Test
	public void testFillMagicSquare() throws ArrayIndexOutOfBoundsException, NegativeArraySizeException, EvenNumberException, BigNumberException {
		setupScenary2();
		int num = 5; 
		
		ms.setSquare(ms.fillMagicSquare(num));
    	int[][] magicS = ms.getSquare();
		int[][] realMS = {{ 17, 24, 1 , 8, 15}, {23, 5, 7, 14, 16}, {4, 6, 13, 20, 22}, {10, 12, 19, 21, 3}, {11, 18, 25, 2, 9}};
		
		assertArrayEquals(magicS, realMS);
	
		
	}
	
	@Test
	public void testFillMagicSquare2() throws ArrayIndexOutOfBoundsException, NegativeArraySizeException, EvenNumberException, BigNumberException {
		setupScenary2();
		int num = 3; 
		
		ms.setSquare(ms.fillMagicSquare(num));
    	int[][] magicS = ms.getSquare();
		int[][] realMS = {{8, 1, 6}, {3, 5, 7}, {4, 9, 2}};
		
		assertArrayEquals(magicS, realMS);
	
		
	}
	
	@Test
	public void testNegativeArray() {
		setupScenary2();
	
		int num = -3;
		
		assertThrows(NegativeArraySizeException.class,()->{
			ms.fillMagicSquare(num);
		});
	}
	
	@Test
	public void testEvenNumberArray() {
		setupScenary2();
	
		int num = 4;
		
		assertThrows(EvenNumberException.class,()->{
			ms.fillMagicSquare(num);
		});
	}
	
	@Test
	public void testBigNumberArray() {
		setupScenary2();
		int num = 103;
		assertThrows(BigNumberException.class,()->{
			ms.fillMagicSquare(num);
		});
	}
	

}
