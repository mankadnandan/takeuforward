public class LargestElement {
    public static void main(String[] args) {
        System.out.println(largestElement(new int[] { 3, 3, 6, 1 }));
        System.out.println(largestElement(new int[] { 3, 3, 0, 99, -40 }));
        System.out.println(largestElement(new int[] { -4, -3, 0, 1, -8 }));
    }

    public static int largestElement(int[] nums) {
        int largestElement = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            largestElement = Math.max(largestElement, nums[i]);
        }
        return largestElement;
    }
}