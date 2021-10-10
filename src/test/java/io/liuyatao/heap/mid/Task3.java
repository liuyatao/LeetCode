package io.liuyatao.heap.mid;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode-cn.com/problems/find-k-pairs-with-smallest-sums/
 * 
 * 373. 查找和最小的K对数字
 */
public class Task3 {

/**
 * Entity
 */
public class Entity {
    private int num1;
    private int num2;

    public Entity(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }
}

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Entity> queue = new PriorityQueue<>(
                (o1, o2) -> (o2.getNum1() + o2.getNum2()) - (o1.getNum1() + o1.getNum2()));
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            for (int j = 0; j < Math.min(nums2.length, k); j++) {
                if (queue.size() < k) {
                    queue.offer(new Entity(nums1[i], nums2[j]));
                    continue;
                }

                Entity peek = queue.peek();
                if (nums1[i] + nums2[j] < peek.getNum1() + peek.getNum2()) {
                    queue.poll();
                    queue.offer(new Entity(nums1[i], nums2[j]));
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            Entity polled = queue.poll();
            if (polled != null) {
                result.add(List.of(polled.getNum1(), polled.getNum2()));
            }
        }
        return result;
    }
}

    @Test
    public void test() {
        Solution solution = new Solution();
        int[] nums1 = { 1, 7, 11 };
        int[] nums2 = { 2, 4, 6 };
        solution.kSmallestPairs(nums1, nums2, 3);
    }
}
