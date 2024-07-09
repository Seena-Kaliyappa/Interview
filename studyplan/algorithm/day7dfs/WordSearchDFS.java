package com.seena.studyplan.algorithm.day7dfs;

/**
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 * <p>
 * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * <p>
 *
 *
 * Example 1:
 * <p>
 *
 * Input: board = [["A","B","C","E"],
 *                 ["S","F","C","S"],
 *                 ["A","D","E","E"]
 * <p>
 *                 ], word = "ABCCED"
 * Output: true
 * Example 2:
 * <p>
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * Output: true
 * Example 3:
 * <p>
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * Output: false
 * <p>
 *
 * Constraints:
 * <p>
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board and word consists of only lowercase and uppercase English letters.
 * <p>
 *
 * Follow up: Could you use search pruning to make your solution faster with a larger board?
 */
public class WordSearchDFS {
    public static void main(String[] args) {
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
                };
        String word = "ABCCED";

        char[][] input = {
                        {'C', 'A','A'},
                        {'A', 'A','A'},
                        {'B', 'C','D'}
                        };
        String word2 = "AAB";
        System.out.println(" Is String found ==>" + exist(input, word2));
        System.out.println(" Is String found ==>" + existWithVisited(input, word2));
    }

    private static boolean exist(char[][] board, String word) {
        boolean result = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j <board[i].length ; j++) {
                if (board[i][j] == word.charAt(0) && !result) {
                    result = dfs(board, word, i, j, 0);
                }
            }
        }
        return result;
    }

    private static boolean existWithVisited(char[][] board, String word) {
        boolean result = false;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j <board[i].length ; j++) {
                if (board[i][j] == word.charAt(0) && !result) {
                    result = existWord(board, i, j, 0, word, visited);
                }
            }
        }
        return result;
    }

    private static boolean dfs(char[][] board, String word, int i, int j, int index) {
        if (i < 0 || i >= board.length || j <0 || j >= board[i].length || board[i][j] != word.charAt(index)) {
            return false;
        }
        if (index == word.length()-1) {
            return true;
        }
        char tmp = board[i][j] ; // take backup
        board[i][j] = ' '; //mark cell is visited
        ++index;
        boolean found =   dfs(board, word, i+1, j, index) ||
                dfs(board, word, i-1, j, index) ||
                dfs(board, word, i, j+1, index) ||
                dfs(board, word, i, j-1, index);
        board[i][j] = tmp; // mark cell is not visited
        return  found;
    }



    public static boolean existWord(final char[][] board, final int i, final int j, final int idx, final String word, final boolean[][] visited) {
        //If idx is equal to length of word, meaning word is found in the board, so return true.
        if (idx == word.length()) {
            return true;
        }

        //If we go out of bounds(first 4 conditions) or char at (i,j) in board is not equal to char at idx in word(fifth condition)
        //or the cell is already visited(sixth condition), then return false.
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(idx) || visited[i][j]) {
            return false;
        }

        //Mark the cell visited.
        visited[i][j] = true;

        //If the word is found by going to top, left, bottom or right cell, then return true.
        boolean isFound = existWord(board, i - 1, j, idx + 1, word, visited) ||
                existWord(board, i, j - 1, idx + 1, word, visited) ||
                existWord(board, i + 1, j, idx + 1, word, visited) ||
                existWord(board, i, j + 1, idx + 1, word, visited);


        //Mark the cell unvisited.
        visited[i][j] = false;

        return isFound;
    }
}
