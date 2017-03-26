package medium;

public class WordSearch {

	/*
	 * Given a 2D board and a word, find if the word exists in the grid.
	 * 
	 * The word can be constructed from letters of sequentially adjacent cell,
	 * where "adjacent" cells are those horizontally or vertically neighboring.
	 * The same letter cell may not be used more than once.
	 * 
	 * For example, Given board =
	 * [ ['A','B','C','E'], 
	 *   ['S','F','C','S'], 
	 *   ['A','D','E','E'] 
	 * ] 
	 * 
	 * word = "ABCCED", -> returns true, 
	 * word = "SEE", -> returns true, 
	 * word = "ABCB", -> returns false.
	 */
	
	public boolean exist(char[][] board, String word) {
		// Your runtime beats 38.35% of java submissions. Runtime 16ms
		if (board.length == 0)
			return false;
		// You can use board[y][x] ^= 256 to mark to make sure a cell not used
		// twice instead of additional space
		boolean[][] used = new boolean[board.length][board[0].length];
		for (int i = 0; i < board.length; i++)
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == word.charAt(0) && helper(word, 1, used, board, i, j))
					return true;
			}
		return false;
	}

	private boolean helper(String word, int i, boolean[][] used, char[][] board, int k, int l) {
		if (i == word.length())
			return true;
		used[k][l] = true;

		// The following you can replce with false condition, which has fewer
		// code lines
		if (k - 1 >= 0 && !used[k - 1][l] && board[k - 1][l] == word.charAt(i))
			if (helper(word, i + 1, used, board, k - 1, l))
				return true;
		if (k + 1 < board.length && !used[k + 1][l] && board[k + 1][l] == word.charAt(i))
			if (helper(word, i + 1, used, board, k + 1, l))
				return true;
		if (l - 1 >= 0 && !used[k][l - 1] && board[k][l - 1] == word.charAt(i))
			if (helper(word, i + 1, used, board, k, l - 1))
				return true;
		if (l + 1 < board[0].length && !used[k][l + 1] && board[k][l + 1] == word.charAt(i))
			if (helper(word, i + 1, used, board, k, l + 1))
				return true;

		used[k][l] = false;
		return false;
	}
}
