import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_1963 {
    static String findValue;
    static PriorityQueue<Number> qu = new PriorityQueue<>();
    static boolean[] visited;

    static class Number implements Comparable<Number> {
        String num;
        int changedNumberCnt;

        public Number(String num, int changedNumberCnt) {
            this.num = num;
            this.changedNumberCnt = changedNumberCnt;
        }

        @Override
        public int compareTo(Number o) {
            return changedNumberCnt - o.changedNumberCnt;
        }
    }
    static void findNumberOfCases (String num, int changedCnt) {
        for (int i = 0; i < 4; i++) {
            if (i == 0) {
                for (int j = 1; j <= 9; j++) {
                    int temp = 0;
                    temp += (j * 1000);
                    temp += (num.charAt(1) - '0') * 100;
                    temp += (num.charAt(2) - '0') * 10;
                    temp += (num.charAt(3) - '0');

                    if (visited[temp]) continue;
                    visited[temp]= true;
                    qu.offer(new Number(String.valueOf(temp), changedCnt + 1));
                }
            }else {
                for (int k = 1; k <= 3; k++) {
                    char[] tempChar = num.toCharArray();
                    for (int j = 0; j <= 9; j++) {
                        tempChar[k] = (char)(j + '0');
                        int number = Integer.parseInt(String.valueOf(tempChar));
                        if (visited[number]) continue;
                        visited[number] = true;
                        qu.offer(new Number(String.valueOf(tempChar), changedCnt + 1));
                    }
                }
            }
        }
    }

    static void isPrime() {
        for(int i = 2; i < 10000; i++) {
            if(!visited[i]) {
                for(int j = i * i; j < 10000; j += i) {
                    visited[j] = true;
                }
            }
        }
    }

    static int bfs() {
        while (!qu.isEmpty()) {
            Number cNum = qu.poll();
            String num = cNum.num;
            int changedCnt = cNum.changedNumberCnt;
            if (num.equals(findValue)) {
                return changedCnt;
            }
            findNumberOfCases(num, changedCnt);
        }

        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            visited = new boolean[10_000];
            isPrime();

            StringTokenizer st = new StringTokenizer(br.readLine());
            String num = st.nextToken();

            qu.offer(new Number(num, 0));
            findValue = st.nextToken();
            System.out.println(bfs());
            qu.clear();
        }
    }
}
