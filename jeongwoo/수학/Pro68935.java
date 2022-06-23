import java.util.*;

/**
 * [68935] 3진법 뒤집기
 * https://programmers.co.kr/learn/courses/30/lessons/68935
 */

public class Pro68935 {
    public int solution(int n) {
        int answer = 0;
        // n -> 3진법
        List<Integer> arr = new ArrayList<>();
        while (n != 0) {
            arr.add(n%3);
            n /= 3;
        }
        // 3진법 -> 10진법
        for (int i=0; i< arr.size(); i++) {
            answer += arr.get(i) * Math.pow(3, arr.size() - i - 1);
        }
        return answer;
    }
}
