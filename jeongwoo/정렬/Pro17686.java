import java.util.Arrays;
import java.util.Comparator;

/**
 * [17686] 파일명 정렬
 * https://programmers.co.kr/learn/courses/30/lessons/17686
 *
 * -아이디어
 * 1. HEAD, NUMBER, TAIL을 가진 클래스를 하나 생성해 준다.
 * 2. 정렬은 HEAD와 NUMBER 기준으로 하기 때문에 Comparator는 HEAD와 NUMBER만 비교한다.
 * 3. HEAD에는 숫자 빼고 다 들어가니까 숫자가 나오기 전까지의 문자를 head에 넣어 주고, 첫 숫자부터 마지막 숫자까지 while을 돌면서 number에 넣어 준다.
 * 4. TAIL은 마지막 숫자 index 이후부터 substring 하는데, TAIL의 경우에는 크기가 0일 수도 있으므로 예외 처리를 한다.
 * 5. 위 과정을 통해 뽑은 HEAD, NUMBER, TAIL로 FILE 클래스 인스턴스를 생성한다.
 * 6. HEAD는 대소문자 구분을 안 하니까 소문자로 바꾸고 비교한다.
 * 7. HEAD가 같다면 NUMBER를 비교한다.
 *
 */

class Pro17686 {
    public static class File {
        private String head;
        private String number;
        private String tail;

        public File(String head, String number, String tail) {
            this.head = head;
            this.number = number;
            this.tail = tail;
        }

        @Override
        public String toString() {
            return head + number + tail;
        }
    }

    public static void main(String[] args) {
        String[] input = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        System.out.println(Arrays.toString(solution(input)));
    }

    public static String[] solution(String[] files) {
        File[] file = new File[files.length];

        for (int i = 0; i < files.length; i++) {
            StringBuilder head = new StringBuilder();
            StringBuilder number = new StringBuilder();
            int index = 0;

            while (!Character.isDigit(files[i].charAt(index))) {
                head.append(files[i].charAt(index++));
            }

            while (Character.isDigit(files[i].charAt(index))) {
                number.append(files[i].charAt(index++));
                if (index >= files[i].length()) {
                    break;
                }
            }
            File f = new File(String.valueOf(head), String.valueOf(number), files[i].substring(index));
            file[i] = f;
        }

        Arrays.sort(file, new Comparator<File>() {
            @Override
            public int compare(File f1, File f2) {
                int compareHead = f1.head.toLowerCase().compareTo(f2.head.toLowerCase());
                if (compareHead == 0) {
                    return Integer.parseInt(String.valueOf(f1.number)) - Integer.parseInt(String.valueOf(f2.number));
                }
                else {
                    return compareHead;
                }
            }
        });

        String[] answer = new String[file.length];
        for (int i = 0; i < file.length; i++) {
            answer[i] = file[i].toString();
        }
        return answer;
    }
}
