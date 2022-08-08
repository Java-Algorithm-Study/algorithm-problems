import java.util.*;

public class Pro_튜플 {
    public int[] solution(String s) {
        Map<Integer, Integer> tuple = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                sb.append(c);
            }else {
                if(sb.length() != 0) {
                    int key = Integer.parseInt(sb.toString());
                    tuple.put(key, tuple.getOrDefault(key, 0) + 1);
                }
                sb.setLength(0);
            }
        }
        List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(tuple.entrySet());
        entryList.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        int[] answer = new int[entryList.size()];
        int idx = 0;
        for (Map.Entry<Integer, Integer> entry : entryList) {
            answer[idx++] = entry.getKey();
        }

        return answer;
    }
}
