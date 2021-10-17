package io.liuyatao.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode-cn.com/problems/3sum/
 * 
 * 
 * 15. 三数之和
 */
public class Task1 {
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            if (nums.length < 3) {
                return result;
            }
            Arrays.sort(nums); // 先进行排序
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) { // 由于是已经排序不可能有
                    break;
                }
                if (i >= 1 && nums[i] == nums[i - 1]) { // 和之前的元素一样，会重复，不处理
                    continue;
                }
                int L = i + 1;
                int R = nums.length - 1;
                while (L < R) {
                    int total = nums[i] + nums[L] + nums[R];
                    if (total == 0) {
                        result.add(List.of(nums[i], nums[L], nums[R]));
                        while (L < R && nums[L] == nums[L + 1]) {
                            L++;
                        }
                        while (L < R && nums[R] == nums[R - 1]) {
                            R--;
                        }
                        R--;
                        L++;
                    } else if (total > 0) {
                        R--;
                    } else if (total < 0) {
                        L++;
                    }
                }
            }
            return result;
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        int[] nums = { -1, 0, 1, 2, -1, -4 };
        List<List<Integer>> result = solution.threeSum(nums);
        for (List<Integer> list : result) {
            System.out.println(list.toString());
        }
    }
}
