package HashMap;

import java.util.HashSet;

public class LongestCommonPrefix {
    
    public static int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> arr1Prefixes = new HashSet<Integer>(); // Set to store all prefixes from arr1

        // Step 1: Build all possible prefixes from arr1
        for (int val : arr1) {
            while (!arr1Prefixes.contains(val) && val > 0) {
                // Insert current value as a prefix
                arr1Prefixes.add(val);
                System.out.println(arr1Prefixes);
                // Generate the next shorter prefix by removing the last digit
                val /= 10;
            }
        }
        System.out.println(arr1Prefixes);

        int longestPrefix = 0;

        // Step 2: Check each number in arr2 for the longest matching prefix
        for (int val : arr2) {
            while (!arr1Prefixes.contains(val) && val > 0) {
                // Reduce val by removing the last digit if not found in the prefix set
                System.out.println(val + " " + val / 10);
                val /= 10;
            }
            if (val > 0) {
                // Length of the matched prefix using log10 to determine the number of digits
                System.out.println( "value " +val + " " + longestPrefix + " " + (int) Math.log10(val));
                longestPrefix = Math.max(
                    longestPrefix,
                    (int) Math.log10(val) + 1
                );
                System.out.println( "value " +val + " " + longestPrefix + " " + (int) Math.log10(val) + 1);
            }
        }

        // System.out.println(arr1Prefixes);

        return longestPrefix;
    }
    public static void main(String[] args) {
        int[] arr1 = {1,10,100,1000,10000};
        int[] arr2 = {100};
        System.out.print(longestCommonPrefix(arr1, arr2));
    }
}