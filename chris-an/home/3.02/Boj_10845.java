
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
    큐 문제
 */

public class Boj_10845 {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Queue<Integer> qu = new LinkedList<Integer>();

        int orderCnt = Integer.parseInt(br.readLine());

        int data = 0;
        while (orderCnt-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            switch (st.nextToken()) {
                case "push" :
                    data = Integer.parseInt(st.nextToken());
                    qu.offer(data);
                    break;

                case "pop" :
                    if (qu.isEmpty()) sb.append("-1\n");
                    else sb.append(qu.poll()).append("\n");
                    break;

                case "size" :
                    sb.append(qu.size()).append("\n");
                    break;

                case "empty" :
                    if(qu.isEmpty()) sb.append("1\n");
                    else sb.append("0\n");
                    break;

                case "front" :
                    if (qu.isEmpty()) sb.append("-1\n");
                    else sb.append(qu.peek()).append("\n");
                    break;

                case "back" :
                    if (qu.isEmpty()) sb.append("-1\n");
                    else sb.append(data).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}
