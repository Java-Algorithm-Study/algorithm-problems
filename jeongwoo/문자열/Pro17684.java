import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * [17684] 압축
 * https://programmers.co.kr/learn/courses/30/lessons/17684
 *
 * -아이디어
 * 1. 현재 입력이 사전에 있는지 확인한다.
 * 2-1. 사전에 있다면 현재 입력 + 다음 글자가 사전에 있는지 확인한다.
 * 2-2. 사전에 없다면 1. 현재 입력 인덱스를 ans에 넣고, 2. 현재 입력 + 다음 글자를 사전에 넣는다.
 * 3. 2-1에서 사전에 없다면 2-2로 가고, 있다면 2-1을 다시 실행해서 2-2의 조건이 될 때까지 계속 돌린다.
 *
 */

public class Pro17684 {
    public static void main(String[] args) {
        String input = "TOBEORNOTTOBEORTOBEORNOT";
        solution(input);
    }

    public static int[] solution(String msg) {
        ArrayList<Integer> ans = new ArrayList<>();

        Map<String, Integer> dictionary = new HashMap<>();

        for (int i = 1; i < 27; i++) {
            String alphabet = String.valueOf((char) (i + 64));
            dictionary.put(alphabet, i);
        }

        int num = 27;
        String[] alphabets = new String[msg.length()];

        for (int i = 0; i < msg.length(); i++) {
            alphabets[i] = String.valueOf(msg.charAt(i));
        }

        for (int i = 0; i < msg.length(); i++) {
            // 현재 입력이 사전에 있는지 확인한다.
            String now = alphabets[i];
            String prevLetter = now;

            int temp = i + 1;
            while (temp < msg.length() && dictionary.containsKey(now)) {
                prevLetter = now;
                now += alphabets[temp];
                temp++;
            }

            if (!dictionary.containsKey(now)) {
                dictionary.put(now, num++);

                // 사전에 없게 되면 현재 입력에 대한 인덱스 번호(Value)를 ans에 넣는다.
                if (prevLetter.length() > 1) {
                    int len = prevLetter.length() - 1;
                    i += len;
                }
                int key = dictionary.get(prevLetter);
                ans.add(key);
            }
            else {
                if (now.length() > 1) {
                    int len = now.length() - 1;
                    i += len;
                }
                int key = dictionary.get(now);
                ans.add(key);
            }
        }

        int[] answer = new int[ans.size()];
        for (int i = 0; i < answer.length; i++ ) {
            answer[i] = ans.get(i);
        }
        return answer;
    }
}
