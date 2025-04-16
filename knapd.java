import java.util.Scanner;

public class KnapsackDP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of items
        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        int[] weight = new int[n];
        int[] value = new int[n];

        // Input weights and values
        System.out.println("Enter weights of items:");
        for (int i = 0; i < n; i++) {
            weight[i] = sc.nextInt();
        }

        System.out.println("Enter values of items:");
        for (int i = 0; i < n; i++) {
            value[i] = sc.nextInt();
        }

        // Input capacity
        System.out.print("Enter knapsack capacity: ");
        int W = sc.nextInt();

        // Solve using DP
        int maxProfit = knapsack(weight, value, n, W);
        System.out.println("Maximum value in knapsack: " + maxProfit);
    }

    public static int knapsack(int[] weight, int[] value, int n, int W) {
        int[][] dp = new int[n + 1][W + 1];

        // Build dp[][] table
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= W; w++) {
                if (weight[i - 1] <= w) {
                    dp[i][w] = Math.max(value[i - 1] + dp[i - 1][w - weight[i - 1]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        // Uncomment below to print DP table (for debugging)
        /*
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                System.out.print(dp[i][w] + " ");
            }
            System.out.println();
        }
        */

        return dp[n][W]; // Maximum value
    }
}
//
import java.util.Scanner;

public class KnapsackBacktracking {

    // Function to find the maximum value using backtracking
    public static int knapsack(int[] weight, int[] value, int n, int W) {
        return knapsackRec(weight, value, n - 1, W, 0);  // Start from the last item
    }

    // Recursive function for backtracking
    private static int knapsackRec(int[] weight, int[] value, int n, int W, int currentValue) {
        // Base Case: No items left or knapsack capacity is 0
        if (n < 0 || W == 0) {
            return currentValue;
        }

        // Exclude the current item and move to the next item
        int exclude = knapsackRec(weight, value, n - 1, W, currentValue);

        // Include the current item, if it fits in the knapsack
        int include = 0;
        if (weight[n] <= W) {
            include = knapsackRec(weight, value, n - 1, W - weight[n], currentValue + value[n]);
        }

        // Return the maximum value between including and excluding the current item
        return Math.max(exclude, include);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of items
        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        int[] weight = new int[n];
        int[] value = new int[n];

        // Input weights and values
        System.out.println("Enter weights of items:");
        for (int i = 0; i < n; i++) {
            weight[i] = sc.nextInt();
        }

        System.out.println("Enter values of items:");
        for (int i = 0; i < n; i++) {
            value[i] = sc.nextInt();
        }

        // Input capacity
        System.out.print("Enter knapsack capacity: ");
        int W = sc.nextInt();

        // Solve using backtracking
        int maxProfit = knapsack(weight, value, n, W);
        System.out.println("Maximum value in knapsack: " + maxProfit);
    }
}
