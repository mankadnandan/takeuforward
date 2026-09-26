import java.util.Arrays;

public class MoveZerosToEnd {
    public static void main(String[] args) {
        int nums[] = new int[] { 0, 1, 4, 0, 5, 2 };
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[] { 0, 0, 0, 1, 3, -2 };
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[] { 0, 20, 0, -20, 0, 20 };
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
        int zeroCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            } else {
                nums[i - zeroCount] = nums[i];
            }
        }

        for (int i = (nums.length - zeroCount); i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}