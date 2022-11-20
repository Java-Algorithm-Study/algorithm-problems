import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea1206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        for(int test_case = 1; test_case <= 10; test_case++) {
            int n = Integer.parseInt(br.readLine());
            int[] buildings = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                buildings[i] = Integer.parseInt(st.nextToken());
            }

            int total = 0;

            for (int i = 2; i < n - 2; i++) {
                int now = buildings[i];

                // 왼쪽 뷰 확인
                int left = Math.max(buildings[i - 1], buildings[i - 2]);

                // 오른쪽 뷰 확인
                int right = Math.max(buildings[i + 1], buildings[i + 2]);

                if (left >= now || right >= now) {
                    continue;
                }

                total +=  now - Math.max(left, right);
            }

           sb.append("#").append(test_case).append(" ").append(total).append("\n");

        }

        System.out.println(sb.toString());
    }
}
