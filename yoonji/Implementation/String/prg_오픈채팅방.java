package Implementation.String;
import java.util.*;
// String 리스트 => String 배열; {list명}.toArray(new String[{list명}.size()])
// 2차원리스트; List<String[]> = new ArrayList<>();
public class prg_오픈채팅방 {
    public String[] solution(String[] record) {
        List<String> answer = new ArrayList<>();
        List<String[]> log = new ArrayList<>();
        Map<String, String> nicknameInfo = new HashMap<>();
        for (String r : record) {
            String[] tmp = r.split(" ");
            // 기록
            if (tmp[0].startsWith("E")) {
                log.add(new String[]{tmp[1], "님이 들어왔습니다."});
                nicknameInfo.put(tmp[1], tmp[2]);
            } else if (tmp[0].startsWith("L")) {
                log.add(new String[]{tmp[1], "님이 나갔습니다."});
            } else if (tmp[0].startsWith("C")) {
                nicknameInfo.put(tmp[1], tmp[2]);
            }
        }
        for (String[] l : log) {
            answer.add(nicknameInfo.get(l[0])+l[1]);
        }
        return answer.toArray(new String[answer.size()]);
    }
}