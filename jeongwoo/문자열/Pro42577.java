import java.util.Arrays;

/**
 * [42577] 전화번호 목록
 * https://programmers.co.kr/learn/courses/30/lessons/
 *
 * -아이디어
 * 1. 입력받은 전화번호 목록을 오름차순으로 정렬한다.
 * 2. 목록을 돌면서 이전 번호로 시작하는 원소가 배열에 있다면 false를 return
 * 3. 목록을 다 돌게 된다면 true;
 *
 */

public class Pro42577 {
    public static void main(String[] args) {
        String[] input = {"12", "112", "13", "1245", "567", "88"};
        System.out.println("main: " + solution(input));
    }

    public static boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length; i++) {
            System.out.println(phone_book[i]);
        }

        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }

        return true;
    }
}
