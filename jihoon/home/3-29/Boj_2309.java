import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj_2309 {
    private static int[] heights = new int[9];
    
    public static void find(int diff) {
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (heights[i] + heights[j] == diff) {
                    heights[i] = -1;
                    heights[j] = -1;
                    return;
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        var bf = new BufferedReader(new InputStreamReader(System.in));
        var sb = new StringBuilder(7);
        
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            int n = Integer.parseInt(bf.readLine());
            heights[i] = n;
            sum += n;
        }
        int diff = sum - 100;
        
        find(diff);
        
        Arrays.sort(heights);
        for (int n : heights) {
            if (n != -1) sb.append(n).append("\n");
        }
    
        System.out.println(sb);
    }
}
