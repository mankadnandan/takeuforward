/*
 * CoinChangeII with Tabulation and BottomUp DP with Space optimization.
 * Here we are just using a single 1D array to solve the entire DP.
 */

public class CoinChangeIIBottomUpSpaceOptimized {
    public static void main(String[] args) {
        System.out.println(count(new int[] { 2, 4, 10 }, 3, 10));
        System.out.println(count(new int[] { 5 }, 1, 10));
        System.out.println(count(new int[] { 1, 2, 3, 5 }, 4, 5));
        System.out.println(count(new int[] { 97, 40, 4, 31, 75, 87, 43, 60, 99, 27, 94, 34, 15, 3, 41, 95, 53, 76, 45,
                12, 10, 73, 38, 5 }, 24, 789));
    }

    public static int count(int[] coins, int N, int amount) {
        int[] prev = new int[amount + 1];

        for (int i = 1; i < coins.length + 1; i++) {
            prev[0] = 1;
            for (int j = 1; j < amount + 1; j++) {
                int nopick = prev[j] % 1000000007;
                int pick = j - coins[i - 1] >= 0 ? prev[j - coins[i - 1]] % 1000000007 : 0;
                prev[j] = (nopick + pick) % 1000000007;
            }
        }
        return prev[amount];
    }
}