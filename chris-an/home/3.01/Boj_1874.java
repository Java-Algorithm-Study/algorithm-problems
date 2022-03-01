import java.io.*;
import java.util.Stack;

public class Boj_1874 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder(); // 출력용
        Stack<Integer> st = new Stack<>(); // 스택로직용

        // 명령 개수
        int orderCnt = Integer.parseInt(br.readLine());

        // 저장
        int [] orderList = new int[orderCnt];
        for (int i = 0; i < orderCnt; i++) {
            orderList[i] = Integer.parseInt(br.readLine());
        }

        // 로직
        int chk = 0; // 최종 max 값 필요
        for (int i = 1; i <= orderCnt; i++) {
            st.push(i);
            sb.append("+").append("\n");
            while (!st.isEmpty()) {

                if (st.peek() == orderList[chk]) {
                    st.pop();
                    sb.append("-").append("\n");
                    chk++;
                } else break;
            }
        }

        // 출력
        if (!st.isEmpty()) bw.write("NO");
        else bw.write(sb.toString());

        bw.close();
    }
}

