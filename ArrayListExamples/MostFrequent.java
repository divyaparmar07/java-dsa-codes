package ArrayListExamples;
import java.util.*;

public class MostFrequent {
     public static int mostFrequent(int[] nums, int key) {
        int freq = Integer.MIN_VALUE, ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length -1; i++) {
            if (key == nums[i]) {
                map.put(nums[i+1], map.getOrDefault(nums[i+1],0) + 1);
            }
        }
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if (entry.getValue() > freq) {
                ans = entry.getKey();
                freq = entry.getValue();
            }
        }
        return ans;
    }
    public static void main(String args[]) {
        int[] nums = {2,1000,2,1000,2,3};
        System.out.println(mostFrequent(nums,2));
    }
}