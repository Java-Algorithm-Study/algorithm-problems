import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_11659 {
    //5 3
    //5 4 3 2 1
    //1 3
    //2 4
    //5 5
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        
        long[] sums = new long[N + 1];
    
        long sum = 0;
        for (int i = 0; i < N; i++) {
            sum += numbers[i];
            sums[i + 1] = sum;
        }
        var sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(sums[end] - sums[start - 1]).append("\n");
        }
        System.out.println(sb);
        
    }
}
