package io.liuyatao.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode-cn.com/problems/pairs-with-sum-lcci/
 * 
 * 
 */
public class Task6 {
    class Solution {
        public List<List<Integer>> pairSums(int[] nums, int target) {
            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(nums);
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    result.add(List.of(nums[left], nums[right]));
                    left++;
                    right--;
                } else if (target > nums[left] + nums[right]) {
                    left++;
                } else if (target < nums[left] + nums[right]) {
                    right--;
                }
            }
            return result;
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        int[] nums = { 5, 5, 6, 6 };
        List<List<Integer>> result = solution.pairSums(nums, 11);
        for (List<Integer> list : result) {
            System.out.println(list.toString());
        }
    }
}
