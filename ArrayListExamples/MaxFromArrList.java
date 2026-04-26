package ArrayListExamples;

import java.util.ArrayList;

public class MaxFromArrList {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(5);
        list.add(9);
        list.add(6);
        list.add(8);

        // O(n) - linear time
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            // if (max < list.get(i)) {
            //     max = list.get(i);
            // }
            max = Math.max(list.get(i), max);
        }

        System.out.println("Max element = " + max);
    }
}
