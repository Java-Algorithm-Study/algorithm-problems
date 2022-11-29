import java.util.Arrays;

/**
 * [17686] 파일명 정렬
 * https://programmers.co.kr/learn/courses/30/lessons/17686
 *
 * -아이디어
 * 1. 파일은 Head, Number, Tail로 나뉜다.
 * 2. Head: 최소 한 글자 이상의 숫자가 아닌 문자로 이루어짐
 * 3. Number: 한 글자에서 최대 다섯 글자 사이의 연속된 숫자, 00000 ~ 99999까지 가능, 맨앞에 0이 올 수도 있음. -> 01 가능
 * 4. Tail: Number 뒷부분으로, 숫자가 다시 나타날 수도 있으며, 아무 글자도 없을 수 있다.
 * -- 정렬 기준
 * 1. Head: 사전순, 대소문자 구분 없다.
 * 2. Number: 9 < 10 < 0011 < 012 < 13 < 014 순서로, 앞에 0은 무시된다. 012 == 12
 * 3. Head가 같으면 Number 기준으로 정렬, 둘 다 같으면 들어온 입력 순서대로 정렬한다.
 * 4. 파일명은 영문 대소문자, 숫자, 공백(" "), 마침표("."), 빼기 부호("-")로 이루어짐
 * 5. 위 정렬 기준대로 File 클래스를 만들어 헤드, 넘버, 테일을 각각 구분하고 정렬한다.
 *
 * -시간 복잡도
 * 1. 평균 : O(nlog(n))
 * 2. 최악 : O(n^2) <= 1000 * 1000
 *
 * -자료 구조
 * 1. File Class : 파일을 head, number, tail로 나눔
 *
 */

public class Pro17686_Again {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[] {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"})));
        int count = 0;
        int num = 25;
        while (num >= 5) {
            count += num / 5;
            num /= 5;
        }
        System.out.println(count);
    }

    static class File implements Comparable<File> {
        private String head;
        private String number;
        private String tail;

        public File(String head, String number, String tail) {
            this.head = head;
            this.number = number;
            this.tail = tail;
        }

        @Override
        public int compareTo(File f) {
            int compareHead = this.head.toUpperCase().compareTo(f.head.toUpperCase());

            if (compareHead == 0) {
                return Integer.parseInt(this.number) - Integer.parseInt(f.number);
            }
            else {
                return compareHead;
            }
        }

        @Override
        public String toString() {
            return head + number + tail;
        }
    }

    public static String[] solution(String[] files) {
        // String[] files를 File 클래스 배열을 만들고 넣는다.
        File[] file = new File[files.length];

        for (int i = 0; i < file.length; i++) {
            StringBuilder head = new StringBuilder();
            StringBuilder number = new StringBuilder();

            int idx = 0;

            while (!Character.isDigit(files[i].charAt(idx))) {
                head.append(files[i].charAt(idx++));
            }

            while (Character.isDigit(files[i].charAt(idx))) {
                number.append(files[i].charAt(idx++));
                if (idx >= files[i].length()) {
                    break;
                }
            }

            file[i] = new File(head.toString(), number.toString(), files[i].substring(idx));
        }

        Arrays.sort(file);
        String[] answer = new String[file.length];
        for (int i = 0; i < file.length; i++) {
            answer[i] = file[i].toString();
        }
        return answer;
    }
}
