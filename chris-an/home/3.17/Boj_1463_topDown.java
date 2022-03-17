
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Top-down 방식.
public class Boj_1463_topDown {

    private static int[] dpTable;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dpTable = new int[N + 1];
        System.out.println(makeToOne(N));
    }

    private static int makeToOne(int n) {
        if (n == 1) return 0; // 초깃값은 1~N 까지라, N이 1 일때, 초깃값 0으로 리턴
        if(dpTable[n] > 0) return dpTable[n]; // DP 테이블에 저장되어있는 값들을 리턴해줍니다. '메모이제이션' 또는 '캐싱'이라 불리움.

        dpTable[n] = makeToOne(n - 1)+1; // An = An-1 + 1 을 기본적인 점화식으로 세팅해 둘 수 있다.
        // 위의 점화식이 나올 수 있는 이유를 예시로 들면
        // 4라는 숫자는 3 에다가 '1을 뺀다'라는 조건을 사용하여 최종 1을 만들 수 있어서 그렇다.


        // 이 두 if문 로직은 위의 점화식으로 세팅을 하고도 최소값이 나올 수 있기 때문에 처리를 해줍니다.
        // 즉 점화식은, 최소값을 뽑을 수 있는 식이 아니고
        // 만약 N이 3과 2를 나눌수 있을 시 최소값이 달라기질 수 있기 때문입니다.
        if (n % 3 == 0) {
            int count = makeToOne(n / 3) + 1; // 먼저 3을 나눈 뒤, 3을 나눈 과정이 '1'횟수 증가를 한 부분이기 때문에 +1를 해줍니다.
            if(count < dpTable[n]) dpTable[n] = count;  // 기본 점화식으로 세팅해준 DP 테이블 값과, 위의 3으로 나눌 수 있는 N을 먼저 3으로 나누고 처리한 값과 비교를 합니다.
        }
        if (n % 2 == 0) {
            int count =  makeToOne(n / 2) + 1; // 위와 동일
            if(count < dpTable[n]) dpTable[n] = count;
        }

        return dpTable[n];
    }
}
