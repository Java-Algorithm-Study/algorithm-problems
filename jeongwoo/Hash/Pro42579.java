import java.util.*;

/**
 * [42579] 베스트 앨범
 * https://programmers.co.kr/learn/courses/30/lessons/42579
 *
 * -아이디어
 * 1. map에 장르별 저장 횟수를 저장한다.
 * 2. value를 기준으로 내림차순 정렬을 한다.
 * 3. map을 돌면서 genres 배열에서 key값과 일치한다면 최댓값, 두 번째 최댓값을 찾아서 list에 저장한다.
 *
 * -시간 복잡도
 * 1. O(장르 종류 * 노래 수) = O(1,000,000)
 *
 */

public class Pro42579 {
    public static void main(String[] args) {
        String[] g = {"classic", "pop", "classic", "classic", "pop"};
        int[] p = {500, 600, 150, 800, 2500};
        System.out.println(Arrays.toString(solution(g, p)));
    }

    public static int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> map = new HashMap<>();

        // 1. map에 장르별 재생 횟수를 저장한다.
        for (int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }

        // 2. value 기준으로 내림차순 정렬
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        List<Integer> answer = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : entryList){
            // 3. 장르별 최대 재생 횟수 찾기
            int max = Integer.MIN_VALUE;
            int firstIndex = Integer.MIN_VALUE;
            for (int i = 0; i < genres.length; i++) {
                if (entry.getKey().equals(genres[i]) && max < plays[i]) {
                    max = plays[i];
                    firstIndex = i;
                }
            }
            answer.add(firstIndex);

            // 4. 장르별 두 번째 재생 횟수 찾기
            int secondMax = Integer.MIN_VALUE;
            int secondIndex = Integer.MIN_VALUE;
            for (int i = 0; i < genres.length; i++) {
                if (i != firstIndex && entry.getKey().equals(genres[i]) && secondMax < plays[i]) {
                    secondMax = plays[i];
                    secondIndex = i;
                }
            }

            // 5. 두 번째 최대 재생곡이 있다면 저장
            if (secondIndex >= 0) {
                answer.add(secondIndex);
            }
        }

        int[] ans = new int[answer.size()];
        int size = 0;
        for (int x : answer) {
            ans[size++] = x;
        }

        return ans;
    }
}
