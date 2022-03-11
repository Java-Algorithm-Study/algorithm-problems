import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 골드바흐의 추측
// 1. 6 <= 짝수 N <= 100만
// 2. N =  홀수 A + B (B-A가 가장 큰 경우를 출력)
// 3. N이 될 A,B가 없다면 "Goldbach's conjecture is wrong." 출력
// 4. 0이 입력되면 종료
public class boj_6588 {
    static final int LIMIT = 1000001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        // 1.소수만 false 표시하기 : 에라토스테네스의 체
        // 100만까지의 소수를 구하기위해 100만 배열 생성 (아래에서도 인덱스 0,1에는 접근하지 않으므로초기화x)
        boolean[] nonPrime = new boolean[LIMIT];

        for (int i=2; i*i < LIMIT; i++) {
            if (!nonPrime[i]) {  // 소수라면
                //소수가 아닌 곳 표시
                for(int j=i*i; j< LIMIT; j+=i) nonPrime[j] = true;
            }
        }
        // 2. N = a+b 경우 찾기
        // nonPrime[i] = false인 i가 소수!
        int b;
        int input;
        while (true) {
            input = Integer.parseInt(br.readLine());
            if (input == 0) break;
            // 3부터 N-3까지인 수의 조합으로 N을 만드는 홀수 a,b 찾기 (크기가 제일 큰)
            for (int a = 3; a <= input - 3; a += 2) {
                b = input - a;
                if (!nonPrime[a] && !nonPrime[b]) {  // 둘다 소수이면
                    // 가장 첫번째 소수 a,b의 diff가 가장 크므로 바로 break
                    sb.append(input).append(" = ").append(a).append(" + ").append(b);
                    break;
                }
            }
            if (sb.length() == 0) System.out.println("Goldbach's conjecture is wrong.");
            else {
                System.out.println(sb);
                sb.setLength(0);
            }
        }
    }
}
