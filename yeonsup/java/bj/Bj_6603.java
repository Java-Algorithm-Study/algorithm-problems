package yeonsup.java.bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Bj_6603 {
    private int n;
    private ArrayList<Integer> numbers;
    private int[] digits = new int[6];
    public static StringBuffer sb = new StringBuffer();

    public void getLotto(StringTokenizer st) {
        initialize(st);

        while (digits[0] < numbers.get(n - 6)) {
            sb.append(this.toString());
            sb.append("\n");
            increment(digits.length - 1, 1);
        }

        int j = 0;
        for (int i = n - 6; i < n; i++) {
            digits[j] = numbers.get(i);
            j++;
        }

        sb.append(this.toString() + "\n");
    }

    private void increment(int i, int f) {
        int x = i, y = f;
        if (i > 0 && digits[i] >= numbers.get(n - f)) {
            increment(--x, ++y);
            digits[i] = numbers.get(numbers.indexOf(digits[i - 1]) + 1);
        } else {
            digits[i] = numbers.get(numbers.indexOf(digits[i]) + 1);
        }
    }

    private void initialize(StringTokenizer st) {
        n = Integer.parseInt(st.nextToken());
        numbers = new ArrayList<>();

        // 맨 앞 사이즈를 제외한 입력된 숫자들 ex) 1 2 3 4 5 6 7
        while (st.hasMoreTokens()) {
            numbers.add(Integer.parseInt(st.nextToken()));
        }

        // 각 자릿 수 초기화
        // 1, 2, 3, 4, 5, 6

        for (int i = 0; i < digits.length; i++) {
            digits[i] = numbers.get(i);
        }
    }


    @Override
    public String toString() {
        String[] print = new String[6];
        for (int i = 0; i < 6; i++) {
            print[i] = String.valueOf(digits[i]);
        }
        return String.join(" ", print);
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String str = br.readLine();
            if(str.equals("0")) break;
            StringTokenizer st = new StringTokenizer(str, " ");
            getLotto(st);
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
    public static void main(String[] args) throws Exception {
        new Bj_6603().solution();
    }
}

