import java.util.ArrayList;

/**
 * [17687] N진수 게임
 * https://programmers.co.kr/learn/courses/30/lessons/17687
 *
 * -아이디어
 * 1. 숫자 0부터 x까지 n진법으로 변환하고 ArrayList에 한 자리씩 담는다.
 * 2. 이때 x는 ArrayList에 담긴 개수가 사람 수 * 글자 수(t * m)까지인 숫자이다.
 * 3. m 명이 있고 p번 째 순서이니까 p - 1부터 +m을 하면서 불러야 될 숫자를 ArrayList에서 뽑는다.
 * 4. 이때 뽑은 숫자가 10보다 크다면 (나머지가 10 이상이 되는 건 10진수보다 더 큰 진법이니까) +55를 통해 문자로 바꾼다.
 * 5. x라는 숫자가 확실하게 나오지 않으니까 마지막에 substring으로 t까지만 리턴한다.
 *
 */

public class Pro17687 {
    private static ArrayList<Integer> arrayList = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(solution(16, 16, 2, 1));
    }

    public static String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();

        int cnt = t * m;

        convert(n, cnt);

        for (int i = p - 1; i < arrayList.size(); i += m) {
            int num = arrayList.get(i);

            if (num >= 10) {
                char ch = (char) (arrayList.get(i) + 55);
                sb.append((ch));
            }
            else {
                sb.append(arrayList.get(i));
            }
        }

        return sb.substring(0, t);
    }

    private static void convert(int n, int cnt) {
        arrayList.add(0);
        int start = 0;

        while (arrayList.size() < cnt) {
            int s = start;
            ArrayList<Integer> temp = new ArrayList<>();

            while (s != 0) {
                temp.add(s % n);
                s = s / n;
            }

            for (int i = temp.size() - 1; i >= 0; i--) {
                arrayList.add(temp.get(i));
            }
            start++;
        }
        System.out.println(arrayList);
    }
}
