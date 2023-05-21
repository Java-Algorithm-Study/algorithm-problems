package language.java.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


// 쇠막대기 (복습 필)

public class Boj_10799 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> st = new Stack<>();
        String input = br.readLine();

        int sum = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') st.push(i);
            else {
                if (st.peek() == (i - 1)) {
                    st.pop();
                    sum += st.size();
                }else {
                    st.pop();
                    sum++;
                }
            }
        }
        System.out.println(sum);
    }
}