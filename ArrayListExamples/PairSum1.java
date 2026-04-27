package ArrayListExamples;

import java.util.ArrayList;

// Find if any pair in a Sorted ArrayList has a target sum.
// list = [1,2,3,4,5,6], target=5
public class PairSum1 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        int target = 5;

        System.out.println(pairSum(list, target));
        System.out.println(pairSumWith2Pointer(list, target));
    }

    // Brute force - O(n2)
    public static boolean pairSum(ArrayList<Integer> list, int target) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) + list.get(j) == target) {
                    return true;
                }
            }
        }
        return false;
    }
    
    // 2 Pointer approach - O(n)
    public static boolean pairSumWith2Pointer(ArrayList<Integer> list, int target) {
        int left = 0, right = list.size() - 1;
        while (left < right) { // left != right

            //case-1
            if (list.get(left) + list.get(right) == target) {
                return true;
            } 
            
            // case -2
            else if (list.get(left) + list.get(right) < target) { // when target is greater then sum then left++ bcz left++ gives us big values. left pointer going towards big numbers
                left++;
            } 
            
            // case-3
            else { // when target is lesser then sum then right-- bcz right-- gives us small values. right pointer going towards small values/ numbers.
                right--;
            }
        }
        return false;
    }
}
