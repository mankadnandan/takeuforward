/*
 * https://takeuforward.org/plus/dsa-concept-revision/day-2/4-sum
 */import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSum {

    public static void main(String[] args) {
        List<List<Integer>> result = fourSum(new int[] { 1, -2, 3, 5, 7, 9 }, 7);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
        System.out.println();

        result = fourSum(new int[] { 7, -7, 1, 2, 14, 3 }, 9);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
        System.out.println();

        result = fourSum(new int[] { 1, 1, 3, 4, -3 }, 5);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
        System.out.println();
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {

        Set<List<Integer>> quadHashSet = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                HashSet<Integer> hashSet = new HashSet<>();
                for (int k = j + 1; k < nums.length; k++) {
                    int currSum = nums[i] + nums[j] + nums[k];
                    int complement = target - currSum;
                    if (hashSet.contains(complement)) {
                        List<Integer> quadruplet = new ArrayList<>();
                        quadruplet.add(nums[i]);
                        quadruplet.add(nums[j]);
                        quadruplet.add(nums[k]);
                        quadruplet.add(complement);
                        Collections.sort(quadruplet);
                        quadHashSet.add(quadruplet);
                    } else {
                        hashSet.add(nums[k]);
                    }
                }
            }
        }
        return new ArrayList<>(quadHashSet);
    }
}
