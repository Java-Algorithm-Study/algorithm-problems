import java.util.LinkedList;

/**
 * [17680] 캐시
 * https://programmers.co.kr/learn/courses/30/lessons/17680
 *
 * -아이디어
 * 1. LRU: 가장 오랫동안 참조되지 않은 페이지를 교체하는 알고리즘
 * 2. 도시 이름이 캐시에 있는지 확인한다. -> 있으면 삭제하고 맨 앞에 다시 넣어 준다. 맨 앞이 가장 최근에 사용된 것.
 * 3. 없다면 캐시 사이즈를 확인한다. 사이즈가 꽉 찼다면 맨 뒤에 있는 것이 가장 오랫동안 사용되지 않은 페이지니까 삭제하고, 새로운 시티를 넣는다.
 *
 * -시간 복잡도
 * 1. 링크드리스트 검색 : O(n)
 * 2. 삽입, 삭제 : O(1)
 *
 * -자료 구조
 * 1. LinkedList : 캐시
 *
 */

public class Pro17680_Again {
    public static void main(String[] args) {
        System.out.println(solution(3, new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
//        System.out.println(solution(3, new String[] {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"}));
    }

    public static int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) {
            return cities.length * 5;
        }

        int answer = 0;
        LinkedList<String> list = new LinkedList<>();

        // 입력을 다 소문자로 변경
        for (int i = 0; i < cities.length; i++) {
            cities[i] = cities[i].toLowerCase();
        }

        for (int i = 0; i < cities.length; i++) {
            // 캐시 히트일 경우
            if (list.contains(cities[i])) {
                list.remove(cities[i]);
                answer += 1;
            }

            // 캐시 미스
            else {
                answer += 5;
            }

            // 가장 최근에 사용된 거니까 넣는다.
            list.addFirst(cities[i]);

            if (list.size() > cacheSize) {
                list.removeLast();
            }
        }

        return answer;
    }
}
