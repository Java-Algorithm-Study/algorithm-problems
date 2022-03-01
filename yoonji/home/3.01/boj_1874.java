import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 문제자체가 이해가 잘 안되서 구글링을 해서 이해했다.
// 이해한 바로는
// 1. 수열을 입력받는다. -> input
// 2. 현재 값부터 해당 값까지 정수를 스택에 push한다.(오름차순) -> +
// 3. input값과 stack의 마지막 값이 같은 값인지 비교하여 같으면 pop, 같지 않으면 수열 만족X => NO 출력 & 종료
// 한번에 출력하기위해  이용
public class boj_1874 {
    public static void main(String[] args) throws IOException {
        solving();
    }

    private static void solving() throws IOException {
        Stack<Integer> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        int start = 0;  // 시작하는 값 찍기
        int num;
        while(T-- > 0) {
            num = Integer.parseInt(br.readLine());
            if (num > start) {
                for (int j = start + 1; j <= num; j++) {
                    stack.push(j);
                    sb.append("+\n");
                }
                start = num;
            }
            // 왜 else if? 마지막 값이 num이랑 다르면
            else if (stack.peek() != num) {
                System.out.println("NO");
                return;
            }
            stack.pop();
            sb.append("-\n");
        }
        System.out.println(sb);
    }
}
