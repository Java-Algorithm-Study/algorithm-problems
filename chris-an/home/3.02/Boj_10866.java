import java.io.*;
import java.util.ArrayDeque;
import java.util.*;

public class Boj_10866 {
    /*
        Deque(덱/데크)
        덱은 Double-Ended Queue 의 줄임말로
        큐의 양쪽에 데이터를 넣고 뺄 수 있는 형태의 자료구조를 의미한다.
        하나의 자료구조에 Queue 와 Stack 을 합쳐 놓은 형태라 할 수 있다.
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        ArrayDeque<Integer> dq = new ArrayDeque<>();

        int orderCnt = Integer.parseInt(br.readLine());
        while (orderCnt-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            boolean bl;
            switch (st.nextToken()) {
                case "push_front" :
                    dq.offerFirst(Integer.parseInt(st.nextToken()));
                    break;

                case "push_back" :
                    dq.offerLast(Integer.parseInt(st.nextToken()));
                    break;

                case "pop_front" :
                    if (dq.isEmpty()) sb.append("-1\n");
                    else sb.append(dq.pollFirst()).append("\n");
                    break;

                case "pop_back" :
                    if (dq.isEmpty()) sb.append("-1\n");
                    else sb.append(dq.pollLast()).append("\n");
                    break;

                case "size" :
                    sb.append(dq.size()).append("\n");
                    break;

                case  "empty" :
                    bl = dq.isEmpty();
                    if (bl) sb.append("1\n");
                    else sb.append("0\n");
                    break;

                case "front" :
                    if(!dq.isEmpty()) sb.append(dq.peekFirst()).append("\n");
                    else sb.append("-1\n");
                    break;

                case "back" :
                    if(!dq.isEmpty()) sb.append(dq.peekLast()).append("\n");
                    else sb.append("-1\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}
