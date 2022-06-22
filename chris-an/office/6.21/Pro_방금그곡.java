public class Pro_방금그곡 {

    public String convertM (String m) {
        m=m.replaceAll("C#", "c");
        m=m.replaceAll("D#", "d");
        m=m.replaceAll("F#", "f");
        m=m.replaceAll("G#", "g");
        m=m.replaceAll("A#", "a");
        return m;
    }

    public int convertHourToMin (String startTime, String endTime) {
        int sMin = (Integer.parseInt(startTime.split(":")[0]) * 60) + Integer.parseInt(startTime.split(":")[1]);
        int eMin = (Integer.parseInt(endTime.split(":")[0]) * 60) + Integer.parseInt(endTime.split(":")[1]);
        return eMin - sMin;
    }

    public String solution(String m, String[] musicinfos) {
        String resultN = "(None)";
        int resultT = 0;

        for (int i = 0; i < musicinfos.length; i++) {
            StringBuilder sb = new StringBuilder();
            String[] splitInfo = musicinfos[i].split(",");

            int playMusicTime = convertHourToMin(splitInfo[0], splitInfo[1]);
            String musicName = splitInfo[2];
            String music = splitInfo[3];
            int time = playMusicTime;

            music = convertM(music);

            for (int j = 0; j < time; j++) {
                sb.append(music.charAt(j % music.length())); // 하.. 이부분을 이렇게 편하게 할 수 있었는데..
            }

            // for (int j = 0; j < time; j++) {
            //     if(j == (minusTime - 1)) {
            //         sb.append(music.charAt(j));
            //         j -= minusTime;
            //         time -= minusTime;
            //     }else if(music.charAt(j+1) == '#') {
            //         sb.append((char)(music.charAt(j) + 32));
            //         j++;
            //         time++;
            //     }else {
            //         sb.append(music.charAt(j));
            //     }
            // }

            String convertString = sb.toString();
            m = convertM(m);
            if (convertString.contains(m)) { // 미리 문자열을 변환해준 뒤, 찾아야지 편하네..
                if(resultT < playMusicTime) {
                    resultT = playMusicTime;
                    resultN = musicName;
                }
            }
        }
        return resultN;
    }
}
