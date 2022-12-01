import java.util.Arrays;

/**
 * [17685] 자동완성
 * https://programmers.co.kr/learn/courses/30/lessons/17685
 *
 * -아이디어
 * 1. 입력 단어를 정렬한다.
 * 2. 정렬한 배열을 앞뒤로 비교하면서 현재 단어와 몇 번째 문자까지 동일한지 찾는다.
 * 3. 앞뒤 비교해서 더 긴 단어의 길이를 더한다.
 *
 * -시간 복잡도
 * 1.(100,000 * 10) 이하
 *
 */

public class Pro17685 {
    public static void main(String[] args) {
        System.out.println(solution(new String[] {"go","gone","guild"}));
        System.out.println(solution(new String[] {"aaaaa", "aaaab", "aaabb", "aabbb", "abbbb"}));
        System.out.println(solution(new String[] {"abc","def","ghi","jklm"}));
        System.out.println(solution(new String[] {"word","war","warrior","world"}));
    }

    public static int solution(String[] words) {
        int answer = 0;
        Arrays.sort(words);

        for (int i = 0; i < words.length; i++) {
            String now = words[i];
            int prevIdx = 0;
            int nextIdx = 0;
            // 연속으로 같은 문자가 나오는지 체크
            boolean prevFlag = true;
            boolean nextFlag = true;

            // i = 0 -> 오른쪽이랑만 비교
            if (i == 0) {
                String next = words[i + 1];

                for (int j = 0; j < now.length(); j++) {
                    if (j < next.length() && nextFlag && now.charAt(j) == next.charAt(j)) {
                        nextIdx++;
                    }
                    else {
                        nextFlag = false;
                    }
                }

                if (nextIdx < now.length()) {
                    nextIdx++;
                }
                answer += nextIdx;
            }

            // i = words.length - 1 -> 왼쪽이랑만 비교
            else if (i == words.length - 1) {
                String prev = words[i - 1];

                for (int j = 0; j < now.length(); j++) {
                    if (j < prev.length() && prevFlag && now.charAt(j) == prev.charAt(j)) {
                        prevIdx++;
                    }
                    else {
                        prevFlag = false;
                    }
                }

                if (prevIdx < now.length()) {
                    prevIdx++;
                }
                answer += prevIdx;
            }

            // 양옆 둘 다 비교
            else {
                String prev = words[i - 1];
                String next = words[i + 1];

                for (int j = 0; j < now.length(); j++) {

                    if (j < prev.length() && prevFlag && now.charAt(j) == prev.charAt(j)) {
                        prevIdx++;
                    }
                    else {
                        prevFlag = false;
                    }

                    if (j < next.length()  && nextFlag && now.charAt(j) == next.charAt(j)) {
                        nextIdx++;
                    }
                    else {
                        nextFlag = false;
                    }
                }

                int max = Math.max(prevIdx, nextIdx);

                if (max < now.length()) {
                    max++;
                }
                
                answer += max;
            }
        }

        return answer;
    }
}
