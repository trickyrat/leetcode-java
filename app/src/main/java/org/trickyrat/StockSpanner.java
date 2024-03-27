package org.trickyrat;

import java.util.ArrayDeque;
import java.util.Deque;

public class StockSpanner {
    Deque<int[]> stack;
    int index;

    public StockSpanner() {
        stack = new ArrayDeque<>();
        stack.push(new int[]{-1, Integer.MAX_VALUE});
        index = -1;
    }

    public int next(int price) {
        index++;
        while (price >= stack.peek()[1]) {
            stack.pop();
        }
        int res = index - stack.peek()[0];
        stack.push(new int[]{index, price});
        return res;
    }
}
