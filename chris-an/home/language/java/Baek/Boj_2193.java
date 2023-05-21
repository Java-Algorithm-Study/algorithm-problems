package language.java.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
    문제를 풀 때, 처음에는 이중 for문과 2차배열을 이용하여 자릿수와 이진수(0,1) 에 카운트를 더해주는 식 방법으로 가려고 하였습니다.
    DP[1][0] 일 때, 1자릿수에 이진 수 숫자 0이 들어갈땐? '0' 이니 당연히 카운트가 되지않아 0개가 될겁니다.
    DP[1][1] 일 때, 위와 동일하지만 숫자 1이 들어가면, '1' 이되어 카운트가 되서 1개로 DP 테이블에 저장
    DP[2][0] 일 때, 2자릿수에 이진수 숫자 0이 들어가면? '00', '01' 이니 카운트가 되서는 안됩니다.
    DP[2][1] 일 때, 2자릿수에 이진수 숫자 1이 들어가면? '10', '11' 이니 '10' 에 한해서 카운트가 되서 1개로 DP 테이블에 저장
    이런식으로 가면,
    여기서 이친수의 성질 0으로 시작하지 않는다는 조건 때문에, DP[N][0] 은 0개가 됩니다.
    즉, 모든 자릿수에는 0이라는 값이 들어가면 안됩니다.
    따라서, DP[N][1] 이진 수 중 '1' 이라는 값만 카운트를 해줘서 DP 테이블에 담아주면 됩니다.
    점화식 규칙은 작은문제부터 큰 문제를 해결하는 방식으로
    DP[N] = DP[N-1] + DP[N-2] 의 규칙으로 갈수 있습니다.
    이 문제는 일차원 배열로 풀 수 있는 문제입니만,
    저는 이차원 배열로 제가 접근하고 이해한 방식으로 풀었습니다 !
 */
public class Boj_2193 {
    //  DP [N][2진수 표현 숫자 0,1]
    static long DP [][] = new long [91][3]; // N 이 90까지이며, 이진수는 0,1 로 이루어져있음

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        DP[1][1] = 1;
        for(int i = 2; i < N+1; i++) { // i 가 2부터 도는건, 아래 구현부 쪽에서 2미만일 경우엔 ArrayIndexOutOfBoundsException 발생으로 위에서 1을 초기화 한 다음에 2부터 시작합니다
            DP[i][1] = DP[i-1][1] + DP[i-2][1];
        }
        System.out.println(DP[N][1]);
    }
}
