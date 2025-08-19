/*
 * This class solves the Unbounded Knapsack Problem with bottom-up dynamic programming.
 * It effectively uses a tabulation way and uses bottom-up approach to solve the problem..
 */

public class UnboundedKnapsackBottomUp {
    public static void main(String[] args) {
        int[] wt = new int[] { 2, 4, 6 };
        int[] val = new int[] { 5, 11, 13 };
        System.out.println(unboundedKnapsack(wt, val, 3, 10));

        wt = new int[] { 1, 3, 4, 5 };
        val = new int[] { 10, 40, 50, 70 };
        System.out.println(unboundedKnapsack(wt, val, 4, 8));

        wt = new int[] { 10, 20, 30 };
        val = new int[] { 60, 100, 120 };
        System.out.println(unboundedKnapsack(wt, val, 3, 60));
    }

    public static int unboundedKnapsack(int[] wt, int[] val, int n, int W) {
        int[][] dp = new int[n + 1][W + 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                int nopick = dp[i - 1][j];
                int pick = 0;
                if (j - wt[i - 1] >= 0) {
                    int remainingWeight = j - wt[i - 1];
                    pick += val[i - 1] + dp[i][remainingWeight];
                }
                dp[i][j] = Math.max(nopick, pick);
            }
        }

        return dp[n][W];
    }
}
