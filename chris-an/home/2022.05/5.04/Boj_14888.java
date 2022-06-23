import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    피연산자 수는 최대 11개
    연산자 수는 최대 10개
    각 연산자의 수에 따라 차례대로 +, -, *, / 연산을 수행해야 함
    ex) 3, 0, 2, 0 입력값이 주어졌을 시, A+B+C+D*E*F
 */
public class Boj_14888 {
    static final int operatorCnt = 4; // +,-,*,/
    static int N;
    static int[] numbers = new int[11];
    static int[] operators = new int[10];
    static boolean[] visited = new boolean[10]; // 연산자 방문처리
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void dfs(int depth, int nIdx, int cum) {
        // base case
        if (depth == N-1) {
            max = Math.max(max, cum);
            min = Math.min(min, cum);
            return;
        }
        // recur
        int sum = 0;
        for (int i = 0; i < N-1; i++) {
            if (!visited[i]) {
                visited[i] = true;
                switch (operators[i]) {
                    case 0 :
                        sum = cum + numbers[nIdx];
                        break;
                    case 1 :
                        sum = cum - numbers[nIdx];
                        break;
                    case  2 :
                        sum = cum * numbers[nIdx];
                        break;
                    case  3 :
                        sum = cum / numbers[nIdx];
                        break;
                }
                dfs(depth + 1, nIdx + 1, sum);
                // Backtracking
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        // 피연산자 저장배열 : numbers
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) numbers[i] = Integer.parseInt(st.nextToken());

        // 연산자 저장배열 : operators
        st = new StringTokenizer(br.readLine());
        int oIdx = 0;
        for (int i = 0; i < operatorCnt; i++) {
            int operator = Integer.parseInt(st.nextToken());
            // 각 연산자에 사용 횟수만큼 순차적으로 operators 배열에 저장합니다.
            for (int j = 0; j < operator; j++)
                operators[oIdx++] = i;
        }

        dfs(0, 1, numbers[0]);
        System.out.println(max);
        System.out.println(min);
    }
}
