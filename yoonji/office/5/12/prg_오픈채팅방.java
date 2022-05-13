import java.util.*;
// 클래스로 안하고. 자료구조사용.
public class prg_오픈채팅방 {
    public String[] solution(String[] record) {
        String[] answer;
        Map<String, String> nicknames = new HashMap<>();
        List<String> inOut = new ArrayList<>();
        List<String> users = new ArrayList<>();
        // 1. 반복문을 돌며 user 정보 save 및 update, inOut 기록
        for (int i=0; i< record.length; i++) {
            String[] unitRecord = record[i].split(" ");
            String status = unitRecord[0];
            String userId = unitRecord[1];
            switch(status) {
                case "Enter":
                    nicknames.put(userId, unitRecord[2]);
                    users.add(userId);
                    inOut.add(status);
                    break;
                case "Leave" :
                    users.add(userId);
                    inOut.add(status);
                    break;
                case "Change" :
                    nicknames.put(userId, unitRecord[2]);
            }
        }
        answer= new String[users.size()];
        // 3. answer에 userId-닉네임 매칭해서 add
        for (int i=0; i<users.size(); i++) {
            if ("Enter".equals(inOut.get(i))) {
                answer[i] = nicknames.get(users.get(i)) + "님이 들어왔습니다.";
            } else if ("Leave".equals(inOut.get(i))) {
                answer[i] = nicknames.get(users.get(i)) + "님이 나갔습니다.";
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        prg_오픈채팅방 t = new prg_오픈채팅방();
        String[] solution = t.solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"});
        System.out.println(solution[0]);
    }
}
