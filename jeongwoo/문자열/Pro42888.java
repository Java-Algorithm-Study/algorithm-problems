import java.util.ArrayList;
import java.util.HashMap;

/**
 * [42888] 오픈 채팅방
 * https://programmers.co.kr/learn/courses/30/lessons/42888
 *
 * -아이디어
 * 1. 닉네임 저장을 위해 record 배열을 돌면서 Leave가 아닐 때 HashMap에 uid(key)에 대해서 nickname(value)를 저장한다.
 * 2. 메시지 처리를 위해 Enter, Leave인 경우 uid를 보고 nickname + 입장 or 퇴장 메시지 출력한다.
 *
 */

public class Pro42888 {
    public static void main(String[] args) {
        String[] input = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        System.out.println(solution(input).toString());
    }

    public static String[] solution(String[] record) {
        ArrayList<String> arrayList = new ArrayList<>();
        HashMap<String, String> hashMap = new HashMap<>();

        // 닉네임 저장
        for (int i = 0; i < record.length; i++) {
            String[] input = record[i].split(" ");
            if (!input[0].equals("Leave")) {
                hashMap.put(input[1], input[2]);
            }
        }

        // result 처리
        for (int i = 0; i < record.length; i++) {
            String[] input = record[i].split(" ");

            if (input[0].equals("Enter")) {
                String ans = hashMap.get(input[1]) + "님이 들어왔습니다.";
                arrayList.add(ans);
            }

            if (input[0].equals("Leave")) {
                String ans = hashMap.get(input[1]) + "님이 나갔습니다.";
                arrayList.add(ans);
            }
        }

        String[] answer = new String[arrayList.size()];
        answer = arrayList.toArray(answer);

        return answer;
    }
}
