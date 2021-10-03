package io.liuyatao.binarySearch.mid;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode-cn.com/problems/xiao-zhang-shua-ti-ji-hua/
 * 
 * LCP 12. 小张刷题计划
 */
public class Task6 {
    class Solution {
        public int minTime(int[] time, int m) {

            if (m >= time.length) {
                return 0;
            }

            int left = 0;
            int right = 0; // 最多耗时
            for (int i = 0; i < time.length; i++) {
                right = right + time[i];
            }
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (!check(mid, time, m)) { // 每天花费mid小时并不能清理完全time数组中的所有
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return right;
        }

        /**
         * 每天耗时 dayTime 小时，m天,是否可以把time[]中的清理完全
         * 
         * @param dayTime
         * @param time2
         * @param m       总天数
         * @return
         */
        private boolean check(int dayTime, int[] time, int m) {
            Arrays.sort(time);
            // 将耗时最多的m个交给其他人完成（每天给一个耗时最长的）
            int[] newTime = Arrays.copyOfRange(time, 0, time.length - m); // 实际需要完成的
            if (newTime[newTime.length - 1] > dayTime) { // 无法完成
                return false;
            }
            if (dayTime >= newTime.length) {
                return true;
            }
            return check1(newTime, m, dayTime);
        }
        public boolean check1(int[] time, int m, int dayTime) {
            boolean[] visited = new boolean[time.length];

            for (int i = time.length - 1; i >= 0; i--) {
                if (!visited[i]) {
                    visited[i] = true;
                    int remaind = dayTime - time[i]; // 剩余时间
                    for (int j = i - 1; j >= 0; j--) {
                        if (remaind >= time[j]) {
                            visited[j] = true;
                            remaind = remaind - time[j];
                        }
                    }
                    m--;
                }
            }
            return m >= 0;
        }
    }

    @Test
    public void test4() {
        Solution solution = new Solution();
        int[] time = { 1, 2, 3, 3 };
        int result = solution.minTime(time, 2);
        System.out.println(result);
    }

    @Test
    public void test1() {
        Solution solution = new Solution();
        int[] time = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int result = solution.minTime(time, 3);
        System.out.println(result);
    }

    @Test
    public void test2() {
        int[] time = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int[] newTime = Arrays.copyOfRange(time, 0, time.length - 3);
        System.out.println(Arrays.toString(newTime));
    }

    @Test
    public void test3() {
        int[] time = { 1, 2, 2, 3, 4 };
        Solution solution = new Solution();
        solution.check1(time, 2, 7);

    }
}
