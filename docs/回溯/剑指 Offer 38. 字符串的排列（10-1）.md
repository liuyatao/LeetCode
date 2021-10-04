# 题目

> [链接地址](https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/)
>

# 题解

```java
    class Solution {
        private char[] charArray;
        private boolean[] visited;

        private List<String> result = new ArrayList<>();

        void dfs(String curStr) {
            // 递归结束条件
            if (curStr.length() == charArray.length) {
                result.add(curStr);
                return;
            }
            List<Character> added = new ArrayList<>();
            for (int i = 0; i < visited.length; i++) {
                if (!visited[i] && !isInList(added, charArray[i])) {
                    String temp = curStr;
                    visited[i] = true;

                    System.out.println(curStr + charArray[i]);
                    dfs(curStr + charArray[i]);

                    added.add(charArray[i]);
                    curStr = temp;
                    visited[i] = false;
                }
            }
        }

        boolean isInList(List<Character> characters, char ch) {
            for (int i = 0; i < characters.size(); i++) {
                if (characters.get(i).charValue() == ch) {
                    return true;
                }
            }
            return false;
        }

        public String[] permutation(String s) {
            charArray = s.toCharArray();
            visited = new boolean[charArray.length];
            dfs("");
            String[] strArray = new String[result.size()];
            result.toArray(strArray);
            return strArray;
        }
    }
```

# 思路

注意重复元素,比如`aba`这种，第一个`a` 和第三个`a`的结果其实是一样的，需要忽略调。

# 参考文档