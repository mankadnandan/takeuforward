/*
 * https://takeuforward.org/plus/dsa/binary-search/logic-building/floor-and-ceil-in-sorted-array
 */

import java.util.Arrays;

public class FloorAndCeilInSortedArray {

    public static void main(String[] args) {
        int[] ans = getFloorAndCeil(new int[] { 3, 4, 4, 7, 8, 10 }, 5);
        System.out.println(Arrays.toString(ans));

        ans = getFloorAndCeil(new int[] { 3, 4, 4, 7, 8, 10 }, 8);
        System.out.println(Arrays.toString(ans));

        ans = getFloorAndCeil(new int[] { 2, 4, 6, 8, 10, 12, 14 }, 1);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] getFloorAndCeil(int[] nums, int x) {
        int left = 0;
        int right = nums.length - 1;
        int floor = -1;
        int ceil = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == x) {
                floor = nums[mid];
                ceil = nums[mid];
                return new int[] { floor, ceil };
            } else if (nums[mid] > x) {
                ceil = nums[mid];
                right = mid - 1;
            } else {
                floor = nums[mid];
                left = mid + 1;
            }
        }
        return new int[] { floor, ceil };
    }
}