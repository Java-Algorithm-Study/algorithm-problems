import java.io.*;

class Boj_2133 {
    static int [] DP;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // N은 1부터 시작하기 때문에 N + 1의 크기를 갖는 배열을 선언한다.
        DP = new int[N+1];

        // 홀수는 불가
        if (N % 2 != 0) {
            System.out.println(0);
        }

        // 타일이 없을 경우는 1개로 초기화 (이건 임의로 지정)
        DP[0] = 1;
        // 타일이 1개일 경우에는 0개입니다.
        DP[1] = 0;
        // 3x2 타일을 채울 수 있는 경우의 수는 3개이다.
        DP[2] = 3;

        // 짝수 루프입니다.
        for (int i = 4; i <= N; i += 2) {
            DP[i] = DP[i - 2] * DP[2];
            for (int j = i - 4; j >= 0; j -= 2) {
                DP[i] = DP[i] + (DP[j] * 2);
            }
        }

        System.out.println(DP[N]);
    }
}






