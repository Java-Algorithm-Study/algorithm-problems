import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 쇠막대기
public class boj_10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        int answer = 0;
        int stickNum = 0;   // 현재 막대기 갯수
        for (int i=0; i<input.length; i++) {
            //1. '('의 경우
            if (input[i] == '(') {
                if (input[i+1] != ')') {        // 막대기 시작이면
                    stickNum++;
                    answer++;
                }
            }
            // 2. ')'의 경우
            else {
                if (input[i-1] == '(') answer += stickNum;// 레이저만나면 막대기갯수만큼 추가
                else stickNum-=1;   // 막대기 끝나면 --
            }
        }
        System.out.println(answer);
    }
}
