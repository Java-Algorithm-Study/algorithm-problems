import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_1934 {
    public static void main(String[] args) throws IOException {
        int bigger;
        int smaller;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] num;
        for (int i=0; i<T; i++) {
            num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            // 1. 대소 비교
            if (num[0] >= num[1]) {
                bigger = num[0];
                smaller = num[1];
            } else {
                bigger = num[1];
                smaller = num[0];
            }
            // 2. 최소공배수 호출
            System.out.println(solveLCM(bigger, smaller));
        }
    }

    // Largest Common Multiple 최소 공배수
    public static int solveLCM(int bigger, int smaller) {
        int multiple = 0;
        int i=1;
        // A의 배수가 B의 배수인지 체크
        while(multiple <= bigger*smaller) {
            multiple = bigger * i;
            if (multiple % smaller == 0) break;
            i++;
        }
        return multiple;
    }
}
