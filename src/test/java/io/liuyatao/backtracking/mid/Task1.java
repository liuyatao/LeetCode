package io.liuyatao.backtracking.mid;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode-cn.com/problems/bP4bmD/
 * 
 * 剑指 Offer II 110. 所有路径
 */
public class Task1 {
    class Solution {

        private LinkedList<Integer> path = new LinkedList<>();
        private List<List<Integer>> paths = new ArrayList<>();

        private int[][] graph;

        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            this.graph = graph;
            dfs(0);
            return paths;
        }

        /**
         * DFS, 整个递归全部自动执行完毕,没有捕获『终止条件』
         * 
         * @param index graph 节点index
         */
        private void dfs(int index) {

            path.add(index);

            if (index == graph.length - 1) {
                paths.add(new LinkedList<>(path));
            }

            int[] nextIndexs = graph[index];
            for (int i = 0; i < nextIndexs.length; i++) {
                dfs(nextIndexs[i]);
            }

            path.removeLast();

        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        int[][] graph = { { 1, 2 }, { 3 }, { 3 }, {} };
        List<List<Integer>> result = solution.allPathsSourceTarget(graph);
        for (List<Integer> list : result) {
            System.out.println(list.toString());
        }
    }
}
