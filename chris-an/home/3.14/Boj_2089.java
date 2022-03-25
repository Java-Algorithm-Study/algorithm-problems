import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_2089 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        // 0일 때 컷.
        if (N == 0) {
            System.out.println(N);
            return;
        }

        // 0이 아닐 때 루프 돌기
        while (N != 1) {
            sb.append(Math.abs(N % (-2)));
            N = (int) Math.ceil((double) N / (-2));
        }
        sb.append(N);
        System.out.println(sb.reverse());
    }
}

