import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
// 이모티콘
public class boj_14226 {
    final static int LIMIT = 1000;
    public static void main(String[] args) {
        // 1. 초기화
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt();
        boolean[][] visited = new boolean[LIMIT*2+1][LIMIT*2+1];  // 복사까지 고려한 최대 경우. 1차원:scrN, 2차원:clipN
        Queue<Emoji> q = new LinkedList<>();
        q.add(new Emoji(1, 0, 0));
        // visited[1][0] = true;  // true로 표시 안해도 TC에서 다시 돌아오지않아서 그런지 통과
        // 인접 노드 우선으로 경우의 수 돌며 최소값 구하기 (작은 수부터 순차적으로 진행되므로 먼저 방문한 게 최소)
        while (!q.isEmpty()) {
            Emoji e = q.poll();
            if (S == e.scrN) {
                System.out.println(e.sec);
                break;
            }
            /** 1. 화면 emoji 모두 복사: 화면 emoji갯수 -> 클립보드 emoji 갯수
             * 조건1. 화면 갯수 != 클립보드 갯수 (같으면 굳이 실행할 필요X)
             * 조건2. !visited[scrN][copyN]
             **/
            if (e.scrN != e.copyN && !visited[e.scrN][e.scrN]) {
                visited[e.scrN][e.scrN] = true;
                q.add(new Emoji(e.scrN, e.scrN, e.sec+1));
            }

            /** 2. 클립보드 -> 화면에 붙여넣기 (갯수 추가)
             * 조건1. 클립보드 갯수 !=0
             * 조건2. !visited[scrN+copyN][copyN]
             * 조건3. 붙여지는 화면 갯수<=LIMIT <- 문제에서 고려하라는 조건을 주지 않은 것 같은데..
             **/
            if (e.copyN > 0 && e.scrN+e.copyN <= LIMIT && !visited[e.scrN+e.copyN][e.copyN]) {
                visited[e.scrN+e.copyN][e.copyN] = true;
                q.add(new Emoji(e.scrN+e.copyN, e.copyN, e.sec+1));
            }
            /** 3. 화면 emoji 1개 삭제
             * 조건1. 화면 갯수 > 0
             * 조건2. !visited[scrN-1][copyN];
             **/
            if (e.scrN > 0 && !visited[e.scrN-1][e.copyN]) {
                visited[e.scrN-1][e.copyN] = true;
                q.add(new Emoji(e.scrN-1, e.copyN, e.sec+1));
            }
        }
        sc.close();
    }
    private static class Emoji {
        private int scrN;
        private int copyN;
        private int sec;
        public Emoji(int scrEmoji, int copyN, int sec) {
            this.scrN = scrEmoji;
            this.copyN = copyN;
            this.sec = sec;
        }
    }
}