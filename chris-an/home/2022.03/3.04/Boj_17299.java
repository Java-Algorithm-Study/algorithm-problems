import java.io.*;
import java.util.Arrays;
import java.util.Stack;

public class Boj_17299 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Integer> st = new Stack<>();
        br.readLine(); // 담을 필요없으니, 이렇게 진행
        String temp = br.readLine();
        System.out.println(temp);

        // IntStream 으로 바꿔 줌.
        int [] n = Arrays.stream(temp.split(" ")).mapToInt(Integer::parseInt).toArray();
        int [] ans = new int[n.length]; // 선언 후 0으로 초기화
        int [] F = new int[1000001]; // 최대 수열 길이 선언, 0으로 초기화
        for (int i = 0; i < n.length; i++) {
            F[n[i]] += 1;
        }

        st.push(0);
        for (int i = 1; i < n.length; i++) {
            if (st.isEmpty()) st.push(i);
            else {
                while (!st.isEmpty() && F[n[st.peek()]] < F[n[i]]) { // Stack 은 NGF 의 idx 값이다.
                    ans[st.peek()] = n[i]; // 출력하고자 할 NGF 의 값을 담는다.
                    st.pop(); // 사용한 인덱스 번호는 pop 시킨다.
                }
                st.push(i);
            }
        }// 과정은 NGF(6) -> NGF(5) -> NGF(4) -> NGF(3) 값을 담은 뒤, 출력문에서 0으로 초기화된 값만 출력하기.

        for (int i = 0; i < ans.length; i++) {
            if (ans[i] == 0) bw.write("-1" + " ");
            else bw.write(ans[i] + " ");
        }
        bw.write("\n");
        bw.flush();
        bw.close();


    }
}
