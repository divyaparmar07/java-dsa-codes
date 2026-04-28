package ArrayListExamples;

import java.util.*;

public class Basic {
    public static void main(String args[]) {
        // String | Boolean | Float
        ArrayList<Integer> list = new ArrayList<>();
        // ArrayList<String> list = new ArrayList<>();

        // Add operation - O(1)
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        // Add at index - O(n)
        list.add(1, 9);

        //print arraylist
        System.out.println(list);

        // Get element - O(1)
        int element = list.get(2);
        System.out.println(element);

        // Delete element - O(n)
        list.remove(2);
        System.out.println(list);
        
        // Set element at index - O(n)
        list.set(2, 10);
        System.out.println(list);

        // Contains Element - O(n)
        System.out.println(list.contains(1));
        System.out.println(list.contains(11));

        System.out.println(list.size());

        // print the arraylist
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
