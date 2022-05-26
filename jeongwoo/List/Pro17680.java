import java.util.LinkedList;
import java.util.List;

/**
 * [17680] 캐시
 * https://programmers.co.kr/learn/courses/30/lessons/17680
 *
 * -아이디어
 * 1. LRU: 가장 오랫동안 참조되지 않은 페이지 교체
 * 2. Linked List로 구현. 도시 이름은 대소문자 구분 없으니까 대문자로 변경한다.
 * 3. 캐시 사이즈가 0이라면 사용할 수 없으니까 cities의 사이즈만큼 시간 추가 후 리턴.
 * 4. Linked List에 존재 여부는 remove의 반환이 boolean이니까 이걸로 판단한다.
 * 5. Linked List에 없다면 miss로 5초 추가 후, 도시 이름을 넣어 준다. 
 * 6. 만약 넣을 때, Linked List가 다 찼다면 가장 오래된 것(index = 0)을 삭제한다.
 *
 */

public class Pro17680 {
    public static void main(String[] args) {
        String[] input = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        System.out.println(solution(3, input));
    }

    private static int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        List<String> caches = new LinkedList<>();
        int time = 0;

        for (int i = 0; i < cities.length; i++) {
            String city = cities[i].toLowerCase();
            // city 삭제의 boolean 여부
            if (caches.remove(city)) {  // 캐시에 있다면
                caches.add(city);   // 뒤에 있는 게 제일 최근
                time += 1;
            }
            else {
                // 사이즈가 넘으면
                if (caches.size() >= cacheSize) {
                    caches.remove(0);
                }
                caches.add(city);
                time += 5;
            }
        }
        return time;
    }
}
