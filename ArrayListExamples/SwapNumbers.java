package ArrayListExamples;

import java.util.*;

public class SwapNumbers {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(5);
        list.add(9);
        list.add(3);
        list.add(6);

        int index1 = 1, index2 = 3;

        System.out.println(list);
        swap(list, index1, index2);

        Collections.sort(list); // ascending order

        //decending order
        Collections.sort(list,Collections.reverseOrder());
        //comparator - fun logic. how the sorting done. apply in list and object

        // int temp = list.get(1);
        // list.set(1, list.get(3));
        // list.set(3, temp);
        System.out.print(list);
    }

    private static void swap(ArrayList<Integer> list, int index1, int index2) {
        int temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);
    }
}
