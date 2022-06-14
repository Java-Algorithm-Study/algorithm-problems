import java.util.Scanner;

// 별 찍기-10
public class boj_2447_14 {
    static char[][] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new char[N][N];
        printStar(0, 0, N, false);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void printStar(int x, int y, int size, boolean isBlank) {
        // 1. 빈 공간 : ' '만 채우고 리턴.
        if (isBlank) {
            for (int i=x; i<x+size; i++) {
                for (int j=y; j<y+size; j++) {
                    arr[i][j] = ' ';
                }
            }
            return;
            // size=9인 때
            // 9행 9,10,11,12,13,14,15,16,17열
            // 10행 9,10,11,12,13,14,15,16,17열
            //..
            // 17행 9,10,11,12,13,14,15,16,17열
        }

        // 2. '*' : size가 1일 때까지 재귀로 호출하다가 size가 1이 되면 그때 하나씩 '*' 찍으면서 리턴하여 재귀 스택이 줄어듦
        if (size == 1) {
            arr[x][y] = '*';
            return;
        }

        int blockSize = size /3;
        int count = 0;
        for (int i=x; i<x+size; i+=blockSize) {
            for (int j=y; j<y+size; j+= blockSize) {
                count++;
                printStar(i, j, blockSize, count == 5);
            }
        }
    }
}