# 题目

> [链接地址](https://leetcode-cn.com/problems/bP4bmD/)
>

# 题解

```java
class Solution {

    private LinkedList<Integer> path = new LinkedList<>();
    private List<List<Integer>> paths = new ArrayList<>();

    private int[][] graph;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        this.graph = graph;
        dfs(0);
        return paths;
    }

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
```

# 思路

DFS进行遍历，保存路径信息，当达到最后一个元素的时候，输出路径。

# 参考文档