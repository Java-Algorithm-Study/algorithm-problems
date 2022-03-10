import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 소수찾기
public class boj_1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();  // N 사용 x
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int ans=0;
        int num;
        while(st.hasMoreTokens()) {
            num = Integer.parseInt(st.nextToken());
            if (isPrime(num)) ans+=1;
        }
        System.out.println(ans);
    }
    // 소수 체크
    private static boolean isPrime(int num) {
        if (num == 1) return false;   // 1은 소수 아님
        for (int i=2; i<= Math.sqrt(num); i++) { //400이라면 20까지만 반복
            if (num % i == 0) return false;
        }
        return true;
    }
}