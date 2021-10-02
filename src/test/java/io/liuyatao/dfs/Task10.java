package io.liuyatao.dfs;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 * 
 * 剑指 Offer 13. 机器人的运动范围
 */
public class Task10 {

    class Solution {

        private int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        private int colLength = 0;
        private int rowLength = 0;
        private boolean[][] visited;
        private boolean[][] marked; // 用于结果打印
        private int count = 0;

        private boolean isInArea(int row, int col) {
            if (col < 0 || col >= colLength) {
                return false;
            }
            if (row < 0 || row >= rowLength) {
                return false;
            }
            return true;
        }

        public int movingCount(int m, int n, int k) {
            rowLength = m;
            colLength = n;
            visited = new boolean[rowLength][colLength];
            marked = new boolean[rowLength][colLength];

            dfs(0, 0, k);
            printMarked();
            return count;
        }

        /**
         * 深度
         * 
         * @param row
         * @param col
         * @param k
         */
        private void dfs(int row, int col, int k) {
            // 终止条件
            int sum = getSum(row) + getSum(col);
            if (sum <= k) {
                count++;
                marked[row][col] = true;
            }
            visited[row][col] = true;
            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];
                if (isInArea(newRow, newCol) && !visited[newRow][newCol]) {
                    dfs(newRow, newCol, k);
                }
            }

        }

        public int getSum(int number) {
            int sum = 0;
            while (number >= 10) {
                sum = sum + number % 10;
                number = number / 10;
            }
            return sum + number;
        }

        private void printMarked() {
            System.out.println("-------------------");
            for (int i = 0; i < marked.length; i++) {
                System.out.println(Arrays.toString(marked[i]));
            }
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        int result = solution.movingCount(16, 8, 4);
        System.out.println(result);
    }

    @Test
    public void test1() {
        Solution solution = new Solution();
        int result = solution.getSum(241);
        System.out.println(result);
    }
}
