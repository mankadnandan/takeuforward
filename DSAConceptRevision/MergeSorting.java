/*
 * https://takeuforward.org/plus/dsa-concept-revision/day-1/merge-sorting
 * 
 * i/p:
 * 14
 * 6 4 2 7 8 1 3 6 9 7 4 1 2 5
 * 
 * o/p:
 * 1 1 2 2 3 4 4 5 6 6 7 7 8 9 
 */
import java.util.Scanner;

public class MergeSorting {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numofEle = in.nextInt();
        int[] nums = new int[numofEle];
        for (int i = 0; i < numofEle; i++) {
            nums[i] = in.nextInt();
        }
        int[] res = mergeSort(nums);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
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
        int[] tmpArr = new int[right - left + 1];
        int[] leftArr = new int[mid - left + 1];
        int[] rightArr = new int[right - mid];
        int leftStart = left;
        int rightStart = mid + 1;

        for (int i = 0; i < leftArr.length; i++) {
            leftArr[i] = nums[leftStart++];
        }

        for (int i = 0; i < rightArr.length; i++) {
            rightArr[i] = nums[rightStart++];
        }

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] <= rightArr[j]) {
                tmpArr[k] = leftArr[i];
                k++;
                i++;
            } else {
                tmpArr[k] = rightArr[j];
                k++;
                j++;
            }
        }

        while (i < leftArr.length) {
            tmpArr[k] = leftArr[i];
            k++;
            i++;
        }

        while (j < rightArr.length) {
            tmpArr[k] = rightArr[j];
            k++;
            j++;
        }

        for (int k2 = 0; k2 < tmpArr.length; k2++) {
            nums[left] = tmpArr[k2];
            left++;
        }
    }
}