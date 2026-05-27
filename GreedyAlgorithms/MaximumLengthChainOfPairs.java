package GreedyAlgorithms;

import java.util.Arrays;
import java.util.Comparator;

// similar approach and que like Activity selection
// in mind greedy + sorting then it's greedy if greedy then sorting or vice-versa
// if we find in general problem sorting apply here it's greedy
public class MaximumLengthChainOfPairs { // nlogn
    public static void main(String[] args) {
        int pairs[][] = {{5, 24}, {39, 60}, {5, 28}, {27, 40}, {50, 90}};

        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1])); // o(logn)

        int chainLen = 1;
        int chainEnd = pairs[0][1]; // last selected pair end // chain end 

        for (int i = 1; i < pairs.length; i++) { // o(n)
            if (pairs[i][0] > chainEnd) {
                chainLen++;
                chainEnd = pairs[i][1];
            }
        }

        System.out.println("Max length of chain = " + chainLen);
    }
}
