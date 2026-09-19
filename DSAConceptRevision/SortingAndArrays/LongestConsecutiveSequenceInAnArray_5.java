package SortingAndArrays;

import java.util.Set;
import java.util.HashSet;

public class LongestConsecutiveSequenceInAnArray_5 {

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[] { 100, 4, 200, 1, 3, 2 }));
        System.out.println(longestConsecutive(new int[] { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 }));
        System.out.println(longestConsecutive(new int[] { 1, 9, 3, 10, 4, 20, 2 }));
    }

    public static int longestConsecutive(int[] nums) {
        Set<Integer> IntToConsecutiveCountSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            IntToConsecutiveCountSet.add(nums[i]);
        }
        int currConsecutiveCount = 1;
        int maxConsecutiveCount = 1;
        for (int i = 0; i < nums.length; i++) {
            if (!IntToConsecutiveCountSet.contains(nums[i] - 1)) {
                int currElement = nums[i];
                while (IntToConsecutiveCountSet.contains(currElement + 1)) {
                    currConsecutiveCount++;
                    currElement++;
                }
                maxConsecutiveCount = Math.max(maxConsecutiveCount, currConsecutiveCount);
                currConsecutiveCount = 1;
            }
        }
        return maxConsecutiveCount;
    }
}
