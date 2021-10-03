package io.liuyatao.binarySearch.easy;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode-cn.com/problems/search-insert-position/
 * 
 * 35. 搜索插入位置
 */
public class Task2 {
    class Solution {
        /**
         * 找到第一个大于等于target的元素的位置，如果没有找到则位于数组的最后一位
         * 
         * @param nums
         * @param target
         * @return
         */
        public int searchInsert(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            // 剩余最后一个元素进行判断
            if (nums[left] >= target) {
                return left;
            } else {
                return nums.length;
            }
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        int[] nums = { 1, 3, 5, 6 };
        int result = solution.searchInsert(nums, 7);
        System.out.println(result);
    }

    @Test
    public void test1() {
        Solution solution = new Solution();
        int[] nums = { 1, 3, 5, 6 };
        int result = solution.searchInsert(nums, -1);
        System.out.println(result);

    }

    @Test
    public void test2() {
        Solution solution = new Solution();
        int[] nums = { 1, 3, 5, 6 };
        int result = solution.searchInsert(nums, 4);
        System.out.println(result);

    }
}
