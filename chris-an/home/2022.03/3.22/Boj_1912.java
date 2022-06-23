import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1912 {

    static int DP[]; // 해당 인덱스 위치의 최대합을 담습니다.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        DP = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] target = new int[N];
        for (int i = 0; i < N; i++) {
            target[i] = Integer.parseInt(st.nextToken());
        }

        DP[0] = target[0]; // N이 1 수열일 땐, 당연히 1이 최대 합.
        int max = DP[0];
        for (int i = 1; i < target.length; i++) {
            DP[i] = Math.max(target[i], target[i] + DP[i-1]);
            max = Math.max(DP[i], max);
        }
        System.out.println(max);
    }
}