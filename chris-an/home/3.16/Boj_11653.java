import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 소인수 분해 정의는 합성수를 소수들의 곱으로 나타낸 것을 말합니다.
// 또한 모든 합성수는 소인수분해된 형태를 갖는다는 산술의 기본정리에서 증명된 조건


public class Boj_11653 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 2; i <= N; i++) {
            while (true) {
                if (N % i == 0) {
                    N = N / i;
                    System.out.println(i);
                } else break;

            }
        }
    }
}


/*
public class Boj_11653 {
    static boolean [] prime;
    static final int N = 10000000;

    static void isPrime() {
        prime = new boolean[N+1];

        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        for (int i = 2; i <= N; i++) {
            if (!prime[i]) continue;
            for (int j = i*2; j <= N; j+=i) prime[j] = false;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        Queue<Integer> qu = new LinkedList<>();
        isPrime();
        for (int i = 2; i <= input; i++) {
            while (true) {
                if (prime[i] && (input % i) == 0) {
                    input = input / i;
                    qu.offer(i);
                }else break;
            }
            if (input == 0) break;
        }

        while (!qu.isEmpty()) System.out.println(qu.poll());
    }
}
*/


