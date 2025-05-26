/*
 * https://takeuforward.org/plus/dsa-concept-revision/day-2/two-sum
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[] { 1, 6, 2, 10, 3 }, 7)));
        System.out.println(Arrays.toString(twoSum(new int[] { 1, 3, 5, -7, 6, -3 }, 0)));
        System.out.println(Arrays.toString(twoSum(new int[] { -6, 7, 1, -7, 6, 2 }, 3)));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i])) {
                int idx = hashMap.get(target - nums[i]);
                if (i < idx) {
                    res[0] = i;
                    res[1] = idx;
                } else {
                    res[0] = idx;
                    res[1] = i;
                }
                return res;
            } else {
                hashMap.put(nums[i], i);
            }
        }
        return res;
    }
}