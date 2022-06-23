import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// DFS 로 푼 문제.
// 가장 빠름
public class Boj_1463_dfs {

    static int min;
    public static void dfs(int N, int cnt) {
        if (N == 1) { // 1을 만들려고 하는 부분이니 초기값은 1 입니다. 즉, Depth 가 1일 때는 탐색 stop. 최소값을 리턴을 해주어야합니다.
            min = min > cnt ? cnt : min;
            return;
        }else if (cnt >= min) { // DP 테이블에 저장된 값보다 작을 경우를 리턴 즉, 벌써 최소값이 나왔는데, 추가적 탐색이 필요하지 않음.
            return;
        }

        if (N % 2 == 0)
            dfs(N/2, cnt+1); // 3가지 조건 중 'X 가 2로 나누어 떨어지면 2로 나눈다.'
        if (N % 3 == 0)
            dfs(N/3, cnt+1); // 3가지 조건 중 'X 가 3로 나누어 떨어지면 3으로 나눈다.'

        dfs(N-1, cnt+1); // 3가지 조건 중 '1을 뺀다'
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        min  = Integer.MAX_VALUE;  // 2147483647
        dfs(N, 0); // 매개변수 cnt 로 최소값 카운트를 유지하기 위해 매개변수로 담아 넘깁니다.
        System.out.println(min); // N으로 넘긴 값의 문제의 원하는 해(최소값)가 담겨있습니다.

    }
}