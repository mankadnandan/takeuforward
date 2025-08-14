import java.util.Arrays;

class MeetingRooms {
    public static void main(String[] args) {
        System.out.println(canAttendMeetings(new int[][] { { 1, 5 }, { 3, 8 }, { 6, 10 }, { 12, 15 } }));
        System.out.println(canAttendMeetings(new int[][] { { 2, 6 }, { 7, 9 }, { 10, 14 }, { 15, 18 } }));
        System.out.println(canAttendMeetings(new int[][] { { 0, 4 }, { 4, 9 }, { 10, 13 }, { 14, 17 } }));
    }

    public static boolean canAttendMeetings(int[][] intervals) {
        // Your code goes here
        Arrays.sort(intervals, (int[] intv1, int[] intv2) -> {
            return Integer.compare(intv1[0], intv2[0]);
        });

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) {
                return false;
            }
        }
        return true;
    }
}