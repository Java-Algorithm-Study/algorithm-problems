import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2보다 큰 짝수
//짝수를 만드는 소수의 합을 구한다.
// N=4인 경우 제외하고
// 반복하며 수를 구한다. (반복 시작, 종료 중요)
public class boj_17103 {
    static final int LIMIT = 1000001;
    static boolean[] nonPrime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        // 1.소수는 false, 소수x는 true 표시하기 : 에라토스테네스의 체
        // 100만까지의 소수를 구하기위해 100만 배열 생성 (아래에서도 인덱스 0,1에는 접근하지 않으므로초기화x)
        nonPrime = new boolean[LIMIT];
        for (int i=2; i*i < LIMIT; i++) {   // 내부 for문을 위해 i*i 로 제한둔다.
            if (!nonPrime[i]) {  // 소수라면
                //소수가 아닌 곳 표시
                for(int j=i*i; j< LIMIT; j+=i) nonPrime[j] = true;  // 소수*소수, 소수*소수+소수 -> 소수가 아닌 곳을 모두 체크할 수 있음
            }
        }
        while (T-- >0) {
            int N = Integer.parseInt(br.readLine());  // 2< 2N <= 1000000
            getAnswer(N);
        }
    }

    // 2. N = a+b 경우 찾기
    // nonPrime[i] = false인 i가 소수!
    private static void getAnswer(int N) {
        int cnt = 0;
        if (N==4) {
            System.out.println(1);
            return;
        }
        // 2부터 N/2까지인 수의 조합으로 N을 만드는 소수 찾기
        for (int a=3; a<= N/2; a+=2) {
            if (!nonPrime[a] && !nonPrime[N-a]) {  // 둘다 소수이면
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
