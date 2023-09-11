package yeonsup.java.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms {

    public boolean canAttendMeetings(int[][] intervals) {
        int last = 0;

        //1. 끝나는 시간 기준으로 정렬
        Arrays.sort(intervals, Comparator.comparing((int[] v) -> v[1]));

        //2. 시작 시간과 끝시간 비교
        for (int[] interval : intervals) {
            System.out.println(Arrays.toString(interval));
            if(last >= interval[0]) return false;
            last = interval[1];
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new MeetingRooms().canAttendMeetings(new int[][]{
                {0,30},{5,10},{15,20}
        }));

        System.out.println(new MeetingRooms().canAttendMeetings(new int[][]{
                {7,10},{2,4}
        }));

        System.out.println(new MeetingRooms().canAttendMeetings(new int[][]{
        }));


    }
}
