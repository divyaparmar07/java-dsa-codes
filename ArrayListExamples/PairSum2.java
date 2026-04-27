package ArrayListExamples;
import java.util.*;
// Find if any pair in a Sorted & Rotated arraylist has a target sum.
// list = 11, 15, 6, 8, 9, 10  target = 16
public class PairSum2 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);
        int target = 16;

        System.out.print(pairSum2(list, target));
    }

    // Time Complexity - O(n)
    private static boolean pairSum2(ArrayList<Integer> list, int target) {
        int pivot = -1;
        int n = list.size();
       for (int i = 0; i < list.size() - 1; i++) { // breaking point
            if (list.get(i) > list.get(i+1)) {
                pivot = i;
                break;
            }
       }
       int left = pivot + 1; // smallest
       int right = pivot; // largest
    //    System.out.print(pivot + " " + left + " " + right); 
       while (left != right) {
            // case - 1
            if (list.get(left) + list.get(right) == target) {
                return true;
            } 
            // case - 2
            else if (list.get(left) + list.get(right) > target) {
                right = (n + right - 1) % n;
            } 
            //case - 3
            else {
                left = (left + 1) % n;
            }
       }
       return false;
    }
}
