import java.util.Stack;

/**
 * 정확성: 9.0
 * 효율성: 14.0
 * 합계: 23.0 / 100.0
 */
public class prg_표편집_try {
    int[] graph;
    Stack<Integer> trashStack = new Stack<>();
    public String solution(int n, int k, String[] cmd) {
        graph = new int[n];
        int cursor = k;

        // 명령문 수행 (삭제 시 1)
        for (String order: cmd) {
            switch(order.charAt(0)) {
                case 'Z' : recover();break;
                case 'C': cursor = remove(cursor); break;
                default : cursor = moveCursor(order.charAt(0), cursor, Integer.parseInt(String.valueOf(order.charAt(2)))); break;
            }
        }
        StringBuilder answer = new StringBuilder();
        for (int isDeleted: graph) {
            if (isDeleted==0) answer.append('O');
            else answer.append('X');
        }
        return answer.toString();
    }

    private void recover() {
        int idx = trashStack.pop();
        graph[idx] = 0;
    }
    private int remove(int cursor) {
        graph[cursor] = 1;
        trashStack.push(cursor);
        // 커서 이동
        if (cursor == graph.length-1) cursor--;
        else cursor++;
        return cursor;
    }
    private int moveCursor(char order, int cursor, int moveCnt) {
        int tmpCursor=0;
        while (moveCnt > 0) {
            if (order == 'D') cursor++;
            if (order == 'U') cursor--;
            if (graph[cursor] == 0) {
                moveCnt--;
            }
        }
        return cursor;
    }
    public static void main(String[] args) {
        prg_표편집_try t = new prg_표편집_try();
        String solution = t.solution(8, 2, new String[]{"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"});
        System.out.println(solution);
    }
}
