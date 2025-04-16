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
