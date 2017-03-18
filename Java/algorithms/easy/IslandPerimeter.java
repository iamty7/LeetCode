package easy;

public class IslandPerimeter {

	/*
	 * You are given a map in form of a two-dimensional integer grid where 1
	 * represents land and 0 represents water. Grid cells are connected
	 * horizontally/vertically (not diagonally). The grid is completely
	 * surrounded by water, and there is exactly one island (i.e., one or more
	 * connected land cells). The island doesn't have "lakes" (water inside that
	 * isn't connected to the water around the island). One cell is a square
	 * with side length 1. The grid is rectangular, width and height don't
	 * exceed 100. Determine the perimeter of the island.
	 * 
	 * Example:
	 * 
	 * [[0,1,0,0] [1,1,1,0] [0,1,0,0] [1,1,0,0]]
	 * 
	 * Answer: 16
	 */

	public int solution(int[][] grid) {
		// Your runtime beats 56.62% of java submissions. Runtime 150ms
		int peri = 0;
		int hei = grid.length, wid = grid[0].length;
		for (int i = 0; i < hei; i++)
			for (int j = 0; j < wid; j++) {
				int cellPre = 0;
				if (grid[i][j] == 1) {
					if (i == 0 || grid[i - 1][j] == 0)
						++cellPre;
					if (i == hei - 1 || grid[i + 1][j] == 0)
						++cellPre;
					if (j == 0 || grid[i][j - 1] == 0)
						++cellPre;
					if (j == wid - 1 || grid[i][j + 1] == 0)
						++cellPre;
				}

				peri += cellPre;
			}

		return peri;
	}

}
