import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_17087 {

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] oneLine = br.readLine().split(" ");
        int N = Integer.parseInt(oneLine[0]);
        int S = Integer.parseInt(oneLine[1]);
        int [] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int A = Integer.parseInt(st.nextToken());
            arr[i] = Math.abs(S - A);
        }
        int gcd = arr[0]; // 동생이 한 명일 땐, 그냥 출력

        for(int i = 1; i < arr.length; i++) { // 동생 한 명일 때를 고려해서 i를 1부터 시작.
            gcd = gcd(gcd,arr[i]);
        }
        System.out.println(gcd);
    }
}