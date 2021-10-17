package io.liuyatao.twoPointers;

import org.junit.jupiter.api.Test;

/**
 * 面试题 02.02. 返回倒数第 k 个节点
 * 
 * https://leetcode-cn.com/problems/kth-node-from-end-of-list-lcci/
 */
public class Task7 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public int kthToLast(ListNode head, int k) {
            ListNode fast = head;
            ListNode slow = head;

            int count = 0;
            while (fast != null) {
                if (count < k) {
                    fast = fast.next;
                    if (fast != null) {
                        System.out.println("fast value :" + fast.val);
                    }
                    count++;
                } else {
                    fast = fast.next;
                    slow = slow.next;
                    if (fast != null) {
                        System.out.println("fast value :" + fast.val + "; slow value:" + slow.val);
                    }
                }
            }
            return slow.val;
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int result = solution.kthToLast(head, 2);
        System.out.println(result);
    }

    @Test
    public void test1() {
        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        int result = solution.kthToLast(head, 1);
        System.out.println(result);
    }
}
