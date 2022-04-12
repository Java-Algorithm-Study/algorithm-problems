import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 부분 수열의 합
public class boj_1182 {
    static int N;
    static int S;
    static int cnt=0;
    static boolean[] visited;
    static int[] inputData;
    public static void main(String[] args) {
        try {
            input();
        } catch (IOException e) {
            e.printStackTrace();
        }
        dfs(0, 0,0);
        System.out.println(cnt);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        inputData = new int[N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        int i=0;
        while(st.hasMoreTokens()) inputData[i++] = Integer.parseInt(st.nextToken());
    }

    private static void dfs(int num, int depth, int sum) {
        if (depth>0 && S == sum) {
            cnt++;
//            System.out.println("depth : " + depth + ", sum : " + sum);
        }
        // N만큼 반복문을 도는데, 그때 i+1에 대해 , 그다음은 i+2, ..., 더해가면서 sum일 때 cnt++
        // i가 N자리가 되면 반복 안돌고 끝남
        // 재귀에서 돌아오면서 그다음 수에 접근..
        for (int i=num; i<N; i++) {
                dfs(i+1, depth+1, sum+inputData[i]);
        }
    }
}
