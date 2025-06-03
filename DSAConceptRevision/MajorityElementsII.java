import java.util.ArrayList;
import java.util.List;

public class MajorityElementsII {
    public static void main(String[] args) {
        System.out.println(majorityElementTwo(new int[] { 1, 2, 1, 1, 3, 2 }));
        System.out.println(majorityElementTwo(new int[] { 1, 2, 1, 1, 3, 2, 2 }));
        System.out.println(majorityElementTwo(new int[] { 1, 2, 1, 1, 3, 2, 2, 3 }));
    }

    public static List<Integer> majorityElementTwo(int[] nums) {
        int count1 = 0;
        int element1 = 0;
        int count2 = 0;
        int element2 = 0;
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (count1 == 0 && nums[i] != element2) {
                count1 = 1;
                element1 = nums[i];
            } else if (count2 == 0 && nums[i] != element1) {
                count2 = 1;
                element2 = nums[i];
            } else if (nums[i] == element1) {
                count1++;
            } else if (nums[i] == element2) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        int min = nums.length / 3 + 1;
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == element1) {
                count1++;
            } else if (nums[i] == element2) {
                count2++;
            }
        }
        if (count1 >= min) {
            result.add(element1);
        }
        if (count2 >= min) {
            result.add(element2);
        }
        return result;
    }
}