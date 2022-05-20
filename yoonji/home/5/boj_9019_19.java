import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// DSLR
/* whiteboard
 레지스터 (0~10000)의 각 자릿수에 대해 DSLR
 D: n*2 -> 결과값이 9999보다 크면, 10000으로 나눈 나머지를 저장.
 S: n-1 -> but, n이 0이면 9999가 저장
 L: 자리를 하나씩 왼쪽으로 이동 ex) 1234 -> 2341  :
 R : 자리를 하나씩 오른쪽으로 이동 ex) 1234 -> 4123
 A, B가 주어지고 A를 B로 만드는데 필요한 최소한의 연산
 A: 1234, B: 3412라면, LL or RR
 1234 --L--> 2341 --L--> 3412
 1234 --R--> 4123 --R--> 3412
 주의. 0이 포함된 경우
 1000 --L--> 1
 1000 --R--> 100
 A,B는 0~9999
2345 10000으로 나눈 몫을 10000으로 나눈 나머지 뒤에 덧붙인다
 34 -> 43
 2345 -> 3452
 1000 -> 0001
 1000 -> 0100
 10 -> 01
*/
public class boj_9019_19 {
    static boolean[] visited;
    static StringBuilder log = new StringBuilder();
    static char[] DSLR = {'D', 'S', 'L', 'R'};
    private static class RegisterInfo {
        int num;
        String orders;
        RegisterInfo (int num, String orders) {
            this.num = num;
            this.orders = orders;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t=0; t<T; t++) {
            String[] line = br.readLine().split(" ");
            int A = Integer.parseInt(line[0]);
            int B = Integer.parseInt(line[1]);
            visited = new boolean[10000];
            bfs(A, B);
        }
        System.out.println(log);
    }
    private static void bfs(int start, int target) {
        Queue<RegisterInfo> que = new LinkedList<>();
        que.offer(new RegisterInfo(start, ""));
        visited[start] = true;
        while (!que.isEmpty()) {
            RegisterInfo now = que.poll();
            if (now.num == target) {
                log.append(now.orders).append("\n");
                return;
            }
            for (int i=0; i<4; i++) {
                int nxt=0;
                String tmpStr;
                StringBuilder sb;
                switch(i) {
                    case 0:
                        nxt = now.num*2;
                        if (nxt > 9999) nxt %= 10000;
                        break;
                    case 1:
                        nxt = now.num==0? 9999:now.num-1;
                        break;
                    case 2:
                        nxt = (now.num % 1000 * 10) + now.num / 1000;   // 1234->2340+1, 0034->340+0
                        break;
                    case 3:
                        nxt = (now.num % 10 * 1000) + now.num / 10;    // 1234 -> 40000+123
                        /* 시간초과..
                        if (now.num<10) nxt = now.num;  //1
                        else {
                            tmpStr = String.valueOf(now.num);
                            System.out.println(tmpStr);
                            sb = new StringBuilder(tmpStr.charAt(tmpStr.length() - 1));
                            sb.append(tmpStr.substring(0, tmpStr.length() - 1));
                            nxt = Integer.parseInt(sb.toString());
                            sb.setLength(0);
                        }*/
                }
                if (visited[nxt]) continue;
                visited[nxt] = true;
                que.offer(new RegisterInfo(nxt, now.orders+DSLR[i]));
            }
        }
    }
}