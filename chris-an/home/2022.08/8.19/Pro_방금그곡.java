public class Pro_방금그곡 {
    public String convertSheetMusic (String m) {
        m = m.replaceAll("C#", "c");
        m = m.replaceAll("D#", "d");
        m = m.replaceAll("F#", "f");
        m = m.replaceAll("G#", "g");
        m = m.replaceAll("A#", "a");
        return m;
    }

    public int convertTime(String time) {
        String[] s = time.split(":");
        return Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
    }

    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int longPeriodOfMusicTime = 0;

        // 하나의 음악 서비스를 뽑아오기.
        for (int i = 0; i < musicinfos.length; i++) {
            // 1. split 작업
            String[] serviceInfo = musicinfos[i].split(",");

            // 2. 시간을 분으로 변경
            // service 이용시간
            int playingTime = convertTime(serviceInfo[1]) - convertTime(serviceInfo[0]);

            // service 이용시간 만큼 loop
            String sheetMusic = convertSheetMusic(serviceInfo[3]);
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < playingTime; j++) {
                sb.append(sheetMusic.charAt((j % sheetMusic.length())));
            }

            m = convertSheetMusic(m);

            if(sb.toString().contains(m)) {
                if(longPeriodOfMusicTime < playingTime) {
                    longPeriodOfMusicTime = playingTime;
                    answer = serviceInfo[2];
                }
            }
        }
        return answer;
    }
}