# 题目

> [链接地址](https://leetcode-cn.com/problems/ZL6zAn/)
>

# 题解

```java
    class Solution {

        private int rowLength = 0;

        private int colLength = 0;

        private boolean[][] visited;

        private int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        private int maxArea = 0;

        private int count = 0;

        private int[][] grid;

        public int maxAreaOfIsland(int[][] grid) {
            this.grid = grid;
            rowLength = grid.length;
            colLength = grid[0].length;
            visited = new boolean[rowLength][colLength];

            for (int i = 0; i < rowLength; i++) {
                for (int j = 0; j < colLength; j++) {
                    if (grid[i][j] == 1 && !visited[i][j]) {
                        count = 0;
                        dfs(i, j);
                        maxArea = Math.max(count, maxArea);
                        System.out.println("maxArea:" + maxArea);
                    }
                }
            }

            return maxArea;
        }

        private void dfs(int row, int col) {
            // 无路可走
            if (grid[row][col] == 0 || visited[row][col]) {
                return;
            }

            visited[row][col] = true;
            count++;
            System.out.println("current: row:" + row + ";col:" + col + ";count:" + count);
            for (int[] direction : directions) {
                int newRow = direction[0] + row;
                int newCol = direction[1] + col;
                if (isInArea(newRow, newCol)) {
                    dfs(newRow, newCol);
                }
            }

        }

        private boolean isInArea(int row, int col) {
            if (row < 0 || row >= rowLength) {
                return false;
            }

            if (col < 0 || col >= colLength) {
                return false;
            }
            return true;
        }
    }
```

# 思路

四个方向进行DFS

# 参考文档