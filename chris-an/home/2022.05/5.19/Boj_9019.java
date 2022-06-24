import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/*
    처음 푼 문제
 */

public class Boj_9019 {
    static String[] registerOrder = {"D", "S", "L", "R"};
    static boolean[] visited;
    static final int orderCnt = 4;
    static Queue<Register> qu;
    static String result;
    static int B;

    static class Register {
        int value;
        String orderStack;

        public Register(int value, String orderStack) {
            this.value = value;
            this.orderStack = orderStack;
        }
    }
    // 10000으로 나눈 나머지 값을 value로 생각
    static void orderD(String order, int value, String orders) {
        //명령어 사용처리
        orders += order;
        //명령어 이행
        value = (value * 2) % 10_000;

        if (value == B) {
            visited[value] = true;
            result = orders;
            return;
        }
        if (!visited[value]) {
            visited[value] = true;
            qu.offer(new Register(value, orders));
        }
    }
    static void orderS(String order, int value, String orders) {
        //명렁어 사용처리
        orders += order;
        //명령어 이행
        if (value == 0) value = 9999;
        else value -= 1;

        if (value == B) {
            visited[value] = true;
            result = orders;
            return;
        }
        if (!visited[value]) {
            visited[value] = true;
            qu.offer(new Register(value, orders));
        }
    }
    static void orderL(String order, int value, String orders) {
        //명렁어 사용처리
        orders += order;

        StringBuilder sb = new StringBuilder();
        String strV = String.valueOf(value);

        // 자리수 맞추기
        if (strV.length() == 4) {
            sb.append(value);
        }else {
            int endLoop = 4 - strV.length();
            for (int i = 0; i < endLoop; i++) {
                sb.append("0");
            }
            sb.append(value);
        }
        // 명령어 이행
        String temp = sb.toString();
        sb.deleteCharAt(0);
        sb.append(temp.charAt(0));
        value = Integer.parseInt(sb.toString());

        if (value == B) {
            visited[value] = true;
            result = orders;
            return;
        }
        if (!visited[value]) {
            visited[value] = true;
            qu.offer(new Register(value, orders));
        }
    }
    static void orderR(String order, int value, String orders) {
        //명렁어 사용처리
        orders += order;

        StringBuilder sb = new StringBuilder();
        String strV = String.valueOf(value);

        // 자리수 맞추기
        if (strV.length() == 4) {
            sb.append(value);
        }else {
            int endLoop = 4 - strV.length();
            for (int i = 0; i < endLoop; i++) {
                sb.append("0");
            }
            sb.append(value);
        }
        // 명령어 이행
        sb.deleteCharAt(sb.length()-1);
        String temp = sb.toString();
        sb.setLength(0);
        sb.append(strV.charAt(strV.length()-1));
        sb.append(temp);
        value = Integer.parseInt(sb.toString());

        if (value == B) {
            visited[value] = true;
            result = orders;
        }

        if (!visited[value]) {
            visited[value] = true;
            qu.offer(new Register(value, orders));
        }
    }
    static void bfs(int a, int b) {
        qu = new LinkedList<>();
        qu.offer(new Register(a, ""));
        visited[a] = true;

        while (!qu.isEmpty()) {
            Register regi = qu.poll();
            int value = regi.value;
            String orders = regi.orderStack;
            if (visited[B]) break;
            for (int i = 0; i < orderCnt; i++) {
                switch (registerOrder[i]) {
                    case "D":
                        orderD(registerOrder[i], value, orders);
                        break;
                    case "S":
                        orderS(registerOrder[i], value, orders);
                        break;
                    case "L":
                        orderL(registerOrder[i], value, orders);
                        break;
                    case "R":
                        orderR(registerOrder[i], value, orders);
                        break;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            visited = new boolean[10_001];
            bfs(A, B);
            System.out.println(result);
        }
    }
}
