import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 두 동전
public class boj_16197_05 {
    static int[][] board;
    static int N,M;
    static final int WALL = -1;
    static int[][] dir = {{0,1}, {0,-1}, {-1,0}, {1,0}};
    public static void main(String[] args) throws IOException {
        // 1. 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        int[][] coinInfo = new int[2][2];
        int idx = 0;
        for (int r=0; r<N; r++) {
            st = new StringTokenizer(br.readLine(), "");
            String boardStatus = st.nextToken();
            for (int c=0; c<M; c++) {
                switch(boardStatus.charAt(c)) {
                    case '#': board[r][c] = WALL; break;
                    case 'o':
                        coinInfo[idx][0] = r;
                        coinInfo[idx][1] = c;
                        idx++;
                }
            }
        }
        // 2. 최소의 버튼횟수 구하기
        bfs(coinInfo[0][0], coinInfo[0][1], coinInfo[1][0], coinInfo[1][1], 0);
        if (minBtnCnt == 11) minBtnCnt=-1;
        System.out.println(minBtnCnt);
    }
    static int minBtnCnt = 11;
    private static void bfs(int coinAR, int coinAC, int coinBR, int coinBC, int btnCnt) {
        if (btnCnt > 10) {
            return;
        }
        for (int i=0; i<4; i++) {
            if (isOneCoinOut(coinAR+dir[i][0], coinAC+dir[i][1], coinBR+dir[i][0], coinBC+dir[i][1])) {
                minBtnCnt = Math.min(minBtnCnt, btnCnt+1);
                return;
            }
            if (!isInBounds(coinAR+dir[i][0], coinAC+dir[i][1]) && !isInBounds(coinBR+dir[i][0], coinBC+dir[i][1])) continue;
            if (areBothWall(coinAR+dir[i][0], coinAC+dir[i][1], coinBR+dir[i][0], coinBC+dir[i][1])) continue;
            int nCoinAR = coinAR+dir[i][0]; int nCoinAC = coinAC+dir[i][1];
            int nCoinBR = coinBR+dir[i][0]; int nCoinBC = coinBC+dir[i][1];

            if (isWall(nCoinAR,nCoinAC)) {
                nCoinAR =coinAR;
                nCoinAC =coinAC;
            }
            if (isWall(nCoinBR,nCoinBC)) {
                nCoinBR = coinBR;
                nCoinBC = coinBC;
            }
            bfs(nCoinAR, nCoinAC, nCoinBR, nCoinBC, btnCnt+1);
        }
    }
    private static boolean isWall(int r, int c) {
        return board[r][c] == WALL;
    }
    private static boolean areBothWall(int aRow, int aCol, int bRow, int bCol) {
        return isWall(aRow, aCol) && isWall(bRow,bCol);
    }
    private static boolean isOneCoinOut(int aRow, int aCol, int bRow, int bCol) {
        if ((isInBounds(aRow, aCol) && !isInBounds(bRow, bCol)) ||
                (!isInBounds(aRow, aCol) && isInBounds(bRow, bCol))) return true;
        return false;
    }
    private static boolean isInBounds(int r, int c) {
        return r>=0 && r<N && c>=0 && c<M;
    }
}