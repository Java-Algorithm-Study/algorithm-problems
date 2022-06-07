import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_10815 {
    
    public static int binarySearch(int[] arr, int target) {
        int maxRepetition = (int) (Math.log(arr.length) / Math.log(2));
        int first = 0;
        int last = arr.length - 1;
        int mid = arr.length / 2;
        
        if (arr[last] == target) return 1;
    
        for (int i = 0; i <= maxRepetition; i++) {
            if (arr[mid] == target) return 1;
            if (target > arr[mid]) first = mid;
            else last = mid;
            mid = (first + last) / 2;
        }
        return 0;
    }
    
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        var st = new StringTokenizer(br.readLine());
        int[] card = new int[N];
        for (int i = 0; i < N; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] numbers = new int[M];
        for (int i = 0; i < M; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(card);

        var sb = new StringBuilder();
        for (int n : numbers) {
            sb.append(binarySearch(card, n)).append(' ');
        }
        System.out.println(sb);
    }
}
