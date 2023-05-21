package language.java.Programmers;

import java.util.*;
import java.util.Stack;

public class Programmers_42576 {

    public static String solution(String[] participant, String[] completion) {

        String answer = "";

        HashMap<String, Integer> map = new HashMap<>();

        for (String name : participant)
            map.put(name, map.getOrDefault(name, 0) + 1);

        for (String name : completion)
            map.put(name, map.get(name) - 1);

        for (String key : map.keySet()) {
            if (map.get(key) > 0) {
                answer = key;
                break;
            }
        }
        System.out.println(answer);
        return answer;
    }
}