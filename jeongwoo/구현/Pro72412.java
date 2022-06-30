import java.util.*;

/**
 * [72412] 순위 검색
 * https://programmers.co.kr/learn/courses/30/lessons/72412
 *
 * -아이디어
 * 1. Input으로 들어오는 값들을 Map에 공백 없이 저장한다.
 * 2. -(모든 조건 가능)도 쿼리에 들어있을 수 있으니까 Input값을 Map에 저장하고, -도 넣어서 저장한다.
 * 3. java backend junior pizza라면
 * 4. java backend junior - /  java backend - - / java backend - pizza
 * 5. 이런 식으로 넣는데, -로 인해 중복된 조건들이 생기면 value에 점수를 여러 개 저장한다.
 * 6. Map 구성 후, 밸류(점수)를 오름차순으로 정렬한다. 
 * 7. 맞는 쿼리가 있다면 그 쿼리에 대한 점수를 기준으로 이분 탐색해서 조건에 맞는 사람이 몇 명 있는지 찾는다.
 *
 * -자료 구조
 * 1. Map<String, ArrayList<Integer>> : String에는 조건 작성, Key는 여러 점수가 들어갈 수 있으니까 list로 넣는다.
 * 
 */

public class Pro72412 {
    public static void main(String[] args) {
        String[] input = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
        System.out.println(Arrays.toString(solution(input, query)).toString());
    }

    private static Map<String, ArrayList<Integer>> map;
    private static String[] stringArray;

    public static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        map = new HashMap<>();

        for (int i = 0; i < info.length; i++) {
            stringArray = info[i].split(" ");
            String[] changedInfo = new String[4];
            dfs(0, changedInfo);
        }

        for (String s : map.keySet()) {
            Collections.sort(map.get(s));
        }

        for (int i = 0; i < query.length; i++) {
            String[] temp = query[i].split(" and ");
            int limit = Integer.parseInt(temp[3].split(" ")[1]);
            temp[3] = temp[3].split(" ")[0];
            String str = temp[0] + temp[1] + temp[2] + temp[3];

            if (map.containsKey(str)) {
                answer[i] = binarySearch(str, limit);
            }

            else {
                answer[i] = 0;
            }

        }


        System.out.println(map);
        return answer;
    }

    private static void dfs(int depth, String[] changedInfo) {
        if (depth == 4) {
            String temp = changedInfo[0] + changedInfo[1] + changedInfo[2] + changedInfo[3];

            if (!map.containsKey(temp)) {
                map.put(temp, new ArrayList<>());
            }

            map.get(temp).add(Integer.parseInt(stringArray[4]));
            return;
        }

        changedInfo[depth] = stringArray[depth];
        dfs(depth + 1, changedInfo);

        changedInfo[depth] = "-";
        dfs(depth + 1, changedInfo);
    }

    private static int binarySearch(String key, int score) {
        List<Integer> list = map.get(key);
        Collections.sort(list);

        int start = 0;
        int end = list.size() - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (list.get(mid) < score) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }

        return list.size() - start;
    }

}
