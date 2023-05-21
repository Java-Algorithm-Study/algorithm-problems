package language.java.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_13398_1 {
    static int [] dpLeftToRight;
    static int [] dpRightToLeft;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dpLeftToRight = new int[N+1];
        dpRightToLeft = new int[N+1];
        int [] arr = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dpLeftToRight[0] = arr[0];
        dpRightToLeft[N-1] = arr[N-1];

        // 왼쪽에서 오른쪽 방향으로
        int max = arr[0];
        for (int i = 1; i < N; i++) {
            dpLeftToRight[i] = Math.max(arr[i], dpLeftToRight[i-1] + arr[i]);
            max = Math.max(max, dpLeftToRight[i]);
        }
        // 오른쪽에서 왼쪽방향으로
        for (int i = N-2; i >= 0; i--) { // N-1은 초기화가 되어있음.
            dpRightToLeft[i] = Math.max(arr[i], dpRightToLeft[i+1] + arr[i]);
            // 여기서는 굳이 max 세팅을 하지 않아도 됩니다.
        }

        for (int i = 1; i < N-1; i++) { // 1부터 N-1까지입니다 why? i-1,i+1일때, 0일 때, 인덱스-1을 조회를 하고 N일 때, 인덱스 N+1을 조회해서, ArrayIndexOutOfBoundsException 에러 발생합니다.
            int excludeOfNum = dpLeftToRight[i-1] + dpRightToLeft[i+1];// 이렇게 하면 수 i인, 1개를 제외한 수열의 최대 합을 찾을 수 있습니다.

            max = Math.max(max, excludeOfNum);
        }
        System.out.println(max);
    }
}
