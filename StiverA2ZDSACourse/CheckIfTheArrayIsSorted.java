/*
https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/description/
https://takeuforward.org/data-structure/check-if-an-array-is-sorted/
 */

public class CheckIfTheArrayIsSorted {
    public static void main(String[] args) {
        System.out.println(check(new int[]{3, 4, 5, 1, 2}));
        System.out.println(check(new int[]{2, 1, 3, 4}));
        System.out.println(check(new int[]{1, 2, 3}));
        System.out.println(check(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1}));
    }

    public static boolean check(int[] nums) {
        int isDecreasingCount = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                isDecreasingCount++;
                if (isDecreasingCount > 1) {
                    return false;
                }
            }
        }
        // Checking first and
        if (isDecreasingCount > 0) {
            if (nums[0] < nums[nums.length - 1]) {
                return false;
            }
        }
        return true;
    }
}