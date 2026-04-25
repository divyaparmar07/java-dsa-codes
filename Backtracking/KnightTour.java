public class KnightTour {
    static int N = 8;
    
    // checking that placing the knight it is safe for this place or not
    static boolean isSafe(int x, int y, int sol[][]) {
        return (x >= 0 && x < N && y >= 0 && y < N && sol[x][y] == -1);
    }

    static void printSolution(int sol[][]) {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                System.out.print(sol[x][y] + " ");
            }
            System.out.println();
        }
    }

    static boolean solveKTUtil(int x, int y, int movei, int sol[][], int xMove[], int yMove[]) {
        int k, next_x, next_y;
        if (movei == N * N) {
            return true;
        }

        /* Try all next moves from the current coordinate */
        for (k = 0; k < 8; k++) {
            next_x = x + xMove[k];
            next_y = y + yMove[k];
            if (isSafe(next_x, next_y, sol)) {
                sol[next_x][next_y] = movei;
                if (solveKTUtil(next_x, next_y, movei + 1, sol, xMove, yMove)) {
                    return true;
                } else {
                    sol[next_x][next_y] = -1; // backtracking
                }
            }
        }

        return false;
    }

    static boolean solveKT() {
        int sol[][] = new int[8][8];

        /* Initialization of solution matrix */
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                sol[x][y] = -1;
            }
        }

        int xMove[] = {2, 1, -1, -2, -2, -1, 1, 2};
        int yMove[] = {1, 2, 2, 1, -1, -2, -2, -1};

        /*
        curr = {5,5};
        Moves -> (5+xMove[idx], 5+yMove[idx])
        idx 0 -> 5+2, 5+1
        idx 1 -> 5+1, 5+2
        idx 2 -> 5-1, 5+2
        */

        // since the knight is initially at the first block
        sol[0][0] = 0;

        if (!solveKTUtil(0,0, 1, sol, xMove, yMove)) {
            System.out.println("Solution does not exist");
            return false;
        } else {
            printSolution(sol);
        }

        return true;
    }

    public static void main(String[] args) {
        if (solveKT()){
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
