package io.liuyatao.binarySearch.mid;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * 
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 */
public class Task3 {
    class Solution {
        private int searchStart(int[] nums, int target) {
            // 查找第一个大于等于target的元素
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] < target) { // 严格小于target的直接排除
                    left = mid + 1;
                } else { // 可能出现的区间，逼近的就是第一target
                    right = mid;
                }
            }
            if (nums[left] == target) {
                return left;
            } else {
                return -1;
            }
        }

        private int searchEnd(int[] nums, int target) {
            // 查找第一个大于等于target的元素
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                int mid = left + (right - left + 1) / 2;
                if (nums[mid] > target) { // 严格大于target的直接排除
                    right = mid - 1;
                } else { // 可能出现的区间，逼近的就是最后一个target(最靠近排除区间的一个)
                    left = mid;
                }
            }
            if (nums[left] == target) {
                return left;
            } else {
                return -1;
            }
        }

        public int[] searchRange(int[] nums, int target) {
            if (nums.length == 0) {
                return new int[] { -1, -1 };
            }
            int[] result = new int[2];
            result[0] = searchStart(nums, target);
            result[1] = searchEnd(nums, target);
            return result;
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        int[] nums = { 5, 7, 7, 8, 8, 10 };
        int[] result = solution.searchRange(nums, 8);
        System.out.println(Arrays.toString(result));
    }
}
