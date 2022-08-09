import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * [42587] 프린터 
 * https://programmers.co.kr/learn/courses/30/lessons/42587
 *
 * -아이디어
 * 1. Map에 priorities를 인덱스 0부터 A, B, C, ..를 key로 넣고, 우선순위를 value로 넣는다.
 * 2. answerMap에는 우선순위가 제일 높을 경우 그에 해당하는 키값과 순서를 밸류로 넣는다.
 * 3. 큐를 돌면서 맨앞에 있는 게 우선순위가 제일 높다면 큐에서 빼고, map에서도 빼고, answerMap에 키값과 순서를 넣는다.
 * 4. 우선순위가 낮다면 다시 큐에 넣는다.
 *
 */
 
public class Pro42587 {
    public static void main(String[] args) {
        int input[] = {1, 1, 9, 1, 1,};
        int location = 0;
        System.out.println(solution(input, location));

    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> answerMap = new HashMap<>();

        for (int i = 0; i < priorities.length; i++) {
            char ch = (char) (i + 65);
            map.put(String.valueOf(ch), priorities[i]);
            queue.add(String.valueOf(ch));
        }

        int num = 0;

        while (!queue.isEmpty()) {
            String now = queue.poll();
            Integer nowValue = map.get(now);
            boolean flag = true;

            for (Integer i : map.values()) {
                if (nowValue < i) {
                    queue.add(now);
                    flag = false;
                    break;
                }
            }
            if (flag) {
                num++;
                answerMap.put(now, num);
                map.remove(now);
            }
        }

        answer = answerMap.get(String.valueOf((char) (location + 65)));

        return answer;
    }
}
