import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj_11576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stT = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int A = Integer.parseInt(stT.nextToken());
        int B = Integer.parseInt(stT.nextToken());
        int cnt = Integer.parseInt(br.readLine());

        Stack<Integer> stk = new Stack<>();

        String [] M = br.readLine().split(" ");
        for (int i = 0; i < M.length; i++) {
            stk.add(Integer.parseInt(M[i]));
        }

        int tmp = 0;
        for (int i = 0; i < cnt ; i++) tmp += (stk.pop() * Math.pow(A,i)) ;

        stk.clear();
        while (tmp!=0) {
            stk.add(tmp % B);
            tmp = tmp / B;
        }

        while (!stk.isEmpty()){
            sb.append(stk.pop()).append(" ");
        }
        System.out.println(sb);
    }
}

