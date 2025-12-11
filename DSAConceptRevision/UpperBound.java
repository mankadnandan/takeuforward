public class UpperBound {

    public static void main(String[] args) {
        System.out.println(upperBound(new int[] { 1, 2, 2, 3 }, 2));
        System.out.println(upperBound(new int[] { 3, 5, 8, 15, 19 }, 9));
        System.out.println(upperBound(new int[] { 3, 5, 8, 15, 19 }, 3));
    }

    public static int upperBound(int[] nums, int x) {
        int start = 0;
        int end = nums.length - 1;
        int ansIdx = nums.length;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= x) {
                start = mid + 1;
            } else {
                ansIdx = mid;
                end = mid - 1;
            }
        }
        return ansIdx;
    }
}
