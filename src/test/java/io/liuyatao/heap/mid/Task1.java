package io.liuyatao.heap.mid;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode-cn.com/problems/ugly-number-ii/
 * 
 * 264. 丑数 II
 */
public class Task1 {

    class Solution {
        public int nthUglyNumber(int n) {
            PriorityQueue<Long> queue = new PriorityQueue<>();
            Set<Long> set = new HashSet<>(); // 用来去重复，不让重复的元素如队列
            int[] factors = new int[] { 2, 3, 5 };
            set.add(1L);
            queue.offer(1L);

            int result = 0;
            for (int i = 0; i < n; i++) {
                long polled = queue.poll();
                result = (int) polled;
                for (int j = 0; j < factors.length; j++) {
                    int factor = factors[j];
                    Long newValue = polled * factor;
                    // 先入set，如果没有重复的再入队列
                    if (set.add(newValue)) {
                        queue.offer(newValue);
                    }
                }
            }
            return result;
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        int result = solution.nthUglyNumber(10);
        System.out.println(result);
    }

}
