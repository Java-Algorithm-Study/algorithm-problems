package DFSorBFS;
import java.util.*;

// 대기실 5개. 크기는 5x5
// 응시자P 끼리 맨해튼 거리 2 이하로 X
// but, 파티션X으로 막혀있으면 O
// 빈 테이블O이 있는거는 X
// 5개 대기실이 거리두기를 지키고 있으면 1, 한명이라도 안지켰으면 0
// 한명이라도 안지킨 이상 종료.
// 인접 칸 탐색시,
// - r,c와 현재 기준 P에서 맨해튼 거리도 함께 넣는다.
// - X를 만나면 그쪽에 있는 P와는 상관없으니까 pass.
// - 그외는 넣는다.
// - 큐에서 값 꺼냈을 때 P이고 맨해튼 거리 안지켰으면 return 0
// visited는 매 P를 찾을 때마다 reset
// 아이디어
// - 2차원 순회하면서 P를 만나면 bfs 호출 (visited 리셋하고)
// - 만약 0이면 answer 배열에 넣고 내부 for문 종료
public class prg_거리두기확인하기 {
    private final char PEOPLE = 'P';
    private final char DESK = 'O';
    int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int[] solution(String[][] places) {
        int[] answer ={1,1,1,1,1};

        for (int i=0; i<5; i++) {
            Loop1:
            for (int r = 0; r < 5; r++) {
                for (int c = 0; c < 5; c++) {
                    if (places[i][r].charAt(c) == PEOPLE) {
                        if (checkFollowRule(places, i, r, c)==0) {
                            answer[i] = 0;
                            break Loop1;
                        }
                    }
                }
            }
        }
        return answer;
    }

    private int checkFollowRule(String[][] rooms, int room, int r, int c) {
        Queue<GridInfo> que = new LinkedList<>();
        que.offer(new GridInfo(r, c));

        while(!que.isEmpty()) {
            GridInfo now = que.poll();
            for (int i=0; i<4; i++) {
                int nextR = now.r + dir[i][0];
                int nextC = now.c + dir[i][1];
                int dist = Math.abs(nextR-r) + Math.abs(nextC-c);
                // 범위 내 & 첫 P인지 체크
                if (isOutOfBounds(nextR, nextC) || (nextR == r && nextC == c)) continue;
                if (dist<=2 && rooms[room][nextR].charAt(nextC) == PEOPLE) return 0;  // 맨해튼 거리
                if (dist<2 && rooms[room][nextR].charAt(nextC) == DESK) {  // 2미만의 거리 내에 있어야 고려.
                    que.offer(new GridInfo(nextR, nextC));
                }
                // 파티션은 고려하지 않아도됨.
                // ppl이면 인접해 있으니까 지켜지지 않은거고
                // desk이면 다시 고려해봐야하니까 que에 넣고
            }
        }
        return 1;
    }
    private boolean isOutOfBounds(int nextR, int nextC) {
        return nextR<0 || nextR>=5 || nextC<0 || nextC>=5;
    }
    private static class GridInfo {
        int r;
        int c;
        GridInfo (int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}