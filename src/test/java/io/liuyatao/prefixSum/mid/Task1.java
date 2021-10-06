package io.liuyatao.prefixSum.mid;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode-cn.com/problems/contiguous-array/
 * 
 * 525. 连续数组
 */
public class Task1 {
    class Solution {
        /**
         * 遇到0 sum-1 遇到1 sum+1。如果有一段前缀和相等，则说明0 1个数相等。
         * 
         * @param nums
         * @return
         */
        public int findMaxLength(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>(); // key为当前元素的前缀和，value为当前index,如果两个sum相同，则说明该段0和1的个数相同
            map.put(0, -1); // 初始化index 为 -1的前缀和
            int preSum = 0; // 前缀和
            int maxLength = 0; // 前缀和相等的最长一段
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 1) {
                    preSum++;
                } else {
                    preSum--;
                }
                // 检测是否有与当前位置的前缀和相等的
                if (map.containsKey(preSum)) {
                    int index = map.get(preSum); // i 与 index 的前缀和相等，从index - i的这一段0、1个数相等
                    maxLength = Math.max(maxLength, i - index);
                } else {
                    map.put(preSum, i); // 没有与当前位置的前缀和一样的，说明从开始到当下没有0 1 个数相等的，0多一些或者1多一些
                }
            }
            return maxLength;
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        int[] nums = { 0, 0, 1, 0, 0, 0, 1, 1 };
        int result = solution.findMaxLength(nums);
        System.out.println(result);
    }
}
