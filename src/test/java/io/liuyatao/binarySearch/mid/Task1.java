package io.liuyatao.binarySearch.mid;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode-cn.com/problems/circus-tower-lcci/
 * 
 * 面试题 17.08. 马戏团人塔
 */
public class Task1 {
    class Persion {
        private int height;
        private int weight;

        public Persion(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Persion [height=" + height + ", weight=" + weight + "]";
        }

    }

    class Solution {

        public int bestSeqAtIndex(int[] height, int[] weight) {
            List<Persion> persions = new ArrayList<>();
            for (int i = 0; i < weight.length; i++) {
                Persion persion = new Persion(height[i], weight[i]);
                persions.add(persion);
            }
            // 根据身高排序；
            persions.sort(new Comparator<Persion>() {
                @Override
                public int compare(Persion o1, Persion o2) {
                    return o1.height - o2.height;
                }
            });

            for (Persion persion : persions) {
                System.out.println(persion);
            }
            // 根据身高排序后 查找最多连续递增的体重总个数

            return 0;
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        int[] height = { 65, 70, 56, 75, 60, 68 };
        int[] weight = { 100, 150, 90, 190, 95, 110 };
        int result = solution.bestSeqAtIndex(height, weight);
        System.out.println(result);
    }
}
