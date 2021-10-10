package io.liuyatao.heap.mid;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 * 
 * 215. 数组中的第K个最大元素
 */
public class Task2 {
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> queue = new PriorityQueue<>(); // 最小堆，解决Top N问题
            for (int i = 0; i < nums.length; i++) {
                queue.offer(nums[i]);
                if (queue.size() > k) { // 如果
                    queue.poll();
                }
            }
            return queue.peek();
        }

        public int findKthLargest1(int[] nums, int k) {
            return IntStream.of(nums).boxed().sorted(Comparator.reverseOrder()).skip(k - 1).findFirst().get();
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        int result = solution.findKthLargest(new int[] { 3, 2, 1, 5, 6, 4 }, 2);
        System.out.println(result);
    }

    @Test
    public void test1() {
        Solution solution = new Solution();
        int result = solution.findKthLargest1(new int[] { 3, 2, 1, 5, 6, 4 }, 2);
        System.out.println(result);
    }
}
