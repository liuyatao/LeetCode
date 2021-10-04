# 题目

> [链接地址](https://leetcode-cn.com/problems/chuan-di-xin-xi/)
>

# 题解

```java
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
                System.out.println("当前节点：" + index + ";抵达节点：" + dest);
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
```

# 思路

构建一个连接关系，index为人的需要，将该人能抵达的节点都加入List中，使用DFS进行递归调用可抵达的节点，设置递归限制条件

# 参考文档

[https://leetcode-cn.com/problems/chuan-di-xin-xi/solution/chuan-di-xin-xi-by-leetcode-solution/](https://leetcode-cn.com/problems/chuan-di-xin-xi/solution/chuan-di-xin-xi-by-leetcode-solution/)