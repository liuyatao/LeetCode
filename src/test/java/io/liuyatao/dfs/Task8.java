package io.liuyatao.dfs;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode-cn.com/problems/bLyHh0/
 * 
 * 剑指 Offer II 116. 朋友圈
 */
public class Task8 {
    class Solution {

        private List<List<Integer>> edges = new ArrayList<>();
        private boolean[] visited;
        private int result = 0;

        public int findCircleNum(int[][] isConnected) {
            int count = isConnected.length; // 人数
            visited = new boolean[count];
            for (int i = 0; i < count; i++) {
                edges.add(new ArrayList<>());
            }
            // 遍历关系图
            for (int i = 0; i < count; i++) {
                for (int j = 0; j < count; j++) {
                    if (isConnected[i][j] == 1 && i != j) {
                        edges.get(i).add(j);
                    }
                }
            }

            // 没有访问过的都是要被dfs的对象
            for (int i = 0; i < visited.length; i++) {
                if (!visited[i]) {
                    dfs(i);
                }
            }
            return result;
        }

        private void dfs(int start) {

            List<Integer> friends = edges.get(start);
            visited[start] = true;

            // 终止条件1
            if (friends.isEmpty()) { // 没有朋友
                result++;
                return;
            }

            // 终止条件2
            boolean isVisited = true;
            for (Integer friend : friends) {
                isVisited = isVisited & visited[friend];
            }
            if (isVisited) { // 如果朋友都被访问过了
                result++;
                return;
            }

            for (Integer friend : friends) {
                if (!visited[friend]) {
                    dfs(friend);
                }
            }
        }
    }

    @Test
    public void test1() {
        Solution solution = new Solution();

        int[][] isConnected = { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } };
        int result = solution.findCircleNum(isConnected);
        System.out.println(result);
    }

    @Test
    public void test2() {
        Solution solution = new Solution();

        int[][] isConnected = { { 1, 0, 0, 1 }, { 0, 1, 1, 0 }, { 0, 1, 1, 1 }, { 1, 0, 1, 1 } };
        int result = solution.findCircleNum(isConnected);
        System.out.println(result);
    }

    @Test
    public void test3() {
        Solution solution = new Solution();

        int[][] isConnected = { { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
                { 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0 }, { 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0 }, { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 },
                { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0 },
                { 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0 }, { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
                { 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 } };
        int result = solution.findCircleNum(isConnected);
        System.out.println(result);
    }
}
