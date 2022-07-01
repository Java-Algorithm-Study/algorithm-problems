package Implementation.String;
import java.io.*;
/*
- 아이디어
 지뢰이면서 열린칸 : * 면서 . -> *
 지뢰아니면서 열린칸 : . 면서 x -> 숫자
 지뢰이면서 닫힌칸 : * 면서 . -> .
 지뢰아니면서 닫힌칸 : . 면서 . -> .
 지뢰이면서 열린칸이 나오면 모두 *표시해야함.
- 시간
  초기:IDE x, 초기 세팅 후:IDE o -> 1h10m (실버5)
 */
public class boj_4396_지뢰찾기 {
    private static final int OPENED_LAND_MINE = -1;
    private static final int OPENED_NO_LAND_MINE = -2;
    private static final int CLOSED_LAND_MINE = -3;
    private static final int CLOSED_NO_LAND_MINE = -4;
    private static final char LAND_MINE = '*';
    private static final int NO_LAND_MINE = '.';

    private static int[][] dirXY = {{-1,-1}, {-1,0}, {-1,1}, {0,1}, {1,1}, {1,0}, {1,-1}, {0,-1}};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] grid = new int[n][n];
        // 1번째 nxn
        for (int i=0; i<n; i++) {
            String line = br.readLine();
            for (int j=0; j<n; j++) {
                grid[i][j] = line.charAt(j);
            }
        }
        // 2번째 nxn
        //지뢰가 있는 칸이 열렸다면 지뢰가 있는 모든 칸이 별표(*)로 표시되어야 한다.
        boolean isLandMineOpened = false;
        for (int i=0; i<n; i++) {
            String line = br.readLine();
            for (int j=0; j<n; j++) {
                // 열려있고
                if (line.charAt(j) == 'x') {
                    // 지뢰 OX?
                    if (grid[i][j] == NO_LAND_MINE) grid[i][j] = OPENED_NO_LAND_MINE;
                    else if (grid[i][j] == LAND_MINE) {
                        grid[i][j] = OPENED_LAND_MINE;
                        isLandMineOpened = true;
                    }
                }
                // 닫혀있고
                else if (line.charAt(j) == '.') {
                    // 지뢰 OX?
                    if (grid[i][j] == NO_LAND_MINE) grid[i][j] = CLOSED_NO_LAND_MINE;
                    else if (grid[i][j] == LAND_MINE) grid[i][j] = CLOSED_LAND_MINE;
                }
            }
        }
        // 출력하기
        StringBuilder sb = new StringBuilder();
        for (int r=0; r<n; r++) {
            sb.setLength(0);
            for (int c=0; c<n; c++) {
                int nowStatus = grid[r][c];
                // 지뢰가 없으면서 열린 칸에는 0과 8 사이의 숫자가 있어야 한다.
                if (nowStatus == OPENED_NO_LAND_MINE) {
                    // 근처 지뢰 갯수 찾기
                    int landMineCnt = 0;
                    for (int adj=0; adj<8; adj++) {
                        int adjRow = r+dirXY[adj][0];
                        int adjCol = c+dirXY[adj][1];
                        if (isOutOfBounds(adjRow, adjCol, n)) continue;
                        if (grid[adjRow][adjCol] == OPENED_LAND_MINE || grid[adjRow][adjCol] == CLOSED_LAND_MINE) {
                            landMineCnt++;
                        }
                    }
                    sb.append(landMineCnt);
                }
                // 다른 모든 지점은 온점(.)이어야 한다.
                else if (nowStatus == OPENED_LAND_MINE) {
                    if (isLandMineOpened) sb.append('*');
                    else sb.append('.');
                }
                else if (nowStatus == CLOSED_LAND_MINE) {
                    if (isLandMineOpened) sb.append('*');
                    else sb.append('.');
                }
                else if (nowStatus == CLOSED_NO_LAND_MINE) sb.append('.');
            }
            System.out.println(sb);
        }
    }

    private static boolean isOutOfBounds(int row, int col, int limit) {
        return row<0 || row>=limit || col<0 || col>=limit;
    }
}