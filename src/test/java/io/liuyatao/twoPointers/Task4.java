package io.liuyatao.twoPointers;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 * 
 * 167. 两数之和 II - 输入有序数组
 */
public class Task4 {
    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int left = 0;
            int right = numbers.length - 1;
            while (left < right) {
                if (target > numbers[left] + numbers[right]) {
                    left++;
                } else if (target < numbers[left] + numbers[right]) {
                    right--;
                } else {
                    break;
                }
            }
            return new int[] { left + 1, right + 1 };
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        int[] result = solution.twoSum(new int[] { 2, 7, 11, 15 }, 9);
        System.out.println(Arrays.toString(result));
    }
}
