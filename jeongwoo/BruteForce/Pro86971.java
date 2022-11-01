/**
 * [86971] 전력망을 둘로 나누기
 * https://programmers.co.kr/learn/courses/30/lessons/86971
 *
 * -아이디어
 * 1. wires를 이차원 배열에 넣는다. 이때 정보는 양방향이어서 map[x][y] = map[y][x] = 1으로 한다.
 * 2. 어디를 끊을지 찾는데, 배열에는 양방향 정보가 있으니까 대각선을 기준으로 한쪽만 체크하면 된다.
 * 3. 끊을 때는 양방향 둘 다 끊는다.
 * 4. map[1][i]부터 연결된 곳을 찾는다.
 * 5. 전체 n - 연결된 개수, 연결된 개수 간 차를 구해서 min에 저장한다.
 *
 *
 */

public class Pro86971 {
    private static int[][] map;
    private static int count;
    private static boolean[][] visited;

    public static void main(String[] args) {

    }

    public int solution(int n, int[][] wires) {
        int length = wires.length;
        map = new int[n + 1][n + 1];
        visited = new boolean[n + 1][n + 1];

        for (int i = 0; i < length; i++) {
            int x = wires[i][0];
            int y = wires[i][1];

            map[x][y] = map[y][x] = 1;
        }

        int min = Integer.MAX_VALUE;

        for (int i = 1; i < map.length; i++) {
            for (int j = i+1; j < map.length; j++) {
                count = 1;
                if (map[i][j] == 1) {
                    map[i][j] = map[j][i] = 0;
                    find(1);
                    map[i][j] = map[j][i] = 1;
                    int other = n - count;
                    min = Math.min(min, Math.abs(count - other));
                }
            }
        }

        return min;
    }

    private static void find(int x) {
        for (int i = 1; i < map.length; i++) {
            if (map[x][i] == 1 && !visited[x][i]) {
                visited[x][i] = visited[i][x] = true;
                count++;
                find(i);
                visited[x][i] = visited[i][x] = false;
            }
        }
    }

}
