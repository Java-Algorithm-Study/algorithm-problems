import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
// 현재 상황에서는 split보다 StringTokenizer가 더 우세할 수 있음 (구분자가 유니코드이거나,hasMoreToken을 사용하면 성능 ↓)
public class boj_10828 {
    // 각각의 자료구조로 푸는 코드를 작성하였습니다. 메모리 효율에서 ArrayList가 조금 더 좋네요
    public static void main(String[] args) throws IOException {
        solvingWithStack();       // 1. Stack을 사용. [memory] 20164	[time] 384

        solvingWithArrayList(); // 2. ArrayList를 사용. [memory] 18284	[time] 384
    }
    /**
     * 스택 자료구조로 ArrayList를 이용한 메서드
     * @throws IOException
     */
    private static void solvingWithArrayList() throws IOException {
        List<Integer> stack = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int lines = Integer.parseInt(br.readLine());
        String[] line;
        for (int i = 0; i < lines; i++) {
            line = br.readLine().split(" ");
            if ("push".equals(line[0])) {
                stack.add(Integer.parseInt(line[1]));
                continue;
            }
            else if ("pop".equals(line[0]))  {
                if (stack.size() == 0) print(-1);
                else print(stack.remove(stack.size() - 1));
                continue;
            }
            else if ("size".equals(line[0])) print(stack.size());
            else if ("empty".equals(line[0])) {
                if (stack.size() == 0) print(1);
                else print(0);
                continue;
            }
            else if ("top".equals(line[0])) {
                if (stack.size() == 0) print(-1);
                else print(stack.get(stack.size()-1));
                continue;
            }
        }
    }
    /**
     * 스택 자료구조로 Stack를 이용한 메서드
     * @throws IOException
     */
    private static void solvingWithStack() throws IOException {
        Stack<Integer> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int lines = Integer.parseInt(br.readLine());
        String[] line;
        for (int i=0; i<lines; i++) {
            line = br.readLine().split(" ");
            if ("push".equals(line[0])) {
                stack.push(Integer.parseInt(line[1]));
                continue;
            }
            else if ("pop".equals(line[0]))  {
                if (stack.size() == 0) print(-1);
                else print(stack.pop());
                continue;
            }
            else if ("size".equals(line[0])) print(stack.size());
            else if ("empty".equals(line[0])) {
                if (stack.size() == 0) print(1);
                else print(0);
                continue;
            }
            else if ("top".equals(line[0])) {
                if (stack.size() == 0) print(-1);
                else print(stack.peek());
                continue;
            }
        }
    }
    // 출력 메서드
    private static void print(Object i) {
        System.out.println(i);
    }
}
