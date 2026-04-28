package ArrayListExamples;

import java.util.*;

public class FindAllLoneyNumbers {

    // TC - O(logn) SC - O(1)
    public static List<Integer> findLonely(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums); // O(logn)
        for (int i = 0; i < nums.length; i++) { // O(n)
            if ((i == 0 || nums[i] - nums[i - 1] > 1) && (i == nums.length - 1 || nums[i+1] - nums[i] > 1) ) {
                res.add(nums[i]);
            }
        }
        return res;
    }

    // Optimized code - O(n)
    public static List<Integer> findLonelyUsingHashMap(int[] nums) {
        List<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        // getting frequency and filling HashMap
        for (int num : nums) {
            map.put(num, map.getOrDefault(num,0) + 1);
        } 
        // traversing HashMap
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) { // entry is pointing to 1st index which have key and value // O(n) worst case
            int val = entry.getKey();
            if (entry.getValue() == 1 && !map.containsKey(val+1) && !map.containsKey(val-1)) {
                res.add(val);
            }

        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {10,6,5,8};
        System.out.println(findLonely(nums));
        System.out.println(findLonelyUsingHashMap(nums));
    }
}
