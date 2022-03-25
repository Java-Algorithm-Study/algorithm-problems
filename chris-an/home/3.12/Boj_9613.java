import java.io.*;
import java.util.StringTokenizer;
/*

   1. 테스트 케이스 의 수 n은 1~100 orderCnt
   2. n은 최대 1 ~ 1,000,000 까지 가능.
   3. n개인 수가 2개 씩 짝지어 만드는 모든 경우의 수는 ? n(n-1)/2 이다.
   4. 따라서, (100*99)/2 는 4950이며,
   5. 두 짝으로 만드는 경우의 수는 4950개 이며, 4950 * 1,000,000 은?
   6. 합의 수는 4,950,000,000 이 될 수 있다.
   7. int 의 표현 범위는 2,147,483,647 이므로
   8. int 의 변수로 담을 수 없다.
   9. long 으로 담아줘야한다. long 표현범위 (9,223,372,036,854,775,807)

 */
public class Boj_9613 {

    static int euclid(int a, int b) {
        if (b == 0) return a;
        return euclid(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int orderCnt = Integer.parseInt(br.readLine());

        while(orderCnt-- > 0) {
            String [] str = br.readLine().split(" ");
            int N = Integer.parseInt(str[0]);
            long sum = 0;
            for (int i = 1; i <= N; i++) {
                for (int j = i+1; j <= N; j++) {
                    sum += euclid(Math.max(Integer.parseInt(str[i]),
                            Integer.parseInt(str[j])), Math.min(Integer.parseInt(str[i]), Integer.parseInt(str[j])));
                }
            }
            bw.write(sum+"\n");
        }


        bw.flush();
        bw.close();
        br.close();
    }
}
