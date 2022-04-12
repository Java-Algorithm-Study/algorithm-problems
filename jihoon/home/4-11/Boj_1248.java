import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Boj_1248 {
    private static int N;
    private static char[][] S;
    private static int[] seq;
//    private static ArrayList<Integer>[] seq;
    
    public static void dfs(int depth) {
        if (depth == N) {
            System.out.println(Arrays.toString(seq));
            return;
        }

        for (int i = -10; i <= 10; i++) {
            seq[depth] = i;
            if (!check(depth)) continue;
            dfs(depth + 1);
        }
    }
    
    public static boolean check(int depth) {
        int sum = 0;
        for (int i = 0; i < depth; i++) {
            sum += seq[i];
        }
        if (depth == 1) {
            if (S[depth][depth] == '+') {
                return seq[depth] >= 0;
            } else if (S[depth][depth] == '-') {
                return seq[depth] <= 0;
            } else {
                return seq[depth] == 0;
            }
            
        } else {
            return true;
        }
    }

    public static void main(String[] args) throws IOException {
//        ArrayList<Integer>[] list = new ArrayList[5];
//        list[0] = new ArrayList();
//        list[0].add(8);
//        System.out.println(list[0]);
        var bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        S = new char[N][N];
        seq = new int[N];
//        seq = new ArrayList[N];
        String s = bf.readLine();
        int index = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                S[i][j] = s.charAt(index++);
            }
        }
        dfs(0);
    }
}
