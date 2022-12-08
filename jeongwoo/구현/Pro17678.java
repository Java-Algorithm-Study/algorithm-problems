import java.util.Arrays;

/**
 * [17687] 셔틀버스
 * https://programmers.co.kr/learn/courses/30/lessons/17687
 *
 * -아이디어
 * 1. timetable 배열을 분 단위로 변경 후 오름차순으로 정렬한다. -> 빨리 온 순서대로 셔틀버스에 탑승하기 때문
 * 2. 모든 단위는 분으로 맞춘다.
 * 3. 셔틀버스 출발 시간 배열을 만든다.
 * 4. timetable 배열 순서대로 m명씩 탑승시키다가 마지막 셔틀버스가 다 찼다면 마지막에 탑승한 사람 -1분을 리턴한다.
 * 5. 마지막 셔틀버스에 자리가 남았다면 마지막 셔틀버스 시간에 맞춰서 줄선다.
 *
 * -시간 복잡도
 * 1. O(timetable length * n) = 2000 * 10
 *
 * -자료 구조
 * 1. int[] : 셔틀버스 시간 배열
 *
 */

public class Pro17678 {
    public static void main(String[] args) {
        System.out.println(solution(2, 1, 2, new String[]{"09:00", "09:00", "09:00", "09:00"}));
    }

    public static String solution(int n, int t, int m, String[] timetable) {
        int[] wait = new int[timetable.length];
        int[] busTime = new int[n];

        for (int i = 0; i < timetable.length; i++) {
            wait[i] = convertTime(timetable[i]);
        }

        Arrays.sort(wait);

        // 첫 차 시간은 항상 9:00으로 고정이어서 540이 시작 시간
        int start = 540;
        busTime[0] = start;
        for (int i = 1; i < n; i++) {
            start += t;
            busTime[i] = start;
        }

        int index = 0;
        for (int i = 0; i < n; i++) {
            int cnt = 0;

            // 버스타임[i] >= wait[i] 이고, cnt > m 이라면 태운다. cnt == m 까지 때울 수 있으니까.
            while (index < wait.length && busTime[i] >= wait[index] && cnt < m) {
                cnt++;
                index++;
            }

            // 마지막 버스라면 콘이 타야 한다.
            if (i == n - 1) {
                // 막차인데 사람이 다 탔다
                if (cnt == m) {
                    int time = wait[index - 1] - 1;
                    int hour = time / 60;
                    int minute =  time % 60;
                    String answer = String.format("%02d", hour) + ":" + String.format("%02d", minute);
                    return answer;
                }
                // 사람이 덜 탔다.
                else if (cnt < m) {
                    int hour = busTime[i] / 60;
                    int minute = busTime[i] % 60;
                    String answer = String.format("%02d", hour) + ":" + String.format("%02d", minute);
                    return answer;
                }
            }
        }

        return "";
    }

    private static int convertTime(String str) {
        String[] arr = str.split(":");
        int time = Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);

        return time;
    }
}
