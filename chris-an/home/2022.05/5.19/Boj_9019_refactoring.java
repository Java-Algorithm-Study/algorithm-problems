import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


/*
    코드 리팩토링
 */

public class Boj_9019_refactoring {
    static Queue<Register> qu;
    static boolean[] visited;
    static int B;

    static class Register {
        int value;
        String orderStack;

        Register(int value, String orderStack) {
            this.value = value;
            this.orderStack = orderStack;
        }

        int D() {
            return (value * 2) % 10000;
        }
        int S() {
            return value == 0 ? 9999 : value - 1;
        }
        int L() {
            return value % 1000 * 10 + value / 1000;
        }
        int R() {
            return value % 10 * 1000 + value / 10;
        }
    }
    
    static void bfs() {
        while (!qu.isEmpty()) {
            Register regi = qu.poll();

            if (regi.value == B) {
                System.out.println(regi.orderStack);
                break;
            }

            if (!visited[regi.D()]) {
                qu.add(new Register(regi.D(), regi.orderStack + "D"));
                visited[regi.D()] = true;
            }
            if (!visited[regi.S()]) {
                qu.add(new Register(regi.S(), regi.orderStack + "S"));
                visited[regi.S()] = true;
            }
            if (!visited[regi.L()]) {
                qu.add(new Register(regi.L(), regi.orderStack + "L"));
                visited[regi.L()] = true;
            }
            if (!visited[regi.R()]) {
                qu.add(new Register(regi.R(), regi.orderStack + "R"));
                visited[regi.R()] = true;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int A = sc.nextInt(); 
            B = sc.nextInt();
            visited = new boolean[10_001];
            qu = new LinkedList<>();
            visited[A] = true;
            qu.add(new Register(A, ""));
            bfs();
        }
    }
}