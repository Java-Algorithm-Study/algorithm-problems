import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * [11723] 집합
 * https://www.acmicpc.net/problem/11723
 *
 * -아이디어
 * 1. 공집합 S를 arrayList로 만든다.
 *
 * -시간 복잡도
 * 1.
 *
 * -자료 구조
 * 1.
 */

public class Boj11723 {
    private static ArrayList<Integer> set = new ArrayList<>();
    private static Integer[] all = new Integer[20];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < 20; i++) {
            all[i] = i + 1;
        }

        while (m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            int x = 0;

            switch (op) {
                case "add" :
                    x =  Integer.parseInt(st.nextToken());
                    add(x);
                    break;

                case "remove" :
                    x =  Integer.parseInt(st.nextToken());
                    remove(x);
                    break;

                case "check" :
                    x =  Integer.parseInt(st.nextToken());
                    sb.append(check(x)).append('\n');
                    break;

                case "toggle" :
                    x =  Integer.parseInt(st.nextToken());
                    toggle(x);
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

    private static void add(int x) {
        if (set.contains(x)) {
            return;
        }
        else {
            set.add(x);
        }
    }

    private static void remove(int x) {
        if (set.contains(x)) {
            set.remove(Integer.valueOf(x));
        }
        else {
            return;
        }
    }

    private static int check(int x) {
        if (set.contains(x)) {
            return 1;
        }
        else {
            return 0;
        }
    }

    private static void toggle(int x) {
        if (set.contains(x)) {
            set.remove(Integer.valueOf(x));
        }
        else {
            set.add(x);
        }
    }

    private static void all() {
        set = new ArrayList<>(List.of(all));
    }

    private static void empty() {
        set = new ArrayList<>();
    }
}
