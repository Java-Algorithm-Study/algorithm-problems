import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Pro_프렌즈4블록 {
    static boolean flag;
    public static int solution(int m, int n, String[] board) {
        Queue<Integer> blocks = new LinkedList<>();
        char[][] newBoard = new char[board.length][board[0].length()];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                newBoard[i][j] = board[i].charAt(j);
            }
        }

        do {
            flag = false;
            for (int i = 0; i < newBoard.length - 1; i++) {
                for (int j = 0; j < newBoard[0].length - 1; j++) {
                    if (newBoard[i][j] == '0') continue; // 이 부분 수정
                    if (check(i, j, newBoard)) {
                        flag = true;
//                        System.out.println(i + " | " + j);
                        blocks.add(i);
                        blocks.add(j);
                    }
                }
            }
            // 지우기
            while (!blocks.isEmpty()) {
                int x = blocks.poll();
                int y = blocks.poll();
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 2; j++) {
                        newBoard[x + i][y + j] = '0';
                    }
                }
            }

            for (int col = 0; col < newBoard[0].length; col++) {
                ArrayList<Character> temp = new ArrayList<>();
                for (int row = newBoard.length - 1; row >= 0; row--) {
                    if (newBoard[row][col] != '0') { // 이 부분 수정
                        temp.add(newBoard[row][col]);
                    }
                }

                for (int i = newBoard.length - 1; i >= 0; i--) {
                    if (temp.size() > 0) newBoard[i][col] = temp.remove(0);
                    else newBoard[i][col] = '0';
                }
            }
        } while (flag);
        return checkZeroInBoard(newBoard);
    }

    public static int checkZeroInBoard(char[][] board) { // 이 부분 추가
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '0') count++;
            }
        }
        return count;
    }

    public static boolean check(int x, int y, char[][] board) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (board[x][y] != board[x + i][y + j]) return false;
            }
        }
        return true;
    }


//    public static void print(char[][] board) {
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[0].length; j++) {
//                sb.append(board[i][j]).append(' ');
//            }
//            sb.append("\n");
//        }
//        System.out.println(sb);
//    }

    public static void main(String[] args) {
        int m = 6;
        int n = 6;
        String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
        String[] board2 = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
        //System.out.println(solution(m, n, board));
        System.out.println(solution(4, 5, board2));
    }
}
