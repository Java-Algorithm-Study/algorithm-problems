package language.java.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;


public class Boj_14002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int target[] = new int[N + 1]; // 입력 받은 수열의 길이 +1
        int DP[] = new int[N + 1];
        Arrays.fill(DP, 1); // 최소 배열은 길이가 1이니 전체 초기화

        for (int i = 1; i < target.length; i++) {
            target[i] = Integer.parseInt(st.nextToken());
        }

        int max = 1;
        for (int i = 2; i < DP.length; i++) {
            for (int j = 1; j < i; j++) { // 차례대로 idx i의 전 j들을 비교하여 길이를 + 시켜줍니다.
                if (target[i] > target[j] && DP[j]+1 > DP[i]) { // 값을 비교 해주고, 길이도 비교를 해줘야합니다. 현재 저장된 수열의 길이보다 작아야합니다.
                    DP[i] = DP[j] + 1;
                }
            }
            max = Math.max(max, DP[i]); // max 값을 갱신해줍니다
        }

        Stack<Integer> stk = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int chk = max;
        for (int i = N; i > 0; i--) {
            if (chk == DP[i]) { // max 값부터 하나씩 차감을하여, 해당 위치에있는 idx 을 스택에 담습니다.
                stk.push(target[i]);
                chk--;
            }
        }

        while (!stk.empty()) sb.append(stk.pop()+" ");

        System.out.println(max);
        System.out.println(sb);
    }
}