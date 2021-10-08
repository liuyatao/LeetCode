package io.liuyatao.stack.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode-cn.com/problems/next-greater-element-i/
 * 
 * 496. 下一个更大元素 I
 */
public class Task1 {
class Solution {
    /**
     * 逆序进入
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // 计算nums中的元素比它大的下一个元素
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                stack.pop();
            }
            map.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());
            stack.push(nums2[i]);
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.get(nums1[i]);
        }
        return nums1;
    }
}

    @Test
    public void test() {
        Solution solution = new Solution();
        int[] nums1 = { 4, 1, 2 };
        int[] nums2 = { 1, 3, 4, 2 };
        int[] result = solution.nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(result));
    }
}
