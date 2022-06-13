import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * [81302] 거리두기 확인하기
 * https://programmers.co.kr/learn/courses/30/lessons/81302
 */

public class Pro81302 {
    private static final char PERSON = 'P';
    private static final char DESK = 'O';
    private static Queue<Integer> xyQue = new LinkedList<>();
    private static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) {
        int[] input = solution(new String[][]{{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}});

        System.out.println(Arrays.toString(input));
    }

    public static int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for (int i = 0; i < 5; i++) {
            String[] p = places[i];

            // 각 방에 P가 있는지 확인하기
            boolean isP = false;

            Loop1:
            for (int r = 0; r < 5; r++) {
                for (int c = 0; c < 5; c++) {
                    if (p[r].charAt(c) == PERSON) {
                        isP = true;
                        answer[i] = bfs(p, r, c);
                        if (answer[i] == 0) {
                            break Loop1;
                        }
                    }
                }
            }
            if (!isP) {
                answer[i] = 1;
            }
        }
        return answer;
    }

    private static int bfs(String[] room, int x, int y) {
        xyQue.offer(x);
        xyQue.offer(y);

        while (!xyQue.isEmpty()) {
            int nowX = xyQue.poll();
            int nowY = xyQue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dir[i][0];
                int nextY = nowY + dir[i][1];

                // 범위 체크
                if (nextX < 0 || nextX >= 5 || nextY < 0 || nextY >= 5) continue;
                // 첫 P인지 체크
                if (nextX == x && nextY == y) continue;

                // 맨해튼 거리
                int d = Math.abs(nextX - x) + Math.abs(nextY - y);

                if (d <= 2 && room[nextX].charAt(nextY) == PERSON) {
                    return 0;
                }

                if (d < 2 && room[nextX].charAt(nextY) == DESK) {
                    xyQue.offer(nextX);
                    xyQue.offer(nextY);
                }
            }
        }
        return 1;
    }
}
