import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1978 {


    static boolean decimal (int a) {
        boolean flag = false;
        if (a == 1) return flag;

        for (int i = 2; i < a; i++) {
            if (a % i == 0) return false; // 소수가 아님.
        }
        return true;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int ordCnt = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = 0;
        for(int i = 0; i < ordCnt; i++) {
            if (decimal(Integer.parseInt(st.nextToken()))) cnt++;
        }
        System.out.println(cnt);
    }
}
