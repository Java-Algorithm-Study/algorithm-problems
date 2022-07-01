import java.util.HashSet;

/**
 * [42839] 소수 찾기
 * https://programmers.co.kr/learn/courses/30/lessons/42839
 */

public class Pro42839 {
    private static HashSet<Integer> set = new HashSet();

    public static void main(String[] args) {
        String input = "17";
        dfs("", input);
        
        int cnt = 0;
        for (int i : set) {
            if (isPrime(i)) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
    
    public static int solution(String numbers) {
        dfs("", numbers);
        int cnt = 0;
        for (int i : set) {
            if (isPrime(i)) {
                cnt++;
            }
        }
        return cnt;
    }
    public static void dfs(String candidate, String remain) {
        // 고른 candidate을 set에 추가한다.
        if (!candidate.equals("")) set.add(Integer.parseInt(candidate));

        // 남은 숫자 중 한 개를 더해 새로운 조합을 만든다
        for(int i = 0; i < remain.length(); i++) {
            dfs(candidate + remain.charAt(i), remain.substring(0, i) + remain.substring(i + 1));
        }
    }

    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
