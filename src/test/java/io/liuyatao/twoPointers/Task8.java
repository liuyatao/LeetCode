package io.liuyatao.twoPointers;

import java.lang.reflect.Array;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode-cn.com/problems/boats-to-save-people/
 * 
 * 881. 救生艇
 */
public class Task8 {
    class Solution {
        public int numRescueBoats(int[] people, int limit) {
            int count = 0;
            Arrays.sort(people);
            int left = 0;
            int right = people.length - 1;
            while (left < right) {
                if (people[right] == limit) {
                    count++;
                    right--;
                    continue;
                }
                int sum = people[left] + people[right];
                if (sum > limit) {
                    right--;
                } else {
                    right--;
                    left++;
                }
                count++;
            }
            if (left == right) {
                return ++count;
            } else {
                return count;
            }
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        int result = solution.numRescueBoats(new int[] { 3, 5, 3, 4 }, 5);
        System.out.println(result);
    }

    @Test
    public void test1() {
        Solution solution = new Solution();
        int result = solution.numRescueBoats(new int[] { 3, 2, 2, 1 }, 3);
        System.out.println(result);
    }

    @Test
    public void test2() {
        Solution solution = new Solution();
        int result = solution.numRescueBoats(new int[] { 2, 2 }, 6);
        System.out.println(result);
    }
}
