package io.liuyatao.prefixSum.mid;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 * 
 * 209. 长度最小的子数组
 */
public class Task2 {
    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int[] preSum = new int[nums.length + 1]; // 前缀和数组
            for (int i = 0; i < nums.length; i++) {
                preSum[i + 1] = preSum[i] + nums[i];
            }

            int ans = Integer.MAX_VALUE;
            // 双指针
            int slow = 0;
            int fast = 0;
            while (fast < nums.length) {
                int sum = preSum[fast + 1] - preSum[slow];// slow到fast之和
                while (sum >= target) { // 遇到slow到fast的和大于target
                    ans = Math.min(ans, fast - slow + 1);
                    slow++;
                    sum = preSum[fast + 1] - preSum[slow];
                }
                fast++;
            }
            return ans == Integer.MAX_VALUE ? 0 : ans;
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        int ans = solution.minSubArrayLen(7, new int[] { 2, 3, 1, 2, 4, 3 });
        System.out.println(ans);
    }

    @Test
    public void test1() {
        Solution solution = new Solution();
        int ans = solution.minSubArrayLen(11, new int[] { 1, 1, 1, 1, 1, 1, 1, 1 });
        System.out.println(ans);
    }
}
