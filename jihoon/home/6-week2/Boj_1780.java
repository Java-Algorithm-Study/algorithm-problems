import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Boj_1780 {
    private static Map<Integer, Integer> map = new HashMap<>();
    
    public static boolean check(int[][] paper) {
        int n = paper[0][0];
        for (int i = 0; i < paper.length; i++) {
            for (int j = 0; j < paper[0].length; j++) {
                if (paper[i][j] != n) return false;
            }
        }
        return true;
    }
    
    public static void split(int[][] paper) {
        if (check(paper)) {
            map.put(paper[0][0], map.getOrDefault(paper[0][0], 0) + 1);
            return;
        }
    
        int paperSize = paper.length / 3;
        for (int i = 0; i < paper.length; i += paperSize) {
            for (int j = 0; j < paper.length; j += paperSize) {
                int[][] slicedPaper = new int[paperSize][paperSize];
                for (int x = 0; x < paperSize; x++) {
                    for (int y = 0; y < paperSize; y++) {
                        slicedPaper[x][y] = paper[i + x][j + y];
                    }
                }
                split(slicedPaper);
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] paper = new int[N][N];
    
        for (int i = 0; i < N; i++) {
            var st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        split(paper);
    
        System.out.println(map.getOrDefault(-1, 0));
        System.out.println(map.getOrDefault(0, 0));
        System.out.println(map.getOrDefault(1, 0));
    }
}
