package io.liuyatao.prefixSum.mid;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode-cn.com/problems/range-sum-query-2d-immutable/
 * 
 * 304. 二维区域和检索 - 矩阵不可变
 */
public class Task3 {
class NumMatrix {
    int[][] prefix;

    public NumMatrix(int[][] matrix) {
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        prefix = new int[rowLength + 1][colLength + 1];
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                prefix[i + 1][j + 1] = prefix[i][j + 1] + prefix[i + 1][j] - prefix[i][j] + matrix[i][j];
            }
        }
        for (int[] is : prefix) {
            System.out.println(Arrays.toString(is));
        }

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return prefix[row2 + 1][col2 + 1] - prefix[row2 + 1][col1] - prefix[row1][col2 + 1] + prefix[row1][col1];
    }
}

    @Test
    public void test() {
        NumMatrix numMatrix = new NumMatrix(new int[][] { { 3, 0, 1, 4, 2 }, { 5, 6, 3, 2, 1 }, { 1, 2, 0, 1, 5 },
                { 4, 1, 0, 1, 7 }, { 1, 0, 3, 0, 5 } });

        int result = numMatrix.sumRegion(2, 1, 4, 3);
        System.out.println(result);
    }
}
