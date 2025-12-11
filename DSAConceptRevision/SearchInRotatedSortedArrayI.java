// Duplicates are not allowed for this problem
public class SearchInRotatedSortedArrayI {
    public static void main(String[] args) {
        System.out.println(search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 0));
        System.out.println(search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 3));
        System.out.println(search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 5));
    }

    public static int search(int[] nums, int k) {
        return binarySearch(nums, 0, nums.length - 1, k);
    }

    private static int binarySearch(int[] nums, int start, int end, int k) {
        if (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == k) {
                return mid;
            }

            if (nums[start] <= nums[mid]) {
                // left is sorted
                if (nums[start] <= k && nums[mid] >= k) {
                    return binarySearch(nums, start, mid - 1, k);
                } else {
                    return binarySearch(nums, mid + 1, end, k);
                }
            } else {
                // right is sorted
                if (nums[mid] <= k && nums[end] >= k) {
                    return binarySearch(nums, mid + 1, end, k);
                } else {
                    return binarySearch(nums, start, mid - 1, k);
                }
            }
        } else {
            return -1;
        }
    }
}