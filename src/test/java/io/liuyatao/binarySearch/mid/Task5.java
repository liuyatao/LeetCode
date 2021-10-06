package io.liuyatao.binarySearch.mid;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode-cn.com/problems/sum-of-mutated-array-closest-to-target/
 * 
 * 1300. 转变数组后最接近目标值的数组和
 */
public class Task5 {
    class Solution {
        public int findBestValue(int[] arr, int target) {
            int min = 0;
            int max = 0;
            for (int i = 0; i < arr.length; i++) {
                max = Math.max(max, arr[i]);
            }
            while (min < max) {
                int mid = min + (max - min) / 2;

                int sum = getSum(arr, mid);
                if (sum < target) { // 找到第一个总和大于等于 target的
                    min = mid + 1;
                } else {
                    max = mid;
                }
            }

            int sum1 = getSum(arr, min);
            int sum2 = getSum(arr, min - 1);

            if (Math.abs(target - sum1) - Math.abs(target - sum2) > 0) {
                return min - 1;
            } else if (Math.abs(target - sum1) - Math.abs(target - sum2) < 0) {
                return min;
            } else {
                return min - 1;
            }
        }

        /**
         * 如果arr中的元素大于value则取value,否则取本身
         * 
         * @param arr
         * @param value
         * @return
         */
        private int getSum(int[] arr, int value) {
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                sum = sum + Math.min(value, arr[i]);
            }
            return sum;
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        int[] arr = { 2, 3, 5 };
        int result = solution.findBestValue(arr, 10);
        System.out.println(result);
    }
}
