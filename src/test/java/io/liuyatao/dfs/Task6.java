package io.liuyatao.dfs;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode-cn.com/problems/check-subtree-lcci/
 * 
 * 面试题 04.10. 检查子树
 */
public class Task6 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {

        private boolean isExist = false;

        /**
         * 判断是否两个二叉树是一样的
         * 
         * @param t1
         * @param t2
         * @return
         */
        public boolean isSameTree(TreeNode t1, TreeNode t2) {
            if (t1 == null && t2 == null) {
                return true;
            }
            if ((t1 == null && t2 != null) || (t1 != null && t2 == null)) {
                return false;
            }

            if ((t1.val == t2.val) && isSameTree(t1.left, t2.left) && isSameTree(t1.right, t2.right)) {
                return true;
            }

            return false;

        }

        public boolean checkSubTree(TreeNode t1, TreeNode t2) {

            // t1不为null t2是null
            if (t2 == null && t1 != null) {
                return true;
            }

            // t1为null t2不为null
            if (t2 != null && t1 == null) {
                return false;
            }
            // 对t1进行dfs
            dfs(t1, t2, t2.val);
            return isExist;
        }

        /**
         * 在t1中找
         * 
         * @param root
         * @param t2Value
         */
        private void dfs(TreeNode t1, TreeNode t2, int t2Value) {
            if (t1 == null) {
                return;
            }
            if (t1.val == t2Value) {
                if (isSameTree(t1, t2)) {
                    isExist = true;
                }
            }
            if (t1.left != null) {
                dfs(t1.left, t2, t2Value);
            }
            if (t1.right != null) {
                dfs(t1.right, t2, t2Value);
            }

        }

        @Test
        public void name() {

        }

        @Test
        public void name1() {

            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);

            TreeNode root1 = new TreeNode(1);
            root1.left = new TreeNode(2);
            root1.right = new TreeNode(3);

            Solution solution = new Solution();
            boolean result = solution.isSameTree(root, root1);
            System.out.println(result);
        }
    }
}
