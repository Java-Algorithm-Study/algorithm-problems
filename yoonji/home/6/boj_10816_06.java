import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// HashMap으로!
public class boj_10816_06 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> map = new HashMap<>();
        int N = strToInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<N; i++) {
            int num = strToInt(st.nextToken());
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        //  찾기
        int M = strToInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        StringBuilder answerSB = new StringBuilder();
        for (int i=0; i<M; i++) {
            int findNum = strToInt(st.nextToken());
            if (map.containsKey(findNum)) answerSB.append(map.get(findNum));
            else answerSB.append(0);
            answerSB.append(" ");
        }
        System.out.println(answerSB);
    }
    private static int strToInt(String str) {
        return Integer.parseInt(str);
    }
}