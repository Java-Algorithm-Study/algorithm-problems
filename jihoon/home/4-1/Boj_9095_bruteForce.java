import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_9095_bruteForce {
    
    public static int factorial(int n) {
        int ans = 1;
        for (int i = 1; i <= n; i++) {
            ans *= i;
        }
        return ans;
    }
    
    public static int withTwo(int n, int a, int b) {
        int count = 0;
        // 1은 최대 8번, 2는 최대 4번 나올 수 있다
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 5; j++) {
                if (a * i + b * j == n) {
                    count += factorial(i + j) / (factorial(i) * factorial(j));
                }
            }
        }
        return count;
    }
    
    public static int withThree(int n, int a, int b, int c) {
        int count = 0;
        // 1은 최대 5번, 2는 최대 3번, 3은 최대 3번 나올 수 있다
        for (int i = 1; i < 6; i++) {
            for (int j = 1; j < 4; j++) {
                for (int k = 1; k < 4; k++) {
                    if (a * i + b * j + c * k == n) {
                        count += factorial(i + j + k) / (factorial(i) * factorial(j) * factorial(k));
                    }
                }
            }
        }
        return count;
    }
    
    public static int calculateAllCases(int n) {
        int count = 0;
    
        // 1로만 나타내는 경우
        count++;
    
        // 2로만 나타내는 경우
        if (n % 2 == 0)
            count++;
    
        // 3으로만 나타내는 경우
        if (n % 3 == 0)
            count++;
    
        // 1, 2으로 나타내는 경우
        count += withTwo(n, 1, 2);
    
        // 1, 3으로 나타내는 경우
        count += withTwo(n, 1, 3);
    
        // 2, 3으로 나타내는 경우
        count += withTwo(n, 2, 3);
    
        // 1, 2, 3으로 나타내는 경우
        count += withThree(n, 1, 2, 3);
        
        return count;
    }
    
    public static void main(String[] args) throws IOException {
        var bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(bf.readLine());
            System.out.println(calculateAllCases(n));
        }
    }
}
