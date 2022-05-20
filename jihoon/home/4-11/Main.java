import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int map[][];
    public static int N;
    public static int answer = Integer.MAX_VALUE;
    public static int M = 0;
    static boolean[] visit;
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visit = new boolean[N];

        for (int i = 0; i < N; i++) {
            var st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // t는 팀원 수. 팀원이 절반으로 떨어지는 것이 아니기 때문에 가능한 경우의 수를 모두 탐색한다.
        for (M = 1; M < N; M++) {
            nCr(0, 0);
        }
        System.out.println(answer);
    }
    
    public static void nCr(int depth, int start) {
        if (depth == M) {
            answer = Math.min(answer, diff());
            // 0이 나오면 가장 작은 최소값이기 때문에 더 이상 순회 할 필요가 없다.
            // 시간을 조금 더 줄일 수 있다.
            if (answer == 0) {
                System.out.println(0);
                System.exit(0);
            }
            return;
        }

        for (int i = start; i < N; i++) {
            visit[i] = true;
            nCr(depth + 1, i + 1);
            visit[i] = false;
        }
    }
    
    public static int diff() {
        int start = 0; // v[] 값이 true면 start팀
        int link = 0; // v[] 값이 false면 link팀
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visit[i] && visit[j]) {
                    start += (map[i][j] + map[j][i]);
                } else if (!visit[i] && !visit[j]) {
                    link += (map[i][j] + map[j][i]);
                }
            }
        }
        return Math.abs(start - link);
    }
}