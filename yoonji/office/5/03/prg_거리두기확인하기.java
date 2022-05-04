import java.util.LinkedList;
import java.util.Queue;

public class prg_거리두기확인하기 {
    static final char PEOPLE = 'P';
    static final char DESK = 'O';
    static Queue<Integer> xyQue = new LinkedList<>();
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static int[] solution(String[][] places) {
        int[] answer = new int[5];
        for (String[] room : places) {
            Loop1:
            for (int r = 0; r < 5; r++) {
                // 거리두기 확인하기
                boolean isThereP = false;
                for (int c = 0; c < 5; c++) {
                    if (room[r].charAt(c) == PEOPLE) {
                        isThereP = true;
                        answer[r] = bfs(room, r, c);
                        if (answer[r] == 0) break Loop1;
                    }
                }
                if (!isThereP) answer[r] = 1;
            }
        }
        return answer;
    }

    private static int bfs(String[] room, int x, int y) {
        xyQue.offer(x);
        xyQue.offer(y);

        while(!xyQue.isEmpty()) {
            int nowX = xyQue.poll();
            int nowY = xyQue.poll();
            for (int i=0; i<4; i++) {
                int nextX = nowX + dir[i][0];
                int nextY = nowY + dir[i][1];
                int dist = Math.abs(nextX-x) + Math.abs(nextY-y);
                // 범위 내 & 첫 P인지 체크
                if (isInBounds(nextX, nextY) || (nextX == x && nextY == y)) continue;
                if (dist<=2 && room[nextX].charAt(nextY) == PEOPLE) return 0;  // 맨해튼 거리
                if (dist<2 && room[nextX].charAt(nextY) == DESK) {  // 2미만의 거리 내에 있어야 고려.
                    xyQue.offer(nextX);
                    xyQue.offer(nextY);
                }
            }
        }
        return 1;
    }
    private static boolean isInBounds(int nextX, int nextY) {
        return nextX<0 || nextX>=5 || nextY<0 || nextY>=5;
    }

    public static void main(String[] args) {
        prg_거리두기확인하기 t = new prg_거리두기확인하기();
        int[] solution = t.solution(new String[][]{{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}});
        System.out.println(solution);
    }
}
