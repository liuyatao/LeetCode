package io.liuyatao.backtracking;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode-cn.com/problems/path-with-maximum-gold/
 * 
 * 
 * 1219. 黄金矿工
 */
public class Task1 {

    class Solution {

        private int max = 0;
        private int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        private boolean[][] visited;

        private int rowLenght = 0;
        private int colLength = 0;

        /**
         * 判断是否在区域中
         * 
         * @param row
         * @param col
         * @param grid
         * @return
         */
        boolean isInArea(int row, int col, int[][] grid) {
            int rowLength = grid.length;
            int colLength = grid[0].length;
            if (row >= rowLength || row < 0) {
                return false;
            }
            if (col >= colLength || col < 0) {
                return false;
            }
            return true;
        }

        public int getMaximumGold(int[][] grid) {
            rowLenght = grid.length;
            colLength = grid[0].length;
            visited = new boolean[rowLenght][colLength];

            for (int i = 0; i < rowLenght; i++) {
                for (int j = 0; j < colLength; j++) {
                    if (grid[i][j] != 0) {
                        System.out.println("=====开始对" + grid[i][j] + "进行dfs遍历");
                        backtracking(grid, i, j, 0);
                    }
                }
            }
            return max;
        }

        /**
         * 回溯过程
         * 
         * @param grid
         * @param row
         * @param col
         * @param now  当前总长度
         */
        void backtracking(int[][] grid, int row, int col, int now) {
            // 结束条件:无路可走
            if (!isInArea(row, col, grid) || grid[row][col] == 0 || visited[row][col]) {
                System.out.println("当前总长度：" + now);
                if (now > max) {
                    max = now;
                    System.out.println("当前最大总长度：" + max);
                }
                return;
            }

            now = now + grid[row][col];
            visited[row][col] = true;

            System.out.println(grid[row][col] + "被选择" + ";总黄金个数" + now);

            // 对该节点进行递归
            for (int[] direction : directions) { // 四个方向的下一个节点
                int newRow = row + direction[0];
                int newCol = col + direction[1];
                backtracking(grid, newRow, newCol, now);
            }

            // 回到初始状态
            now = now - grid[row][col];
            visited[row][col] = false;
            System.out.println(grid[row][col] + "被恢复" + ";总黄金个数" + now);
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        int[][] grid = { { 1, 6, 1 }, { 5, 8, 7 }, { 1, 9, 1 } };
        int result = solution.getMaximumGold(grid);
        System.out.println(result);
    }
}
