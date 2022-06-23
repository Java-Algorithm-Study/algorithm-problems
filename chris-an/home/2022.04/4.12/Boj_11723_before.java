import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Boj_11723_before {

    static HashSet<Integer> hs = new HashSet<>();
    static StringBuilder sb = new StringBuilder();

    public static void add(int x) {
        hs.add(x);
    }

    public static void remove(int x) {
        hs.remove(x);
    }

    public static int check(int x) {
        if(hs.contains(x)) return 1;
        else return 0;
    }

    public static void toggle(int x) {
        if(hs.contains(x)) hs.remove(x);
        else hs.add(x);
    }

    public static void all() {
        hs = new HashSet<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20));
    }

    public static void empty() {
        hs.clear();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());
        while (M-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {
                case "add" :
                    add(Integer.parseInt(st.nextToken()));
                    break;

                case "remove" :
                    remove(Integer.parseInt(st.nextToken()));
                    break;

                case "check" :
                    sb.append(check(Integer.parseInt(st.nextToken()))).append('\n');
                    break;

                case "toggle" :
                    toggle(Integer.parseInt(st.nextToken()));;
                    break;

                case "all" :
                    all();
                    break;

                case "empty" :
                    empty();
                    break;
            }
        }
        System.out.println(sb);
    }
}