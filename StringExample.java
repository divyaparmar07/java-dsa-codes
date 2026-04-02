
public class StringExample {
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // String str = sc.next();
        // String fruits[] = {"apple","mango","banana"};
        String s1 = "aab", s2 = "abb";
        // for(int i=0;i<str.length();i++){ //length() = to get length
        // System.out.print(str.charAt(i)+" "); // to get every character and print it.
        // }
        // isPalindrome(str);
        // System.out.println(getShortestPath(str));
        // compareStrings(s1, s2);
        // findLargestString(fruits);
        // System.out.println(str.substring(0, 5));
        // System.out.println(Substring(str, 0, 5));

        // If string O(26*str.length)=O(n2) time complexity
        // StringBuilder sb = new StringBuilder("");
        // for(char c='a';c<='z';c++){ //O(26) = time complexity
        // sb.append(c);
        // }
        // System.out.println(sb); //sb.length()

        // stringToUpperCase(str);
        // stringCompression(str);
        // String str = "ApnaCollege".replace("l", "");
        // System.out.println(str);
        // System.out.println(countVowel(str));
        // sc.close();
        isAnagram(s1, s2);
    }

    // finding string is palindrome or not
    public static void isPalindrome(String str) {
        int low = 0, high = str.length() - 1;
        boolean isPalindrome = true;
        while (low <= high) {
            if (str.charAt(low) != str.charAt(high)) {
                isPalindrome = false;
                break;
            }
            low++;
            high--;
        }
        if (isPalindrome)
            System.out.println("String is palindrome");
        else
            System.out.println("String is not a palindrome");
    }

    // finding the shortest path - O(n) - linear time
    public static float getShortestPath(String path) {
        int x = 0, y = 0;
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == 'W') { // West case
                x--;
            } else if (path.charAt(i) == 'E') { // East case
                x++;
            } else if (path.charAt(i) == 'N') { // North case
                y++;
            } else if (path.charAt(i) == 'S') { // South case
                y--;
            }
        }
        return (float) Math.sqrt((x * x) + (y * y)); // type casting double to float
    }

    // compare two strings
    public static void compareStrings(String s1, String s2) {
        if (s1.equals(s2)) // equal method checks value of the strings and return true if equal.
            System.out.println("Strings are equal.");
        else
            System.out.println("Strings are not equal.");
    }

    public static String Substring(String str, int startIndex, int endIndex) {
        String subString = "";
        for (int i = startIndex; i < endIndex; i++) {
            subString += str.charAt(i);
        }
        return subString;
    }

    // finding largest string from the string array using Lexicographic order
    public static void findLargestString(String[] str) {
        String largest = str[0];
        for (int i = 0; i < str.length; i++) {
            if (largest.compareTo(str[i]) < 0) { // largest<str[i]
                largest = str[i];
            }
        }
        System.out.println(largest);
    }

    // convert string to uppercase letter only first character - O(n) = n is length
    // of string
    public static void stringToUpperCase(String str) {
        StringBuilder sb = new StringBuilder("");
        char ch = Character.toUpperCase(str.charAt(0));
        sb.append(ch);
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            } else {
                sb.append(str.charAt(i));
            }

        }
        System.out.println(sb);
    }

    // String compression - O(n) linear time
    public static void stringCompression(String str) {
        // String newStr = "";
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < str.length(); i++) {
            Integer count = 1;
            while (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                count += 1;
                i++;
            }
            sb.append(str.charAt(i)); // newString+=str.charAt(i);
            if (count > 1)
                sb.append(count.toString()); //// newString+=count.toString();
            // System.out.println(count);
        }
        System.out.println(sb);
    }

    // count of vowels in the string
    public static int countVowel(String str) {
        int count = 0;
        // one way to do this O(n) Using Brute Force
        // for(int i=0;i<str.length();i++){
        // char ch = str.charAt(i);
        // if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u')
        // count++;
        // }
        // second way to do this using two pointer
        int low = 0, high = str.length() - 1;
        while (low <= high) {
            char c1 = str.charAt(low);
            char c2 = str.charAt(high);
            if (c1 == 'a' || c1 == 'e' || c1 == 'i' || c1 == 'o' || c1 == 'u')
                count++;
            if (low != high && (c2 == 'a' || c2 == 'e' || c2 == 'i' || c2 == 'o' || c2 == 'u'))
                count++;
            low++;
            high--;
        }
        return count;
    }

    // Anagram String - O(n2)
    public static void isAnagram(String s1, String s2) {
        int count = 0;
        if (s1.length() == s2.length()) {
            for (int i = 0; i < s1.length(); i++) {
                for (int j = 0; j < s2.length(); j++) {
                    if (s1.charAt(i) == s2.charAt(j)) {
                        System.out.println(s1.charAt(i) + " " + s2.charAt(j));
                        count++;
                    }
                }
            }
        }
        if (count == s1.length())
            System.out.println("Strings are Anagram.");
        else
            System.out.println("Strings are not Anagram.");
    }
}
