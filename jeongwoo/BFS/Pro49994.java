import java.util.LinkedList;
import java.util.Queue;

/**
 * [49994] 방문 길이
 * https://programmers.co.kr/learn/courses/30/lessons/49994
 *
 * -아이디어
 * 1. 시작점을 (5, 5)로 잡고 시작한다.
 * 2. 위치 이동 후, 범위 안에 있으면 다음 위치로 이동하고, 출발 -> 도착 지점에 대해 visited 배열을 true 처리한다.
 * 3. 이때 방향성은 무시해야 하니까 출발 -> 도착, 도착 -> 출발 둘 다 true 체크한다.
 * 4. 범위를 벗어나는 경우에는 원래 출발점에 계속 머무른다.
 *
 */

public class Pro49994 {
    public static void main(String[] args) {
        String input = "LULLLLLLU";
        System.out.println(solution(input));
    }

    public static int solution(String dirs) {
        int answer = 0;
        char[] command = dirs.toCharArray();
        boolean[][][][] visited = new boolean[11][11][11][11];
        Queue<Integer> queue = new LinkedList<>();

        // 시작 위치 설정
        queue.add(5);
        queue.add(5);
        int idx = 0;

        while (idx < command.length) {
            char cm = command[idx];

            int x = queue.poll();
            int y = queue.poll();
            int nx = 0;
            int ny = 0;

            // 명령어에 따른 위치 설정
            switch (cm) {
                case 'U' :
                    nx = x - 1;
                    ny = y;
                    break;

                case 'D' :
                    nx = x + 1;
                    ny = y;
                    break;

                case 'R' :
                    nx = x;
                    ny = y + 1;
                    break;

                case 'L' :
                    nx = x;
                    ny = y - 1;
                    break;
            }

            // 위치 범위 체크
            if (nx < 0 || nx > 10 || ny < 0 || ny > 10) {
                // 현재 자리 그대로
                queue.add(x);
                queue.add(y);
                continue;
            }

            // 길 방문 체크
            if (!visited[nx][ny][x][y] && !visited[x][y][nx][ny]) {
                visited[nx][ny][x][y] = true;
                visited[x][y][nx][ny] = true;
                answer++;
            }

            // 위치 이동
            queue.add(nx);
            queue.add(ny);
        }

        return answer;
    }
}
