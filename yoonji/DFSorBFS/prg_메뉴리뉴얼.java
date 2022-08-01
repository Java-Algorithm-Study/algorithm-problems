package DFSorBFS;
import java.util.*;

// 단품 메뉴 조합 -> 새 메뉴로 코스요리 형태로 재구성
// 가장 많이 함께 주문한 단품메뉴들을 구성하기로 결정
// 최소 2가지 이상의 단품 메뉴로 구성 + 최소 2명 이상의 손님으로부터 주문된 단품메뉴
// course : 오름차순 2~10
// 알파벳 오름차순. 배열에 담은 것도 오름차순
// 가장 많이 함께 주문된 메뉴 구성이 여러 개면, 모두 배열에 담는다.
//[2,3,4] : 구성되야할 단품 메뉴 갯수
// 2개 : AC가 4번이나 주문
// 3개 : CDE 3번
// 4개 : ACDE 2번
// - 아이디어
// 각 사이즈만큼 순회하며 orders 원소를 순회한다.
// key: size만큼 더해진 문자를 정렬 시킨 후, hashMap ++
// max인 value를 갖는 모든 key를 answer에 추가한다.
// 2번째 예제 : 길이에 상관없이, 사전순으로 정렬되어야 하므로 우선순위 큐를 사용
public class prg_메뉴리뉴얼 {
    Map<String, Integer> map;
    PriorityQueue<String> pq = new PriorityQueue<>();   // String 우선순위: 사전 정렬
    int maxCnt=-1;
    public String[] solution(String[] orders, int[] course) {
        for (int size: course) {
            map = new HashMap<>();
            maxCnt = -1;
            for (String o : orders) {
                if (o.length() >= size) {
                    makeCase_dfs(0, 0, o, size, "");
                }
            }
            // couse 길이의 문자열인 key 중 max값 구한다.
            if (maxCnt<2) continue;
            for (String key : map.keySet()) {
                if (map.get(key) == maxCnt) {
                    pq.offer(key);
                }
            }
        }
        int answerSize = pq.size();
        String[] answer = new String[answerSize];
        for (int i=0; i<answerSize; i++) {
            answer[i] = pq.poll();
        }
        return answer;
    }
    // size만큼의 조합을 order에 대해 구한다.
    private void makeCase_dfs(int idx, int depth, String order, int size, String combi) {
        if (depth == size) {
            char[] tmp = combi.toCharArray();
            Arrays.sort(tmp);
            combi = String.valueOf(tmp);
            map.put(combi, map.getOrDefault(combi, 0)+1);
            maxCnt = Math.max(maxCnt, map.get(combi));
            return;
        }
        for (int i=idx; i<order.length(); i++) {
            makeCase_dfs(i+1, depth+1, order, size, combi+order.charAt(i));
        }
    }
}
