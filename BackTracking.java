public class BackTracking {
    public static void main(String[] args) {
        // int arr[] = new int[5];
        // changeArr(arr, 0, 1);
        // printArr(arr);
        String str = "abc";
        findSubsets(str, new String(""), 0);
    } 

    // Time Complexity = O(n) & Space Complexity = O(n)
    // n steps perform up and return n steps perform
    // print then steps perform O(2n) = remove constant = O(n)
    public static void changeArr(int arr[], int i, int val) {
        // 1. Base case
        if (i == arr.length) {
            printArr(arr); // printing array
            return;
        }
        // 2. recursion
        arr[i] = val; // change value
        changeArr(arr, i+1, val+1); // fn call
        //after return
        arr[i] = arr[i] - 2; // backtracking step
    }

    // reference by value arrays are directly pass by reference.
    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    // Q1: find & print all subsets of the string
    // Time Complexity - O(n * 2^n) & Space Complexity - O(n)
    public static void findSubsets(String str, String ans, int i) {
        // Base case
        if (i == str.length()) {
            if (ans.length() == 0) {
                System.out.println("null");
            } else {
                System.out.println(ans);
            }
            return;
        }

        // Recursion
        // Yes choice
        findSubsets(str, ans+str.charAt(i), i+1);
        // No choice
        findSubsets(str, ans, i+1);
    }
}
