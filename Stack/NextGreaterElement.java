package Stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String args[]) {
        // Time complexity = O(n)
        int arr[] = {6, 8, 0, 1, 3};
        Stack<Integer> s = new Stack<>();
        int nextGreater[] = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            // 1. while
            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) { // s.peek() is the index of the stack and in stack we are pushing index of the element
                // if smaller then we pop the element
                s.pop();
            }

            // 2. if-else
            if (s.isEmpty()) {
                nextGreater[i] = -1;
            } else {
                nextGreater[i] = arr[s.peek()];
            }

            // 3. push in stack
            s.push(i);
        }

        System.out.println(Arrays.toString(nextGreater));

        // variations
        // next Greater Right
        // next Greater Left
        // next Smaller Right
        // next Smaller Left
    }
}