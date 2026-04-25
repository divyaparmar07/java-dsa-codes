// three ways 
// 1. all possible
// 2. count ways
// 3. solution is exist or not if yes then print one.
public class NQueenProblem {
    static int count = 0;
    public static void main(String[] args) {
        
        int n = 4; // output 2 boards n = 5 then 10 boards printing
        char board[][] = new char[n][n];
        //initialize
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        // nQueens(board, 0);
        if (nQueens(board, 0)) {
            System.out.println("solution is possible");
            printBoard(board);
        } else {
            System.out.println("Solution is not possible");
        }
        // System.out.println("total ways to solve n queens = " + count);
    }

    public static boolean isSafe(char board[][], int row, int col) {
        //vertical up
        for (int i = row-1; i>=0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        //diagonal left up
        for (int i = row-1, j=col-1; i>=0 && j>=0; i--,j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        //diagonal right up
        for (int i=row-1, j=col+1; i>=0 && j<board.length; i--,j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
    
    // Q3 - N Queens - Time Complexity O(n!)
    // public static void nQueens(char board[][], int row) {
    //     //base
    //     if (row == board.length) {
    //         // printBoard(board);
    //         count++; // couting possible ways
    //         return;
    //     }

    //     //column loop
    //     for (int j = 0; j < board.length; j++) {
    //         if (isSafe(board, row, j)) {
    //             board[row][j] = 'Q';
    //             nQueens(board, row+1); // function call
    //             board[row][j] = '.'; // backtracking step
    //         }
    //     }
    // }

    // Check if problem can be solved & print only  1 solution to N Queens Problem
    public static boolean nQueens(char board[][], int row) {
        //base
        if (row == board.length) {
            // printBoard(board);
            count++; // couting possible ways
            return true;
        }

        //column loop
        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';
                if (nQueens(board, row+1)) {
                    return true;
                } 
                board[row][j] = '.'; // backtracking step
            }
        }
        return false; // not any one possible way
    }

    public static void printBoard(char board[][]) {
        System.out.println("---------chess board--------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
