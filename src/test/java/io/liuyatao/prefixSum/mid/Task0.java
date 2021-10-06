package io.liuyatao.prefixSum.mid;

import org.junit.jupiter.api.Test;

public class Task0 {

    @Test
    public void test1() {
        int[] array = new int[] { 3, 5, 2, -2, 4, 1 };
        int[] preSum = new int[array.length + 1]; // 比原来元素多一个

        for (int i = 0; i < array.length; i++) {
            preSum[i + 1] = preSum[i] + array[i];
            System.out.println("i:" + i + "；当前元素：" + array[i] + ",前缀和是：" + preSum[i] + ";preSum[" + (i + 1) + "] = "
                    + preSum[i + 1]);
        }
    }
}
