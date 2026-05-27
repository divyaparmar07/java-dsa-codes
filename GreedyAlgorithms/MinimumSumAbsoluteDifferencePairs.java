package GreedyAlgorithms;

import java.security.KeyStore.Entry;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinimumSumAbsoluteDifferencePairs {
    public static void main(String[] args) { // O(nlogn)
        // int A[] = {1, 2, 3};
        // int B[] = {2, 1, 3};
        // int A[] = {4, 1, 8, 7};
        // int B[] = {2, 3, 6, 5};

        // Arrays.sort(A);
        // Arrays.sort(B); // logn

        // int minDiff = 0;

        // for (int i = 0; i < A.length; i++) { // n
        //     minDiff += Math.abs(A[i] - B[i]);
        // }

        // System.out.println("min absolutr diff of pairs = " + minDiff);

        // aaAbcBC 3 
        // abc     0 
        // AbBCab  0 
        // cCceDC  0 
        // AbcbDBdD 1

        // String word = "abc";
        // System.out.println( "count = " + numberOfSpecialChars(word));
        
    }   

    
    public static int numberOfSpecialChars(String word) {
        int count = 0;
        // Set<Character> set = new HashSet<>();
        HashMap<Character, Integer> map = new HashMap<>();
        // adding index of uppercase and 
        for (int i = 0; i < word.length(); i++) {
            char lc = word.charAt(i);
            char uc = Character.toUpperCase(lc);
            // set.add(lc);
            // lowercase
            if (word.contains(String.valueOf(uc)) && lc >= 'a' && lc <= 'z') {
                map.put(lc, i);
            }
            if (lc >= 'A' && lc <= 'Z' && map.get(uc) == null) {
                map.put(uc, i);
            }
        } 

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            char uc = Character.toUpperCase(ch);
            if (ch >= 'a' && ch <= 'z') {
                if (map.containsKey(ch) && map.containsKey(uc) 
                         && (map.get(ch) < map.get(uc))) {
                            count++;
                            map.remove(ch);
                            map.remove(uc);
                        }
            }
        }
        // for (char ch : set) {
        //     char uc = Character.toUpperCase(ch);
        //     if (ch >= 'a' && ch <= 'z') {
        //         if (map.containsKey(ch) && map.containsKey(uc) 
        //                  && (map.get(ch) < map.get(uc))) {
        //                     count++;
        //                 }
        //     }
        // }
		// Set<Character> set = new HashSet<>();
		// for (int i = 0; i < word.length(); i++) {
		// 	char ch = word.charAt(i);
		// 	char uc = Character.toUpperCase(ch);
		// 	int index = i;
		// 	if (word.contains(String.valueOf(uc))) {
		// 		if (ch >= 'a' && ch <= 'z' && !set.contains(ch)) {
		// 			for (int j = i+1; j < word.length(); j++) {
		// 				if (word.charAt(j) == ch) {
		// 					index = j;
		// 				}
		// 			}
        //             int jIndex = -1;
		// 			for (int j = 0; j < word.length(); j++) {
		// 				if (uc == word.charAt(j)) {
		// 					set.add(ch);
        //                     jIndex = j;
		// 					break;
		// 				}
		// 			}
        //             if (index < jIndex) {
        //                 count++;
        //             }
		// 		}
		// 	}
		// }
		return count;
    }

    public static int numberOfSpecialChars1(String word) {
        int count = 0;

        int[] lowerCase = new int[26];
        int[] upperCase = new int[26];

        // setting all values to -1
        Arrays.fill(lowerCase, -1);
        Arrays.fill(upperCase, -1);
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            // character is lowercase then updating index in lowerCase Array
            if (Character.isLowerCase(ch)) {
                lowerCase[ch - 'a'] = i;
            } else { // character is uppercase then updating index in upperCase Array
                if (upperCase[ch - 'A'] == -1) {
                    upperCase[ch - 'A'] = i;
                }
            }
        }

        for (int i = 0; i < 26; i++) {
            // checking both index
            if (lowerCase[i] != -1 && upperCase[i] != -1 && lowerCase[i] < upperCase[i]) {
                count++;
            }
        }
		return count;
    }

}