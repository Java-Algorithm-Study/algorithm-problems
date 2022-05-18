import java.util.Stack;

//기존
// 쓰레기통을 스택으로 쓴다.
// 제거 시 isDeleted 배열을 1로 세팅. 복구 시 0으로 세팅.
// 변경 부분
// LinkedList를 사용하고, 데이터는 앞뒤 정보를 갖고 있는 Node 클래스를 생성한다.
// index 기준 앞뒤 정보를 갖고 있는 pre, next 배열이 필요하다.
// 매 삭제, 복구마다 answer에 'O', 'X'로 세팅한다.
public class prg_표편집_answer {
    Stack<Node> trashStack = new Stack<>();
    private static class Node {
        int pre;
        int next;
        int curr;
        Node(int pre, int curr, int next) {
            this.pre = pre;
            this.curr = curr;
            this.next = next;
        }
    }
    public String solution(int n, int k, String[] cmd) {
        int[] pre = new int[n];
        int[] next = new int[n];
        // 현재 위치의 앞뒤 번호 저장(맨 앞의 pre는 -1, 맨뒤의 next는 -1
        for (int i = 0; i < n; i++) {
            pre[i] = i - 1;
            next[i] = i + 1;
        }
        next[n - 1] = -1;
        // 미리 OX String을 만들어놓는다.
        StringBuilder answerSB = new StringBuilder("O".repeat(n));

        for (int i = 0; i < cmd.length; i++) {
            char order = cmd[i].charAt(0);
            if (order == 'D') {
                int moveCnt = Integer.parseInt(cmd[i].substring(2));
                while (moveCnt-- > 0) {
                    k = next[k];
                }
            } else if (order == 'U') {
                int moveCnt = Integer.parseInt(cmd[i].substring(2));
                while (moveCnt-- > 0) {
                    k = pre[k];
                }
            } else if (order == 'C') {
                trashStack.push(new Node(pre[k], k, next[k]));
                if (pre[k] != -1) next[pre[k]] = next[k];
                if (next[k] != -1) pre[next[k]] = pre[k];
                answerSB.setCharAt(k, 'X');
                // 커서 조정
                if (next[k] != -1) k=next[k];
                else k = pre[k];
            } else {  // 'Z'
                Node recoveredNode = trashStack.pop();
                if (recoveredNode.pre != -1) next[recoveredNode.pre] = recoveredNode.curr;
                if (recoveredNode.next != -1) pre[recoveredNode.next] = recoveredNode.curr;
                answerSB.setCharAt(recoveredNode.curr, 'O');
            }
        }
        return answerSB.toString();
    }
    public static void main(String[] args) {
        prg_표편집_try t = new prg_표편집_try();
        String solution = t.solution(8, 2, new String[]{"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"});
        System.out.println(solution);
    }
}
