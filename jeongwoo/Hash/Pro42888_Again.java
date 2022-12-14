import java.util.*;

/**
 * [42888] 오픈채팅방
 * https://programmers.co.kr/learn/courses/30/lessons/42888
 *
 * -아이디어
 * 1. record를 돌면서 Leave가 아닐 때 uid와 닉네임을 해쉬 맵에 저장한다. -> 닉네임이 변경될 수 있으니까 uid를 key로 설정
 * 2. 닉네임을 다 저장했다면 record를 다시 돌면서 입장, 퇴장 문구를 출력한다.
 *
 * -시간 복잡도
 * 1. O(n) = 100,000
 *
 * -자료 구조
 * 1. HashMap : uid, 닉네임 저장
 * 2. ArrayList : result 저장
 */

public class Pro42888_Again {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[] {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"})));
    }

    public static String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        List<String> list = new ArrayList<>();

        for (int i = 0; i < record.length; i++) {
            String[] str = record[i].split(" ");

            if (!str[0].equals("Leave")) {
                map.put(str[1], str[2]);
            }
        }

        for (int i = 0; i < record.length; i++) {
            String[] str = record[i].split(" ");
            
            if (str[0].equals("Enter")) {
                String temp = map.get(str[1]) + "님이 들어왔습니다.";
                list.add(temp);
            }

            else if (str[0].equals("Leave")) {
                String temp = map.get(str[1]) + "님이 나갔습니다.";
                list.add(temp);
            }
        }

        return list.stream().toArray(String[]::new);
    }
}
