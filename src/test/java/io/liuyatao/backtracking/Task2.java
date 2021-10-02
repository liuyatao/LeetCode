package io.liuyatao.backtracking;

import java.util.LinkedList;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode-cn.com/problems/paths-with-sum-lcci/
 * 
 * 面试题 04.12. 求和路径
 */
public class Task2 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {

        private int sum;
        private int count;// 路径条数

        void dfs(TreeNode root, LinkedList<Integer> paths) {
            // 递归结束条件
            if (root == null) {
                return;
            }
            paths.add(root.val);
            System.out.println("path" + paths.toString());

            int index = paths.size() - 1;
            int currentPathValue = 0;
            while (index >= 0) {
                currentPathValue = currentPathValue + paths.get(index);
                if (currentPathValue == sum) {
                    count++;
                }
                index--;
            }

            if (root.left != null) {
                dfs(root.left, paths);
            }
            if (root.right != null) {
                dfs(root.right, paths);
            }
            paths.removeLast();

        }

        public int pathSum(TreeNode root, int sum) {
            this.sum = sum;
            LinkedList<Integer> paths = new LinkedList<>();
            dfs(root, paths);
            return count;
        }
    }

    @Test
    public void test1() {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        int result = solution.pathSum(root, 22);
        System.out.println(result);
    }

    @Test
    public void test2() {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(-2);
        root.right = new TreeNode(-3);
        int result = solution.pathSum(root, -5);
        System.out.println(result);
    }

    @Test
    public void test3() {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left = new TreeNode(1);
        int result = solution.pathSum(root, 1);
        System.out.println(result);
    }
}
