package Stack;

import java.util.Stack;

public class ValidParenthesis {

    public static boolean isValid(String str) { // O(n)
        Stack<Character> s= new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') { //opening
                s.push(ch);
            } else {
                //closing
                if (s.isEmpty()) { // if str= ))))) no any opening bracket then returning false
                    return false;
                }
                if ((s.peek() == '(' && ch == ')') // ()
                     || ( s.peek() == '{' && ch == '}') // {}
                    || s.peek() == '[' && ch == ']') { // []
                        s.pop();
                } else { // successfully pair not formed then return false string making wrong/invalid
                    return false;
                }
            }
        }
        
        if (s.isEmpty()) {
            return true;
        } else { // pending opening brackets then return false
            return false;
        }
    }
    public static void main(String[] args) {
        String str = "({})[]"; // true
        System.out.println(isValid(str));
    }
}
