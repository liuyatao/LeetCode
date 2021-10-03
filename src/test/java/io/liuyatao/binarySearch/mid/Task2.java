package io.liuyatao.binarySearch.mid;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 * 
 * 153. 寻找旋转排序数组中的最小值
 */
public class Task2 {
    class Solution {
        public int findMin(int[] nums) {
            if (nums[nums.length - 1] > nums[0]) { // 单调递增
                return nums[0];
            }

            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[0] <= nums[mid]) { // 位于左侧,找到第一个小于nums[0]的元素
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return nums[left];
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        int[] nums = { 3, 4, 5, 1, 2 };
        int result = solution.findMin(nums);
        System.out.println(result);
    }

    @Test
    public void test1() {
        Solution solution = new Solution();
        int[] nums = { 11, 13, 15, 17 };
        int result = solution.findMin(nums);
        System.out.println(result);
    }

    @Test
    public void test2() {
        Solution solution = new Solution();
        int[] nums = { 5, 1, 2, 3, 4 };
        int result = solution.findMin(nums);
        System.out.println(result);
    }
}
