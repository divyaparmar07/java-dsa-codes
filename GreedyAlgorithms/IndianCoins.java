package GreedyAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class IndianCoins {
    public static void main(String[] args) {
        Integer coins[] = {1, 2, 5, 10, 20, 50, 100, 500, 2000};

        // descending order
        Arrays.sort(coins, Comparator.reverseOrder());

        int countOfCoins = 0;
        int amount = 1059;
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= amount) {
                while (coins[i] <= amount) {
                    countOfCoins++;
                    ans.add(coins[i]);
                    amount -= coins[i];
                }
            }
        }

        System.out.println("Total (min) Count used = " + countOfCoins);
        System.out.println(ans);

    }
}

/* Notes: Job sequencing Problem : profit -> max 
            Activity Selection : Max -> work
Min or max based on that do sorting in greedy
Max profit then based on profit sorting done
Max work then ending time based on sorting done
Max value and min weight then ratio based on sorting (fractional knapsack)

*/