/**
 * [17679] 프렌즈 4 블록
 * https://programmers.co.kr/learn/courses/30/lessons/17679
 *
 * -아이디어
 * 1. x, y에 대해서 (x, y) (x, y+1) (x+1, y) (x+1, y+1)이 같은 그림인지 검사한다.
 * 2. 같다면 삭제할 수 있으니까 삭제 표시를 한다.
 * 3. 맵 한 판을 다 검사했으면 한 번 맵을 돌 때 몇 개를 삭제할 수 있는지 개수를 카운팅한다.
 * 4. 카운팅 후에는 삭제한 블록이 있는 칸에 위에 있는 블록들로 덮는다.
 * 5. 삭제할 블록이 없을 때까지 1 ~ 4를 반복한다.
 *
 */

public class Pro17679 {
    public static void main(String[] args) {
        String[] input = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
        System.out.println(solution(4, 5, input));
    }

    public static int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] map = new char[m][n];

        for (int i = 0; i < map.length; i++) {
            map[i] = board[i].toCharArray();
        }

        while (true) {
            boolean[][] isDeleted = new boolean[m][n];
            int count = checkMap(map, isDeleted);
            if (count == 0) {
                break;
            }
            answer += count;
            downBlock(map);
        }


        return answer;
    }

    // 맵 한 판을 전부 다 검사
    private static int checkMap(char[][] map, boolean[][] isDeleted) {
        int count = 0;

        for (int i = 0; i < map.length - 1; i++) {
            for (int j = 0; j < map[i].length - 1; j++) {
                if (map[i][j] == 'X') {
                    continue;
                }
                checkFourBlock(map, isDeleted, i, j);
            }
        }

        for (int i = 0; i < isDeleted.length; i++) {
            for (int j = 0; j < isDeleted[i].length; j++) {
                if (isDeleted[i][j]) {
                    count++;
                    map[i][j] = 'X';
                }
            }
        }
        return count;
    }

    private static void checkFourBlock(char[][] map, boolean[][] isDeleted, int i, int j) {
        char nowBlock = map[i][j];

        for (int x = i; x < i + 2; x++) {
            for (int y = j; y < j + 2; y++) {
                if (map[x][y] != nowBlock) {
                    return;
                }
            }
        }

        for (int x = i; x < i + 2; x++) {
            for (int y = j; y < j + 2; y++) {
                isDeleted[x][y] = true;
            }
        }
    }

    private static void downBlock(char[][] map) {
        for (int j = 0; j < map[0].length; j++) {
            for (int i = map.length - 1; i >= 0; i--) {
                if (map[i][j] == 'X') {
                    for (int k = i - 1; k >= 0; k--) {
                        if (map[k][j] == 'X') {
                            continue;
                        }
                        map[i][j] = map[k][j];
                        map[k][j] = 'X';
                        break;
                    }
                }
            }
        }
    }

}
