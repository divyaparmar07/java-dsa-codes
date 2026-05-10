package Stack;

import java.util.Stack;

public class StackUsingJavaCollectionFramework {
    public static void main(String[] args) {
        // Stack using Java Collections Framework(JCM)
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);

        while(!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}
