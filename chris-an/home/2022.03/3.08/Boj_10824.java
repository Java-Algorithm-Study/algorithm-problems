import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*

    런타임 에러 (NumberFormat) 발생
    int의 표현 범위는 -2,147,483,648 ~ 2,147,483,647라서 10,000,001,000,000을 받을 수 없음

 */
public class Boj_10824 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] temp = br.readLine().split(" ");
        System.out.println(Long.parseLong((temp[2] + temp[3]))+Long.parseLong((temp[0] + temp[1])));
        br.close();
    }
}
