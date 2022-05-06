import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_15658_05 {
    static int N;
    static int[] S;
    static int[] operator;
    static final int PLUS = 0;
    static final int MINUS = 1;
    static final int MULTI = 2;
    static final int DIVISION = 3;
    static int maxResult = Integer.MIN_VALUE;
    static int minResult = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
       inputAndInit();
        dfs(1, S[0]);   // S[0]을 sum에 넣고 시작하므로 depth=1
        System.out.print(maxResult+"\n"+minResult);
    }

    private static void inputAndInit() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        S = new int[N];
        operator = new int[4];
        for (int i=0;i<N;i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }
    }
    private static void dfs(int depth, int sum) {
        if (depth == N) {
            maxResult = Math.max(maxResult, sum);
            minResult = Math.min(minResult, sum);
            return;
        }
        for (int i=0; i<4; i++) {
            if (operator[i] > 0) {
                operator[i]--;
                int originalSum = sum;
                switch(i) {
                    case PLUS: sum+=S[depth]; break;
                    case MINUS: sum-=S[depth]; break;
                    case MULTI: sum*=S[depth]; break;
                    case DIVISION:
                        if (sum<0) {
                            sum = (sum*(-1))/S[depth];
                            sum *= (-1);
                        } else {
                            sum /= S[depth];
                        }
                }
                dfs(depth + 1, sum);
                operator[i]++;
                sum = originalSum;  // 이전 값으로 back
            }
        }
    }
}
