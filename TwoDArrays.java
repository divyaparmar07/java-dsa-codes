// import java.util.Scanner;

public class TwoDArrays {
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // int matrix[][] = new int[3][3];

        // getting input from the user
        // for (int i = 0; i < matrix.length; i++) {
        //     for (int j = 0; j < matrix[i].length; j++) {
        //         matrix[i][j] = sc.nextInt();
        //     }
        // }

        // finding smallest and largest element in the 2D Array
        // int largest = Integer.MIN_VALUE, smallest = Integer.MAX_VALUE;
        // for (int i = 0; i < matrix.length; i++) {
        //     for (int j = 0; j < matrix[i].length; j++) {
        //         if (matrix[i][j] > largest)
        //             largest = matrix[i][j];
        //         if (matrix[i][j] < smallest)
        //             smallest = matrix[i][j];
        //     }
        // }

        // System.out.println("Max value: " + largest);
        // System.out.println("Min value: " + smallest);
        // sc.close();

        int mat[][] = {{4, 7, 8}, {8, 8, 7}};
        int nums[][] = {{1, 4, 9}, {11, 4, 3}, {2, 2, 3}};
        System.out.println(Q1(mat, 7));
        System.out.println(Q2(nums, 1));
    }

    // count the number of 7 in the mat[][] 2D array
    public static int Q1(int mat[][], int target) {
        int count = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == target) {
                    count++;
                }
            }
        }
        return count;
    }

    // print the sum of 2nd rows in the nums[][] array
    public static int Q2(int nums[][], int row) {
        int sum = 0;
        for (int i = 0; i < nums[0].length; i++) {
            sum += nums[row][i];
        }
        return sum;
    }    
}