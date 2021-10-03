package io.liuyatao.binarySearch.easy;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode-cn.com/problems/sqrtx/
 * 
 * 69. Sqrt(x)
 */
public class Task3 {
    class Solution {
        public int mySqrt(int x) {
            if (x == 0) {
                return 0;
            }
            int left = 1;
            int right = x;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (mid < x / mid) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            if (x / left == left) {
                return left;
            }
            return left - 1;
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        int result = solution.mySqrt(8);
        System.out.println(result);
    }
}
