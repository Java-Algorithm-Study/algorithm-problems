import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * [14888] 연산자 끼워 넣기
 * https://www.acmicpc.net/problem/14888
 *
 * -아이디어
 * 1. N개의 숫자와 N-1개의 연산자가 주어진다.
 * 2. 연산자를 중복 없이 순서 상관 있게 나열한다 -> 순열
 * 3. 각 값이 나올 때마다 최소, 최대 비교를 해서 결과값을 저장한다.
 *
 * -시간 복잡도
 * 1.
 *
 * -자료 구조
 * 1.
 */

public class Boj14888 {
    private static int n;
    private static int[] nums, operator;
    private static boolean[] visited;
    private static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        nums = new int[n];
        operator = new int[10];
        visited = new boolean[10];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int idx = 0;
        for (int i = 0; i < 4; i++) {
            int cnt = Integer.parseInt(st.nextToken());
            for (int j = 0; j < cnt; j++) {
                operator[idx++] = i;
            }
        }

        dfs(nums[0], 1, 0);
        System.out.println(max);
        System.out.println(min);
    }

    private static void dfs(int num, int idx, int level) {
        if (level == n - 1) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }

        int result = 0;

        for (int i = 0; i < n-1; i++) {
            if(visited[i]) {
                continue;
            }
            visited[i] = true;
            switch (operator[i]) {
                case 0:
                    result = num + nums[idx];
                    break;

                case 1:
                    result = num - nums[idx];
                    break;

                case 2:
                    result = num * nums[idx];
                    break;

                case 3:
                    result = num / nums[idx];
                    break;
            }
            dfs(result, idx + 1, level + 1);
            visited[i] = false;
        }
    }
}
