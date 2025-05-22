public class KadanesAlgorithm {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[] { 2, 3, 5, -2, 7, -4 }));
        System.out.println(maxSubArray(new int[] { -2, -3, -7, -2, -10, -4 }));
        System.out.println(maxSubArray(new int[] { -1, 2, 3, -1, 2, -6, 5 }));
    }

    public static int maxSubArray(int[] nums) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            if (currSum < 0) {
                maxSum = Math.max(currSum, maxSum);
                currSum = 0;
            } else {
                maxSum = Math.max(currSum, maxSum);
            }
        }
        return maxSum;
    }
}