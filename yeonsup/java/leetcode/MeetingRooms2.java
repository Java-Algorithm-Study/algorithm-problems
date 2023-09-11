package yeonsup.java.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MeetingRooms2 {

    public int minMeetingRooms(int[][] intervals) {
        int cnt = 1;
        int last = 0;
        List<Integer> list = new ArrayList();

        Arrays.sort(intervals, Comparator.comparing((int[] v) -> v[0]));

        for (int[] interval : intervals) {
            System.out.println(Arrays.toString(interval));
            for (int i = 0; i < list.size(); i++) {
                if(list.get(i) <= interval[0]) {
                    list.remove(i);
                }
            }
            list.add(interval[1]);
            cnt = Math.max(cnt, list.size());

        }

        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(new MeetingRooms2().minMeetingRooms(new int[][]{
                {0,30},{5,10},{15,20}
        }));

        System.out.println(new MeetingRooms2().minMeetingRooms(new int[][]{
                {0,30},{5,10},{9, 16},{15,20}
        }));

        System.out.println(new MeetingRooms2().minMeetingRooms(new int[][]{
                {0,30},{5,10},{9, 16},{15,20},{21, 30}, {3, 45}
        }));


        System.out.println(new MeetingRooms2().minMeetingRooms(new int[][]{
                {7,10},{2,4}
        }));

        System.out.println(new MeetingRooms2().minMeetingRooms(new int[][]{
                {7,10}
        }));


//
//        System.out.println(new MeetingRooms2().canAttendMeetings(new int[][]{
//        }));


    }
}
