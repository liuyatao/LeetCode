package io.liuyatao.difference;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode-cn.com/problems/corporate-flight-bookings/
 * 
 * 1109. 航班预订统计
 */
public class Task2 {

    class Solution {
        public int[] corpFlightBookings(int[][] bookings, int n) {
            int[] result = new int[n]; // 原始数组
            int[] difference = new int[n]; // 差分数组
            for (int i = 0; i < bookings.length; i++) {
                int[] booking = bookings[i];
                int start = booking[0] - 1;
                int end = booking[1] - 1;
                int count = booking[2];
                difference[start] = difference[start] + count;
                if (end + 1 < n) {
                    difference[end + 1] = difference[end + 1] - count;
                }
            }
            result[0] = difference[0];
            for (int j = 1; j < difference.length; j++) {
                result[j] = difference[j] + result[j - 1];
            }
            System.out.println("数组：" + Arrays.toString(result));
            return result;
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        int[][] bookings = { { 1, 2, 10 }, { 2, 3, 20 }, { 2, 5, 25 } };
        int[] result = solution.corpFlightBookings(bookings, 5);
        System.out.println(Arrays.toString(result));
    }
}
