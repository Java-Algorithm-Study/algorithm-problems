package DP;

import java.util.*;

//2x2 형태 붙으면 사라짐.
// 블록이 여러 2x2에 포함되도 조건에 만족
// 블록이 아래로 떨어져서 빈 공간을 채운다. => 조건 만족하면 또 반복.
// 지워지는 블록이 모두 몇개인가? 8개12
// 탐색하면서, 4개 블록이상 모이면 제거 가능.
// - 제거되려면 2x2 블록 형태여야함.
// T
// TT
// TT
// T 인 경우, line 8,9 T만 제거됨.
// - 세로 행을 한 열로 봐야함
// CCBDE
// AAADE
// AAABF
// CCBBF 이면
// [[CAAC],[CAAC], [BAAB], [BBDD], [FFEE]]로 봐야함.
// CC
// CC
// BB
// BBDD 3, 4-3=1
// FFEE
// 배열 만드는데만 10분ㅋㅋ
// board 한바퀴 돌면서 지울 표시(→↘↓) - 지운다.
// 2x2에 부합하는지를 어떻게 체크해야할지 모르겠음.
public class prg_프렌즈4블록 {
    char[][] charBoard;
    private final static char DELETED_FLAG = '.';
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        charBoard = new char[m][n];
        for (int i=0; i<m; i++) {
            charBoard[i] = board[i].toCharArray();
        }

        while (true) {
            int delCnt = checkBlock(m,n);
            if (delCnt == 0) break; // 겹치는 square가 없다는 의미
            answer += delCnt;

            // 지워진(.) 공간에 블록 내리기
            dropBlock(m, n);
        }
        return answer;
    }

    private int checkBlock(int row, int col) {
        boolean[][] deleted = new boolean[row][col];
        // 한바퀴 탐색 -> 지울곳 표시
        for (int i=1; i<row; i++) {
            for (int j=1; j<col; j++) {
                if (charBoard[i][j] == DELETED_FLAG) {
                    System.out.println("("+i+","+j+")는 이전 판에서 제거(.표시)되었습니다");
                    continue;
                }
                char curr = charBoard[i][j];
                if (curr == charBoard[i][j-1] && curr == charBoard[i-1][j] && curr == charBoard[i-1][j-1]) {
                    deleted[i][j - 1] = true;
                    deleted[i-1][j] = true;
                    deleted[i-1][j - 1] = true;
                    deleted[i][j] = true;
                }
            }
        }
        //전체 순회하며 표시 후, 삭제할 블록 갯수를 구할 수 있음
        return countDeletedFlag(deleted);
    }

    private int countDeletedFlag(boolean[][] deleted) {
        int deletedCnt = 0;
        for (int i=0; i<deleted.length; i++) {
            for (int j=0; j<deleted[0].length; j++) {
                if (deleted[i][j]) {
                    charBoard[i][j] = DELETED_FLAG;
                    deletedCnt++;
                }
            }
        }
        return deletedCnt;
    }

    // .표시 발견하면, 그 위 행들을 순회하며 아래로 하나씩 내린다.
    private void dropBlock(int m, int n) {
        for (int i=m-1; i>0; i--) { // 그 위의 행들을 확인하므로 >0까지.
            for (int j=0; j<n; j++) {
                if (charBoard[i][j] != DELETED_FLAG) continue;
                // 지워진 공간의 같은 행의 상위 열들 순회
                for (int up = i-1; up>=0; up--) {
                    if (charBoard[up][j] != DELETED_FLAG) {
                        charBoard[i][j] = charBoard[up][j];
                        charBoard[up][j] = DELETED_FLAG;
                        break;  // 위 블록들 중 하나라도 찾았으면, 계속 이어서 진행하다, 그위 블록에서 '.'이면 다시 하나씩 아래로 내리는 방식.
                    }
                }
            }
        }
    }
}