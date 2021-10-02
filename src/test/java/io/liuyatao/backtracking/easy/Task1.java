package io.liuyatao.backtracking.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode-cn.com/problems/binary-tree-paths/
 * 
 * 257. 二叉树的所有路径
 */
public class Task1 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {

        List<String> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();

        public List<String> binaryTreePaths(TreeNode root) {
            dfs1(root);
            return result;
        }

        /**
         * 捕获终止条件，手动触发return
         * 
         * @param root
         */
        private void dfs(TreeNode root) {
            // 终止条件
            if (root == null) {
                return;
            }
            path.add(root.val);

            if (root.left == null && root.right == null) {
                String str = path.stream().map(i -> {
                    return String.valueOf(i);
                }).collect(Collectors.joining("->"));
                result.add(str);
            }
            dfs(root.left);
            dfs(root.right);

            path.removeLast();
        }

        /**
         * 递归完全执行，
         * @param root
         */
        private void dfs1(TreeNode root) {
            
            path.add(root.val);
            
            if (root.left == null && root.right == null) {
                String str = path.stream().map(i -> {
                    return String.valueOf(i);
                }).collect(Collectors.joining("->"));
                result.add(str);
            }

            if (root.left != null) {
                dfs(root.left);
            }
            if (root.right != null) {
                dfs(root.right);
            }

            path.removeLast();
        }

    }

    @Test
    public void test() {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.right = new TreeNode(3);
        List<String> result = solution.binaryTreePaths(root);
        System.out.println(result.toString());
    }
}
