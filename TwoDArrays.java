import java.util.Scanner;

public class TwoDArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int matrix[][] = new int[3][3];

        // getting input from the user
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        // finding smallest and largest element in the 2D Array
        int largest = Integer.MIN_VALUE, smallest = Integer.MAX_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > largest)
                    largest = matrix[i][j];
                if (matrix[i][j] < smallest)
                    smallest = matrix[i][j];
            }
        }

        System.out.println("Max value: " + largest);
        System.out.println("Min value: " + smallest);
        sc.close();
    }
}
