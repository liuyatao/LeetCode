package io.liuyatao.binarySearch.easy;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode-cn.com/problems/binary-search/
 * 
 * 704. 二分查找
 */
public class Task1 {
    class Solution {
        /**
         * 在循环体中查找元素
         * 
         * @param nums
         * @param target
         * @return
         */
        public int search(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            // 剩余一个元素依旧要查找
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return -1;
        }

        /**
         * 排除法，逐步排除一定不符合要求的元素，不断缩减待搜索范围，最后剩余一个，再判断是否满足条件
         * 
         * @param nums
         * @param target
         * @return
         */
        public int search1(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            // 当两个指向同一个地方的时候停止，剩余一个元素
            while (left < right) {
                int mid = left + (right - left + 1) / 2;
                if (nums[mid] > target) {
                    right = mid - 1; // mid及mid后面的严格不满足条件
                } else {
                    left = mid;
                }
            }
            if (nums[left] == target) {
                return left;
            } else {
                return -1;
            }
        }

        public int search2(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            // 当两个指向同一个地方的时候停止，剩余一个元素
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] < target) {
                    left = mid + 1; // mid及mid前面的严格不满足条件
                } else {
                    right = mid;
                }
            }
            if (nums[left] == target) {
                return left;
            } else {
                return -1;
            }
        }
    }

    @Test
    public void test1() {
        Solution solution = new Solution();
        int[] nums = { -1, 0, 3, 5, 9, 12 };
        int result = solution.search(nums, 13);
        System.out.println(result);
    }

    @Test
    public void test2() {
        Solution solution = new Solution();
        int[] nums = { -1, 0, 3, 5, 9, 12 };
        int result = solution.search1(nums, 13);
        System.out.println(result);
    }

    @Test
    public void test3() {
        Solution solution = new Solution();
        int[] nums = { -1, 0, 3, 5, 9, 12 };
        int result = solution.search2(nums, 13);
        System.out.println(result);
    }
}
