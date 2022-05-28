import java.util.LinkedList;
import java.util.List;
// 최근 값을 뒤에 저장한다.
// 이미 캐시에 있다면, 최근 위치로 옮긴다. (제거 후 추가)
public class prg_캐시 {
    public int solution(int cacheSize, String[] cities) {
        List<String> caches = new LinkedList<>();
        int time = 0;
        for (int i=0; i<cities.length; i++) {
            String city = cities[i].toLowerCase();
            // remove()-> boolean 여부로 contains 체크
            if (caches.remove(city)) {  // 캐시에 있다면
                caches.add(city);   // 뒤에 있는게 제일 최근
                time++;
            } else {
                if (caches.size() > cacheSize) {                // 사이즈가 넘으면
                    caches.remove(0);
                }
                caches.add(city);
                time+=5;
            }
        }
        return time;
    }
    /* 기존 풀이...
    public int solution(int cacheSize, String[] cities) {
        int takenTime = 0;
        List<String> citiesCache = new LinkedList<>();
        Map<String, Integer> citiesLocation = new HashMap<>();
        for (int i=0; i<cities.length; i++) {
            // map의 key로 있는지 찾고, 그 위치를 index로 List에서 지울까?
            String city = cities[i].toLowerCase();
            if (citiesLocation.containsKey(city)) {
                // int location = citiesLocation.get(city);
                // 제거
                citiesCache.remove(city);   // String으로 삭제
                citiesCache.add(city);
                citiesLocation.put(city, 0);
                takenTime+=1;
            } else {
                // 추가
                // System.out.println(citiesLocation);
                citiesCache.add(city);
                citiesLocation.put(city, 0);
                // 넣었는데 넘친 경우
                if (citiesCache.size() > cacheSize) {
                    String removedCity = citiesCache.remove(0);
                    citiesLocation.remove(removedCity);
                }
                takenTime+=5;
            }
        }
        return takenTime;
    }*/
}