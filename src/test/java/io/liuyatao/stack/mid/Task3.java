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
    private Stack<Integer> stack = new Stack<>(); // 单调递减

    private Stack<Integer> widthStack = new Stack<>();

    public StockSpanner() {

    }

    public int next(int price) {
        int width = 1;
        while (!stack.isEmpty() && price >= stack.peek()) {
            stack.pop();
            width = width + widthStack.pop();
        }
        stack.push(price);
        widthStack.push(width);
        return width;
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
        System.out.println(stockSpanner.next(85));
    }

}
