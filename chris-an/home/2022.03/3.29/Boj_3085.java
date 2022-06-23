import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_3085 {
    static char[][] arr;

    // 갯수를 카운트하는 메서드
    static public int check(char[][] arr, int rowSt, int rowEnd, int colSt, int colEnd) {
        int result = Integer.MIN_VALUE;

        // 열
        /*  탐색 시작
            →  →  →
            →  →  →
         */
        for (int i = rowSt; i <= rowEnd; i++) {
            int cnt = 1; // 1부터 시작 갯수 1초기화
            for (int j = 1; j < arr.length; j++) {
                if (arr[i][j] == arr[i][j - 1]) {
                    cnt += 1;
                } else
                    cnt = 1; // 리셋

                if (cnt > result) result = cnt;
            }
        }

        // 행
        /*
             탐색 시작
             ↓  ↓
             ↓  ↓
             ↓  ↓
         */
        for (int i = colSt; i <= colEnd; i++) {
            int cnt = 1; // 1부터 시작 갯수 1초기화
            for (int j = 1; j < arr.length; j++) {
                if (arr[j][i] == arr[j - 1][i]) {
                    cnt += 1;
                } else
                    cnt = 1; // 리셋

                if (cnt > result) result = cnt;
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new char[N][N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        }


        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 열
                if (N > i + 1) {
                    char temp = arr[i][j];
                    arr[i][j] = arr[i + 1][j];
                    arr[i + 1][j] = temp;

                    int tmp = check(arr, i, i + 1, j, j);
                    if (max < tmp) max = tmp; // 최댓값 갱신

                    temp = arr[i][j];
                    arr[i][j] = arr[i + 1][j];
                    arr[i + 1][j] = temp;
                }

                // 행
                if (N > j + 1) {
                    // 교환작업
                    char temp = arr[i][j];
                    arr[i][j] = arr[i][j + 1];
                    arr[i][j + 1] = temp;
                    // 갯수 카운트를 합니다 !
                    int tmp = check(arr, i, i, j, j + 1);
                    if (max < tmp) max = tmp; // 최대값으로 갱신

                    // 교환작업한 걸 원상복구
                    temp = arr[i][j];
                    arr[i][j] = arr[i][j + 1];
                    arr[i][j + 1] = temp;
                }
            }
        }
        System.out.println(max);
    }
}