import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {
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

        Set<List<Integer>> result = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            Set<Integer> hashSet = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) {
                int currSum = nums[i] + nums[j];
                if (hashSet.contains(-1 * currSum)) {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[j]);
                    triplet.add(-1 * currSum);
                    Collections.sort(triplet);
                    result.add(triplet);
                } else {
                    hashSet.add(nums[j]);
                }
            }
        }

        return new ArrayList<>(result);
    }
}