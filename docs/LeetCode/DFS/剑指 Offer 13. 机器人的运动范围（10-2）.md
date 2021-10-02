# 题目

> [链接地址](https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/)
>

# 题解

```java
    class Solution {

        private int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        private int colLength = 0;
        private int rowLength = 0;
        private boolean[][] visited;
        private boolean[][] marked; // 用于结果打印
        private int count = 0;

        private boolean isInArea(int row, int col) {
            if (col < 0 || col >= colLength) {
                return false;
            }
            if (row < 0 || row >= rowLength) {
                return false;
            }
            return true;
        }

        public int movingCount(int m, int n, int k) {
            rowLength = m;
            colLength = n;
            visited = new boolean[rowLength][colLength];
            marked = new boolean[rowLength][colLength];

            dfs(0, 0, k);
            printMarked();
            return count;
        }

        /**
         * 深度
         * 
         * @param row
         * @param col
         * @param k
         */
        private void dfs(int row, int col, int k) {
            int sum = getSum(row) + getSum(col);
            if (sum <= k) {
                count++;
                marked[row][col] = true;
            }
            visited[row][col] = true;
            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];
                if (isInArea(newRow, newCol) && !visited[newRow][newCol]) {
                    dfs(newRow, newCol, k);
                }
            }

        }

        public int getSum(int number) {
            int sum = 0;
            while (number >= 10) {
                sum = sum + number % 10;
                number = number / 10;
            }
            return sum + number;
        }

        private void printMarked() {
            System.out.println("-------------------");
            for (int i = 0; i < marked.length; i++) {
                System.out.println(Arrays.toString(marked[i]));
            }
        }
    }
```

# 思路

直接DFS遍历整个二维数组，只统计满足条件的

# 未通过用例

输入：`16, 8, 4`  与其结果是`15`.但是应该是`25`

```java
[true, true, true, true, true, false, false, false]
[true, true, true, true, false, false, false, false]
[true, true, true, false, false, false, false, false]
[true, true, false, false, false, false, false, false]
[true, false, false, false, false, false, false, false]
[false, false, false, false, false, false, false, false]
[false, false, false, false, false, false, false, false]
[false, false, false, false, false, false, false, false]
[false, false, false, false, false, false, false, false]
[false, false, false, false, false, false, false, false]
[true, true, true, true, false, false, false, false]
[true, true, true, false, false, false, false, false]
[true, true, false, false, false, false, false, false]
[true, false, false, false, false, false, false, false]
[false, false, false, false, false, false, false, false]
[false, false, false, false, false, false, false, false]
```

# 参考文档