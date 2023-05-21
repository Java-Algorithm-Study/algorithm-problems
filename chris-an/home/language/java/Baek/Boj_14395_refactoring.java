package language.java.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_14395_refactoring {
    //static boolean[] visited = new boolean[1_000_000_001]; // 10의 9승
    static Set<Long> list = new HashSet<>();
    static final char[] operators = {'*', '+', '-', '/'};
    static boolean flag;
    static class Node {
        long s;
        String operator;

        public Node(long s, String operator) {
            this.s = s;
            this.operator = operator;
        }
    }
    static String bfs (long s, int t) {
        String result = "-1";
        if (s == t) return "0";

        Queue<Node> qu = new LinkedList<>();
        //visited[s] = true;
        list.add(s);
        qu.offer(new Node(s, ""));

        while (!qu.isEmpty()) {
            Node curNode = qu.poll();

            if (curNode.s == t) return curNode.operator;
            for (int i = 0; i < operators.length; i++) {
                if (flag && operators[i] == '/') continue;
                long operateS = operateNumber(i, curNode.s);
                if (operateS > t) continue;
                if (curNode.s == 0) continue;

                if (!list.contains(operateS)) {
                    list.add(operateS);
                    qu.offer(new Node(operateS, operatorAdd(curNode.operator, operators[i])));
                }

            }
        }

        return result;
    }

    static String operatorAdd(String operator, char addOperator) {
        StringBuilder sb = new StringBuilder();
        sb.append(operator).append(addOperator);
        return sb.toString();
    }

    static long operateNumber(int i, long s) {
        switch (operators[i]) {
            case '+' :
                s = s + s;
                break;
            case '-' :
                s = s - s;
                break;
            case '*' :
                s = s * s;
                break;
            case '/' :
                s = s / s;
                flag = true;
                break;
        }
        return s;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        System.out.println(bfs(s, t));
    }
}
