package io.liuyatao.twoPointers;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 * 
 * 240. 搜索二维矩阵 II
 */
public class Task3 {
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            // 从左上角开始
            int initRow = matrix.length - 1;
            int initCol = 0;
            while (initRow >= 0 && initCol < matrix[0].length) {
                if (target < matrix[initRow][initCol]) {
                    initRow--;
                } else if (target > matrix[initRow][initCol]) {
                    initCol++;
                } else {
                    return true;
                }
                System.out.println("initRow=" + initRow + ";initCol=" + initCol);
            }
            return false;
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        int[][] matrix = { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 }, { 10, 13, 14, 17, 24 },
                { 18, 21, 23, 26, 30 } };
        boolean result = solution.searchMatrix(matrix, 25);
        System.out.println(result);
    }
}
