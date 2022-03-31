import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_14500 {
    private static final int[][][] shapes = {
            {{0, 0}, {1, 0}, {2, 0}, {3, 0}, {4, 1}}, // 1-1
            {{0, 0}, {0, 1}, {0, 2}, {0, 3}, {1, 4}}, // 1-2
            {{0, 0}, {0, 1}, {1, 0}, {1, 1}, {2, 2}}, // 2-1
            {{0, 0}, {1, 0}, {2, 0}, {2, 1}, {3, 2}}, // 3-1
            {{0, 1}, {1, 1}, {2, 0}, {2, 1}, {3, 2}}, // 3-2
            {{0, 0}, {1, 0}, {1, 1}, {1, 2}, {2, 3}}, // 3-3
            {{0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 3}}, // 3-4
            {{0, 0}, {0, 1}, {0, 2}, {1, 0}, {2, 3}}, // 3-5
            {{0, 0}, {0, 1}, {1, 1}, {2, 1}, {3, 2}}, // 3-6
            {{0, 0}, {0, 1}, {1, 0}, {2, 0}, {3, 2}}, // 3-7
            {{0, 0}, {0, 1}, {0, 2}, {1, 2}, {2, 3}}, // 3-8
            {{0, 0}, {1, 0}, {1, 1}, {2, 1}, {3, 2}}, // 4-1
            {{0, 1}, {1, 0}, {1, 1}, {2, 0}, {3, 2}}, // 4-2
            {{0, 0}, {0, 1}, {1, 1}, {1, 2}, {2, 3}}, // 4-3
            {{0, 1}, {0, 2}, {1, 0}, {1, 1}, {2, 3}}, // 4-4
            {{0, 1}, {1, 0}, {1, 1}, {1, 2}, {2, 3}}, // 5-1
            {{0, 0}, {0, 1}, {0, 2}, {1, 1}, {2, 3}}, // 5-2
            {{0, 1}, {1, 0}, {1, 1}, {2, 1}, {3, 2}}, // 5-3
            {{0, 0}, {1, 0}, {1, 1}, {2, 0}, {3, 2}}, // 5-4
    };
    
    public static void main(String[] args) throws IOException {
        var bf = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(bf.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] board = new int[N][M];
        
        // make board
        for (int i = 0; i < N; i++) {
            var line = new StringTokenizer(bf.readLine(), " ");
            for (int j = 0; j < M; j++) {
                int n = Integer.parseInt(line.nextToken());
                board[i][j] = n;
            }
        }
        
        int max = 0;
    
        for (int[][] shape : shapes) {
            int shapeMax = 0;
            for (int verticalShift = 0; verticalShift <= N - shape[4][0]; verticalShift++) {
                for (int horizontalShift = 0; horizontalShift <= M - shape[4][1]; horizontalShift++) {
                    int sum = 0;
                    for (int i = 0; i < 4; i++) {
                        int v = shape[i][0] + verticalShift;
                        int h = shape[i][1] + horizontalShift;
                        sum += board[v][h];
                    }
                    shapeMax = Math.max(shapeMax, sum);
                }
            }
            max = Math.max(max, shapeMax);
        }
        
        System.out.println(max);
        
        bf.close();
    }
}
