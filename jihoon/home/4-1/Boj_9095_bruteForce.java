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
    
    public static int case12(int n) {
        int count = 0;
        // 1은 최대 8번, 2는 최대 4번 나올 수 있다
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 5; j++) {
                if (i + 2 * j == n) {
                    count += factorial(i + j) / (factorial(i) * factorial(j));
                }
            }
        }
        return count;
    }
    
    public static int case13(int n) {
        int count = 0;
        // 1은 최대 7번, 3은 최대 3번 나올 수 있다
        for (int i = 1; i < 8; i++) {
            for (int j = 1; j < 4; j++) {
                if (i + 3 * j == n) {
                    count += factorial(i + j) / (factorial(i) * factorial(j));
                }
            }
        }
        return count;
    }
    
    public static int case23(int n) {
        int count = 0;
        // 2는 최대 4번, 3은 최대 4번 나올 수 있다
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 5; j++) {
                if (2 * i + 3 * j == n) {
                    count += factorial(i + j) / (factorial(i) * factorial(j));
                }
            }
        }
        return count;
    }
    
    public static int case123(int n) {
        int count = 0;
        // 1은 최대 5번, 2는 최대 3번, 3은 최대 3번 나올 수 있다
        for (int i = 1; i < 6; i++) {
            for (int j = 1; j < 4; j++) {
                for (int k = 1; k < 4; k++) {
                    if (i + 2 * j + 3 * k == n) {
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
        count += case12(n);
    
        // 1, 3으로 나타내는 경우
        count += case13(n);
    
        // 2, 3으로 나타내는 경우
        count += case23(n);
    
        // 1, 2, 3으로 나타내는 경우
        count += case123(n);
        
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
