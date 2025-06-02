import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum_2 {
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
        Arrays.sort(nums);
        List<List<Integer>> quadResultList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int k = j + 1;
                int l = nums.length - 1;
                while (k < l) {
                    int currSum = nums[i] + nums[j] + nums[k] + nums[l];
                    if (currSum == target) {
                        List<Integer> quadruplet = new ArrayList<>();
                        quadruplet.add(nums[i]);
                        quadruplet.add(nums[j]);
                        quadruplet.add(nums[k]);
                        quadruplet.add(nums[l]);
                        quadResultList.add(quadruplet);
                        k++;
                        while (k < l && nums[k] == nums[k - 1]) {
                            k++;
                        }
                    } else if (currSum > target) {
                        l--;
                        while (k < l && nums[l] == nums[l + 1]) {
                            l--;
                        }
                    } else {
                        k++;
                        while (k < l && nums[k] == nums[k - 1]) {
                            k++;
                        }
                    }
                }
            }
        }
        return quadResultList;
    }
}
