import java.util.Scanner;

// 퀸 공격 칸 : 대각선, 같은 행, 같은 열
// 2행 3열에 있다면
// 둘러싼 칸: (1,3), (1,4), (2,2), (2,4), (3,2), (3,3), (3,4),
// 대각선 : 좌측 싱-우측하 (1,2), (0,1) - (3r 4c), (4r 5c), (5r 6c), (6r 7c) 좌측 하-우측 상 (3r 2c), (4r 1c) (5r 0c) - (1r 4c), (0r 5c)
// 같은 행 : 좌 (2r 2c), (2r 1c), (2r 0c), 우 (2r 4c), (2r 5c), (2r 6c), (2r 7c)
// 같은 열 : 상 (1r 3c), (0r 3c) 하 (3r 3c),(4r 3c),(5r 3c),(6r 3c), (7r 3c)
// 모두 공격 가능

// ★ 2차원 배열로 생각하지 않고, index가 행, 값이 열인 1차원 배열로 둔다.
// 행을 기준으로 채워나간다.
public class boj_9663_09 {
    static int N;
    static int[] board;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        board = new int[N];
        // 퀸을 놓고 두면 안되는 곳을 모두 true 처리 한다.
        // 그 다음 퀸을 놓는데, true처리가 안된 곳 + 범위를 벗어나지 않는 곳에 놓아야 한다.
        // 이것을 N번 두면 경우의수+1이 된다.
        checkQueen(0);
        System.out.print(answer);
    }
    static int answer=0;
    private static void checkQueen(int row) {
        if (row == N) {
            answer++;
            return;
        }
        for (int c=0; c<N; c++) {
            board[row] = c;   // 현재 상태
            if (isPossible(row)) checkQueen(row+1); // 현재 행 전달
        }
    }
// 행이 row, 열이 col
    // index가 열, 값이 행
    private static boolean isPossible(int row) {
        for (int i=0; i<row; i++) {
            if (board[row]== board[i]) return false;
            else if (Math.abs(row-i) == Math.abs(board[row]-board[i])) return false;
        }
        return true;
    }
}
