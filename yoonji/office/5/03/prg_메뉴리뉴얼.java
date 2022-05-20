import java.util.*;
// 1. course만큼 돌면서, 사이즈가 course보다 큰 order에 대해서 조합을 찾는다.
// 2. 해당 단위에 대해 조합을 찾으면서 HashMap에 횟수와 함께 기록한다.
// 3. course만큼 돌면서, HashMap에서 course에 해당하는 key들중 가장 많이 주문된 횟수값을 얻어서, value가 max인 key들을 answer에 추가한다.
public class prg_메뉴리뉴얼 {
    private HashMap<String, Integer> menus = new HashMap<>();
    public String[] solution(String[] orders, int[] course) {
        for (int i = 0; i < orders.length; i++) {
            char[] ch = orders[i].toCharArray();
            Arrays.sort(ch);
            orders[i] = String.valueOf(ch);
        }
        for (int c : course) {
            for (String order : orders) {
                if (order.length() >= c) {
                    combination_byDFS(order, 0, 0, c, "");
                }
            }
        }
        List<String> answer = new ArrayList<>();
        for (int c : course) {
            int maxOrdered = Integer.MIN_VALUE;
            for (String menu : menus.keySet()) {
                // 단위마다 가장 많이 주문한 menu들을 뽑아야함.
                if (menu.length() == c) {
                    maxOrdered = Math.max(maxOrdered, menus.get(menu));
                }
            }
            // if key's value is maxOrdered, add key at answer list
            for (Map.Entry<String, Integer> entry : menus.entrySet()) {
                String key = entry.getKey();
                if (key.length() != c) continue;
                Integer value = entry.getValue();
                if (value == maxOrdered && value>1) answer.add(key);
            }

        }
        // 오름차순 정렬
        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }
    private void combination_byDFS(String menu, int start, int level, int limit, String combi) {
        if (level == limit) {
            menus.put(combi, menus.getOrDefault(combi, 0) + 1);
            return;
        }
        for (int i = start; i < menu.length(); i++) {
            combination_byDFS(menu, i + 1, level + 1, limit, combi + menu.charAt(i));
        }
    }
    public static void main(String[] args) {
        String[] str = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2, 3, 4};
        prg_메뉴리뉴얼 t = new prg_메뉴리뉴얼();
        String[] solution = t.solution(str, course);
        for(String s: solution) System.out.print(s+", ");

//        for (int i = 0; i < course.length; i++) {
//            for (int j = 0; j < str.length; j++) {
//                if (str[j].length() >= course[i]) {
//                    combination(str[j], 0, 0, course[i], "");
//                }
//            }
//        }
    }
}