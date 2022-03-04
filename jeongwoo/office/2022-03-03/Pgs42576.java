import java.util.*;

/**
 * [42576] 완주하지 못한 선수
 * https://programmers.co.kr/learn/courses/30/lessons/42576
 */

public class Solution {
    public String solution(String[] participant, String[] completion) {

        String answer = "";
        
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < participant.length; i++) {
            map.put(participant[i], map.getOrDefault(participant[i], 0) + 1);
        }

        for (int i = 0; i < completion.length; i++) {
                map.put(completion[i], map.get(completion[i])-1);
            
        }

        for (String key : map.keySet())
        {
            if (map.get(key) > 0)
            {
                answer = key;
                break;
            }
        }    
        return answer;
    }
}
