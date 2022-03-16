import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 진법 변환
// 'A' ~ 'Z' : 65~90
// '1' ~ '9' : 49~57
public class boj_2745 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String s = st.nextToken();
        int B = Integer.parseInt(st.nextToken());   // N진법
        int ans=0;

        for (int i=0; i<s.length(); i++) {  // 앞부터 시작
            int number;
            char c = s.charAt(i);
            // 알파벳 문자(A~Z)이면 숫자(10~35)로 변환하기 위해 55빼기
            if ('A' <= c)
                number = c - 55;
            // 숫자 문자('1'~'9')이면 숫자(1~9)로 변환하기 위해 48빼기
            else
                number = c - '0';   // '0'은 48
            // pow(B, 0~)와 곱해서 ans에 더한다.
            ans += number * Math.pow(B, s.length() - 1 - i);
        }
        System.out.println(ans);
    }
}
