import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class Boj_1406 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        int N = Integer.parseInt(bf.readLine());
        StringBuffer sb = new StringBuffer();

        // 문자열을 담을 LinkedList 선언
        LinkedList<Character> chars = new LinkedList<Character>();

        // 문자열을 char로 쪼개 LinkedList에 담는다
        for (char ch : str.toCharArray()) {
            chars.add(ch);
        }

        // List Iterator 생성
        ListIterator<Character> iter = chars.listIterator();

        // cursor 끝까지 이동
        while(iter.hasNext()){
            iter.next();
        }

        for (int i = 0; i < N; i++) {
            String order = bf.readLine();
            if (order.charAt(0) == 'L') {
                if (iter.hasPrevious()) {
                    iter.previous();
                }
            } else if (order.charAt(0) == 'D') {
                if (iter.hasNext()) {
                    iter.next();
                }
            } else if (order.charAt(0) == 'B') {
                if (iter.hasPrevious()) {
                    iter.previous(); // 제거할 문자, iter.remove()를 사용하기 전에 꼭 previous() 나 next()를 호출해야 한다.
                    iter.remove();
                }
            } else if (order.charAt(0) == 'P') {
                char word = order.split(" ")[1].charAt(0);
                iter.add(word);
            }
        }

        for (char word : chars) {
            sb.append(word);
        }
        System.out.println(sb.toString());
    }

}
