import java.util.Scanner;

// 별찍기-12
// N = 3 * 2^k => 3, 6, 12, 24, 48 , ..

// 세로 N, 가로 길이 2N-1
// 24, 47  (가운데이고 index 고려하면 // h = 24 -> 12 -> 6 -> 3

// row는 0 -> 12 -> 18 -> 21
// col은 23 -> 11/35 -> 5/41 -> 2/44
public class boj_2448_15 {
    static char[][] arr;
    public static void main(String[] args) {
        // 1. 초기화 및 공백 채우기
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new char[N][2*N - 1];
        
        for (int i=0; i<N; i++) {
            for (int j=0; j<2*N-1; j++) {
                arr[i][j] = ' ';
            }
        }
        // 2. 별 찍기
        drawStar(0, N-1, N, 0);
        StringBuilder sb = new StringBuilder();
        for(char[] row : arr){
            for (char col: row) {
                sb.append(col);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void drawStar(int r, int c, int h, int count) {
        if (h==3) {
            arr[r][c] = '*';
            arr[r + 1][c - 1] = arr[r + 1][c + 1] = '*';
            arr[r + 2][c - 2] = arr[r + 2][c + 2] = arr[r + 2][c - 1] = arr[r + 2][c + 1] = arr[r + 2][c] = '*';
            /*System.out.println("Count: " + count+ ", 높이: "+h+"/ 현재 r, c: ("+ r+", " +c+")");
            for(char[] row : arr){
                for (char col: row) {
                    System.out.print(col);
                }
                System.out.println();
            }*/
            return;
        }
//        System.out.println("Count: " + count+ ", 높이: "+h+"/ 현재 r, c: ("+ r+", " +c+")");
        // h>3일 때 실행
        // r은 ↓, c는 ->
        drawStar(r, c, h/2, count+1);
        drawStar(r+h/2, c-h/2, h/2, count+1);
        drawStar(r+h/2, c+h/2, h/2, count+1);
    }
}