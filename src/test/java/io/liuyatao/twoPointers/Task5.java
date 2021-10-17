package io.liuyatao.twoPointers;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/3sum-closest/
 * 
 * 16. 最接近的三数之和
 */
public class Task5 {
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int result = nums[0] + nums[1] + nums[2];
            for (int i = 0; i < nums.length - 2; i++) {
                int left = i + 1;
                int right = nums.length - 1;
                while (left != right) {
                    int sum = nums[i] + nums[left] + nums[right];
                    if (Math.abs(sum - target) < Math.abs(result - target))
                        result = sum;
                    if (sum > target) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
            return result;
        }
    }
}
