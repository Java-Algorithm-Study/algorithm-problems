import java.util.*;

/**
 * [17685] 자동완성
 * https://school.programmers.co.kr/learn/courses/30/lessons/17685
 *
 * -아이디어
 * 1. 정렬 후, 해당 문자열의 앞뒤와 비교한다.
 *
 */

public class Pro_17685 {

    public static void main(String[] args) {
        String[] words = {"word","war","warrior","world"};


        int result = 0;
        Arrays.sort(words);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<words.length; i++) {
            String cur = words[i];
            sb.setLength(0);

            if (i == 0) {
                for (int j = 0; j < cur.length(); j++) {
                    sb.append(cur.charAt(j));
                    if (!words[i + 1].startsWith(sb.toString()) || j == cur.length() - 1) {
                        result += sb.length();
                        break;
                    }
                }
            } else if (i == words.length - 1) {
                for (int j = 0; j < cur.length(); j++) {
                    sb.append(cur.charAt(j));
                    if (!words[i - 1].startsWith(sb.toString()) || j == cur.length() - 1) {
                        result += sb.length();
                        break;
                    }
                }
            } else {
                for (int j = 0; j < cur.length(); j++) {
                    sb.append(cur.charAt(j));
                    if (j != cur.length() - 1 && (words[i - 1].startsWith(sb.toString()) || words[i + 1].startsWith(sb.toString())))
                        continue;
                    else {
                        result += sb.length();
                        break;
                    }
                }
            }
        }


        System.out.println(result);
    }
}
