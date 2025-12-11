public class SearchInRotatedSortedArrayII {

    public static void main(String[] args) {
        System.out.println(searchInARotatedSortedArrayII(new int[] { 7, 8, 1, 2, 3, 3, 3, 4, 5, 6 }, 3));
        System.out.println(searchInARotatedSortedArrayII(new int[] { 7, 8, 1, 2, 3, 3, 3, 4, 5, 6 }, 10));
        System.out.println(searchInARotatedSortedArrayII(new int[] { 7, 8, 1, 2, 3, 3, 3, 4, 5, 6 }, 7));
        System.out.println(searchInARotatedSortedArrayII(new int[] { 7, 8, 9, 1, 2, 3, 4, 5, 6 }, 9));
        System.out.println(searchInARotatedSortedArrayII(new int[] { 3, 1, 2, 3, 3, 3, 3 }, 1));
    }

    public static boolean searchInARotatedSortedArrayII(int[] nums, int k) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == k) {
                return true;
            }

            // For the case when the array is rotated at the duplicate element
            if (nums[start] == nums[mid] && nums[mid] == nums[end]) {
                start = start + 1;
                end = end - 1;
                continue;
            }

            if (nums[start] <= nums[mid]) {
                if (nums[start] <= k && nums[mid] >= k) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (nums[mid] <= k && nums[end] >= k) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return false;
    }
}
