/**
 * [60057] 문자열 압축
 * https://programmers.co.kr/learn/courses/30/lessons/60057
 *
 * -아이디어
 * 1. 1 ~ 문자열 길이/2만큼 압축을 시도해 볼 수 있다.
 * 2. 문자열 길이 절반을 넘어가면 압축의 의미가 사라진다.
 * 3. 압축을 몇 개씩 할지 정하고, 압축 단어 앞부분과 뒷부분이 같다면 반복되는 횟수를 카운트한다.
 * 4. 앞 인덱스와 현재 인덱스가 다르다면 현재 인덱스에 해당하는 문자열을 더한다.
 * 5. 압축이 한 번 끝날 때마다 문자열 길이를 min에 갱신한다.
 *
 * -시간 복잡도
 * 1. n * n/2 * n/2 이하 (n <= 1,000)
 *
 * -자료 구조
 * 1. StringBuilder : 압축 문자열 저장
 *
 */

public class Pro60057 {
    public static void main(String[] args) {
        System.out.println(solution("aabbaccc"));
    }
    public static int solution(String s) {
        int min = Integer.MAX_VALUE;
        
        if (s.length() == 1) {
            return s.length();
        }
        
        for (int i = 1; i <= s.length() / 2; i++) {
            String answer = "";
            int count = 1;
            String now = "";

            for (int j = 0; j < s.length() ; j = j + i) {
                String prev = now;
                StringBuilder sb = new StringBuilder();

                for (int k = j; k < j + i; k++) {
                    if (k >= s.length()) {
                        break;
                    }
                    sb.append(s.charAt(k));
                }

                now = sb.toString();
                if (prev.equals(now)) {
                    count++;
                }
                else {
                    if (count > 1) {
                        answer += String.valueOf(count);
                    }
                    answer += now;
                    count = 1;
                }
            }

            if (count > 1) {
                answer += String.valueOf(count);
            }

            min = Math.min(min, answer.length());
        }

        return min;
    }
}
