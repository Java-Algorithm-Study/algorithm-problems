import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

// 삽입과 삭제 빈번하다
// LinkedList에서 remove와 add는 리스트의 처음부터 끝까지 탐색하여 O(n)의 시간이 소요
// ListIterator 활용
public class boj_1406 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Character> list = new LinkedList<>();
        ListIterator<Character> iter = list.listIterator();
        String word = br.readLine();
        for (int i=0; i< word.length(); i++)
            iter.add(word.charAt(i));

        int operNum = Integer.parseInt(br.readLine());  // 명령 갯수
        while (operNum-- > 0) {
            String oper = br.readLine();
            switch (oper.charAt(0)) {
                case 'L':
                    if(iter.hasPrevious()) iter.previous();
                    break;
                case 'D':
                    if (iter.hasNext()) iter.next();
                    break;
                case 'B':
                    if (iter.hasPrevious()) {
                        iter.previous();
                        iter.remove();  // 오른쪽 원소를 지우므로
                    }
                    break;
                case 'P':
                    iter.add(oper.charAt(2));
                    break;
            }
        }
        for (char c : list) sb.append(c);
        System.out.println(sb);
    }

    /**
     * 시간초과 뜬 메서드
     * @throws IOException
     */
    void timeExceed() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Character> list = new LinkedList<>();

        String word = br.readLine();
        for (int i=0; i< word.length(); i++)
            list.add(word.charAt(i));

        int cursor = list.size(); // 커서는 길이로 지정

        int operNum = Integer.parseInt(br.readLine());  // 명령 갯수
        while (operNum-- > 0) {
            String oper = br.readLine();
            switch (oper.charAt(0)) {
                case 'L':
                    if (cursor > 0) cursor -= 1;
                    break;
                case 'D':
                    if (cursor < list.size()) cursor += 1;
                    break;
                case 'B':
                    if (cursor > 0) {
                        list.remove(cursor - 1);
                        cursor -= 1;
                    }
                    break;
                case 'P':
                    list.add(cursor, oper.charAt(2));
                    cursor+=1;
                    break;
            }
        }
        for (char c : list) System.out.print(c);
    }
}