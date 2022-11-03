import java.util.Arrays;

/**
 * [42885] 구명보트 
 * https://programmers.co.kr/learn/courses/30/lessons/42885
 *
 * -아이디어
 * 1. 몸무게 순서로 정렬한다.
 * 2. 제일 무거운 사람 + 제일 가벼운 사람을 같이 넣을 수 있으면 넣는다.
 * 3. 못 넣는다면 무거운 사람만 태운다.
 *
 */
 
public class Pro42885 {
    public static void main(String[] args) {
        
    }

    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);
        int index = 0;

        for (int i = people.length - 1; i >= index; i--) {
            if (people[i] + people[index] <= limit) {
                answer++;
                index++;
            }
            else {
                answer++;
            }
        }

        return answer;
    }
}
