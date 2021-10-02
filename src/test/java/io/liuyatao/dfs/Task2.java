package io.liuyatao.dfs;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode-cn.com/problems/chuan-di-xin-xi/
 * 
 * LCP 07. 传递信息
 */
public class Task2 {

    class Solution {
        private List<List<Integer>> edges = new ArrayList<>();

        private int n;
        private int k;
        private int count; // 方案个数

        void dfs(int index, int steps) {
            // 退出条件
            if (steps == k) { // 只执行k步
                System.out.println(k + "步后");
                if (index == n - 1) {
                    count++;
                    System.out.println("符合要求");
                }
                return;
            }
            List<Integer> dests = edges.get(index); // 当前节点所能抵达的节点
            for (Integer dest : dests) {
                System.out.println("当前节点：" + index + ";抵达节点：" + dest + ";当前step" + (steps + 1));
                dfs(dest, steps + 1);
            }
        }

        public int numWays(int n, int[][] relation, int k) {
            this.n = n;
            this.k = k;
            for (int i = 0; i < n; i++) {
                List<Integer> dests = new ArrayList<>(); // list的序号是source,里面对应若干个dest
                edges.add(dests);
            }
            for (int[] re : relation) {
                edges.get(re[0]).add(re[1]);
            }
            dfs(0, 0);
            return count;
        }
    }

    @Test
    public void name() {
        Solution solution = new Solution();
        int[][] relation = { { 0, 2 }, { 2, 1 }, { 3, 4 }, { 2, 3 }, { 1, 4 }, { 1, 3 }, { 2, 0 }, { 0, 4 } };
        int result = solution.numWays(5, relation, 3);
    }
}
