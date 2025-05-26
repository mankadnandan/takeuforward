/*
 * https://takeuforward.org/plus/dsa-concept-revision/day-1/quick-sorting
 */

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] nums = { 7, 4, 1, 5, 3 };
        quickSort(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[] { 5, 6, 2, 1, 7, 8, 9, 6, 3, 54, 87, 96, 54, 1, 2, 5, 89 };
        quickSort(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[] { 5, 7, 45, 12, 65, 98, 25, 74, 15, 25, 36, 9, 7, 4, 2, 5, 8 };
        quickSort(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[] { 2 };
        quickSort(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[] { 5, 9, 8, 5, 7, 4, 1, 2, 3, 6, 5, 8 };
        quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static int[] quickSort(int[] nums) {
        quickSortHelper(nums, 0, nums.length - 1);
        return nums;
    }

    private static void quickSortHelper(int[] nums, int start, int end) {
        if (start <= end) {
            int i = start;
            int j = end - 1;
            int p = end;

            while (i <= j) {
                if (nums[i] >= nums[p]) {
                    swap(nums, i, j);
                    j--;
                } else {
                    i++;
                }
            }
            swap(nums, i, p);
            quickSortHelper(nums, start, i - 1);
            quickSortHelper(nums, i + 1, end);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}