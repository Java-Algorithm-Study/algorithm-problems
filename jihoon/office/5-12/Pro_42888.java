import java.util.*;

public class Pro_42888 {
    
    public static String[] solution(String[] record) {
        String[] ans;
        Map<String, String> map = new HashMap<>();
        List<String> inOut = new ArrayList<>();
        List<String> users = new ArrayList<>();
        
        for (int i = 0; i < record.length; i++) {
            String[] order = record[i].split(" ");
            String status = order[0];
            String uId = order[1];
            switch (status) {
                case "Enter":
                    inOut.add(status);
                    users.add(uId);
                    map.put(uId, order[2]);
                    break;
                case "Leave":
                    inOut.add(status);
                    users.add(uId);
                    break;
                case "Change":
                    map.put(uId, order[2]);
            }
        }
        ans = new String[users.size()];
        for (int i = 0; i < users.size(); i++) {
            if ("Enter".equals(inOut.get(i))) {
                ans[i] = map.get(users.get(i)) + "님이 들어왔습니다.";
            } else if ("Leave".equals(inOut.get(i))) {
                ans[i] = map.get(users.get(i)) + "님이 나갔습니다.";
            }
        }
        System.out.println(Arrays.toString(ans));
        return ans;
    }
    
    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        System.out.println(solution(record));
    }
}
