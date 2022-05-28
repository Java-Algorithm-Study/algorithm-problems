import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 벽부수고 이동하기4
    // 벽을 중심으로 cnt를 세면, 중복되서 칸을 세게 됨. => 시간초과
    // 1. empty를 기준으로 먼저 grouping한다.
    // - groupedGrid에 groupId를 하나씩 늘려가며 인접하는 칸에 groupId를 대체한다.
    // - groupId의 전체 크기를 HashMap에 <groupId, 전체 크기>로 저장한다.
    // 2. 벽을 만나면 인접한 4칸에 대해 방문하며
    // - 중복되지 않은 groupId가 있다면 set에 넣어준다.
    // - set에서 groupId를 꺼내서, Map의 value를 모두 더해서 전체 인접 칸 합%10 으로 해당 value(1)를 대체한다.
public class boj_16946_24 {
    static final int WALL = 1;
    static int N,M;
    static int[][] grid;
    static int[][] groupedGrid;
    static int[] dirX = {0, -1, 0, 1};
    static int[] dirY = {1, 0, -1, 0};
    static boolean[][] visited;
    static Map<Integer, Integer> groupIdLen  = new HashMap<>();
    public static void main(String[] args) throws IOException {
        init();
        // 1.empty끼리 그룹화하기
        int groupId = 2;
        for (int r=0; r<N; r++) {
            for (int c=0; c<M; c++) {
                if (groupedGrid[r][c] == 0) groupEmpty_bfs(r, c, groupId++);
            }
        }
        // 2. 벽을 만나면 네 방면 체크
        checkMovableCntAndPrint();
    }
    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        grid = new int[N][M];
        groupedGrid = grid;
        visited = new boolean[N][M];
        for (int r=0; r<N; r++) {
            String row = br.readLine();
            for (int c=0; c<M; c++) {
                grid[r][c] = row.charAt(c) - '0';
            }
        }
    }
    private static void checkMovableCntAndPrint() {
        Set<Integer> groupIdSet;
        StringBuilder answerSB = new StringBuilder();
        for (int r=0; r<N; r++) {
            for (int c = 0; c < M; c++) {
                if (grid[r][c] == WALL) {
                    groupIdSet = new HashSet<>();
                    for (int i=0; i<4; i++) {
                        int adjRow = r + dirY[i];
                        int adjCol = c + dirX[i];
                        if (isOutOfBound(adjRow, adjCol)) continue;
                        if (groupedGrid[adjRow][adjCol] == WALL) continue;
                        if (groupIdSet.contains(groupedGrid[adjRow][adjCol])) continue;
                        groupIdSet.add(groupedGrid[adjRow][adjCol]);
                    }
                    int possibleMove = 1;
                    if (!groupIdSet.isEmpty()) {
                        for(int cnt: groupIdSet)
                            possibleMove += groupIdLen.get(cnt);  // groupId의 전체 크기
                    }
                    answerSB.append(possibleMove % 10);
                }
                else answerSB.append(0);
            }
            answerSB.append("\n");
        }
        System.out.println(answerSB);
    }
    private static void groupEmpty_bfs(int r, int c, int groupId) {
        Queue<GridLocationInfo> que = new LinkedList<>();
        que.offer(new GridLocationInfo(r, c));
        int cntLen = 1;
        groupedGrid[r][c] = groupId;
        visited[r][c] = true;
        while (!que.isEmpty()) {
            GridLocationInfo curr = que.poll();
            for (int i = 0; i < dirX.length; i++) {
                int nxtRow = curr.row + dirY[i];
                int nxtCol = curr.col + dirX[i];
                if (isOutOfBound(nxtRow, nxtCol)) continue;
                if (visited[nxtRow][nxtCol]) continue;
                if (grid[nxtRow][nxtCol] == 0) {
                    visited[nxtRow][nxtCol] = true;
                    groupedGrid[nxtRow][nxtCol] = groupId;
                    cntLen++;
                    que.offer(new GridLocationInfo(nxtRow, nxtCol));
                }
            }
        }
        groupIdLen.put(groupId, cntLen);
    }
    private static boolean isOutOfBound(int nxtRow, int nxtCol) {
        return nxtRow<0 || nxtRow>=N || nxtCol<0 || nxtCol >= M;
    }
    private static class GridLocationInfo {
        int row;
        int col;
        GridLocationInfo(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}