package language.java.Programmers;

import java.util.*;

public class Pro_64061 {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> answer = new Stack<>();
        Stack<Integer> [] stk = new Stack[board.length];
        int cnt = 0;
        // 초기화
        for (int i=0; i<board.length; i++) {
            stk[i] =  new Stack<>();
        }
        for (int i = board.length-1; i >= 0 ; i--) {
            for (int j = 0; j < board[i].length; j++) {
                stk[j].push(board[i][j]);
            }
        }

        for (int i = 0; i < moves.length; i++) {
            if(stk[moves[i]-1].empty()) continue;

            int doll = stk[moves[i]-1].pop();
            while(doll == 0) {
                doll = stk[moves[i]-1].pop();
            }

            //비어있을 경우,
            if (answer.empty()) {
                answer.push(doll);
            }else {
                if (doll == answer.peek()) {
                    answer.pop();
                    cnt += 2;
                }else {
                    answer.push(doll);
                }
            }
        }
        return cnt;
    }
}
