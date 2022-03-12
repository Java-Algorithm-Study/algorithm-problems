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
        String[] A = br.readLine().split(" ");

        int ans = Math.abs(S - Integer.parseInt(A[0]));
        // 최대공약수 구하기
        for (int i=1; i<N; i++) {
            ans = solveGCD(ans, Math.abs(S - Integer.parseInt(A[i])));
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