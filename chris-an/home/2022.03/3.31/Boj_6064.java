import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_6064 {

    static int lcm(int M, int N) {
        return M * N / gcd(M, N);
    }

    static int gcd(int M, int N) {
        while (N != 0) {
            int r = M % N;
            M = N;
            N = r;
        }
        return M;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int year = x;

            int checkPoint = N; // 루프 길이를 x 고정을 통해 y를 찾으니, y 길이로 세팅을해줍니다.
            while (checkPoint-- > 0) {
                int target = year % N == 0 ? N : year % N; // tmp 에 연산처리해주다가, N으로 나누었을 시 나온 값이 y 값일 경우를 찾음.
                if (target == y) break; // y를 찾았다면 return

                year += M; // 매 로프마다 기준이 M이니 year 에 M을 추가
            }

            // 예외를 잡아줍니다. 유효하지 않은 표현일 때를 위해 최소공배수를 구하여 그보다 높을 시, 예외
            if(year > lcm(M, N)) System.out.println(-1);
            else System.out.println(year);
        }

    }
}
