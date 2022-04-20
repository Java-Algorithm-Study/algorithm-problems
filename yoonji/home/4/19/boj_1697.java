import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
// 숨바꼭질
public class boj_1697 {
    final static int LIMIT = 100_000;
    public static void main(String[] args) throws IOException {
        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        if (N==K) {
            System.out.println(0);
            return;
        }
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[LIMIT+1];   // boolean->int로 수정하여 시간을 값으로 저장
        q.add(N);
        while (!q.isEmpty()) {
            int curr = q.poll();
            // 이미 동생 위치에 왔다면 종료
            if (visited[K] != 0) {
                System.out.println(visited[K]);
                break;
            }
            // X+1 이동
            if (curr+1<=LIMIT && visited[curr+1]==0) {
                visited[curr+1] = visited[curr]+1;
                q.add(curr+1);
            }
            // X-1 이동
            if (curr-1>=0 && visited[curr-1]==0) {
                visited[curr-1] = visited[curr]+1;
                q.add(curr-1);
            }
            // X*2 이동
            if (curr*2<=LIMIT && visited[curr*2]==0) {
                visited[curr*2] = visited[curr]+1;
                q.add(curr*2);
            }
        }
    }
}