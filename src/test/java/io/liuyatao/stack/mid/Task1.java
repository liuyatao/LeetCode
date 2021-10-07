package io.liuyatao.stack.mid;

import java.util.Stack;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode-cn.com/problems/maximum-width-ramp/
 * 
 * 962. 最大宽度坡
 */
public class Task1 {
    class Solution {
        public int maxWidthRamp(int[] nums) {
            // 从单调栈保留从左往右保留最小的单调栈，只保存更低的坡底
            Stack<int[]> stack = new Stack<>();
            for (int i = 0; i < nums.length; i++) {
                if (stack.isEmpty()) {
                    stack.push(new int[] { nums[i], i });
                } else {
                    if (nums[i] <= stack.peek()[0]) {
                        stack.push(new int[] { nums[i], i });
                    }
                }
            }

            int maxWidth = 0;
            // 从右往左做比较
            for (int i = nums.length - 1; i >= 0; i--) {
                while (!stack.isEmpty() && nums[i] >= stack.peek()[0]) { // 当前坡底所能形成的最大坡度,当前元素还可以继续与栈中的更远的元素比较大小
                    int[] poped = stack.pop();
                    System.out.println("栈顶元素：" + poped[0] + ";当前元素：" + nums[i] + ",当前距离：" + (i - poped[1]));
                    maxWidth = Math.max(maxWidth, i - poped[1]);
                }
            }
            return maxWidth;
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        int[] nums = new int[] { 9, 8, 1, 0, 1, 9, 4, 0, 4, 1 };
        int result = solution.maxWidthRamp(nums);
        System.out.println(result);
    }

    @Test
    public void test1() {
        Solution solution = new Solution();
        int[] nums = new int[] { 6, 1, 8, 2, 0, 5 };
        solution.maxWidthRamp(nums);
    }

    @Test
    public void test2() {
        int[] nums = new int[] { 6, 1, 8, 2, 3, 5 };
        Stack<Integer> stack = new Stack<>();
        // 单调递减栈
        for (int i = nums.length - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                stack.add(nums[i]);
            }
            // 比较当前值与栈顶与元素大小，如果栈顶元素比较大，则弹出
            while (!stack.isEmpty()) {
                if (stack.peek() > nums[i]) {
                    stack.pop();
                } else { // 栈中没有比当前元素大的
                    break;
                }
            }
            stack.push(nums[i]);
        }
        System.out.println(stack.toString());
    }
}
