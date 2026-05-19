package Stack;

import java.util.Arrays;
import java.util.Stack;

public class StackUsingJavaCollectionFramework {
    public static void main(String[] args) {
        // Stack using Java Collections Framework(JCM)
        // Stack<Integer> s = new Stack<>();
        // s.push(1);
        // s.push(2);
        // s.push(3);

        // while(!s.isEmpty()) {
        //     System.out.println(s.peek());
        //     s.pop();
        // }

        String str = "/home/"; // [, home];
        String str2 = "/home//foo/"; // [, home, , foo]
        String str3 = "/home/user/Documents/../Pictures"; // [, home, user, Documents, .., Pictures]
        String str4 = "/../"; // [, ..]
        String str5 = "/.../a/../b/c/../d/./"; // [, ..., a, .., b, c, .., d, .]
        System.out.println(simplifyPath(str5));

    }

    public static String simplifyPath(String path) { // O(n) + O(n) = O(n)
        Stack<String> st = new Stack<>();
        String[] group = path.split("/");
        // System.out.println(Arrays.toString(group));
        for (String s : group) {
            if (s.equals("") || s.equals(".")) {
                continue;
            } else if (s.equals("..")) {
                if (!st.isEmpty()) {
                    st.pop();
                }
            } else {
                // getting file name
                // System.out.println(s);
                st.push(s); 
            }
        }

        // System.out.println(st);
        if (st.isEmpty()) {
            return "/"; // if stack is empty
        }
        StringBuilder res = new StringBuilder();
        for (String curr : st) {
            // System.out.println(curr);
            res.append("/").append(curr);
        }
        return res.toString();
    }

    public static String decodeString(String s) {
        Stack<Integer> st1 = new Stack<>();
        Stack<StringBuilder> st2 = new Stack<>();
        StringBuilder curr = new StringBuilder();
        int count = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) { // if digit then save that to count
                count = count * 10 + (ch - '0');
            }
            else if (ch == '[') { // if opening bracket then pushing digit to st1 stack and reseting to 0 and pushing curr to st2 and reseting curr
                st1.push(count);
                count = 0;
                st2.push(curr);
                curr = new StringBuilder();
            }
            else if (ch == ']') { // if closing bracket then appending character to k times which is st1 s.peek() element
                int k = st1.pop();
                StringBuilder temp = curr;
                curr = st2.pop();
                while (k > 0) {
                    curr.append(temp);
                    k--;
                }
            }
            else { // if character then we are append to curr stringbuilder
                curr.append(ch);
            }
        }

        return curr.toString();
    }

}
