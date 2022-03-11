import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Arrays;
import java.util.StringTokenizer;
// 소수 구하기
public class boj_1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int[] MN = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();       // 메모리:19576, 시간:528
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");  // 메모리: 18768, 시간: 504
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

//        for (int i=MN[0]; i<= MN[1]; i++) {
        for (int i=M; i<= N; i++) {
            if (isPrime(i)) sb.append(i).append("\n");
        }
        System.out.println(sb);
    }
    private static boolean isPrime(int num) {
        if (num < 2) return false;   // 1인 경우 소수 아님
        else {
            for (int i=2; i<= Math.sqrt(num); i++) {
                if (num % i == 0) return false;
            }
        }
        return true;
    }
}
