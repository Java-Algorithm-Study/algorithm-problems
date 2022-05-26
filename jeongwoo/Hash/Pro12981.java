import java.util.HashSet;

/**
 * [12981] 영어 끝말잇기 
 * https://programmers.co.kr/learn/courses/30/lessons/12981
 *
 * -아이디어
 * 1. 단어는 HashSet에 넣고, 단어가 나올 때마다 set에 있는지 찾아본다.
 * 2. n명이서 하니까 번호는 for (i = 0; i < words.length; i++)에서 
 * 3. 번호: num = (i+1) % n == 0 ? n : (i+1) % n
 * 4. 차례는 (i / n) + 1
 * 
 */
 
public class Pro12981 {
    public static void main(String[] args) {
        String[] input = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        System.out.println(solution(3, input));
    }
    public static int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        HashSet<String> set = new HashSet<>();

        int who;
        int order;
        char end = words[0].charAt(0);

        for (int i = 0; i < words.length; i++) {
            who = (i+1) % n == 0 ? n : (i+1) % n;
            order = i / n + 1;

            if (end != words[i].charAt(0)) {
                answer[0] = who;
                answer[1] = order;
                break;
            }

            end = words[i].charAt(words[i].length() - 1);

            if (!set.contains(words[i])) {
                set.add(words[i]);
            }
            else {
                answer[0] = who;
                answer[1] = order;
                break;
            }
        }
        return answer;
    }
}
