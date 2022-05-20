import java.util.HashSet;

public class Pro_4994_1 {
    //    private static boolean[][][] visited = new boolean[11][11][4];
    private static int[][][] horizontal = new int[11][11][11];
    private static int[][][] vertical = new int[11][11][11];
    
    private static int count;
    
    public static int solution(String dirs) {
        int x = 5;
        int y = 5;
        for (int i = 0; i < dirs.length(); i++) {
            char ch = dirs.charAt(i);
            switch (ch) {
                case 'U' -> {
                    if (check(x, y + 1)) continue;
                    if (vertical[y][y + 1][x] == 1) continue;
                    if (vertical[y + 1][y][x] == 1) continue;
                    
                    vertical[y][y + 1][x] = 1;
                    vertical[y + 1][y][x] = 1;
                    y++;
                    count++;
                }
                case 'D' -> {
                    if (check(x, y - 1)) continue;
                    if (vertical[y][y - 1][x] == 1) continue;
                    if (vertical[y - 1][y][x] == 1) continue;
                    
                    vertical[y][y - 1][x] = 1;
                    vertical[y - 1][y][x] = 1;
                    y--;
                    count++;
                }
                case 'R' -> {
                    if (check(x + 1, y)) continue;
                    if (horizontal[x][x + 1][y] == 1) continue;
                    if (horizontal[x + 1][x][y] == 1) continue;
                    
                    horizontal[x][x + 1][y] = 1;
                    horizontal[x + 1][x][y] = 1;
                    x++;
                    count++;
                }
                case 'L' -> {
                    if (check(x - 1, y)) continue;
                    if (horizontal[x][x - 1][y] == 1) continue;
                    if (horizontal[x - 1][x][y] == 1) continue;
                    
                    horizontal[x][x - 1][y] = 1;
                    horizontal[x - 1][x][y] = 1;
                    x--;
                    count++;
                }
            }
        }
        return count;
    }
    
    public static boolean check(int x, int y) {
        return x > 10 || x < 0 || y > 10 || y < 0;
    }
    
    public static void main(String[] args) {
        String str1 = "ULURRDLLU"; // 7
        String str2 = "LULLLLLLU"; // 7
        String str3 = "UUUUUDDDDD"; // 5
        String str4 = "UUUUUUDDDDDD"; // 5
        System.out.println(solution(str1));
    }
}
