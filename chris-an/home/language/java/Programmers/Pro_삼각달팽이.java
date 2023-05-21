package language.java.Programmers;

public class Pro_삼각달팽이 {
    public int[] solution(int n) {
        int[] answer = new int[(n*(n+1))/2];

        int[][] matrix = new int[n][n];
        int x = -1, y = 0;
        int num = 1;

        // 좌표값으로 접근
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i % 3 == 0) {
                    x++;
                } else if (i % 3 == 1) {
                    y++;
                } else if (i % 3 == 2) {
                    x--;
                    y--;
                }
                matrix[x][y] = num++;
            }
        }

        // 값 뽑아 내기
        int k = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == 0)
                    break;
                answer[k++] = matrix[i][j];
            }
        }

        return answer;
    }
}



/*
2022.07.26
제한시간 1시간

failed

class Solution {
    int[][] map;
    int count = 1;
    // 수평
    public void roop1(int k, int idx) {
        for (int i = idx; i < k; i++) {
            map[idx][i] = count++;
        }
    }

    // 사선
    public void roop2(int k, int idx, int row) {
        for (int i = k; i >= 0; i--;) {
            map[row][idx] = count++;
        }
    }

    // 수직
    public void roop3(int k, int idx, int col) {
        for (int i = idx; i < k; i++) {
            map[i][col] = count++;
        }
    }

    public int[] solution(int n) {
        int[] answer = {};
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            map[i][0] = count++;
        }

        int type = 0;

        int r1Idx = 0;
        int r2Idx = n-1;
        int r3Idx = 1;

        int col = 1, row = n-1;

        for (int k = n; k >= 0; k--) {
            int tmp = type % 3;
            // 수평
            if(tmp == 0) {
                roop1(k, r1Idx);
                r1Idx++;
            // 사선
            }else if(tmp == 1) {
                roop2(k, r2Idx, row);
                r2Idx -= 2;
                row--;
            // 수직
            }else {
                roop3(k, r3Idx, col);
                r3Idx += 2;
                col++;
            }
            type++;
        }

        return answer;
    }
}
*/