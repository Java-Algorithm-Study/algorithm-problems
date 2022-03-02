import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

// 출력은 매 명령마다 출력하므로 그냥 print로 진행
public class boj_10866 {
    public static void main(String[] args) throws IOException {
        Deque<String> deque = new ArrayDeque<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        String[] operStartWithP;     // 'p'로 시작하는 명령어
        while (testCase-- > 0) {
        // 1. 명령을 입력받는다.
            String[] line = br.readLine().split(" ");
            // 1-1. charAt(0)으로 p인 것, 그외로 구분
            switch (line[0].charAt(0)) {
                case 'p':
                    // 1-2. push와 pop을 _로 구분
                    operStartWithP =line[0].split("_");
                    if (operStartWithP[0].equals("push"))
                        // 1-3. front와 back 구분 ->  정수인 line[1] 을 앞 or 뒤에 추가
                        if (operStartWithP[1].equals("back")) deque.addLast(line[1]);
                        else deque.addFirst(line[1]);
                    else if (operStartWithP[0].equals("pop"))
                        if (operStartWithP[1].equals("back")) removeLast(deque);
                        else removeFirst(deque);
                    break;
                case 's':
                    print(deque.size());
                    break;
                case 'e':
                    if (deque.isEmpty()) print(1);
                    else print(0);
                    break;
                case 'f':
                    if (deque.isEmpty()) print(-1);
                    else print(deque.getFirst());
                    break;
                case 'b':
                    if (deque.isEmpty()) print(-1);
                    else print(deque.getLast());

            }
        }
    }

    private static void print(Object o) {
        System.out.println(o);
    }

    private static void removeFirst(Deque<String> deque) {
        if (deque.isEmpty()) print(-1);
        else print(deque.removeFirst());
    }

    private static void removeLast(Deque<String> deque) {
        if (deque.isEmpty()) print(-1);
        else print(deque.removeLast());
    }
}
