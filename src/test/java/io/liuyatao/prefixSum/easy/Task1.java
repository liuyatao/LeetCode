package io.liuyatao.prefixSum.easy;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode-cn.com/problems/range-sum-query-immutable/
 * 
 * 303. 区域和检索 - 数组不可变
 */
public class Task1 {
class NumArray {
    private int[] preSum;

    public NumArray(int[] nums) {
        preSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

    }

    public int sumRange(int left, int right) {
        return preSum[right + 1] - preSum[left];
    }
}

    @Test
    public void test() {
        NumArray numArray = new NumArray(new int[] { -2, 0, 3, -5, 2, -1 });
        int result = numArray.sumRange(0, 2);
        System.out.println(result);
    }
}
