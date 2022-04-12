import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_2529_before {

    static int K;
    static int[] arrTemp;
    static boolean[] visited = new boolean[10];
    static List<String> signOfInequality = new ArrayList<>();
    //    static Long max = Long.MIN_VALUE;
//    static Long min = Long.MAX_VALUE;
    static StringBuilder sb = new StringBuilder();
    static List<String> outPutDataArr = new ArrayList<>();

    static void backTracking(int depth) {

        // 베이스케이스
        if (depth == K+1) {
            sb.append(arrTemp[0]);
            for (int i = 0; i < signOfInequality.size(); i++) {
                if ("<".equals(signOfInequality.get(i))) {
                    if (!(arrTemp[i] < arrTemp[i+1])) {
                        sb.setLength(0);
                        return;
                    }
                }else if (">".equals(signOfInequality.get(i))) {
                    if (!(arrTemp[i] > arrTemp[i+1])) {
                        sb.setLength(0);
                        return;
                    }
                }

                sb.append(arrTemp[i+1]);
            }
            outPutDataArr.add(sb.toString());

            /* 수정 전
                max = Math.max(max, Long.parseLong(sb.toString()));
                min = Math.min(min, Long.parseLong(sb.toString()));
             */

            sb.setLength(0);
            return;
        }

        // 루프
        for (int i = 0; i < 10; i++) {

            if (!visited[i]) {
                visited[i] = true;
                arrTemp[depth] = i;
                backTracking(depth + 1);
                visited[i] = false;
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        arrTemp = new int[K+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            signOfInequality.add(st.nextToken());
        }

        backTracking(0);

        /* 수정 전
            String minStr;
            if (String.valueOf(min).length() == 2) {
                minStr = "0" + min;
            }else minStr = String.valueOf(min);

            System.out.println(max);
            System.out.println(minStr);
         */


        Collections.sort(outPutDataArr);
        System.out.println(outPutDataArr.get(outPutDataArr.size()-1));
        System.out.println(outPutDataArr.get(0));
    }
}
