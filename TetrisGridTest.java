import junit.framework.TestCase;
import java.util.*;

public class TetrisGridTest extends TestCase {
	
	// Provided simple clearRows() test
	// width 2, height 3 grid
	public void testClear1() {
		boolean[][] before =
		{	
			{true, true, false, },
			{false, true, true, }
		};
		
		boolean[][] after =
		{	
			{true, false, false},
			{false, true, false}
		};
		
		TetrisGrid tetris = new TetrisGrid(before);
		tetris.clearRows();

		assertTrue( Arrays.deepEquals(after, tetris.getGrid()) );
	}
	
	public void testClear2() {
		boolean[][] before =
		{	
			{true, true, false, false,true},
			{false, true, true, true, true}
		};
		
		boolean[][] after =
		{	
			{true, false, false,false,false},
			{false, true, true,false, false}
		};
		
		TetrisGrid tetris = new TetrisGrid(before);
		tetris.clearRows();

		assertTrue( Arrays.deepEquals(after, tetris.getGrid()) );
	}
	
	public void testClear3() {
		boolean[][] before =
		{	
			{true, true, true, true,true},
			{false, false, false, false, true}
		};
		
		boolean[][] after =
		{	
			{true, true, true,true,false},
			{false, false, false,false, false}
		};
		
		TetrisGrid tetris = new TetrisGrid(before);
		tetris.clearRows();

		assertTrue( Arrays.deepEquals(after, tetris.getGrid()) );
	}
	
	public void testClear4() {
		boolean[][] before =
		{	
			{true, false, false, false, true,  true,  true},
			{true, false, true,  false, false, true,  true},
			{true, true,  false, true,  true,  true,  false},
			{true, true,  true,  true,  false, true,  true},
			{true, true,  false, true,  true,  true,  true}
		};
		
		boolean[][] after =
		{	
			{false, false, false, true,  true,  false,  false},
			{false, true,  false, false, true,  false,  false},
			{true,  false, true,  true,  false, false,  false},
			{true,  true,  true,  false, true,  false,  false},
			{true,  false, true,  true,  true,  false,  false}
		};
		
		TetrisGrid tetris = new TetrisGrid(before);
		tetris.clearRows();

		assertTrue( Arrays.deepEquals(after, tetris.getGrid()) );
	}
	
	public void testClear5() {
		boolean[][] before =
		{	
			{true,  false, false, false, true,  true,  true},
			{true,  false, true,  false, false, false, true},
			{true,  true,  false, true,  true,  true,  true},
			{false, true,  true,  true,  false, true,  true},
			{true,  true,  false, true,  true,  true,  true}
		};
		
		boolean[][] after =
		{	
			{true,  false, false, false, true,  true,  false},
			{true,  false, true,  false, false, false, false},
			{true,  true,  false, true,  true,  true,  false},
			{false, true,  true,  true,  false, true,  false},
			{true,  true,  false, true,  true,  true,  false}
		};
		
		TetrisGrid tetris = new TetrisGrid(before);
		tetris.clearRows();

		assertTrue( Arrays.deepEquals(after, tetris.getGrid()) );
	}
	
	public void testClear6() {
		boolean[][] before =
		{	
			{},
			{}
		};
		
		boolean[][] after =
		{	
			{},
			{}
		};
		
		TetrisGrid tetris = new TetrisGrid(before);
		tetris.clearRows();

		assertTrue( Arrays.deepEquals(after, tetris.getGrid()) );
	}
	
	public void testClear7() {
		boolean[][] before =
		{	
			{},
			{}
		};
		
		boolean[][] after =
		{	
			{false, false, false},
			{true, false, true,}
		};
		
		TetrisGrid tetris = new TetrisGrid(before);
		tetris.clearRows();

		assertFalse( Arrays.deepEquals(after, tetris.getGrid()) );
	}
	
	public void testClear8() {
		boolean[][] before =
		{	
			{true, true, true},
			{true, true, true}
		};
		
		boolean[][] after =
		{	
			{false, false, false},
			{false, false, false}
		};
		
		TetrisGrid tetris = new TetrisGrid(before);
		tetris.clearRows();

		assertTrue( Arrays.deepEquals(after, tetris.getGrid()) );
	}
	
	
	
}
