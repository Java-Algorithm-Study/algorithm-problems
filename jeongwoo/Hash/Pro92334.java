import java.util.*;
import java.util.Map.Entry;

/*
신고 결과 받기
https://school.programmers.co.kr/learn/courses/30/lessons/92334

1. map에 신고 당한 사람, 신고한 사람을 넣는데 신고한 사람은 중복될 수 있으니까 set으로 설정한다.
2. 신고 당한 사람이 가지고 있는 value 값이 k 이상이면 정지 처리 -> 이 사람의 value에 들어가 있는 유저한테 메일이 간다.
3. 유저 이름과 인덱스 값을 저장하고, 메일이 가게 되면 answer에 인덱스 찾아서 ++
*/

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        Map<String, HashSet<String>> map = new HashMap<>();
        Map<String, Integer> idx = new HashMap<>();
        
        for (int i = 0; i < id_list.length; i++) {
            idx.put(id_list[i], i);
            map.put(id_list[i], new HashSet<>());
        }
        
        for (int i = 0; i < report.length; i++) {
            String[] str = report[i].split(" ");
            // str[1] = 신고 당한 사람
            // str[0] = 신고한 사람
            map.get(str[1]).add(str[0]);
        }
                
        for (int i = 0; i < id_list.length; i++) {
            HashSet<String> set = map.get(id_list[i]);
            if (set.size() >= k) {
                for (String str : set) {
                    answer[idx.get(str)]++;
                }
            }
        }
        
        return answer;
    }
}
