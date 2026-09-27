import java.util.Arrays;

public class RearrangeArrayElementsBySign {

    public static void main(String[] args) {
        int[] nums = new int[] { 2, 4, 5, -1, -3, -4 };
        int[] res = rearrangeArray(nums);
        System.out.println(Arrays.toString(res));

        nums = new int[] { 1, -1, -3, -4, 2, 3 };
        res = rearrangeArray(nums);
        System.out.println(Arrays.toString(res));

        nums = new int[] { -4, 4, -4, 4, -4, 4 };
        res = rearrangeArray(nums);
        System.out.println(Arrays.toString(res));
    }

    public static int[] rearrangeArray(int[] nums) {

        int result[] = new int[nums.length];
        int oddPtr = 1;
        int evenPtr = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                result[evenPtr] = nums[i];
                evenPtr += 2;
            } else {
                result[oddPtr] = nums[i];
                oddPtr += 2;
            }
        }

        return result;
    }
}