package SortingAndArrays;

/*
    This is O(N^3) brute force solution.
 */

public class LongestConsecutiveSequenceInAnArray_3 {
    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[] { 100, 4, 200, 1, 3, 2 }));
        System.out.println(longestConsecutive(new int[] { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 }));
        System.out.println(longestConsecutive(new int[] { 1, 9, 3, 10, 4, 20, 2 }));
    }

    public static int longestConsecutive(int[] nums) {
        int currConsecutiveCount = 0;
        int maxConsecutiveCount = 0;
        for (int i = 0; i < nums.length; i++) {
            currConsecutiveCount = 1;
            int searchElement = nums[i] + 1;
            while (linearSearch(nums, searchElement)) {
                currConsecutiveCount++;
                searchElement++;
            }
            maxConsecutiveCount = Math.max(maxConsecutiveCount, currConsecutiveCount);
        }
        return maxConsecutiveCount;
    }

    private static boolean linearSearch(int[] nums, int x) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == x) {
                return true;
            }
        }
        return false;
    }
}