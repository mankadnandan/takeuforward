import java.util.Arrays;

/*
 * This soltution uses counting sort, where we count number of 0s, 1s, and 2s and then put them in the right place.
 * This takes two iteration of the array.
 * For a single iteration, and hence the optimal solution, see Dutch National Flag Algorithm based solution.
 */

public class SortAnArrayOf0s1sAnd2s_2 {

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 0, 2, 1, 0 };
        sortZeroOneTwo(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[] { 0, 0, 1, 1, 1 };
        sortZeroOneTwo(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[] { 1, 1, 2, 2, 1 };
        sortZeroOneTwo(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[] { 0, 1 };
        sortZeroOneTwo(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[] { 2, 0, 1 };
        sortZeroOneTwo(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sortZeroOneTwo(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else if (nums[mid] == 2) {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
