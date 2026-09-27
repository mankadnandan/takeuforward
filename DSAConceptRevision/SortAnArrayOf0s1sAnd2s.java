import java.util.Arrays;

/*
 * This soltution uses counting sort, where we count number of 0s, 1s, and 2s and then put them in the right place.
 * This takes two iteration of the array.
 * For a single iteration, and hence the optimal solution, see Dutch National Flag Algorithm based solution.
 */

public class SortAnArrayOf0s1sAnd2s {
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

    }

    public static void sortZeroOneTwo(int[] nums) {
        int numOf0s = 0;
        int numOf1s = 0;
        int numOf2s = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                numOf0s++;
            } else if (nums[i] == 1) {
                numOf1s++;
            } else if (nums[i] == 2) {
                numOf2s++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (i < numOf0s) {
                nums[i] = 0;
            } else if (i < numOf0s + numOf1s) {
                nums[i] = 1;
            } else if (i < numOf0s + numOf1s + numOf2s) {
                nums[i] = 2;
            }
        }
    }
}