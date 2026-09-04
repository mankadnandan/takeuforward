package SortingAndArrays;

/*
 * https://takeuforward.org/plus/dsa/problems/merge-sorting
 */

import java.util.Arrays;

public class MergeSortingII {

    public static void main(String[] args) {
        int[] nums = new int[] { 5, 7, 1, 8, 9, 25, 4 };
        System.out.println(Arrays.toString(mergeSort(nums)));
        nums = new int[] { 3, 2, 1 };
        System.out.println(Arrays.toString(mergeSort(nums)));
        nums = new int[] { 1, 1, 1 };
        System.out.println(Arrays.toString(mergeSort(nums)));
        nums = new int[] { 1, 8, 5, 6, 4, 7 };
        System.out.println(Arrays.toString(mergeSort(nums)));
    }

    public static int[] mergeSort(int[] nums) {
        mergeSortHelper(nums, 0, nums.length - 1);
        return nums;
    }

    private static void mergeSortHelper(int[] nums, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSortHelper(nums, left, mid);
            mergeSortHelper(nums, mid + 1, right);
            merge(nums, left, mid, right);
        }
    }

    private static void merge(int[] nums, int left, int mid, int right) {
        int start = left;
        int[] larr = new int[mid - left + 1];
        int[] rarr = new int[right - mid];

        System.arraycopy(nums, left, larr, 0, larr.length);
        System.arraycopy(nums, mid + 1, rarr, 0, rarr.length);

        int i = 0;
        int j = 0;
        while (i < larr.length && j < rarr.length) {
            if (larr[i] <= rarr[j]) {
                nums[start] = larr[i];
                i++;
                start++;
            } else {
                nums[start] = rarr[j];
                j++;
                start++;
            }
        }
        while (j < rarr.length) {
            nums[start] = rarr[j];
            j++;
            start++;
        }
        while (i < larr.length) {
            nums[start] = larr[i];
            i++;
            start++;
        }
    }
}