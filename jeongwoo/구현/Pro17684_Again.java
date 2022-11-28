import java.util.*;

/**
 * [17684] 압축
 * https://programmers.co.kr/learn/courses/30/lessons/17684
 *
 * -아이디어
 * 1. A ~ Z를 map에 key는 단어, value는 순서로 넣는다.
 * 2. msg 한 글자씩 map에 있는지 확인한다.
 * 3. 해당 글자가 맵에 있으면 다음 글자도 더해서 맵에 있는지 확인한다.
 * 4. 맵에 없을 때까지 다음 글자를 가지고 온다.
 * 5. 더한 글자들이 맵에 없다면 맵에 추가하고, 추가하기 이전 글자는 value를 찾는다.
 *
 * -시간 복잡도
 * 1. O(n^2) <= 1000 * 1000
 *
 * -자료 구조
 * 1. ArrayList : 순서 담을 배열
 * 2. Map : 단어 사전 (단어, 순서)
 *
 */

public class Pro17684_Again {
    public static void main(String[] args) {
        System.out.println(solution("TOBEORNOTTOBEORTOBEORNOT"));
    }

    public static int[] solution(String msg) {
        List<Integer> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for (int i = 1; i <= 26; i++) {
            map.put(String.valueOf((char) (i + 64)), i);
        }

        int mapIdx = 27;
        int i = 0;
        while (i < msg.length()) {
            String now = String.valueOf(msg.charAt(i));

            // 맵에 없는 단어가 나올 때까지 찾는다
            int idx = i + 1;
            String prev = "";
            while (idx < msg.length() && map.containsKey(now)) {
                prev = now;
                now += String.valueOf(msg.charAt(idx++));
            }

            // 다음 글자를 더한 문자열이 맵에 없으니까 추가한다.
            if (!map.containsKey(now)) {
                map.put(now, mapIdx++);
                i = idx - 1;
                list.add(map.get(prev));
            }
            // 마지막 글자 처리
            else {
                list.add(map.get(now));
                break;
            }
        }

        int[] answer = new int[list.size()];
        for (int j = 0; j < answer.length; j++) {
            answer[j] = list.get(j);
        }
        return answer;
    }
}
