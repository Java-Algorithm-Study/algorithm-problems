// 크레인 인형뽑기 게임
// https://programmers.co.kr/learn/courses/30/lessons/64061

import java.util.Stack;

public class Pro_64061 {
    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        System.out.println(solution(board, moves));
    }
    
    public static int solution(int[][] board, int[] moves) {
        Stack<Integer> answer = new Stack<>();
        Stack<Integer>[] stk = new Stack[board.length];
        int cnt = 0;
        
        for (int i = 0 ; i < board.length; i++)
            stk[i] = new Stack<>();
        
        for (int i = board.length - 1; i >= 0 ; i--) {
            for (int j = 0; j < board[i].length; j++) {
                stk[j].push(board[i][j]);
            }
        }
        
        for (int i = 0; i < moves.length; i++) {
            
            if (stk[moves[i] - 1].empty()) continue;
            
            int doll = stk[moves[i] - 1].pop();
            
            while (doll == 0)
                doll = stk[moves[i] - 1].pop();
            
            if (answer.empty()) answer.push(doll);
            
            else {
                if (doll == answer.peek()) {
                    answer.pop();
                    cnt += 2;
                }
                else answer.push(doll);
            }
        }
        
        return cnt;
    }
}
