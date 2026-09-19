package SortingAndArrays;

/*
    This is O(NLogN) solution where we use sorting first and then run the algorithm to count the consecutive numbers.
 */

import java.util.Arrays;

public class LongestConsecutiveSequenceInAnArray_4 {

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[] { 100, 4, 200, 1, 3, 2 }));
        System.out.println(longestConsecutive(new int[] { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 }));
        System.out.println(longestConsecutive(new int[] { 1, 9, 3, 10, 4, 20, 2 }));
    }

    public static int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int currConsecutiveCount = 1;
        int maxConsecutiveCount = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            } else if (nums[i] == nums[i - 1] + 1) {
                currConsecutiveCount++;
                maxConsecutiveCount = Math.max(maxConsecutiveCount, currConsecutiveCount);
            } else {
                currConsecutiveCount = 1;
            }
        }
        return maxConsecutiveCount;
    }

}