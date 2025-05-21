/*
 * https://takeuforward.org/plus/dsa-concept-revision/day-1/longest-consecutive-sequence-in-an-array
 * 
 * i/p:
 * 4
 * 6
 * 100 4 200 1 3 2
 * 10
 * 0 3 7 2 5 8 4 6 0 1
 * 7
 * 1 9 3 10 4 20 2
 * 28
 * 17 12 -8 -11 14 -19 9 -4 -11 -12 -8 5 15 14 9 -19 12 5 0 18 13 -1 3 19 16 -13 -11 9
 * 
 * o/p:
 * 1 1 2 2 3 4 4 5 6 6 7 7 8 9 
 * 
 */
import java.util.Arrays;
import java.util.Scanner;

public class LongestConsecutiveSequenceInAnArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numOfTestCases = in.nextInt();
        for (int i = 0; i < numOfTestCases; i++) {
            int numofEle = in.nextInt();
            int[] nums = new int[numofEle];
            for (int j = 0; j < numofEle; j++) {
                nums[j] = in.nextInt();
            }
            int res = longestConsecutive(nums);
            System.out.println(res);
        }        
    }

    public static int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int currConsCount = 1;
        int maxConsCount = 1;
        int prevNum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (prevNum == nums[i]) {
                continue;
            } else if (prevNum + 1 == nums[i]) {
                currConsCount++;
            } else {
                currConsCount = 1;
            }
            prevNum = nums[i];
            maxConsCount = Math.max(maxConsCount, currConsCount);
        }
        return maxConsCount;
    }

}
