import java.util.ArrayList;

/**
 * [67257] 수식 최대화
 * https://programmers.co.kr/learn/courses/30/lessons/67257
 *
 * -아이디어
 * 1. 피연산자와 연산자를 각각 ArrayList에 따로 담는다.
 * 2. DFS로 연산자에 대한 우선순위 순열을 담은 배열을 생성한다.
 * 3. 100 - 200 * 300 - 500 + 20 : -는 인덱스 0, 100과 200은 인덱스 0, 1이다.
 * 4. 계산해야 되는 연산자를 찾고, 그 인덱스 i에 대해서 operand에서 i, i+1에 해당하는 값으로 연산한다.
 * 5. 연산 결과는 operand(i)에 업데이트한다. i+1은 삭제.
 * 6. operand ArrayList 사이즈가 하나씩 줄어드니까 여기 for문 인덱스 i를 하나씩 빼준다.
 *
 */

public class Pro67257 {
    private static boolean[] visited = new boolean[3];
    private static String[] priority = new String[3];
    private static String[] arr = {"-", "*", "+"};
    private static ArrayList<String> operator = new ArrayList<>();
    private static ArrayList<Long> operand = new ArrayList<>();
    private static long max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        String str1 = "100-200*300-500+20";
        System.out.println(solution(str1));
    }

    public static long solution(String expression) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < expression.length(); i++) {
            if (Character.isDigit(expression.charAt(i))) {
                sb.append(expression.charAt(i));
            }
            else {
                operand.add(Long.parseLong(sb.toString()));
                sb.setLength(0);
                operator.add(String.valueOf(expression.charAt(i)));
            }
        }
        operand.add(Long.parseLong(sb.toString()));
        dfs(0);
        return max;
    }

    private static void dfs(int depth) {
        if (depth == 3) {
            ArrayList<String> tempOperator = new ArrayList<>();
            tempOperator.addAll(operator);
            ArrayList<Long> tempOperand = new ArrayList<>();
            tempOperand.addAll(operand);

            for (int i = 0; i < priority.length; i++) {
                for (int j = 0; j < tempOperator.size(); j++) {
                    if (priority[i].equals(tempOperator.get(j))) {
                        String op = tempOperator.remove(j);
                        long op1 = tempOperand.get(j);
                        long op2 = tempOperand.remove(j + 1);
                        long ans = calculate(op, op1, op2);
                        tempOperand.set(j, ans);
                        j--;
                    }
                }
            }
            max = Math.max(max, Math.abs(tempOperand.get(0)));
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (!visited[i]) {
                visited[i] = true;
                priority[depth] = arr[i];
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }

    private static long calculate(String op, long op1, long op2) {
        long result = 0;
        switch (op) {
            case "+" :
                result = op1 + op2;
                break;

            case "-" :
                result = op1 - op2;
                break;

            case "*" :
                result = op1 * op2;
                break;
        }
        return result;
    }
}
