package io.liuyatao.backtracking.mid;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/
 * 
 * 剑指 Offer 12. 矩阵中的路径
 */
public class Task2 {
    class Solution {

        private int rowLength;
        private int colLength;
        private char[] chWord;
        private boolean[][] visited;
        private char[][] board;

        private int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        public boolean exist(char[][] board, String word) {
            rowLength = board.length;
            colLength = board[0].length;
            chWord = word.toCharArray();
            this.board = board;
            visited = new boolean[rowLength][colLength];

            for (int i = 0; i < rowLength; i++) {
                for (int j = 0; j < colLength; j++) {
                    dfs(i, j, 0);
                }
            }
            return false;
        }

        private void dfs(int row, int col, int index) {

            if (board[row][col] != chWord[index]) {
                return;
            }

            visited[row][col] = true;

            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];
                if (isInAres(newRow, newCol)) {
                    dfs(newRow, newCol, index + 1);
                }
            }


        }

        private boolean isInAres(int row, int col) {
            if (row < 0 || row >= rowLength) {
                return false;
            }
            if (col < 0 || col >= colLength) {
                return false;
            }
            return true;
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        solution.exist(board, "ABCCED");
    }
}
