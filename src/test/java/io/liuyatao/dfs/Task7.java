package io.liuyatao.dfs;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode-cn.com/problems/route-between-nodes-lcci/
 * 
 * 面试题 04.01. 节点间通路
 */
public class Task7 {
    class Solution {
        private List<List<Integer>> edges = new ArrayList<>();
        boolean isExist = false;

        public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
            for (int i = 0; i < n; i++) {
                edges.add(new ArrayList<>());
            }
            for (int[] item : graph) {
                int itemStart = item[0];
                int itemEnd = item[1];
                edges.get(itemStart).add(itemEnd);
            }
            dfs(start, target);
            return isExist;
        }

        /**
         * 要么正常执行结束都没有找到，要么找到目的地
         * 
         * @param start
         * @param target
         */
        private void dfs(int start, int target) {
            if (start == target) {
                isExist = true;
                return;
            }
            List<Integer> ends = edges.get(start);
            for (Integer end : ends) {
                dfs(end, target);
            }
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        int[][] graph = { { 0, 1 }, { 0, 2 }, { 1, 2 }, { 1, 2 } };
        boolean result = solution.findWhetherExistsPath(3, graph, 0, 2);
        System.out.println(result);

    }
}
