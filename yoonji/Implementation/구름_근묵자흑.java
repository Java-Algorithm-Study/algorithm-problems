package Implementation;
// - 문제이해
// 길이 N개의 수열 (1~N의 숫자로 구성)
// 연속된 K개 정수 골라서 그중 최솟값으로 값을 변경한다.
// 수열을 모두 같은 수로 만들고자 할 때, 최소 몇번 골라야하는가?
// 예) 2 3 1 4
// 1 1 1 4
// 1 1 1 1 => 2번만에!
// - 조건
// 길이 N: 2이상10만이하
// K: 2~N이하
// 예2) K=3, N=8,  랜덤 수열 (7 3 1 8 4 6 2 5)
// 최소: 1
// 1 1 1 8 4 6 2 5
// 1 1 1 1 1 6 2 5
// 1 1 1 1 1 1 1 5
// 1 1 1 1 1 1 1 1
// - 아이디어
// 1~N이므로, 최소는 무조건 1.
// 한번은 무조건 수행되고, 그 후는 나눗셈의 몫과 나머지로 구할 수 있다.
// 그려보면서 규칙을 찾았다.
import java.io.*;
public class 구름_근묵자흑 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        int removeCnt = 1;
        if (N > K) {
            N -= K;
            removeCnt += N / (K - 1);
            int remainder = N % (K - 1);
            removeCnt += (remainder == 0) ? 0 : 1;
        }
        System.out.println(removeCnt);
    }
}
