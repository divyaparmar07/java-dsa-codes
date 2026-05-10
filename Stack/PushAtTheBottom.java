package Stack;

import java.util.Stack;

public class PushAtTheBottom {

    // push at the bottom of the stack TC = O(n) Amazon
    public static void pushAtBottom(Stack<Integer> s, int data) {
        // stack is empty then push the element
        if (s.isEmpty()) {
            s.push(data);
            return;
        }

        int top = s.pop(); // pop the element
        pushAtBottom(s, data); // Recursion
        s.push(top); // pop the element
    }
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);

        pushAtBottom(s, 4);
        while(!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }
}
