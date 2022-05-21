import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1748 {
    
    public static int make9(int n) {
        return (int) (9 * Math.pow(10, n - 1));
    }
    
    public static int solution(int n) {
        int index = 0;
        int number = 9;
    
        while (String.valueOf(number).length() <= String.valueOf(n).length()) {
            number = make9(++index);
        }
    
        int ans = 0;
        for (int i = 1; i < index - 1; i++) {
            ans += make9(i) * i;
        }
        
        int k = (int) Math.pow(10, index - 2);
        ans += (n - k + 1) * (index - 1);
        return ans;
    }
    
    public static void main(String[] args) throws IOException {
        var bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
    
//        int sum = 0;
//
//        for (int i = 1, len = 1; i <= N; i*=10, len++) {
//            int end = i * 10 - 1;
//            if (end > N) end = N;
//            sum += (end - i + 1) * len;
//        }
//        System.out.println(sum);

        int answer = solution(N);
        System.out.println(answer);
        bf.close();
        
    }
}
