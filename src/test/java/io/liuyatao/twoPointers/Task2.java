package io.liuyatao.twoPointers;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode-cn.com/problems/container-with-most-water/
 * 
 * 11. 盛最多水的容器
 */
public class Task2 {
    class Solution {
        public int maxArea(int[] height) {
            int left = 0;
            int right = height.length - 1;
            int max = Integer.MIN_VALUE;
            while (left < right) {
                int value = Math.min(height[right], height[left]) * (right - left);
                max = Math.max(max, value);
                if (height[right] >= height[left]) {
                    left++;
                } else {
                    right--;
                }
            }
            return max;
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        int result = solution.maxArea(height);
        System.out.println(result);
    }
}
