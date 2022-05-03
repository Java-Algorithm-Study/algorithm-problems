import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 단어수학
/* 1. num이라는 배열에 depth에 따라 숫자 0~9를 모두 다른 경우의 수로 넣는다.
   2. 깊이가 현재 문자열들의 전체 알파벳 수가 되면 (중복허용x) 모두 채울수 있으니까
   3. 모든 문자열을 반복문 돌면서, 각 문자열에서 10을 곱해나가면서 (특정 문자와 대칭되는 숫자를 indexOf로 찾고 이를 num배열의 index로 숫자와 매칭시켜) 특정 알파벳에 매칭되는 숫자를 더해간다.
*/
public class boj_1339 {
    static List<Character> alpabets;
    static int N;
    static String[] words;
    static int[] num;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        inputAndCollectAlpabet();
        // dfs로 모든 알파벳에 대해 경우의 수 구하기
        dfs(0);
        System.out.println(maxResult);
    }

    static int maxResult = Integer.MIN_VALUE;
    private static void dfs(int depth) {
        if (depth == alpabets.size()) {
            int sum = matchAlpabetWithNum();
            maxResult = Math.max(maxResult, sum);
            return;
        }
        for (int i=0; i<=9; i++) {
            if (!visited[i]) {
                visited[i] = true;
                num[depth] = i;
                dfs(depth + 1);
                visited[i] = false;
                num[depth] = 0; // 아무 계산 안되는 상태
            }
        }
    }
    private static int matchAlpabetWithNum() {
        int sum = 0;
        for (int i=0; i<N; i++) {
            int realNum = 0;
            for (int j = 0; j < words[i].length(); j++) {
                realNum *= 10;
                // 문자와 숫자를 연결해 생각하는 것이 어려움. 10을 곱해주는 생각 ★
                realNum += num[alpabets.indexOf(words[i].charAt(j))];  // alpabets.indexOf() : 특정 문자의 인덱스
            }
            sum += realNum;
        }
        return sum;
    }
    private static void inputAndCollectAlpabet() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        words = new String[N];
        num = new int[10];
        visited = new boolean[10];
        alpabets = new ArrayList<>();
        for (int i=0; i<N; i++) {
            words[i] = br.readLine();
            for (int j=0; j<words[i].length(); j++) {
                if (!alpabets.contains(words[i].charAt(j)))
                    alpabets.add(words[i].charAt(j));
            }
        }
    }
}