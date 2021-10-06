package io.liuyatao.difference;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode-cn.com/problems/range-addition/
 * 
 * 370 区间加法
 */
public class Task1 {
    /**
     * Solution
     */
    public class Solution {
        public int[] update(int lenght, int[][] updates) {
            int[] result = new int[lenght];
            int[] difference = new int[lenght];
            for (int i = 0; i < updates.length; i++) {
                int[] tuple = updates[i];
                int start = tuple[0];
                int end = tuple[1];
                int inc = tuple[2];
                difference[start] = inc;
                if (end + 1 < lenght) {
                    difference[end + 1] = difference[end + 1] - inc;
                }
            }
            result[0] = difference[0];
            for (int j = 1; j < difference.length; j++) {
                result[j] = difference[j] + result[j - 1];
            }
            System.out.println("结果是：" + Arrays.toString(result));
            return result;
        }
    }

    @Test
    public void name() {
        Solution solution = new Solution();
        int[][] updates = { { 1, 3, 2 }, { 2, 4, 3 }, { 0, 2, -2 } };
        int[] result = solution.update(5, updates);
        System.out.println(Arrays.toString(result));
    }
}
