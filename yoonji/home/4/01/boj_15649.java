import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// N과 M (1)
public class boj_15649 {
    static StringBuilder answer = new StringBuilder();
    static int[] oneLine; // line별
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(st.nextToken());

        visited = new boolean[N];
        oneLine = new int[length];
        dfs(N, length, 0);
        System.out.println(answer);
    }

    private static void dfs(int num, int length, int depth) {
        if (depth == length) {  // 깊이 끝까지 왔다면 해당 line에 해당하는 oneLine배열을 answer에 추가
            for (int n: oneLine)
                answer.append(n).append(" ");
            answer.append("\n");
            return;
        }
        // oneLine은 아래에서 다시 덮어씌워지므로 초기화할 필요 없음.
        for (int i=0; i<num; i++){
            // 방문 안한 경우 (방문했다면 한 line에서 중복되는 수이므로 방문X)
            if (!visited[i]) {
                visited[i] = true;
                oneLine[depth] = i+1;   // 현재 depth에 i+1값 저장
                dfs(num, length, depth+1);  // 그다음에 올 수 재귀호출
                visited[i] = false;// length 만큼 돌았을테니 다음 line을 위해 다시 visited[i]= false
            }
        }
    }
}

// 내 풀이
// 중복은 아래 조건문으로 피하고자했다.
// if (depth>0 && sb.toString().contains(String.valueOf(num))) return;
// 하지만 아래와 같이 출력된다..
// 4 2를 입력했을 떄
// 1 2
// 3
// 4
// 2 1
// 2
// 3
// 4
// 3 1
// 2
// 3
// 4
// 4 1
// 2
// 3
// 4
// dfs 문제 풀 때는 방문 여부를 나타내는 boolean배열을 활용하는 것이 좋다. 다시 풀어보았다.