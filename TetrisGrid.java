//
// TetrisGrid encapsulates a tetris board and has
// a clearRows() capability.

public class TetrisGrid {
	private boolean[][] grid;
	/**
	 * Constructs a new instance with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
	public TetrisGrid(boolean[][] grid) {
		this.grid = grid;
	}
	
	
	/**
	 * Does row-clearing on the grid (see handout).
	 */
	public void clearRows() {
		for(int i = grid[0].length - 1; i>=0; i--) {
			if(canRemove(i)) {
				for(int j = 0; j<grid.length; j++) {
					grid[j][i] = false;
				}
				// check if it isn't last Column.
				if(i != grid[0].length-1) {
					fullSwap(i);
				}
				
			}
		}
	}
	
	//if full column is full of true we can remove this column.
	private boolean canRemove(int col) {
		for(int i=0; i<grid.length; i++) {
			if(grid[i][col] == false) {
				return false;
			}
		}
		return true;
	}
	
	
	//we change all columns with this right column.
	private void fullSwap(int col) {
		for(int i = col; i<grid[0].length - 1; i++) {
			swapCol(i);
		}
	}
	
	// change exact column with right column.
	private void swapCol(int col) {
		for(int i=0; i<grid.length; i++) {
			boolean tmp = grid[i][col];
			grid[i][col] = grid[i][col+1];
			grid[i][col+1] = tmp;
		}
	}
	
	
	/**
	 * Returns the internal 2d grid array.
	 * @return 2d grid array
	 */
	boolean[][] getGrid() {
		return grid; 
	}
}
