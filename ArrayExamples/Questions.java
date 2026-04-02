import java.util.Arrays;

public class Questions {
    public static void main(String args[]) {
        int[] nums = { -1, 0, 1, 2, -1, -4 };
        // System.out.println(twiceValueOrDistinct(nums));
        System.out.print(targetNumber(nums, 0));
    }

    // Q1: Given an integer array nums, return true if any value appears at least
    // twice in the
    // array, and return false if every element is distinct.
    public static boolean twiceValueOrDistinct(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                return true;
            }
        }
        return false;
    }

    // Q2: There is an integer array nums sorted in ascending order (with distinct
    // values).
    // Prior to being passed to your function, nums is possibly rotated at an
    // unknown
    // pivot index k (1 <= k < nums.length) such that the resulting array is
    // [nums[k],
    // nums[k+1],..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For
    // example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and
    // become [4,5,6,7,0,1,2].
    public static int targetNumber(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            if (nums[low] == target) {
                return low;
            }
            if (nums[high] == target) {
                return high;
            }
            low++;
            high--;
        }
        return -1;
    }
}
