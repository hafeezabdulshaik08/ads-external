public class NQueens {
    static int N = 4; // Number of queens and the size of the board

    // Function to print the board
    static void printBoard(int[] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i] == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    // Function to check if the queen placement is safe
    static boolean isSafe(int[] board, int row, int col) {
        // Check previous rows for column and diagonal conflicts
        for (int i = 0; i < row; i++) {
            // Check if queens are in the same column or diagonal
            if (board[i] == col || Math.abs(board[i] - col) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }

    // Recursive backtracking function to solve N-Queens problem
    static boolean solveNQueens(int[] board, int row) {
        // If all queens are placed
        if (row == N) {
            printBoard(board); // Print the current solution
            return true;
        }

        boolean res = false;
        // Try placing the queen in all columns one by one
        for (int col = 0; col < N; col++) {
            if (isSafe(board, row, col)) {
                board[row] = col;  // Place queen in the current position
                // Recursively place queen in the next row
                res = solveNQueens(board, row + 1) || res;
                // Backtrack (remove queen)
                board[row] = -1;
            }
        }
        return res;
    }

    // Main function to solve the N-Queens problem
    public static void main(String[] args) {
        int[] board = new int[N];  // Create an array to store the queen positions

        // Initialize the board
        for (int i = 0; i < N; i++) {
            board[i] = -1;  // -1 means no queen placed in that row
        }

        // Call the solve function
        if (!solveNQueens(board, 0)) {
            System.out.println("Solution does not exist");
        }
    }
}
