package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [2089] -2진수
 * https://www.acmicpc.net/problem/2089
 *
 * -아이디어
 * 1. 2진수처럼 -2로 주어진 숫자를 나눈다.
 * 2. 나머지가 -1인 경우에는 나머지가 1이 되어야 하니까 -1을 곱한다.
 * 3. -1인 경우의 몫에 1을 더한다.
 *
 * -시간 복잡도
 * 1. O(n) 이하
 *
 */

public class Boj2089 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String ans = "";

        if (n == 0) {
            System.out.println(0);
        }

        while(n != 0) {
            if(n % -2 == -1) {
                ans = ((n % -2) * -1) + ans;
                n = (n / -2) + 1;
            }
            else {
                ans = (n % -2) + ans;
                n= n / -2;
            }
        }

        System.out.println(ans);

    }
}
