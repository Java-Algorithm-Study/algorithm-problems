import java.io.*;
import java.util.Arrays;

// greedy
/*
    자신이 N명 중 예상 등수 (동석차X)
    A등 예상=>실제 B등 : 불만도는 |A-B|
    N명학생의 불만도의 총합을 최소로 하면서 등수 매기자
    예상 등수 <= 500,000(50만)
    1 5 3 1 2 : 5명
    1 5 3 4 2 => 방문안한 값으로 최대한 예상등수와 가까운 등수 중..
    1 2 2 2 3
    1 2 3 4 5 => 5
    1 2 4 5 3 => 5  뒤의 값을 위해 다른 걸로 하든 안하든 값이 같음
    이미 예상등수값이 배정됐다면, 앞뒤로 찾아나감
*/
// 오름차순 정렬하고 이미 방문한 경우 뒤의 값만 체크하면 된다.  -> 시간초과
// 1~N까지의 등수로 제한하므로, 입력받은 배열을 정렬 시킨 후, 인덱스와의 차잇값을 더하면된다.
// 주의 : int범위는 -2,147,483,648 ~ 2,147,483,647인데, 500,000명의 학생이 모두 50만을 예상하면? 대략차이 30만*50만명 = 150,000,000,000=> int넘어섬
public class boj_2012_greedy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] expectedRanks = new int[N+1];
        long absDiffWithExpectAndReal = 0;
        for (int i=1; i<=N; i++) {
            expectedRanks[i] = Integer.parseInt(br.readLine()); //1 5 3 1 2
        }
        Arrays.sort(expectedRanks); // 1 1 2 3 5
        for (int i=1; i<=N; i++) {
            absDiffWithExpectAndReal+= Math.abs(expectedRanks[i]-i);
        }
        System.out.println(absDiffWithExpectAndReal);
        /*
        boolean[] visited = new boolean[N+1];
        for (int i=0; i<N; i++) {
            if (!visited[expectedRanks[i]]) {
                visited[expectedRanks[i]] = true;
            } else {    // 이미 방문한 경우
                int tmpDiff = 0;
                while (true) {
                    tmpDiff++;
                    int nxtRank = expectedRanks[i] + tmpDiff;
                    if (!visited[nxtRank]) {
                        visited[nxtRank] = true;
                        absDiffWithExpectAndReal += nxtRank - expectedRanks[i];
                        break;
                    }
                }
            }
        }*/
    }
}