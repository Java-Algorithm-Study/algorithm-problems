/**
 * [17683] 방금 그 곡
 * https://programmers.co.kr/learn/courses/30/lessons/17683
 *
 * -아이디어
 * 1. 악보에 사용되는 음 C# 등 #이 붙은 건 G 등 다른 문자로 변환한다.
 * 2. 시간을 분 단위로 다 변환한다.
 * 3. 1분에 음 1개씩 재생되니까 네오가 기억한 멜로디(m)의 길이 > 재생 시간 -> 네오가 들은 음악이 아니니까 패스.
 * 4. 일치하는 음악이 여러 개라면 제목으로 비교하니까 제목을 저장한다.
 * 5. 재생 시간이 같으면 먼저 입력된 음악 제목을 반환해야 한다.
 *
 * -시간 복잡도
 * 1. O(n * 1440) 이하 -> 시간이 00:00 넘어가는 일 없다고 나와 있으니까 musicInfos.length * musicInfos[i]의 재생 시간
 *
 * -자료 구조
 * 1. String[] str = musicInfos split
 */

public class Pro17683_Again {
    public static void main(String[] args) {
        System.out.println(solution("ABCDEFG", new String[]{"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
    }

    public static String solution(String m, String[] musicinfos) {
        String answer = "";
        int time = 0;
        m = convertMusic(m);

        for (int i = 0; i < musicinfos.length; i++) {
            String[] info = musicinfos[i].split(",");
            String[] start = info[0].split(":");
            String[] end = info[1].split(":");
            String name = info[2];
            String music = convertMusic(info[3]);

            int startTime = Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]);
            int endTime = Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1]);
            int totalTime = endTime - startTime;

            // 멜로디 길이가 재생 시간보다 더 길면 맞는 노래가 아니니까 pass
            if (m.length() > totalTime) {
                continue;
            }

            StringBuilder temp = new StringBuilder();

            for (int j = 0; j < totalTime; j++) {
                temp.append(music.charAt(j % music.length()));
            }


            if (String.valueOf(temp).contains(m)) {
                // 재생 시간이 제일 긴 음악, 재생 시간도 같을 경우 먼저 입력된 음악
                if (time < totalTime) {
                    answer = name;
                    time = totalTime;
                }
            }
        }

        if (time == 0) {
            return "(None)";
        }

        return answer;
    }

    public static String convertMusic(String music) {
        music = music.replaceAll("C#", "H");
        music = music.replaceAll("D#", "I");
        music = music.replaceAll("F#", "J");
        music = music.replaceAll("G#", "K");
        music = music.replaceAll("A#", "L");
        music = music.replaceAll("E#", "M");

        return music;
    }
}
