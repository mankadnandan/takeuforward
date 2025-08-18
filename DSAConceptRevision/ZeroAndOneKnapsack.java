
/*
 * This class solves the 0/1 Knapsack Problem with Recursion and dynamic programming.
 */
import java.util.Arrays;

public class ZeroAndOneKnapsack {
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
        int[][] dp = new int[n][W + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return knapsack01Helper(0, wt, val, n, W, dp);
    }

    private static int knapsack01Helper(int idx, int[] wt, int[] val, int n, int W, int[][] dp) {

        if (dp[idx][W] != -1) {
            return dp[idx][W];
        }

        if (idx == n - 1) {
            if (W - wt[idx] >= 0) {
                return val[idx];
            } else {
                return 0;
            }
        }

        int nopick = knapsack01Helper(idx + 1, wt, val, n, W, dp);
        int pick = 0;
        if (W - wt[idx] >= 0) {
            pick = val[idx] + knapsack01Helper(idx + 1, wt, val, n, W - wt[idx], dp);
        }

        return dp[idx][W] = Math.max(nopick, pick);
    }
}