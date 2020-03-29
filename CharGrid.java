// HW1 2-d array Problems
// CharGrid encapsulates a 2-d grid of chars and supports
// a few operations on the grid.

public class CharGrid {
	private char[][] grid;

	/**
	 * Constructs a new CharGrid with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
	public CharGrid(char[][] grid) {
		this.grid = grid;
	}
	
	/**
	 * Returns the area for the given char in the grid. (see handout).
	 * @param ch char to look for
	 * @return area for given char
	 */
	public int charArea(char ch) {
		int minX = grid[0].length;
		int maxX = 0;
		int minY = grid.length;
		int maxY = 0;
		int counter = 0;
		for(int i=0; i<grid.length; i++) {
			for(int j = 0; j <grid[0].length; j++) {
				if(grid[i][j] == ch) {
					counter ++;
					if(i < minY) minY = i;
					if(i > maxY) maxY = i;
					if(j < minX) minX = j;
					if(j > maxX) maxX = j;
				}
			}
		}
		if(counter == 1) return 1;
		if(counter == 0) return 0;
		int result = (maxX - minX + 1) * (maxY - minY + 1);
		return result; 
	}
	
	/**
	 * Returns the count of '+' figures in the grid (see handout).
	 * @return number of + in grid
	 */
	public int countPlus() {
		int res = 0;
		for(int i =0; i<grid.length; i++) {
			for(int j = 0; j <grid[0].length; j++) {
				if((left(i,j,grid[i][j]) == 0 ))continue;
				int left = left(i,j,grid[i][j]);
				int right = right(i,j,grid[i][j]);
				int up = up(i,j,grid[i][j]);
				int down = down(i,j,grid[i][j]);
				if((right == left) && (up == left) && (down == left)) res++;	
			}
		}
		return res; 
	}
	
	private int up(int x, int y, char ch) {
		int res = 0;
		for(int i=x - 1; i>=0; i--) {
			if(ch == grid[i][y]) {
				res++;
			}else break;
		}
		return res;
	}
	
	private int down(int x, int y, char ch) {
		int res = 0;
		for(int i=x + 1; i<grid.length; i++) {
			if(ch == grid[i][y]) {
				res++;
			}else break;
		}
		return res;
	}
	
	private int right(int x, int y, char ch) {
		int res = 0;
		for(int i=y + 1; i<grid[0].length; i++) {
			if(ch == grid[x][i]) {
				res++;
			}else break;
		}
		return res;
	}
	
	private int left(int x, int y, char ch) {
		int res = 0;
		for(int i=y - 1; i>=0; i--) {
			if(ch == grid[x][i]) {
				res++;
			}else break;
		}
		return res;
	}
	
}
