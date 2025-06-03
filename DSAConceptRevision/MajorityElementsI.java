/*
 * https://takeuforward.org/plus/dsa-concept-revision/day-3/majority-element-i
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MajorityElementsI {

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[] { 7, 0, 0, 1, 7, 7, 2, 7, 7 }));
        System.out.println(majorityElement(new int[] { 1, 1, 1, 2, 1, 2 }));
        System.out.println(majorityElement(new int[] { -1, -1, -1, -1 }));
    }

    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], hashMap.getOrDefault(nums[i], 0) + 1);
        }
        int maxCount = 0;
        int maxCountKey = 0;
        for (Entry<Integer, Integer> entry : hashMap.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();

            if (maxCount < value) {
                maxCount = value;
                maxCountKey = key;
            }
        }
        return maxCountKey;
    }
}