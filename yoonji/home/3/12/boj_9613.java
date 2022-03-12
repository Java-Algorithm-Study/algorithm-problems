import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// GCD 합
// T개 Test Case
// 1<= N <=100 : 수의 개수 (수는 1,000,000 넘지 X)
// 각 TC마다 모든 쌍의 GCD 합 출력
public class boj_9613 {
    static long sum = 0;    // ※ N은 1,000,000을 안넘지만 sum은 넘을 수 있음.
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        ArrayList<Integer> list;
        // T줄 입력받기
        for (int i=0; i<T; i++) {
            list = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            while (N-- >0) {
                list.add(Integer.parseInt(st.nextToken())); // 100이하 수
            }
            solution(list);
            sum = 0;
        }
        System.out.println(sb);
    }
    private static void solution(ArrayList<Integer> list) {
        for (int i=0; i<list.size()-1; i++) {
            for (int j=i+1; j<list.size(); j++) {
                sum += solveGCD(list.get(i), list.get(j));
            }
        }
        sb.append(sum).append("\n");
    }
    private static int solveGCD(int a, int b) {
        if (b == 0) return a;
        else return solveGCD(b, a % b);
    }
}
