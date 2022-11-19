import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Swea1228 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = 10;

        for(int test_case = 1; test_case <= T; test_case++) {
            List<Integer> list = new ArrayList<>();

            // 1. 암호문 길이
            int n = Integer.parseInt(br.readLine());

            // 2. 원래 암호문을 List에 넣는다.
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            // 3. 명령어 개수
            int commandCount = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < commandCount; i++) {
                // 앞에 I가 나오면
                if (st.nextToken().equals("I")) {
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());

                    for (int j = 0; j < y; j++) {
                        list.add(x, Integer.parseInt(st.nextToken())); // x는 삽입할 자리의 인덱스
                        x++;
                    }
                }
            }

            // 테케 하나 끝나면 출력
            System.out.print("#" + test_case + " ");
            for (int a = 0; a < 10; a++) {
                System.out.print(list.get(a) + " ");
            }
            System.out.println();
        }
    }
}
