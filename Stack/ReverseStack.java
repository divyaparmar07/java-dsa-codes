package Stack;

import java.util.Stack;

// if any modification in stack data and we don't need to use extra memory in most cases recursion is used. 
public class ReverseStack {

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

    // amdocs TC = O(n) SC = O(1)
    public static void reverseStack(Stack<Integer> s) {
        // stack is empty then stack is already reversed so we cannot do anything
        if (s.isEmpty()) {
            return;
        }
        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s, top);
    }

    public static void printStack(Stack<Integer> s) {
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        // original 3 2 1
        reverseStack(s);
        printStack(s);
        // 1 2 3
    }
}