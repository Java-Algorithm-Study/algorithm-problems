public class prg_방문길이 {
    private static boolean[][][] visited = new boolean[11][11][4];
    private static int count;
    private static final int SOUTH = 0;
    private static final int NORTH = 1;
    private static final int WEST = 2;
    private static final int EAST = 3;
    public static int solution(String dirs) {
        int x = 5;
        int y = 5;
        for (int i = 0; i < dirs.length(); i++) {
            char ch = dirs.charAt(i);
            switch (ch) {
                case 'U' :
                    if (!isInBounds(x, y+1)) continue;
                    visited[x][y][NORTH] = true;
                    y++;
                    checkVisited(x, y, SOUTH);
                    break;
                case 'D' :
                    if (!isInBounds(x, y-1)) continue;
                    visited[x][y][SOUTH] = true;
                    y--;
                    checkVisited(x, y, NORTH);
                    break;
                case 'R' :
                    if (!isInBounds(x+1, y)) continue;
                    visited[x][y][EAST] = true;
                    x++;
                    checkVisited(x, y, WEST);
                    break;
                case 'L' :
                    if (!isInBounds(x-1, y)) continue;
                    visited[x][y][WEST] = true;
                    x--;
                    checkVisited(x, y, EAST);
                    break;
            }
        }
        return count;
    }
    private static void checkVisited(int x, int y, int dir) {
        if (visited[x][y][dir]) return;
        visited[x][y][dir] = true;
        count++;
    }
    private static boolean isInBounds(int x, int y) {
        return x <= 10 && x >= 0 && y <= 10 && y >= 0;
    }
    public static void main(String[] args) {
        int ret = solution("ULURRDLLU");
        System.out.println(ret);
    }
}