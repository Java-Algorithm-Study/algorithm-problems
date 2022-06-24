import java.util.*;

public class Sw_1244_pass {
    static int len, result;
    static boolean[][] visit;
    static int swap(int num, int a, int b) {
        int pow1 = (int) Math.pow(10, len-a-1);
        int pow2 = (int) Math.pow(10, len-b-1);
        int digit1 = num / pow1 % 10;
        int digit2 = num / pow2 % 10;
        return num -digit1*pow1 + digit2*pow1 -digit2*pow2 + digit1*pow2;
    }
    static void solve(int num, int remain) {
        if( visit[num][remain] ) return;
        visit[num][remain] = true;
        if( remain == 0) {
            if( num > result ) result = num;
            return;
        }
        for(int i=0; i<len-1; i++) {
            for(int j=i+1; j<len; j++) {
                solve(swap(num, i, j), remain-1);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=1; tc<=T; tc++) {
            int N = sc.nextInt();
            int R = sc.nextInt();
            result = 0;
            len = String.valueOf(N).length();
            visit = new boolean[1000000][R+1];
            solve(N, R);
            System.out.format("#%d %d\n", tc, result);
        }
        sc.close();
    }
}
