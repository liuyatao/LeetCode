package io.liuyatao.prefixSum.mid;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode-cn.com/problems/longest-well-performing-interval/
 * 
 * 1124. 表现良好的最长时间段
 */
public class Task6 {

    class Solution {
        public int longestWPI(int[] hours) {
            int[] newHours = new int[hours.length];
            for (int i = 0; i < newHours.length; i++) {
                if (hours[i] > 8) {
                    newHours[i] = 1;
                } else {
                    newHours[i] = -1;
                }
            }
            int[] preSum = new int[hours.length + 1];
            for (int i = 0; i < newHours.length; i++) {
                preSum[i + 1] = preSum[i] + newHours[i];
            }
            return 0;
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        int[] hours = new int[] { 9, 9, 6, 0, 6, 6, 9 };
        solution.longestWPI(hours);
    }

}
