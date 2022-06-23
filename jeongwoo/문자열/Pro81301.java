/**
 * [81301] 숫자 문자열과 영단어
 * https://programmers.co.kr/learn/courses/30/lessons/81301
 */

public class Pro81301 {
    public int solution(String s) {
        String[] number = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String[] word = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        int answer = 0;
        
        for (int i = 0; i < word.length; i++) {
            if (s.contains(word[i])) {
                s = s.replaceAll(word[i], number[i]);
            }
        }
        
        answer = Integer.parseInt(s);
        return answer;
        
    }
}
