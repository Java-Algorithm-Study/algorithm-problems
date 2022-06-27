import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * [13023] ABCDE
 * https://www.acmicpc.net/problem/13023
 *
 * -아이디어
 * 1.사람 수 N, 친구 관계 수 M, 0 1 ->  0과 1이 친구.
 * 2. a -> b -> c -> d -> e 이런 관계가 있으면 1, 아니면 0
 * 3. 총 5명이 친구의 친구의 친구..
 * 4. dfs로 5명이 친구의 친구의 친구 관계일 때 1을 리턴한다.
 *
 * -시간 복잡도
 * 1. O(deg(A))
 *
 * -자료 구조
 * 1. 한 노드에서 연결된 노드가 4개가 있는지를 확인해야 하니까 ArrayList를 사용한다.
 */

public class Boj13023 {
    private static ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
    private static boolean[] visited;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // ArrayList 초기화
        for (int i = 0; i < n; i++) {
            arrayList.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arrayList.get(a).add(b);
            arrayList.get(b).add(a);
        }

        for (int i = 0; i < n; i++) {
            visited = new boolean[n];
            dfs(i, 0);

            if (answer > 0) {
                break;
            }
        }
        System.out.println(answer);
    }

    private static void dfs(int start, int level) {
        if (level == 4) {
            answer = 1;
            return;
        }

        visited[start] = true;

        for (int i : arrayList.get(start)) {
            if (!visited[i]) {
                dfs(i, level + 1);
            }
        }
        visited[start] = false;
    }
}
