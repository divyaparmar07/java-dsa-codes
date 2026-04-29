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

        System.out.println();

        // int[] nums = {1,3,2};
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(2);
        nums.add(3);
        System.out.println(isMonotonic(nums));
    }

    // Using Array
    // public static boolean isMonotonic(int[] nums) {
    //     int incre = 0, decre = 0;
    //     for (int i = 0; i < nums.length - 1; i++) {
    //         if (i <= i+1 && nums[i] <= nums[i+1]) {
    //             incre++;
    //         }
    //         if (i <= i+1 && nums[i] >= nums[i+1]) {
    //             decre++;
    //         }
    //     }
    //     System.out.println(incre + " " + decre);
    //     if(incre == nums.length - 1 || decre == nums.length - 1) {
    //         return true;
    //     }
    //     return false;
    // }

    public static boolean isMonotonic(ArrayList<Integer> nums) {
        int incre = 0, decre = 0;
        for (int i = 0; i < nums.size() - 1; i++) {
            if (i <= i+1 && nums.get(i) <= nums.get(i+1)) {
                incre++;
            }
            if (i <= i+1 && nums.get(i) >= nums.get(i+1)) {
                decre++;
            }
        }
        if (incre == nums.size() - 1 || decre == nums.size() - 1) {
            return true;
        }
        return false;
    }

}
