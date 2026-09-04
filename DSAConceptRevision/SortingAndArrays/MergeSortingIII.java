package SortingAndArrays;

import java.util.Arrays;

public class MergeSortingIII {
    public static void main(String[] args) {
        int[] arr = mergeSort(new int[] { 7, 4, 1, 5, 3 });
        System.out.println(Arrays.toString(arr));
        arr = mergeSort(new int[] { 5, 4, 4, 1, 1 });
        System.out.println(Arrays.toString(arr));
        arr = mergeSort(new int[] { 3, 2, 3, 4, 5 });
        System.out.println(Arrays.toString(arr));
    }

    private static int[] mergeSort(int[] arr) {
        mergeSortHelper(arr, 0, arr.length - 1);
        return arr;
    }

    private static void mergeSortHelper(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSortHelper(arr, left, mid);
            mergeSortHelper(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int leftSize = mid - left + 1;
        int rightSize = right - mid;
        int lStart = left;
        int rStart = mid + 1;
        int leftArr[] = new int[leftSize];
        int rightArr[] = new int[rightSize];

        for (int i = 0; i < leftArr.length; i++) {
            leftArr[i] = arr[lStart];
            lStart++;
        }

        for (int i = 0; i < rightArr.length; i++) {
            rightArr[i] = arr[rStart];
            rStart++;
        }

        int i = 0;
        int j = 0;
        int k = left;
        while (i < leftSize && j < rightSize) {
            if (leftArr[i] < rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }
        while (i < leftSize) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }
        while (j < rightSize) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }
}
