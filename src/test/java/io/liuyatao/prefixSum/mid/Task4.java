package io.liuyatao.prefixSum.mid;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode-cn.com/problems/continuous-subarray-sum/
 * 
 * 523. 连续的子数组和
 */
public class Task4 {

    class Solution {
        private int[] preSum;

        public boolean checkSubarraySum(int[] nums, int k) {
            preSum = new int[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                preSum[i + 1] = preSum[i] + nums[i];
            }
            // (sum[i]-sum[j])%k = 0 即 sum[i]%k = sum[j]%k
            Map<Integer, Integer> map = new HashMap<>(); // key为存放(preSum[i]) % k;
            map.put(0, -1); //为了满足前n个之和为k的倍数
            for (int i = 0; i < nums.length; i++) {
                int key = (preSum[i]) % k;
                if (map.containsKey(key)) {
                    int index = map.get(key);
                    if (i - index >= 2) {
                        return true;
                    }
                }
                if (!map.containsKey(key)) {
                    map.put(key, i);
                }
            }
            return false;
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        int[] nums = { 23, 2, 4, 6, 7 };
        boolean result = solution.checkSubarraySum(nums, 6);
        System.out.println(result);
    }

    @Test
    public void test4() {
        Solution solution = new Solution();
        int[] nums = { 23, 2, 4, 6, 6 };
        boolean result = solution.checkSubarraySum(nums, 7);
        System.out.println(result);
    }

    @Test
    public void test6() {
        Solution solution = new Solution();
        int[] nums = { 3, 4, 6 };
        boolean result = solution.checkSubarraySum(nums, 6);
        System.out.println(result);
    }

    @Test
    public void test5() {
        Solution solution = new Solution();
        int[] nums = { 1, 0 };
        boolean result = solution.checkSubarraySum(nums, 2);
        System.out.println(result);
    }

    @Test
    public void test3() {
        Solution solution = new Solution();
        int[] nums = { 0, 0 };
        boolean result = solution.checkSubarraySum(nums, 1);
        System.out.println(result);
    }

    @Test
    public void test2() {
        Solution solution = new Solution();
        int[] nums = { 1, 1, 1, 2, 1, 3, 3 };
        boolean result = solution.checkSubarraySum(nums, 6);
        System.out.println(result);
    }

    @Test
    public void test1() {
        Solution solution = new Solution();
        int[] nums = { 5, 0, 0, 0 };
        boolean result = solution.checkSubarraySum(nums, 3);
        System.out.println(result);
    }

}
