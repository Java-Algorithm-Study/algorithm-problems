package language.java.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_16928 {
    static boolean[] visited = new boolean[101];
    static int[][] moveInfo;

    static class LocateInfo {
        int loc;
        int count;

        public LocateInfo(int loc, int count) {
            this.loc = loc;
            this.count = count;
        }
    }

    static int checkingToClimbTheLadder(int location) {
        for (int i = 0; i < moveInfo.length; i++) {
            if (location == moveInfo[i][0]) {
                return moveInfo[i][1];
            }
        }
        return location;
    }

    static void bfs() {
        Queue<LocateInfo> qu = new LinkedList<>();
        qu.offer(new LocateInfo(1, 0));
        visited[1] = true;

        while (!qu.isEmpty()) {
            LocateInfo currLoc = qu.poll();

            int location = currLoc.loc;

            if (location == 100) {
                System.out.println(currLoc.count);
                return;
            }

            // 주사위 돌리기
            for (int i = 1; i <= 6; i++) {
                int nLoc = location + i;
                // 100이 넘어갈 시 pass, 방문했던 곳이라면 pass
                if (nLoc > 100 || visited[nLoc]) continue;

                int convertLocation = checkingToClimbTheLadder(nLoc);
                // 이동 가능하니 이동 go
                if (convertLocation != nLoc) {
                    visited[convertLocation] = true;
                    qu.offer(new LocateInfo(convertLocation, currLoc.count + 1));
                }else {
                    // 위 과정에 해당 되지 않을 시, 그냥 flow 잇기
                    visited[nLoc] = true;
                    qu.offer(new LocateInfo(nLoc, currLoc.count + 1));
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int ladderCnt = Integer.parseInt(st.nextToken());
        int snakeCnt = Integer.parseInt(st.nextToken());

        moveInfo = new int[ladderCnt+snakeCnt][2];
        for (int i = 0; i < ladderCnt + snakeCnt; i++) {
            st = new StringTokenizer(br.readLine());
            moveInfo[i][0] = Integer.parseInt(st.nextToken());
            moveInfo[i][1] = Integer.parseInt(st.nextToken());
        }
        bfs();
    }
}
