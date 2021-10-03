package io.liuyatao.binarySearch.mid;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode-cn.com/problems/find-the-duplicate-number/
 * 
 * 287. 寻找重复数
 */
public class Task4 {

    class Solution {
        /**
         * 找到第一个value = index，该方法有问题，[7,9,7,4,2,8,7,7,1,5] 无法通过
         */
        // public int findDuplicate(int[] nums) {
        // Arrays.sort(nums);
        // int left = 0;
        // int right = nums.length - 1;
        // while (left < right) {
        // int mid = left + (right - left) / 2;
        // if (nums[mid] == mid + 1) {
        // left = mid + 1;
        // } else {
        // right = mid;
        // }
        // }
        // return nums[left];
        // }

        public int findDuplicate(int[] nums) {
            Arrays.sort(nums);
            int left = 0;
            int right = nums.length - 1;

            while (left < right) {
                int mid = left + (right - left) / 2;
                int count = 0;
                for (int i = 0; i < mid; i++) {
                    if (nums[i] <= nums[mid]) {
                        count++;
                    }
                }
                if (count < nums[mid]) {
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
        int[] nums = { 1, 3, 4, 2, 2 };
        int result = solution.findDuplicate(nums);
        System.out.println(result);
    }

    @Test
    public void test1() {
        Solution solution = new Solution();
        int[] nums = { 7, 9, 7, 4, 2, 8, 7, 7, 1, 5 };
        int result = solution.findDuplicate(nums);
        System.out.println(result);
    }
}
