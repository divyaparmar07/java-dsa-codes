package ArrayListExamples;

import java.util.ArrayList;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        ArrayList<Integer> height = new ArrayList<>();
        // 1 8 6 2 5 4 8 3 7
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);
        
        System.out.println(storeWater(height));
        System.out.println(storeWaterUsingTwoPointer(height));
    }

    // Brute force - TC = O(n2)
    public static int storeWater(ArrayList<Integer> height) {
        int maxWater = 0;
        for (int i = 0; i < height.size(); i++) {
            for (int j = i+1; j < height.size(); j++) {
                int heig = Math.min(height.get(i),height.get(j));
                int width = j - i;
                int currWater = heig * width;
                maxWater = Math.max(currWater, maxWater);
            }
        }
        return maxWater;
    }

    // Two Pointer - TC - O(n)
    public static int storeWaterUsingTwoPointer(ArrayList<Integer> height) {
        int maxWater = 0;
        int left = 0, right = height.size() - 1;
        while (left < right) {
            // calculate water area
            int heigh = Math.min(height.get(left), height.get(right));
            int width = right - left;
            maxWater = Math.max(heigh * width, maxWater);

            //update pointer
            if (height.get(left) < height.get(right)) {
                left++;
            } else {
                right--;
            }
        }
        return maxWater;
    }
    
}