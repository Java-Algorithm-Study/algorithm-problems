package language.java.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Coordinate___ {
    int x, y;
    Coordinate___(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Boj_7562 {

    static int I;
    static int x, y; // 초기 좌표
    static int targetX, targetY; // 찾는 좌표
    static boolean[][] visited; // 방문처리
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[][] map;
    //    static ArrayList<Integer> finishList = new ArrayList<>();
    static Queue<Coordinate___> qu;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            I = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            targetX = Integer.parseInt(st.nextToken());
            targetY = Integer.parseInt(st.nextToken());


            map = new int[I][I];
            visited = new boolean[I][I];
            visited[x][y] = true;


            qu = new LinkedList<>();
            qu.offer(new Coordinate___(x, y));

            if (!(x == targetX && y == targetY)) bfs();
            System.out.println(map[targetX][targetY]);


//            Collections.sort(finishList);
//            System.out.println(finishList.get(0));
//            System.out.println(finishList.get(finishList.size())-1);
        }
    }
    private static void bfs() {
        while (!qu.isEmpty()) {
            Coordinate___ point = qu.poll();

            for (int i = 0; i < 8; i++) {
                int newX = point.x + dx[i];
                int newY = point.y + dy[i];

                if (newX >= 0 && newX < I && newY >= 0 && newY < I && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    qu.offer(new Coordinate___(newX, newY));
                    map[newX][newY] = map[point.x][point.y] + 1;

//                    if (newX == targetX && newY == targetY)
//                        finishList.add(map[newX][newY]);
                }
            }
        }
    }
}
