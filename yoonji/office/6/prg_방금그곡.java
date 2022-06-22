/*
- 이해
 playTime이 melody 길이보다 짧은 경우 네오가 기억한 곡이 아닐수도있고
 playTime이 melody길이보다 길면 반복재생해서 비교해봐야한다.
 음악 제목 title, 재생시간 playTime, 악보 melody
- 구현 순서
 1. 문자열에서 정보 빼내기
 C# => H, D# => I, F# => J, G# => K, A# => L
 2. melody와 m : 변환 메서드 호출
 3.
 m의 길이 > melody.length() => 맞는지 알수없으니까 틀린 것으로 간주하고 continue
 playTime : melody.length()보다 길면, 이어 붙인다.
 + 작으면 잘라내는 것을 해야 TC 30번 통과함..
 4. 조건일치하면? playTime이 max인것. playTime이 같은 경우, 나중에 입력된 것이므로 무시.
 일치하는 조건 없으면 (None) 출력
- input
 m,악보길이 <=1439
 musicinfos 갯수 <=100
 */
public class prg_방금그곡 {
    public String solution(String m, String[] musicinfos) {
        int maxPlayTime = 0;
        String answer = "(None)";
        for(String music: musicinfos) {
            // 1.
            String[] musicInfo = music.split(",");
            int startT = strTimeToIntTime(musicInfo[0]);
            int endT = strTimeToIntTime(musicInfo[1]);
            int playTime = endT - startT;

            String title = musicInfo[2];

            // 2.
            String melody = convertMelody(musicInfo[3]);
            int melodyL = melody.length();
            String neoMelody = convertMelody(m);
            // 3.
            if (neoMelody.length() > playTime) continue;    // 재생시간이 네오m보다 짧으면 알수없다.

            if (playTime > melodyL) {
                melody = createTotalMelody(playTime, melody, melodyL);
            } else if (playTime < melodyL) {
                melody = melody.substring(0,playTime);
            }
            // 4.
            if (melody.contains(neoMelody)) {
                if (maxPlayTime < playTime) {
                    maxPlayTime = playTime;
                    answer = title;
                }
            }
        }
        return answer;
    }

    // 28분 melody 3개, 3*9
    // 8분 melody 3개, 3*2
    // 5분 abcdef 6개.
    // 30분. 3개. 10번
    private String createTotalMelody(int playT, String melody, int melodyL) {
        StringBuilder totalMelody = new StringBuilder();
        for (int i=0; i < playT / melodyL; i++){
            totalMelody.append(melody.substring(0, melodyL));
        }
        totalMelody.append(melody.substring(0, playT % melodyL));
        return totalMelody.toString();
    }
    private String convertMelody(String melody) {
        // C# => H, D# => I, F# => J, G# => K, A# => L
        melody = melody.replaceAll("C#", "H");
        melody = melody.replaceAll("D#", "I");
        melody = melody.replaceAll("F#", "J");
        melody = melody.replaceAll("G#", "K");
        melody = melody.replaceAll("A#", "L");
        return melody;
    }
    private int strToInt(String str) {return Integer.parseInt(str);}
    private int strTimeToIntTime(String strTime) {
        return strToInt(strTime.split(":")[0])*60 + strToInt(strTime.split(":")[1]);
    }
}