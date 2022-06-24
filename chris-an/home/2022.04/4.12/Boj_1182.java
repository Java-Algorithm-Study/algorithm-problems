import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1182 {
    static int N, S;
    static int[] arr;
    static int count;

    public static void backTracking(int start, int depth, int sum) {
        if (S == sum) count++;

        for (int i = start; i < N; i++) {
            backTracking(i + 1 ,  depth + 1, sum + arr[i]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        backTracking(0, 0, 0);

        // s가 0인 경우 카운트가 생기고 시작하니 제거
        if (S == 0) count--;

        System.out.println(count);
    }
}
