import java.io.*;
import java.util.Arrays;

public class Boj_17103 {

    /*
        골드바흐 파티션 17103번 문제.
     */
    static boolean [] prime;

    public static void isPrime() {
        prime = new boolean[1000001];

        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;

        for (int i = 2; i <= 1000000; i++) {
            if (!prime[i]) continue;
            for (int j = i * 2; j <= 1000000; j += i) prime[j] = false;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        isPrime(); // while 문 안에서 매 번 소수를 계산하기 보단, 미리 정해진 1,000,000 수 내의 소수를 구하고 시작하면 시간 효율이 좋아짐

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            int cnt = 0;
            for (int i = 2; i <= N/2; i++) { // 문제에서 '두 소수의 순서만 다른 것은 같은 파티션이다' 이 부분 때문에 생각한 부분입니다.
                // 결국 합이 같은 소수가 위치만 다르게 반복되는 경우가 존재하는 걸 방지해서 절반만 루프를 돌게 합니다.
                if (prime[i] && prime[N-i]) cnt++;  // N = (순차적)소수 + (합을 뺀) 소수를 카운트해주면 됩니다.
            }
            System.out.println(cnt);

        }
    }
}
