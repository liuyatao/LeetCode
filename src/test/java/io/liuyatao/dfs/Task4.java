package io.liuyatao.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode-cn.com/problems/destination-city/
 * 
 * 1436. 旅行终点站
 */
public class Task4 {
    class Solution {
        private Map<String, String> map = new HashMap<>();

        private String result;

        void dfs(List<List<String>> paths, int index) {
            List<String> current = paths.get(index);
            if (!map.containsKey(current.get(1))) {
                result = current.get(1);
                return;
            }
            for (int i = 0; i < paths.size(); i++) {
                List<String> next = paths.get(i);
                if (next.get(0) == current.get(1)) {
                    dfs(paths, i);
                }
            }
        }

        public String destCity(List<List<String>> paths) {
            for (List<String> list : paths) {
                map.put(list.get(0), list.get(1));
            }
            dfs(paths, 0);
            return result;
        }
    }

    @Test
    public void name() {
        Solution solution = new Solution();
        List<List<String>> paths = new ArrayList<>();
        paths.add(Arrays.asList("London", "New York"));
        paths.add(Arrays.asList("New York", "Lima"));
        paths.add(Arrays.asList("Lima", "Sao Paulo"));
        String result = solution.destCity(paths);
        System.out.println(result);
    }
}
