package language.java.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_15658 {
    static final int operatorCnt = 4; // +,-,*,/
    static int N;
    static int[] numbers;
    static int[] operators;
    static boolean[] visited = new boolean[44];
    static int[] temp = new int[10];
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static int calc() {
        int sum = numbers[0];
        for (int i = 0 ; i < N-1; i++) {
            switch (temp[i]) {
                case 0 :
                    sum += numbers[i + 1]; break;
                case 1 :
                    sum -= numbers[i + 1]; break;
                case 2 :
                    sum *= numbers[i + 1]; break;
                case 3 :
                    sum /= numbers[i + 1]; break;
            }
        }
        return sum;
    }

    public static void dfs(int depth) {
        // base case
        if (depth == N-1) {
            int sum = calc();
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }

        // recur
        int beforeOperators = -1;
        for (int i = 0; i < operators.length; i++) {
            if (!visited[i] && operators[i] != beforeOperators) { // 이전 연산자와 동일할 시, 동일한 조합이 만들어짐으로 pass
                visited[i] = true;
                beforeOperators = operators[i]; // 동일한 연산자 조합을 피하기 위해 저장해 놓습니다.
                temp[depth] = operators[i];
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        // 피연산자 저장배열 : numbers
        numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            numbers[i] = Integer.parseInt(st.nextToken());



        st = new StringTokenizer(br.readLine());
        int[] op = new int[4];
        int totalOperatorCnt = 0;
        for (int i = 0; i < operatorCnt; i++) {
            int operator = Integer.parseInt(st.nextToken());
            op[i] = operator;
            totalOperatorCnt += operator;
        }

        // 연산자 저장배열 : operators
        operators = new int[totalOperatorCnt];
        int oIdx = 0;
        for (int i = 0; i < op.length; i++) {
            for (int j = 0; j < op[i]; j++) {
                operators[oIdx++] = i;
            }
        }

        dfs(0);
        System.out.println(max);
        System.out.println(min);
    }
}
