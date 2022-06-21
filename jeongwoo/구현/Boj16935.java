import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [16935] 배열 돌리기 3 
 * https://www.acmicpc.net/problem/16935
 *
 * -아이디어
 * 1. 1번 연산 : 행 기준으로 변경 0행 -> 5행, 1행 -> 4행, 2행 - > 3행
 * 2. 2번 연산 : 열 기준으로 변경 0열 -> 5열
 * 3. 3번 연산 : arr 열 -> temp 행 / arr 행 -> temp 열 : 전체 행 - 1 - 행
 * 4. 4번 연산 : arr 행 -> temp 열 / arr 열 -> temp 행 : 전체 행 - 1 열
 * 5. 5번 연산 : 구간 나누고 1 -> 2는 x + n/2 ..
 * 6. 6번 연산 : 구간 나누고 1 -> 4는 x + n/1
 *
 */

public class Boj16935 {
    private static int n, m;
    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < r; i++) {
            switch (Integer.parseInt(st.nextToken())) {
                case 1 :
                    one();
                    break;

                case 2 :
                    two();
                    break;

                case 3 :
                    three();
                    break;

                case 4 :
                    four();
                    break;

                case 5 :
                    five();
                    break;

                case 6 :
                    six();
                    break;

            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                sb.append(arr[i][j]).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);
        
    }

    private static void one() {
        int[][] temp = new int[arr.length][arr[0].length];

        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[0].length; j++) {
                temp[(temp.length - 1) - i][j] = arr[i][j];
            }
        }

        arr = temp;
    }

    private static void two() {
        int[][] temp = new int[arr.length][arr[0].length];

        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[0].length; j++) {
                temp[i][(temp[0].length - 1) - j] = arr[i][j];
            }
        }

        arr = temp;
    }

    private static void three() {
        int[][] temp = new int[arr[0].length][arr.length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                temp[j][(arr.length - 1) - i] = arr[i][j];
            }
        }

        arr = temp;
    }

    private static void four() {
        int[][] temp = new int[arr[0].length][arr.length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                temp[(arr[0].length - 1) - j][i] = arr[i][j];
            }
        }

        arr = temp;
    }

    private static void five() {
        int[][] temp = new int[arr.length][arr[0].length];
        int newN = temp.length / 2;
        int newM = temp[0].length / 2;

        // 1 -> 2 : y + m/2
        for (int i = 0; i < newN; i++) {
            for (int j = 0; j < newM; j++) {
                temp[i][j + newM] = arr[i][j];
            }
        }

        // 2 -> 3 : x + n/2
        for (int i = 0; i < newN; i++) {
            for (int j = newM; j < temp[0].length; j++) {
                temp[i + newN][j] = arr[i][j];
            }
        }

        // 3 -> 4 : y - m/2
        for (int i = newN; i < temp.length; i++) {
            for (int j = newM; j < temp[0].length; j++) {
                temp[i][j - newM] = arr[i][j];
            }
        }

        // 4 -> 1 : x - n/2
        for (int i = newN; i < temp.length; i++) {
            for (int j = 0; j < newM; j++) {
                temp[i - newN][j] = arr[i][j];
            }
        }

        arr = temp;
    }

    private static void six() {
        int[][] temp = new int[arr.length][arr[0].length];
        int newN = temp.length / 2;
        int newM = temp[0].length / 2;

        // 1 -> 4 : x + n/2
        for (int i = 0; i < newN; i++) {
            for (int j = 0; j < newM; j++) {
                temp[i + newN][j] = arr[i][j];
            }
        }

        // 4 -> 3 : y + m/2
        for (int i = newN; i < temp.length; i++) {
            for (int j = 0; j < newM; j++) {
                temp[i][j + newM] = arr[i][j];
            }
        }

        // 3 -> 2 : x - n/2
        for (int i = newN; i < temp.length; i++) {
            for (int j = newM; j < temp[0].length; j++) {
                temp[i - newN][j] = arr[i][j];
            }
        }

        // 2 -> 1 : y - m/2
        for (int i = 0; i < newN; i++) {
            for (int j = newM; j < temp[0].length; j++) {
                temp[i][j - newM] = arr[i][j];
            }
        }

        arr = temp;
    }
}
