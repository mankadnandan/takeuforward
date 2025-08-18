/*
 * This class solves the 0/1 Knapsack Problem with bottom-up dynamic programming.
 * It effectively uses a tabulation way and uses bottom-up approach to solve the problem.
 */
public class ZeroAndOneKnapsackBottomUp {
    public static void main(String[] args) {
        int[] wt = new int[] { 10, 20, 30 };
        int[] val = new int[] { 60, 100, 120 };
        System.out.println(knapsack01(wt, val, 3, 50));

        wt = new int[] { 5, 4, 6, 3 };
        val = new int[] { 10, 40, 30, 50 };
        System.out.println(knapsack01(wt, val, 4, 10));

        wt = new int[] { 1, 2, 3, 8, 7, 4 };
        val = new int[] { 20, 5, 10, 40, 15, 25 };
        System.out.println(knapsack01(wt, val, 6, 10));
    }

    public static int knapsack01(int[] wt, int[] val, int n, int W) {
        int[][] dp = new int[n + 1][W + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                int pick = 0;
                if (wt[i - 1] <= j) {
                    int prev = j - wt[i - 1] >= 0 ? dp[i - 1][j - wt[i - 1]] : 0;
                    pick = val[i - 1] + prev;
                }
                int nopick = dp[i - 1][j];
                dp[i][j] = Math.max(pick, nopick);
            }
        }
        return dp[n][W];
    }
}