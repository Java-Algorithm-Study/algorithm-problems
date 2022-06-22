/**
 * [17683] 방금 그 곡
 * https://programmers.co.kr/learn/courses/30/lessons/17683
 *
 * -아이디어
 * 1. #이 붙은 멜로디는 새로운 다른 문자로 치환한다.
 * 2. 시간은 분 단위로 환산한다.
 * 3. 재생 시간이 네오가 들은 음의 길이보다 짧다면 그 곡은 배제해야 되니까 넘긴다.
 * 4. 재생 시간만큼 sb에 라디오에서 나온 음을 붙인다.
 * 5. contains로 sb에 네오가 들은 음의 길이가 포함돼 있는지 확인한다.
 * 6. 맞다면 일단 제목과 재생 시간을 저장한다.
 * 9. 또 찾다가 일치하는 음악이 존재한다면 분 단위를 비교해서 갱신한다.
 * 10. 분단위도 같으면 먼저 나온 것으로 둔다.
 *
 */

public class Pro17683 {
    public static void main(String[] args) {
        String m = "CCB";
        String[] musicinfos = {"03:00,03:10,FOO,CCG#CCB", "04:00,04:08,BAR,ABC"};
        System.out.println(solution(m, musicinfos));
    }

    public static String solution(String m, String[] musicinfos) {
        int maxPlayTime = 0;
        String maxTitle = "";
        StringBuilder sb;

        for (String music : musicinfos) {
            sb = new StringBuilder();

            String[] info = music.split(",");

            String[] startTime = info[0].split(":");
            String[] endTime = info[1].split(":");

            String musicTitle = info[2];
            String melody = convert(info[3]);
            m = convert(m);

            int startMinute = Integer.parseInt(startTime[0]) * 60 + Integer.parseInt(startTime[1]);
            int endMinute = Integer.parseInt(endTime[0]) * 60 + Integer.parseInt(endTime[1]);

            int playTime = endMinute - startMinute;


            if (playTime < m.length()) {
                continue;
            }

            for (int i = 0; i < playTime; i++) {
                sb.append(melody.charAt(i % melody.length()));
            }

            if (sb.toString().contains(m)) {
                if (maxPlayTime < playTime) {
                    maxPlayTime = playTime;
                    maxTitle = musicTitle;
                }
            }
        }
        if (maxPlayTime == 0) {
            maxTitle = "(None)";
        }

        return maxTitle;
    }

    public static String convert(String melody) {
        // C# -> H, D# -> I, F# -> J, G# -> K, A# -> L
        melody = melody.replaceAll("C#", "H");
        melody = melody.replaceAll("D#", "I");
        melody = melody.replaceAll("F#", "J");
        melody = melody.replaceAll("G#", "K");
        melody = melody.replaceAll("A#", "L");
        melody = melody.replaceAll("E#", "M");

        return melody;
    }
}
