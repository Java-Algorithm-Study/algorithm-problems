import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 2명 이상인 경우, 최대공약수를 구한다.
// 숨바꼭질 6
public class boj_17087 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NS = br.readLine().split(" ");
        int N = Integer.parseInt(NS[0]);
        int S = Integer.parseInt(NS[1]);
        int[] diff = new int[N];
        String[] A = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            diff[i] = Math.abs(S - Integer.parseInt(A[i]));
        }

        int ans = diff[0];
        // 동생이 1명인 경우, 그냥 리턴
        if (N == 1) {
            System.out.println(diff[0]);
            return;
        }
        // 최대공약수 구하기
        for (int i=1; i<N; i++) {
            ans = solveGCD(ans, diff[i]);
        }
        System.out.println(ans);
    }
    // Greatest Common Divisor 최대 공약수
    public static int solveGCD(int bigger, int smaller) {
        // 재귀 이용..예시
        // 1. 48, 24
        // (24, 0) => return 24
        // 2. 24, 24 => return 24
        if (smaller == 0) return bigger;
        else return solveGCD(smaller, bigger % smaller);    // bigger<smaller인 경우, 첫 재귀호출로 자리가 바뀜. ex) 33, 22 -> (22, 33)
    }
}
