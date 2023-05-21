package language.java.Programmers;

public class Pro_49994 {
    private static boolean[][][] visited = new boolean[11][11][4];
    private static int count;

    public static int solution(String dirs) {
        int x = 5;
        int y = 5;
        for (int i = 0; i < dirs.length(); i++) {
            char ch = dirs.charAt(i);
            switch (ch) {
                case 'U' :
                    if (check(x, y + 1)) continue;
                    visited[x][y][1] = true;
                    y++;
                    if (visited[x][y][0]) continue;
                    visited[x][y][0] = true;
                    count++;
                    break;

                case 'D' :
                    if (check(x, y - 1)) continue;
                    visited[x][y][0] = true;
                    y--;
                    if (visited[x][y][1]) continue;
                    visited[x][y][1] = true;
                    count++;
                    break;

                case 'R' :
                    if (check(x + 1, y)) continue;
                    visited[x][y][3] = true;
                    x++;
                    if (visited[x][y][2]) continue;
                    visited[x][y][2] = true;
                    count++;
                    break;
                case 'L' :
                    if (check(x - 1, y)) continue;
                    visited[x][y][2] = true;
                    x--;
                    if (visited[x][y][3]) continue;
                    visited[x][y][3] = true;
                    count++;
                    break;

            }
        }
        return count;
    }

    public static boolean check(int x, int y) {
        return x > 10 || x < 0 || y > 10 || y < 0;
    }
}
