/*
 * This class solves the Unbounded Knapsack Problem with bottom-up dynamic programming.
 * It effectively uses a tabulation way and uses bottom-up approach to solve the problem..
 */

public class UnboundedKnapsackBottomUpSpaceOptimized {
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
        int[] dpPrev = new int[W + 1];
        int[] dpCurr = new int[W + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                int nopick = dpPrev[j];
                int pick = 0;
                if (j - wt[i - 1] >= 0) {
                    int remainingWeight = j - wt[i - 1];
                    pick += val[i - 1] + dpCurr[remainingWeight];
                }
                dpCurr[j] = Math.max(nopick, pick);
            }
            dpPrev = dpCurr;
        }

        return dpPrev[W];
    }
}