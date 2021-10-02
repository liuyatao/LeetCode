package io.liuyatao.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/
 * 
 * 剑指 Offer 38. 字符串的排列
 */
public class Task3 {
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

    @Test
    public void test() {
        Solution solution = new Solution();
        String[] result = solution.permutation("aba");
        System.out.println(Arrays.toString(result));
    }
}
