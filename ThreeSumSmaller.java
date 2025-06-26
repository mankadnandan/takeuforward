/*
 * https://takeuforward.org/plus/dsa/problems/3sum-smaller
 */

import java.util.Arrays;

public class ThreeSumSmaller {
    public static void main(String[] args) {
        System.out.println(threeSumSmaller(new int[] { -2, 0, 1, 3 }, 2));
        System.out.println(threeSumSmaller(new int[] { 0 }, 0));
        System.out.println(threeSumSmaller(new int[] { 1, 2, 3, 4, 5 }, 8));
        System.out.println(threeSumSmaller(new int[] { 7, -55, -55, 48 }, 35));
    }

    public static int threeSumSmaller(int[] nums, int target) {
        int result = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                if (nums[i] + nums[left] + nums[right] < target) {
                    result += right - left;
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}