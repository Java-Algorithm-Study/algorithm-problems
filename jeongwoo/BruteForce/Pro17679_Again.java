/**
 * [17679] 프렌즈 4 블록
 * https://programmers.co.kr/learn/courses/30/lessons/17679
 *
 * -아이디어
 * 1. 한 블록당 오른쪽 아래 즉, (x, y) (x, y+1) (x+1, y) (x+1, y+1)을 확인한다.
 * 2. 다 같은 모양이라면 해당 세트는 삭제 표시를 한다.
 * 3. 삭제 표시된 곳에 대해 점수를 추가한다.
 * 4. 삭제된 곳 (X 표시가 있는 블럭)에 위에 있는 블럭들을 내린다. (자리 이동)
 * 5. 위 과정을 전체 블럭에서 삭제되는 칸이 0일 때까지 반복한다.
 *
 * -시간 복잡도
 * 1. O(n^3) = 30^3 이하 
 *
 * -자료 구조
 * 1. char[][] : 블록
 * 2. boolean[][] : 삭제 표시
 *
 */

public class Pro17679_Again {
    public static void main(String[] args) {
        System.out.println(solution(4, 5, new String[] {"CCBDE", "AAADE", "AAABF", "CCBBF"}));
    }
    public static int solution(int m, int n, String[] board) {
        int answer = 0;

        char[][] map = new char[m][n];

        for (int i = 0; i < map.length; i++) {
            map[i] = board[i].toCharArray();
        }

        while (true) {
            boolean[][] isDeleted = new boolean[m][n];
            // 맵 탐색
            int count = checkOneMap(map, isDeleted);

            // 삭제할 블록이 없으니까 끝낸다
            if (count == 0) {
                return answer;
            }

            // 이번 탐색에서 삭제된 블록들을 총 합에 더한다.
            answer += count;

            // 블록 내리기
            moveBlocks(map);

        }
    }

    private static int checkOneMap(char[][] map, boolean[][] isDeleted) {
        int deletedCount = 0;

        // 해당 블록에 오른쪽 아래 세트를 확인하니까 (3, 3)이라면 (2, 2)에서 확인하니까 map.length - 1까지만 확인하면 된다.
        for (int i = 0; i < map.length - 1; i++) {
            for (int j = 0; j < map[i].length - 1; j++) {
                if (map[i][j] == 'X') {
                    continue;
                }

                checkFourBlocks(i, j, map, isDeleted);
            }
        }

        // checkFourBlocks()에서 삭제 표시된 블럭들을 X로 바꾸고, 삭제된 칸들을 더한다.
        for (int i = 0; i < isDeleted.length; i++) {
            for (int j = 0; j < isDeleted[i].length; j++) {
                if (isDeleted[i][j]) {
                    map[i][j] = 'X';
                    deletedCount++;
                }
            }
        }

        return deletedCount;
    }

    private static void checkFourBlocks(int x, int y, char[][] map, boolean[][] isDeleted) {
        char now = map[x][y];

        for (int i = x; i < x + 2; i++) {
            for (int j = y; j < y + 2; j++) {
                // 하나라도 다르다면 삭제하지 못하는 칸이니까 리턴한다.
                if (map[i][j] != now) {
                    return;
                }
            }
        }

        for (int i = x; i < x + 2; i++) {
            for (int j = y; j < y + 2; j++) {
                // 삭제 가능하다고 표시한다.
                isDeleted[i][j] = true;
            }
        }
    }

    private static void moveBlocks(char[][] map) {
        for (int i = 0; i < map[0].length; i++) {
            for (int j = map.length - 1; j >= 0; j--) {
                if (map[j][i] == 'X') {

                    for (int k = j - 1; k >= 0; k--) {
                        if (map[k][i] == 'X') {
                            continue;
                        }
                        map[j][i] = map[k][i];
                        map[k][i] = 'X';
                        break;
                    }
                }
            }
        }
    }
}
