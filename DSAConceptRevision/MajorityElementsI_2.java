/*
 * https://takeuforward.org/plus/dsa-concept-revision/day-3/majority-element-i
 */
import java.util.Arrays;

public class MajorityElementsI_2 {
     public static void main(String[] args) {
        System.out.println(majorityElement(new int[] { 7, 0, 0, 1, 7, 7, 2, 7, 7 }));
        System.out.println(majorityElement(new int[] { 1, 1, 1, 2, 1, 2 }));
        System.out.println(majorityElement(new int[] { -1, -1, -1, -1 }));
    }

    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}