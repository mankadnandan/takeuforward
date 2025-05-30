import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_2 {
    public static void main(String[] args) {
        List<List<Integer>> result = threeSum(new int[] { 2, -2, 0, 3, -3, 5 });
        for (List<Integer> list : result) {
            System.out.println(list);
        }

        System.out.println();

        result = threeSum(new int[] { 2, -1, -1, 3, -1 });
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            while (j < k) {                
                int currSum = nums[i] + nums[j] + nums[k];
                if (currSum == 0) {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[j]);
                    triplet.add(nums[k]);
                    result.add(triplet);
                    j++;
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                } else if (currSum > 0) {
                    k--;
                    while (k > j && nums[k] == nums[k + 1]) {
                        k--;
                    }
                } else {
                    j++;
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                }
            }
        }
        return result;
    }
}
