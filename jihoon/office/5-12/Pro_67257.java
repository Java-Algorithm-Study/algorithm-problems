import java.util.*;

public class Pro_67257 {
    List<Long> numbers = new ArrayList<>();
    List<Character> operations = new ArrayList<>();
    boolean[] visited = new boolean[3];
    char[] operationsByPriority;
    List<Character> nonOverlappedOpers = new ArrayList<>();
    long max = Long.MIN_VALUE;
    
    public long solution(String expression) {
        // 1. expression을 두 List로 나눈다.
        int idx = 0;
        for (int i = 0; i < expression.length(); i++) {
            char curr = expression.charAt(i);
            if (!Character.isDigit(curr)) {
                numbers.add(Long.parseLong(expression.substring(idx, i)));
                idx = i + 1;
                operations.add(curr);
                if (!nonOverlappedOpers.contains(curr)) nonOverlappedOpers.add(curr);
            }
        }
        numbers.add(Long.parseLong(expression.substring(idx))); // 마지막 피연산자 처리
        // 전체 연산자 갯수에 따라
        operationsByPriority = new char[nonOverlappedOpers.size()];
        visited = new boolean[nonOverlappedOpers.size()];
        setPriorityByDfs(0);
        return max;
    }
    
    // 2. 연산지를 dfs로 경우의 수를 구해서 우선순위를 정한다.
    private void setPriorityByDfs(int depth) {
        if (depth == nonOverlappedOpers.size()) {
            calculate();
            return;
        }
        for (int i = 0; i < nonOverlappedOpers.size(); i++) {
            if (visited[i]) continue;
            visited[i] = true;
            operationsByPriority[depth] = nonOverlappedOpers.get(i);
            setPriorityByDfs(depth + 1);
            visited[i] = false;
        }
    }
    
    // 3. 정해진 우선순위로 계산한다.
    // 연산자ByPriority와 피연산자로 계산.
    List<Long> copiedNum;
    List<Character> copiedOper;
    private void calculate() {
        List<Long> copiedNum = new ArrayList<>(numbers);
        List<Character> copiedOper = new ArrayList<>(operations);
        long sum = 0;
        for (int i = 0; i < operationsByPriority.length; i++) {
            int idx = 0;
            char curr = operationsByPriority[i];
            while (idx <= copiedOper.size() - 1) {
                //현재 우선순위 연산자 curr과 비교
                if (curr == copiedOper.get(idx)) {
                    switch (curr) {
                        case '*':
                            sum = (copiedNum.get(idx) * copiedNum.get(idx + 1));
                            removeAndAddToList(idx, sum);
                            break;
                        case '+' :
                            sum = (copiedNum.get(idx) + copiedNum.get(idx + 1));
                            removeAndAddToList(idx, sum);
                            break;
                        case '-' :
                            sum = (copiedNum.get(idx) - copiedNum.get(idx + 1));
                            removeAndAddToList(idx, sum);
                    }
                } else idx++; // 해당 연산자가 아닌 경우 다음 idx 검사
            }
        }
        sum = Math.abs(sum);
        max = Math.max(max, sum);
    }
    private void removeAndAddToList(int idx, long sum) {
        copiedNum.remove(idx);
        copiedNum.remove(idx);
        copiedNum.add(idx, sum);
        copiedOper.remove(idx);
    }
    public static void main(String[] args) {
        String expression = "100-200*300-500+20";
        String ex3 = "1+2+3";
        String ex2 = "50*6-3*2";
        Pro_67257 t = new Pro_67257();
        System.out.println(t.solution(ex3));
    }
    
}