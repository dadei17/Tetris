
// Test cases for CharGrid -- a few basic tests are provided.

import junit.framework.TestCase;

public class CharGridTest extends TestCase {
	
	public void testCharArea1() {
		char[][] grid = new char[][] {
				{'a', 'y', ' '},
				{'x', 'a', 'z'},
			};
		
		
		CharGrid cg = new CharGrid(grid);
				
		assertEquals(4, cg.charArea('a'));
		assertEquals(1, cg.charArea('z'));
	}
	
	
	public void testCharArea2() {
		char[][] grid = new char[][] {
				{'c', 'a', ' '},
				{'b', ' ', 'b'},
				{' ', ' ', 'a'}
			};
		
		CharGrid cg = new CharGrid(grid);
		
		assertEquals(6, cg.charArea('a'));
		assertEquals(3, cg.charArea('b'));
		assertEquals(1, cg.charArea('c'));
	}
	
	public void testCharArea3() {
		char[][] grid = new char[][] {
				{'x', 'a', 'k'},
				{'b', ' ', 'b'},
				{' ', ' ', 'y'},
				{'k', ' ', 'x'}
			};
		
		CharGrid cg = new CharGrid(grid);
		
		assertEquals(12, cg.charArea('x'));
		assertEquals(12, cg.charArea('k'));
		assertEquals(6, cg.charArea(' '));
		assertEquals(3, cg.charArea('b'));
		assertEquals(0, cg.charArea('h'));
		assertEquals(1, cg.charArea('a'));
	}
	
	public void testCountPlus1() {
		char[][] grid = new char[][] {
			{'a', 'a', 'y', 'y'},
			{'a', 'a', 'a', 'y'},
			{'z', 'a', 'y', 'y'},
			{'z', 'y', 'y', 'y'},
			{'y', 'y', 'y', 'y'}
		};
		CharGrid cg = new CharGrid(grid);
		
		assertEquals(2, cg.countPlus());
		
	}
	
	public void testCountPlus2() {
		char[][] grid = new char[][] {
			{'a', 'a', 'a', 'a', 'a'},
			{'a', 'a', 'a', 'a', 'a'},
			{'a', 'a', 'a', 'a', 'a'},
			{'a', 'a', 'a', 'a', 'a'},
			{'a', 'a', 'a', 'a', 'a'}
		};
		CharGrid cg = new CharGrid(grid);
		
		assertEquals(1, cg.countPlus());
		
	}
	
	public void testCountPlus3() {
		char[][] grid = new char[][] {
			{'a', 'g', 'a', 'a', 'a','a'},
			{'g', 'g', 'g', 'a', 'a','a'},
			{'a', 'g', 'a', 'a', 'a','a'},
			{'z', 'a', 'a', 'a', 'z','a'},
			{'z', 'a', 'a', 'a', 'a','a'}
		};
		CharGrid cg = new CharGrid(grid);
		
		assertEquals(3, cg.countPlus());
		
	}
	
	public void testCountPlus4() {
		char[][] grid = new char[][] {
			{'a', 'g', 'a', 'a', 'a','a'},
			{'g', 'g', 'g', 'a', 'a','a'},
			{'a', 'g', 'a', 'a', 'a','a'},
			{'z', 'g', 'a', 'a', 'z','a'},
			{'z', 'a', 'a', 'a', 'a','a'}
		};
		CharGrid cg = new CharGrid(grid);
		
		assertEquals(1, cg.countPlus());
		
	}
	
	public void testCountPlus5() {
		char[][] grid = new char[][] {
			{' ', 'g', 'p', ' ', 'a','a',' ','a',' '},
			{'a', 'g', 'p', 'a', 'a','a','x','a','b'},
			{'p', 'p', 'p', 'p', 'p','x','x','x',' '},
			{'a', 'g', 'p', 'a', 'a','y','x','a','b'},
			{' ', 'g', 'p', 'a', 'y','y','y','a','b'},
			{'z', 'z', 'z', 'z', 'z','y','z','z','z'},
			{'a', 'g', 'x', 'x', 'a','y','g',' ',' '}
		};
		CharGrid cg = new CharGrid(grid);
		
		assertEquals(2, cg.countPlus());
		
	}
	
	
	
}
