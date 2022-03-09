import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1934 {

    /*
        최소 공배수
        두 자연수 A와 B에 대해서, A의 배수이면서 B의 배수인 자연수를 A와 B의 공배수라고 한다.
        이런 공배수 중에서 가장 작은 수를 최소공배수라고 한다.
        예를 들어, 6과 15의 공배수는 30, 60, 90등이 있으며, 최소 공배수는 30이다.
     */

    // 최소공배수 : 최대공배수 * (최소공배수*(a/최소공배수) * (최소공배수*(b/최소공배수)

    /*
        유클리드 호제법이란?
        유클리드 호제법은 큰 두수가 있을 때, 최대 공약수를 구하기 위해 사용된다.
     */

    static int euclid(int a, int b) {
        if (b == 0) return a;
        return euclid(b, a % b);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int orderCnt = Integer.parseInt(br.readLine());

        while(orderCnt-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int gcd = euclid(Math.max(a, b), Math.min(a, b));
            sb.append(gcd * (a / gcd) * b / gcd).append("\n");
        }

        System.out.println(sb);
    }
}
