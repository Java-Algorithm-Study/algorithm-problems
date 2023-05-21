package language.java.Programmers;
import java.util.*;

public class Prg_구명보트 {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        // 무조건 for문 하나로 처리
        int idx = 0;
        for (int i = people.length -1; i >= idx; i--) {
            if (people[i] + people[idx] <= limit) {
                idx++;
            }
            answer++;
        }
        return answer;
    }
}
