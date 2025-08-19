/*
 * This class solves the Unbounded Knapsack Problem with Recursion and dynamic programming.
 */

import java.util.Arrays;

public class UnboundedKnapsack {

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
        int[][] dp = new int[n][W + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return unboundedKnapsackHelper(0, wt, val, n, W, dp);
    }

    private static int unboundedKnapsackHelper(int idx, int[] wt, int[] val, int n, int remainingWeight, int[][] dp) {
        if (idx >= n) {
            return 0;
        }

        if (dp[idx][remainingWeight] != -1) {
            return dp[idx][remainingWeight];
        }

        int noPick = unboundedKnapsackHelper(idx + 1, wt, val, n, remainingWeight, dp);
        int pick = 0;
        if (remainingWeight - wt[idx] >= 0) {
            pick = val[idx] + unboundedKnapsackHelper(idx, wt, val, n, remainingWeight - wt[idx], dp);
        }
        return dp[idx][remainingWeight] = Math.max(pick, noPick);
    }
}