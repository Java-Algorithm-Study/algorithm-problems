import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_11651 {
    private static class Point implements Comparable<Point> {
        int x;
        int y;
        
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        @Override
        public String toString() {
            return x + " " + y;
        }
        
        @Override
        public int compareTo(Point o) {
            if (o.y - this.y > 0) return -1;
            else if (o.y - this.y < 0) return 1;
            else {
                return this.x - o.x;
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Point[] points = new Point[N];
        
        for (int i = 0; i < N; i++) {
            var st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points[i] = new Point(x, y);
        }
        
        Arrays.sort(points);
        
        var sb = new StringBuilder();
        for (Point point : points) {
            sb.append(point).append("\n");
        }
        System.out.println(sb);
    }
}
