import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1932_2 {
    static int DP [][];
    static int arr [][];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int H = Integer.parseInt(br.readLine());
        DP = new int[H][H];
        arr = new int[H][H];

        // 2차원 배열에 직각삼각형을 x, y 사각 테이블 표에 담는다고 생각합니다.
        StringTokenizer st;
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                //System.out.println(arr[i][j]);
            }
        }
        // 제일 윗값 초기화
        DP[0][0] = arr[0][0];

        // 하나 씩 DP 세팅
        for (int i = 1; i < H; i++) {
            for (int j = 0; j <= i; j++) {
                if (j > 0) {
                    DP[i][j] = DP[i-1][j-1] + arr[i][j];
                }

                DP[i][j] = Math.max(DP[i][j], DP[i-1][j] + arr[i][j]);
            }
        }

        // 층간 최대값 구하기
        int max = DP[H-1][0];
        for (int i = 1; i < H; i++) {
            max = Math.max(max, DP[H-1][i]);
        }

        System.out.println(max);
    }
}
