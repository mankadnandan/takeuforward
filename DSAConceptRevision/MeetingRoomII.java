import java.util.Arrays;

public class MeetingRoomII {

    public static void main(String[] args) {
        int[][] intervals = { { 0, 30 }, { 5, 10 }, { 15, 20 } };
        System.out.println(minMeetingRooms(intervals));

        intervals = new int[][] { { 7, 10 }, { 2, 4 } };
        System.out.println(minMeetingRooms(intervals));

        intervals = new int[][] { { 1, 2 }, { 11, 20 }, { 13, 21 }, { 7, 21 } };
        System.out.println(minMeetingRooms(intervals));
    }

    public static int minMeetingRooms(int[][] intervals) {
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];

        for (int i = 0; i < end.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int count = 0;
        int maxCount = 0;
        int i = 0;
        int j = 0;
        while (i < start.length && j < end.length) {
            if (start[i] < end[j]) {
                count++;
                i++;
                maxCount = Math.max(count, maxCount);
            } else {
                count--;
                j++;
            }
        }
        return maxCount;
    }
}