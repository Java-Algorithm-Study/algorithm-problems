package language.java.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_11726 {

    static int dp [];

    public static int fibo(int n) {
        // * 여기서도 10007를 나눠주지 않을 시, d[n]에 담긴 값이 틀어집니다.
        // 마지막에만 출력쪽에만  %10007 연산을 해줄 시 중간에 저장되는 값들이 int 값을 넘어서므로 오버플로우가 발생하기 때문이다.
        // Top-Bottom 방식의 단점의 예입니다..
        if(dp[n] > 0) return dp[n] %= 10007;
        if(2 > n) return dp[n] = n % 10007; // 메모이제이션 되어있는 값 가져오기.즉, 한번 거친 연산은 dp에 저장되어있어서 가져옴.
        return dp[n] = fibo(n-1) + fibo(n-2);
    }

    public static void main(String[] args) throws IOException {

        // 그림을 그려보면 피보나치 수열이다.
        // 일단 점화식은 An = An-1 + An-2 이다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()) + 1; // 피보나치 수열 인덱싱 맞추기.
        dp = new int[N+1];

        // N은 피보나치수열의 인덱스번호이다.
        dp[0] = 0;
        dp[1] = 1;
        fibo(N);

        System.out.println(dp[N] % 10007);
    }
}


/*

// Bottom-Up 방식
        for(int i = 0; i < fibonacci.length; i++) {
            if(i == 0) fibonacci[0] = 0;
            else if(i == 1) fibonacci[1] = 1;
            else fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }

 */