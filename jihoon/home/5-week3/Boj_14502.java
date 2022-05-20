import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_14502 {
    private static int N;
    private static int M;
    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, 1, 0, -1};
    private static int maxSafeArea = 0;
    
    private static class Virus {
        int x;
        int y;
    
        public Virus(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public static int[][] copy(int[][] original) {
        int[][] answer = new int[original.length][original[0].length];
        for (int i = 0; i < original.length; i++) {
            for (int j = 0; j < original[0].length; j++) {
                answer[i][j] = original[i][j];
            }
        }
        return answer;
    }
    
    public static void constructWall(int depth, int[][] map) {
        if (depth == 3) {
            findVirus(copy(map));
            return;
        }
    
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    constructWall(depth + 1, map);
                    map[i][j] = 0;
                }
            }
        }
    }
    
    public static void printMap(int[][] map) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(map[i][j]).append(' ');
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    
    public static void findVirus(int[][] map) {
        ArrayList<Integer> xCoordinates = new ArrayList<>();
        ArrayList<Integer> yCoordinates = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 2) {
                    xCoordinates.add(i);
                    yCoordinates.add(j);
                }
            }
        }
        spreadVirus(xCoordinates, yCoordinates, map);
        int safeArea = countZeros(map);
        maxSafeArea = Math.max(maxSafeArea, safeArea);
    }
    
    public static void spreadVirus(ArrayList<Integer> xCoordinates, ArrayList<Integer> yCoordinates, int[][] map) {
        Queue<Virus> q = new LinkedList<>();
        for (int i = 0; i < xCoordinates.size(); i++) {
            q.offer(new Virus(xCoordinates.get(i), yCoordinates.get(i)));
        }
    
        while (!q.isEmpty()) {
            Virus current = q.poll();
            int x = current.x;
            int y = current.y;
    
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (map[nx][ny] == 0) {
                    map[nx][ny] = 2;
                    q.offer(new Virus(nx, ny));
                }
            }
        }
    }
    
    public static int countZeros(int[][] map) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) count++;
            }
        }
        return count;
    }
    
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        constructWall(0, map);
        System.out.println(maxSafeArea);
    }
}
