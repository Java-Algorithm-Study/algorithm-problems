import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// Base Conversation
// A진법으로 나타낸 숫자를 B진법으로 변환
// A -> 10 -> B진법
public class boj_11576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(br.readLine());  // 사용x
        // A진법 숫자 (0이상 A미만) -> 10진법
        // 공백을 구분으로 각 A의 0승, 1승,.. 곱해서 더하면 10진법이 된다.  (문제 의도 파악하기 어려움)
        int decimal = 0;
        String[] nums = br.readLine().split(" ");
        for (int i=0; i<n; i++) {
            decimal += Integer.parseInt(nums[i]) * Math.pow(A, n-i-1);
        }
        // 10진법 -> B진법
        List<Integer> stack = new ArrayList<>();    // 선입후출 스택 이용
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n; i++) {
            while (decimal != 0) {
                stack.add(decimal%B);   // 나머지
                decimal /= B;   // 몫
            }
        }
        for (int i=stack.size()-1; i>=0; i--) sb.append(stack.remove(i)).append(" ");
        System.out.println(sb);
    }
}