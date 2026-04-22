public class ArrayExample {
    public static void main(String[] args) {
        // int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
;
        // int target = 0;
        // int[] prices = { 7, 6, 4, 3, 1 };
        // reverseArray(nums);
        // for(int i=0;i<nums.length;i++){
        // System.out.print(nums[i]+ " ");
        // }
        // pairArray(nums);
        // printSubarrays(nums);
        // System.out.println("index: "+findTargetElementInArray(nums,target));
        // System.out.println("Trapped Rainwater: " + trappedRainwater(nums));
        // System.out.println("Maximum profit: " + buyAndSellStocks(prices));
        System.out.print(maxOfSumArraysUsingKadane(arr));
    }

    public static void reverseArray(int[] arr) {
        int first = 0;
        int end = arr.length - 1;
        while (first < end) {
            int temp = arr[first];
            arr[first] = arr[end];
            arr[end] = temp;
            first++;
            end--;
        }
    }

    public static void pairArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                System.out.print("[" + arr[i] + "," + arr[j] + "] ");
            }
            System.out.println();
        }
    }

    public static void printSubarrays(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                System.out.print("(");
                for (int start = i; start <= j; start++) {
                    System.out.print(" " + arr[start]);
                }
                System.out.print("),");
            }
            System.out.println();
        }
    }

    // Using Brute Force - Basic solution TC- O(n3)
    public static int maxOfSubArrays(int[] arr) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int sum = 0; // current sum
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }
                // System.out.println(sum);
                if (sum > max)
                    max = sum;
                if (sum < min)
                    min = sum;
            }
        }
        // System.out.println("Min value: "+min);
        return max;
    }

    // Using Prefix sum technique - TC - O(n2)
    // prefix[end] - prefix[start - 1]
    public static int maxOfSubArraysUsingPrefixArray(int[] arr) {
        int max = Integer.MIN_VALUE;
        int[] prefix = new int[arr.length];
        prefix[0] = arr[0];
        // calculate prefix array
        for (int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int sum = 0;
                // finding current sum
                sum = i == 0 ? prefix[j] : prefix[j] - prefix[i - 1];
                if (sum > max)
                    max = sum;
            }
        }
        return max;
    }

    // Using kadane's Algorithm only for positive numbers - TC O(n)
    // HW - write condition for negative number what if we have all nums are negative.
    public static int maxOfSumArraysUsingKadane(int[] arr) {
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];
            if (currentSum < 0) {
                currentSum = 0;
            }
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    // With Negative numbers solution
    // class Solution {
    // public int maxSubArray(int[] nums) {
    //      int currentSum = 0;
    //     int maxSum = Integer.MIN_VALUE;
    //     int negNum = 0;
    //     for (int i = 0; i < nums.length; i++) {
    //         if (nums[i] < 0) {
    //             negNum++;
    //         }
    //     }
    //     if (negNum == nums.length) {
    //         for (int i = 0; i < nums.length; i++) {
    //             currentSum += nums[i];
    //             if (currentSum < 0) {
    //                 currentSum = Math.max(currentSum, nums[i]);
    //             }
    //             maxSum = Math.max(maxSum, currentSum);
    //         }
    //     } else {
    //         for (int i = 0; i < nums.length; i++) {
    //             currentSum += nums[i];
    //             if (currentSum < 0) {
    //                 currentSum = 0;
    //             }
    //             maxSum = Math.max(maxSum, currentSum);
    //         }
    //     }
    //     return maxSum;
    // }
    // }

    // Trapped RainWater problem
    public static int trappedRainwater(int height[]) {
        int trappedWater = 0;
        // calculate left max boundry - array(Auxiliary array-helper array)
        int[] left = new int[height.length];
        left[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
        }

        // calculate right max boundry - array(Auxiliary array-helper array)
        int[] right = new int[height.length];
        right[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i]);
        }

        // waterlevel=find min of leftboundry,rightboundry
        // trappedlevel = waterlevel-height
        for (int i = 0; i < height.length; i++) {
            int waterlevel = Math.min(left[i], right[i]);
            trappedWater += waterlevel - height[i];
        }

        return trappedWater;
    }

    // Buy and sell stocks problem
    public static int buyAndSellStocks(int[] prices) {
        int maxProfit = 0;
        int buyingPrice = Integer.MAX_VALUE; // Track minimum price
        for (int i = 0; i < prices.length; i++) {
            if (buyingPrice < prices[i]) { // If our buying price is less than selling price then we got profit
                int profit = prices[i] - buyingPrice; // today's profit
                maxProfit = Math.max(maxProfit, profit);
            } else { // If our selling price is low then buying price then we can update buying price
                     // to selling price
                buyingPrice = prices[i];
            }
        }
        return maxProfit;
    }

    public static int findTargetElementInArray(int[] nums, int target) {
        // int index=-1;
        // int low=0, high=nums.length-1;
        // int mid=(low+high)/2;
        // while (low<high) {
        // if(nums[mid]==target){
        // return mid;
        // }else if(nums[mid]>target){
        // high=mid-1;
        // }else {
        // low=mid+1;
        // }
        // }
        return -1;
    }
}