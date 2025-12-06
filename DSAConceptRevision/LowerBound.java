public class LowerBound {

    public static void main(String[] args) {

        int[] nums = new int[] { 1, 2, 2, 3 };
        System.out.println(lowerBound(nums, 2));

        nums = new int[] { 3, 5, 8, 15, 19 };
        System.out.println(lowerBound(nums, 9));

        nums = new int[] { 3, 5, 8, 15, 19 };
        System.out.println(lowerBound(nums, 3));
    }

    public static int lowerBound(int[] nums, int x) {
        int start = 0;
        int end = nums.length - 1;
        int ansIdx = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= x) {
                ansIdx = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if (ansIdx == -1) {
            return nums.length;
        } else {
            return ansIdx;
        }
    }
}