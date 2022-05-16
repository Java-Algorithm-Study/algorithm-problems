import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Sw_6485 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        // 버스 정류장 노선 정리
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine()); // 테스트 케이스
            Queue<Integer> qu = new LinkedList<>();
            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                while (st.hasMoreTokens()) {
                    qu.offer(Integer.parseInt(st.nextToken()));
                }
            }
            // 출력 해야할 P 정류장 담아놓기
            int P = Integer.parseInt(br.readLine());
            int[] pArr = new int[P];
            for (int j = 0; j < P; j++) {
                pArr[j] = Integer.parseInt(br.readLine());
            }

            // 정류장에 겹치는 노선 check
            int[] result = new int[5001];
            for (int j = 0; j < N; j++) {
                int st = qu.poll();
                int end = qu.poll();
                for (int k = st; k <= end; k++) {
                    result[k]++;
                }
            }

            // 출력 부분!
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < P; j++) {
                sb.append(result[pArr[j]]).append(" ");
            }
            System.out.println("#" + (i + 1) + " " + sb);
        }
    }
}
