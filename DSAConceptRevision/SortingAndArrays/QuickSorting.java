package SortingAndArrays;

import java.util.Arrays;

public class QuickSorting {

    public static void main(String[] args) {
        int[] arr = { 7, 4, 1, 5, 3 };

        quickSort(arr);
        System.out.println(Arrays.toString(arr));

        arr = new int[] { 5, 4, 4, 1, 1 };
        quickSort(arr);
        System.out.println(Arrays.toString(arr));

        arr = new int[] { 3, 2, 3, 4, 5 };
        quickSort(arr);
        System.out.println(Arrays.toString(arr));

        arr = new int[] { -20, 3, -27, 16, 36, 21, 4, 37, -5, 30, 38, 19, -26, 28, -15, 9, -35, -15, -40, 12, -27, 45,
                -29, -50, 46, 30 };
        quickSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static int[] quickSort(int[] nums) {
        quickSortHelper(nums, 0, nums.length - 1);
        return nums;
    }

    private static void quickSortHelper(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        int i = l - 1;
        int pivot = arr[r];
        for (int j = l; j <= r - 1; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, r);
        quickSortHelper(arr, l, i);
        quickSortHelper(arr, i + 2, r);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}