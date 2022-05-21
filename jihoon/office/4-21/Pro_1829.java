import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Pro_1829 {
    public static int[][] dir = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
    public static int[][] pict;
    public static boolean[][] visited;
    
    public static int bfs(int x, int y) {
        int count = 1;
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        q.offer(y);
        visited[x][y] = true;
        int idx = pict[x][y];
        while (!q.isEmpty()) {
            x = q.poll();
            y = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];
                
                if (nx < 0 || ny < 0 || nx >= pict.length || ny >= pict[0].length) continue;
                
                if (visited[nx][ny]) continue;
                
                if (idx != pict[nx][ny]) continue;
                
                q.offer(nx);
                q.offer(ny);
                visited[nx][ny] = true;
                count++;
            }
        }
        return count;
    }
    
    public static int[] solution(int m, int n, int[][] picture) {
        pict = picture;
        visited = new boolean[m][n];
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pict[i][j] == 0) continue;
                if (!visited[i][j]) {
                    int cnt = bfs(i, j);
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, cnt);
                    numberOfArea++;
                }
            }
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        System.out.println(numberOfArea);
        System.out.println(maxSizeOfOneArea);
        return answer;
    }
    
    public static void main(String[] args) {
        int m = 6;
        int n = 4;
        int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        System.out.println(solution(m, n, picture));
    }
}
