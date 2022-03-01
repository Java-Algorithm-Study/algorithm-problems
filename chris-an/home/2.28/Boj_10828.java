import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 스택 10828문제

public class Boj_10828 {
    private int max;
    private int ptr;
    private int [] stk;

    public Boj_10828(int capacity) {
        ptr = 0;
        max = capacity;
        stk = new int[max];
    }

    public void push (int input) {
        stk[ptr++] = input;
    }

    public int pop() {
        if(ptr <= 0) return -1;
        return stk[--ptr];
    }

    public int top() {
        if (ptr <= 0)
            return -1;
        return stk[ptr-1];
    }

    public int size() {
        return ptr;
    }

    // 안 비어있으면, 0  비어있으면 1
    public int empty() {
        if (ptr <= 0) return 1;
        else return 0;
    }


    public static void main(String [] arg) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int capacity = Integer.parseInt(br.readLine());
        Boj_10828 sk = new Boj_10828(capacity);

        while(capacity > 0) {

            int input;
            st = new StringTokenizer(br.readLine(), " ");

            switch (st.nextToken()) {
                case "push":
                    input = Integer.parseInt(st.nextToken());
                    sk.push(input);
                    break;

                case "pop":
                    System.out.println(sk.pop());
                    break;

                case "size":
                    System.out.println(sk.size());

                    break;

                case "empty":
                    System.out.println(sk.empty());
                    break;

                case "top":
                    System.out.println(sk.top());
                    break;
            }
            capacity--;
        }
    }
}























