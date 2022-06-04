import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/** 4연산
 * 이해
 * - s를 t로 바꾸는 최소 연산.
 * - s==t라면 '0', s를 t로 못바꾸면 -1, 가능하면 여러개중 사전순 첫번째거 출력
 * - t==1이라면 '/'
 * - '-'는 모든 값을 0으로 만들기 때문에 최소갯수의 연산에 필요 없다.
 * 아이디어
 * 1. bfs로 연산4가지를 탐색하며, 종료 조건은 10^9를 넘으면
 * 2. 큐에는 현재 수와 여태까지 계산된연산자 클래스를 넣는다.
 * 3. 사전순으로 for문을 돌려서 가장 먼저 구하는 연산이 사전순으로도 정렬된 것.
 * 주의!
 * 배열은 메모리공간 할당이 약 5억까지만 가능해서 target (최대 10^9)만큼의 배열 생성 불가 => 방문 처리를 Set으로 체크하여 동일한 값이 있을 경우 방문X
 */
public class boj_14395_03 {
    static char[] operators = {'*', '+', '/'};  // 사전순
    static boolean findCheck = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int s = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        if (s==t) {
            System.out.println(0);
        } else if (t== 1) {
            System.out.println("/");
        } else {
            bfs(s, t);
            if (!findCheck) System.out.println(-1);
        }
    }
    private static void bfs(int number, int target) {
        Set<Integer> visitedSet = new HashSet<>();
        Queue<CalculateInfo> que = new LinkedList<>();
        que.offer(new CalculateInfo(number, ""));
        visitedSet.add(number);
        while (!que.isEmpty()) {
            CalculateInfo curr = que.poll();
            if (curr.num == target) {
                findCheck = true;
                System.out.println(curr.operatorHistory);
                return;
            }
            // -를 제외해서 0이 될 일 X
            for(int i=0; i<3; i++) {
                long nxtNum = curr.num; // 계산된 값 자체(10^9 * 10^9)는 int를 넘을 수 있으므로
                if (i==0) nxtNum *= nxtNum;
                else if (i==1) nxtNum += nxtNum;
                else nxtNum /= nxtNum;

                if (nxtNum>target) continue;    // n-n 빼야하는 경우는 target에 도달하지 못하므로 아예 배제
                if (visitedSet.contains((int)nxtNum)) continue;
                visitedSet.add((int)nxtNum);
                que.offer(new CalculateInfo((int)nxtNum, curr.operatorHistory+operators[i]));
            }
        }
    }
    private static class CalculateInfo {
        int num;
        String operatorHistory;
        CalculateInfo (int num, String operatorHistory) {
            this.num = num;
            this.operatorHistory = operatorHistory;
        }
    }
}
