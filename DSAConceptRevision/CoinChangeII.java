import java.util.Arrays;

public class CoinChangeII {
    public static void main(String[] args) {
        System.out.println(count(new int[] { 2, 4, 10 }, 3, 10));
        System.out.println(count(new int[] { 5 }, 1, 10));
        System.out.println(count(new int[] { 1, 2, 3, 5 }, 4, 5));
        System.out.println(count(new int[] { 97, 40, 4, 31, 75, 87, 43, 60, 99, 27, 94, 34, 15, 3, 41, 95, 53, 76, 45,
                12, 10, 73, 38, 5 }, 24, 789));
    }

    public static int count(int[] coins, int N, int amount) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        int ways = countHelper(0, coins, N, amount, dp);
        return ways;
    }

    public static int countHelper(int idx, int[] coins, int N, int remainingAmount, int[][] dp) {
        if (remainingAmount == 0) {
            return 1;
        }

        if (idx >= N) {
            return 0;
        }

        if (dp[idx][remainingAmount] != -1) {
            return dp[idx][remainingAmount];
        }

        int ways = countHelper(idx + 1, coins, N, remainingAmount, dp) % 1000000007;
        if (remainingAmount - coins[idx] >= 0) {
            ways = ways % 1000000007 + countHelper(idx, coins, N, remainingAmount - coins[idx], dp) % 1000000007;
        }
        return dp[idx][remainingAmount] = ways % 1000000007;
    }
}