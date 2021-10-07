package io.liuyatao.prefixSum.mid;

import java.util.Arrays;
import java.util.Stack;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode-cn.com/problems/longest-well-performing-interval/
 * 
 * 1124. 表现良好的最长时间段
 */
public class Task6 {

class Solution {
    public int longestWPI(int[] hours) {
        int[] newHours = new int[hours.length];
        for (int i = 0; i < newHours.length; i++) {
            if (hours[i] > 8) {
                newHours[i] = 1;
            } else {
                newHours[i] = -1;
            }
        }
        int[] preSum = new int[hours.length + 1];
        for (int i = 0; i < newHours.length; i++) {
            preSum[i + 1] = preSum[i] + newHours[i];
        }
        System.out.println(Arrays.toString(preSum));
        // 只要j的前缀和大于i的前缀和，则说明i-j疲劳天数大于不疲劳天数，即【表现良好的时间段】
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < preSum.length; i++) {
            if (stack.isEmpty()) {
                stack.push(new int[] { preSum[i], i });
            } else {
                if (stack.peek()[0] >= preSum[i]) {
                    stack.push(new int[] { preSum[i], i });
                }
            }
        }

        int longest = 0;
        int longestStart = 0;
        int longestEnd = 0;
        for (int i = preSum.length - 1; i >= 0; i--) {
            if (!stack.isEmpty()) {
                System.out.println(
                        "栈顶元素：" + stack.peek()[0] + ",当前元素：" + preSum[i] + ", 距离：" + (i - stack.peek()[1]));
            }
            while (!stack.isEmpty() && preSum[i] > stack.peek()[0]) {
                int[] poped = stack.pop();
                if (i - poped[1] > longest) {
                    longest = i - poped[1];
                    longestStart = poped[1];
                    longestEnd = i;
                }
                System.out.println("longestStart:" + longestStart + ",longestEnd:" + longestEnd);
            }
        }
        return longestEnd - longestStart;
    }
}

    @Test
    public void test() {
        Solution solution = new Solution();
        int[] hours = new int[] { 9, 9, 6, 0, 6, 6, 9 };
        int result = solution.longestWPI(hours);
        System.out.println(result);
    }

    @Test
    public void test1() {
        Solution solution = new Solution();
        int[] hours = new int[] { 6, 6, 6 };
        int result = solution.longestWPI(hours);
        System.out.println(result);
    }
}
