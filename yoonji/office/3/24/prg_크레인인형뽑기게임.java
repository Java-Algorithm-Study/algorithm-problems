import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class prg_크레인인형뽑기게임 {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> basket = new Stack<>();
        Stack<Integer> [] playBox = new Stack[board.length];
        int cnt = 0;
        // 1. playBox 초기화
        for (int i=0; i<board.length; i++) {
            playBox[i] =  new Stack<>();
        }
        // 2. 행은 --, 각 열은 ++해서 반복을 돌면, 각 인덱스를 돌면서 스택에 push한다.
        for (int i = board.length-1; i >= 0 ; i--) {
            for (int j = 0; j < board[i].length; j++) {
                playBox[j].push(board[i][j]);
            }
        }
        // 3. 크레인 작동!
        for (int i = 0; i < moves.length; i++) {
            if(isOnePlayBoxEmpty(playBox[moves[i]-1])) continue;
            int doll = playBox[moves[i]-1].pop();
            while(doll == 0) {
                doll = playBox[moves[i]-1].pop();
            }
            // 바구니가 비어있을 경우, 인형 추가
            if (basket.empty()) basket.push(doll);
            else {
                // 바구니 속 인형과 일치하면, 인형을 빼고 숫자 증가. 일치하지 않으면 인형만 추가
                if (doll == basket.peek()) {
                    basket.pop();
                    cnt += 2;
                }else {
                    basket.push(doll);
                }
            }
        }
        return cnt;
    }

    private boolean isOnePlayBoxEmpty(Stack<Integer> oneStackInPlayBox) {
        if (oneStackInPlayBox.empty()) return true;
        else return false;
    }

    public static void main(String[] args) {
        prg_크레인인형뽑기게임 t = new prg_크레인인형뽑기게임();
        int solution = t.solution(new int[][]{{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}}, new int[]{1, 5, 3, 5, 1, 2, 1, 4});
        System.out.println(solution);
    }
}