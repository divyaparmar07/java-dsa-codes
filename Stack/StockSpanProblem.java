package Stack;

import java.util.Stack;

public class StockSpanProblem {

    // Microsoft Flipkart Adobe Amazon Samsung
    // Stock Span Problem
    // Span = max no's of consecutive days for which price <= today's price
    // Span = today stock's price before today, how many days stock price less or equal today's price
    private static void stockSpan(int[] stocks, int[] span) {
        Stack<Integer> s = new Stack<>();
        span[0] = 1; // bcz before 0 idx we don't have any element
        s.push(0);

        for (int i = 1; i < stocks.length; i++) {
            int currPrice = stocks[i];
            while (!s.empty() && currPrice > stocks[s.peek()]) {
                s.pop();
            }
            if (s.isEmpty()) {
                span[i] = i+1; // including itself and all elment bcz before that all elements are equal or less
            } else {
                int preHigh = s.peek();
                span[i] = i - preHigh;
            }

            s.push(i);
        }
    }

    public static void main(String[] args) {
        int stocks[] = {100, 80, 60, 70, 60, 85, 100};
        int span[] = new int[stocks.length];
        stockSpan(stocks, span);

        for (int i = 0; i < span.length; i++) {
            System.out.print(span[i]+ " ");
        }
    }
}
