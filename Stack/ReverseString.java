package Stack;

import java.util.Stack;

public class ReverseString {

    // Microsoft, Flipkart, Adobe, Amazon, Paytm
    public static String reverseString(String str) {
        Stack<Character> s = new Stack<>(); 
        int idx = 0; // using for string
        while (idx < str.length()) {
            s.push(str.charAt(idx));
            idx++;
        }
        StringBuilder result = new StringBuilder("");
        while (!s.isEmpty()) {
            char curr = s.pop();
            result.append(curr);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseString("HelloWorld"));
    }
}
