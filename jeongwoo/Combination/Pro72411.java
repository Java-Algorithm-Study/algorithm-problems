import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/**
 * [72411] 메뉴 리뉴얼
 * https://programmers.co.kr/learn/courses/30/lessons/72411
 */

public class Pro72411 {
    private static ArrayList<String> arrayList = new ArrayList<>();
    private static HashMap<String, Integer> hashMap = new HashMap<>();

    public static void main(String[] args) {
        String[] str = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2, 3, 4};

        System.out.println(Arrays.toString(solution(str, course)));
    }

    private static String[] solution(String[] orders, int[] course) {
        // orders[i] 값들을 사전 순서로 정렬
        for (int i = 0; i < orders.length; i++) {
            char[] ch = orders[i].toCharArray();
            Arrays.sort(ch);
            System.out.println(ch.toString());
            orders[i] = String.valueOf(ch); // ch.toString()은 메모리값 반환
        }

        // 코스 개수에 따라 메뉴 조합 구하기
        for (int i = 0; i < course.length; i++) {
            for (int j = 0; j < orders.length; j++) {
                if (orders[j].length() >= course[i]) {
                    combination(orders[j], 0, 0, course[i], "");
                }
            }
        }

        for (int i = 0; i < course.length; i++) {
            // 코스 개수(키)가 같은 것 중에서 제일 많이 언급된 횟수(값) 찾기 
            int max = Integer.MIN_VALUE;
            for (String key : hashMap.keySet()) {
                if (key.length() == course[i]) {
                    max = Math.max(max, hashMap.get(key));
                }
            }

            // 같은 코스 개수에서 횟수가 2 이상인 최댓값을 갖는 코스 담기
            for (String key : hashMap.keySet()) {
                if (max >= 2 && key.length() == course[i] && hashMap.get(key) == max) {
                    arrayList.add(key);
                }
            }
        }

        Collections.sort(arrayList);

        String[] answer = new String[arrayList.size()];
        for (int i = 0; i < answer.length; i++) {
            System.out.println(arrayList.get(i));
            answer[i] = arrayList.get(i);
        }
        return answer;
    }

    private static void combination(String str, int start, int level, int r, String combi) {
        if (level == r) {
            hashMap.put(combi, hashMap.getOrDefault(combi, 0) + 1);
            return;
        }

        for (int i = start; i < str.length(); i++) {
            combination(str, i + 1, level + 1, r, combi + str.charAt(i));
        }
    }
}
