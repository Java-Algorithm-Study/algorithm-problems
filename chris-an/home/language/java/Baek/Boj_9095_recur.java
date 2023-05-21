package language.java.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_9095_recur {

    // baseCase 와, recur 쪽을 어떻게 구현할지?, 그리고 초기값을 무엇으로 시작할지.
    // recur 를 어떤식으로 루프를 도느냐에 따라, main 쪽 첫 메서드 호출 부분이 달라짐
    // 1, 2, 3 더하기 재귀로 풀기
    // 정수 3개를 사용
    static int cnt;
    public static void recur(int N, int temp) {

        // base case 구현
        if (temp > N) { // 수가 넘어갈 경우, return
            return;
        }else if (temp == N) {  // 정수 N일 때 카운트를 해준다.
            cnt++;
            return;
        }

        // recur 구현
        for (int i = 1; i <= 3; i++) { // 1,2,3을 하나씩 더하는 개념
            recur(N,  temp += i); // 더해주다가 수가 넘어갈 수 있음.
            temp -= i; // 빼주지 않으면 루프가 비정상적으로 돔.
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            cnt = 0;
            recur(N, 0);// 루프를 돌아 찾아야할 기준 N과 쌓일 초기화를 해줍니다.
            System.out.println(cnt);
        }
    }
}
