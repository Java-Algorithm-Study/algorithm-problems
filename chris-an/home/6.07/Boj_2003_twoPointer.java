import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2003_twoPointer {
    private static int convertStrToInt(String input) {
        return Integer.parseInt(input);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = convertStrToInt(st.nextToken());
        int M = convertStrToInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] inputDataArr = new int[N];
        for (int i = 0; i < N; i++) inputDataArr[i] = convertStrToInt(st.nextToken());

        int start = 0;
        int end = 0;
        int sum = 0;
        int cnt = 0;
        while (true) {
            // base case
            if (end == N) break; // 인덱스 마지막일 시 종료.
            if (sum >= M) sum -= inputDataArr[start++];
            else sum += inputDataArr[end++];
            // check
            if (sum == M) cnt++;
        }

        System.out.println(cnt);
    }
}
