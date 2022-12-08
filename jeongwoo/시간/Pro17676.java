/**
 * [17676] 추석 트래픽
 * https://programmers.co.kr/learn/courses/30/lessons/17676
 *
 * -아이디어
 * 1. 년월일을 제거하고, 나머지 시간들을 초로 변경한다.
 * 2. 정렬된 상태로 들어오니까 다음 트래픽의 시작 시간(완료 - 처리 + 0.001)을 구해서 시작 시간보다 크다면 같은 초에 진행되니까 cnt++
 * 3. 끝 시간을 기준으로 시작 시간과 1초를 보는 거니까 끝 시간에 1초를 더한 뒤 비교한다.
 * 4. ex) i번 째 끝 시간이 4.002인 경우, i + 1번 째 시작 시간이 5.001라면 4.002 기준으로 1초간 (4.002 ~ 5.002) 사이에 i + 1번 째가 시작한다.
 *
 * -시간 복잡도
 * 1. O(n^2)
 *
 * -자료 구조
 * 1. lines[] : 입력 받은 값을 시간으로 변환 후 다시 저장
 *
 */

public class Pro17676 {
    public static void main(String[] args) {
        System.out.println(solution(new String[] {"2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s"}));
        System.out.println(solution(new String[] {"2016-09-15 01:00:04.002 2.0s", "2016-09-15 01:00:07.000 2s"}));
    }

    public static int solution(String[] lines) {
        int max = Integer.MIN_VALUE;

        // 초 변환
        for (int i = 0; i < lines.length; i++) {
            lines[i] = lines[i].substring(11).replace("s", "");
            String[] str = lines[i].split(":");
            int sec = Integer.parseInt(str[0]) * 3600 + Integer.parseInt(str[1]) * 60;
            String[] str2 = str[2].split(" ");
            double temp = Double.parseDouble(String.valueOf(sec)) + Double.parseDouble(str2[0]);
            lines[i] = temp + " " + str2[1];

        }

        for (int i = 0; i < lines.length; i++) {
            String[] str = lines[i].split(" ");

            // 끝나는 시간을 기준으로 +1초간 같이 진행되는 트래픽이 있는지 찾기 위해 1초를 더한다.
            double end = Double.parseDouble(str[0]) + 1;

            int cnt = 0;
            for (int j = i; j < lines.length; j++) {
                String[] str2 = lines[j].split(" ");
                double start = Double.parseDouble(str2[0]) - Double.parseDouble(str2[1]) + 0.001;

                if (start < end) {
                    cnt++;
                }
            }

            max = Math.max(max, cnt);
        }

        return max;
    }
}
