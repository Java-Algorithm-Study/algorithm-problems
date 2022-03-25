import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * [17103] 골드바흐 파티션
 * https://www.acmicpc.net/problem/17013
 *
 * -아이디어
 * 1. n/2까지 돌면서 소수를 찾는다.
 * 2. n - 찾은 소수가 소수인지 판별한다.
 * 3. 맞다면 cnt++
 *
 * -시간 복잡도
 * 1. O(T*N/2)
 * 2. 시간 초과 뜸: 소수를 하나씩 판별하지 말고, 아리스토테네스 체를 이용해서 전체 범위에 대한 소수를 구해 놓고 판별하는 게 더 나음.
 *
 */

public class Boj17103 {
    private static boolean[] prime = new boolean[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        isPrime(1000000);

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i : arr) {
            int cnt = 0;
            for (int j = 2; j <= i/2; j++) {
                if (prime[j] && prime[i - j])
                    cnt++;
            }
            sb.append(cnt).append('\n');
        }
        System.out.println(sb.toString());
    }

    private static boolean isPrime(int x) {
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;

        for (int i = 2; i * i <= x; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= x; j += i) {
                    prime[j] = false;
                }
            }
        }
        return prime[x];
    }

}
