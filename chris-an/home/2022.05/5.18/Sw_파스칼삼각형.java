import java.util.Scanner;

public class Sw_파스칼삼각형 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int i = 1; i <= T; i++) {
            int N = sc.nextInt();
            int[][] map = new int[N][N];
            map[0][0]= 1;
            for (int j = 1; j < N; j++) {
                map[j][0] = 1;
                for (int k = 1; k <= j - 1; k++) {
                    map[j][k] = map[j - 1][k - 1] + map[j - 1][k];
                }
                map[j][j] = 1;
            }
            System.out.println("#" + i);
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < j + 1; k++) {
                    System.out.print(map[j][k] + " ");
                }
                System.out.println();
            }
        }
    }
}
