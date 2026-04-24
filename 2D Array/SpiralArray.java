//Spiral element print of array
public class SpiralArray {
    public static void main(String args[]) {
        // int matrix[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        // int matrix[][] = {{1,2,3},{4,5,6},{7,8,9}};
        int matrix[][] = { { 10, 20, 30, 40 }, { 15, 25, 35, 45 }, { 27, 29, 37, 48 }, { 32, 33, 39, 50 } };
        searchElementInSortedArray(matrix, 100);

    }

    public static void printSpiral(int matrix[][]) {
        int startRow = 0, endRow = matrix.length - 1, startCol = 0, endCol = matrix[0].length - 1;
        while (startRow <= endRow && startCol <= endCol) {
            // top
            for (int j = startRow; j <= endCol; j++) {
                System.out.print(matrix[startRow][j] + " ");
            }
            // right
            for (int i = startRow + 1; i <= endRow; i++) {
                System.out.print(matrix[i][endCol] + " ");
            }
            // bottom
            for (int j = endCol - 1; j >= startCol; j--) {
                if (startRow == endRow) {
                    break;
                }
                System.out.print(matrix[endCol][j] + " ");
            }
            // left
            for (int i = endRow - 1; i >= startRow + 1; i--) {
                if (startCol == endCol) {
                    break;
                }
                System.out.print(matrix[i][startRow] + " ");
            }
            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }
    }

    public static void DiagonalSum(int matrix[][]) {
        int i = 0, j = matrix.length - 1;
        int sum = 0;
        while (i <= j) {
            // System.out.print(matrix[i][i]+" "+matrix[i][j] +" "+ matrix[j][i]+"
            // "+matrix[j][j]+" ");
            if (i == j) {
                sum += matrix[i][i];
            } else {
                sum += matrix[i][i];
                sum += matrix[i][j];
                sum += matrix[j][i];
                sum += matrix[j][j];
            }
            i++;
            j--;
        }
        System.out.println("Sum is: " + sum);
    }

    // stair case search
    public static boolean searchElementInSortedArray(int matrix[][], int key) {
        int row = 0, col = matrix.length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == key) {
                System.out.println("Found key at (" + row + "," + col + ")");
                return true;
            } else if (matrix[row][col] > key) {
                col--;
            } else if (matrix[row][col] < key) {
                row++;
            }
        }
        System.out.println("Key not found");
        return false;
    }

}
