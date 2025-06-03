/*
 * https://takeuforward.org/plus/dsa-concept-revision/day-3/majority-element-i
 */
public class MajorityElementsI_3 {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[] { 7, 0, 0, 1, 7, 7, 2, 7, 7 }));
        System.out.println(majorityElement(new int[] { 1, 1, 1, 2, 1, 2 }));
        System.out.println(majorityElement(new int[] { -1, -1, -1, -1 }));
    }

    public static int majorityElement(int[] nums) {
        int currCount = 0;
        int currElement = 0;

        for (int i = 0; i < nums.length; i++) {
            if (currCount == 0) {
                currElement = nums[i];
                currCount++;
            } else if (nums[i] == currElement) {
                currCount++;
            } else{
                currCount--;
            }
        }

        return currElement;
    }
}