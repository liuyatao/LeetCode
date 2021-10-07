package io.liuyatao.stack.mid;

import java.util.Stack;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode-cn.com/problems/online-stock-span/
 * 
 * 901. 股票价格跨度
 */
public class Task3 {
    class StockSpanner {
        private Stack<int[]> stack = new Stack<>(); // 单调递减
        private int index = 0;

        public StockSpanner() {

        }

        public int next(int price) {
            int result = 0;
            if (stack.isEmpty()) {
                result = 1;
                stack.push(new int[] { price, index });
            } else {
                if (stack.peek()[0] <= price) { // 比栈顶元素小的进栈
                    stack.push(new int[] { price, index });
                } else { // 比栈顶元素大的计算距离

                }

                if (stack.isEmpty()) {
                    result = 1;
                } else {
                    result = index - stack.peek()[1] + 1;
                }
                stack.push(new int[] { price, index });
            }
            index++;
            return result;
        }
    }

    @Test
    public void test() {
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next(100));
        System.out.println(stockSpanner.next(80));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(70));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(75));

    }

}
