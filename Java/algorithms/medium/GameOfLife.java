package medium;

public class GameOfLife {
	/*
	 * According to the Wikipedia's article:
	 * "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
	 * 
	 * Given a board with m by n cells, each cell has an initial state live (1)
	 * or dead (0). Each cell interacts with its eight neighbors (horizontal,
	 * vertical, diagonal) using the following four rules (taken from the above
	 * Wikipedia article):
	 * 
	 * Any live cell with fewer than two live neighbors dies, as if caused by
	 * under-population. Any live cell with two or three live neighbors lives on
	 * to the next generation. Any live cell with more than three live neighbors
	 * dies, as if by over-population.. Any dead cell with exactly three live
	 * neighbors becomes a live cell, as if by reproduction. Write a function to
	 * compute the next state (after one update) of the board given its current
	 * state.
	 * 
	 * Follow up: Could you solve it in-place? Remember that the board needs to
	 * be updated at the same time: You cannot update some cells first and then
	 * use their updated values to update other cells. In this question, we
	 * represent the board using a 2D array. In principle, the board is
	 * infinite, which would cause problems when the active area encroaches the
	 * border of the array. How would you address these problems?
	 */

	public void gameOfLife(int[][] board) {
		// 2 represents reborn, -1 represents death in the next generation
		// Your runtime beats 7.47% of java submissions. Runtime 2ms
		for (int i = 0; i < board.length; i++)
			for (int j = 0; j < board[0].length; j++) {
				int cnt = -board[i][j];
				for (int k = -1; k < 2; k++)
					for (int l = -1; l < 2; l++) {
						if (-1 < i + k && i + k < board.length && -1 < j + l && j + l < board[0].length
								&& Math.abs(board[i + k][j + l]) == 1)
							cnt++;
					}
				if ((cnt < 2 || cnt > 3) && board[i][j] == 1)
					board[i][j] = -1;
				if (cnt == 3 && board[i][j] == 0)
					board[i][j] = 2;
			}
		for (int i = 0; i < board.length; i++)
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == -1)
					board[i][j] = 0;
				if (board[i][j] == 2)
					board[i][j] = 1;
			}
	}

	public void gameOfLife2(int[][] board) {
		// !! More elegant way
		// Your runtime beats 16.53% of java submissions. Runtime 1ms

		/*
		 * To solve it in place, we use 2 bits to store 2 states:
		 * 
		 * [2nd bit, 1st bit] = [next state, current state]
		 * 
		 * - 00 dead (next) <- dead (current) - 01 dead (next) <- live (current)
		 * - 10 live (next) <- dead (current) - 11 live (next) <- live (current)
		 * 
		 * To get the current state, simply do
		 * board[i][j] & 1 
		 * 
		 * To get the next state, simply do
		 * board[i][j] >> 1
		 */

		if (board == null || board.length == 0)
			return;
		int m = board.length, n = board[0].length;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int lives = liveNeighbors(board, m, n, i, j);

				// In the beginning, every 2nd bit is 0;
				// So we only need to care about when will the 2nd bit become 1.
				if (board[i][j] == 1 && lives >= 2 && lives <= 3) {
					board[i][j] = 3; // Make the 2nd bit 1: 01 ---> 11
				}
				if (board[i][j] == 0 && lives == 3) {
					board[i][j] = 2; // Make the 2nd bit 1: 00 ---> 10
				}
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] >>= 1; // Get the 2nd state.
			}
		}
	}

	public int liveNeighbors(int[][] board, int m, int n, int i, int j) {
		int lives = 0;
		for (int x = Math.max(i - 1, 0); x <= Math.min(i + 1, m - 1); x++) {
			for (int y = Math.max(j - 1, 0); y <= Math.min(j + 1, n - 1); y++) {
				lives += board[x][y] & 1;
			}
		}
		lives -= board[i][j] & 1;
		return lives;
	}
}
