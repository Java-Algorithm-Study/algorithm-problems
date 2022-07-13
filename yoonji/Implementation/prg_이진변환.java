package Implementation;

import java.util.Arrays;
// 까다로웠던 점
// - StringBuilder는 equals()가 오버라이딩되어있지 않아서 equals() -> 주소를 비교한다.  (계속 false가 나온 이유..)
// - String 변수를 그냥 다른 String 변수에 대입하면, 깊은 복사가 되기 때문에 서로 영향을 미치지 않는다.
    // 예) String clone = s;
// - String의 replace()는 변경된 값을 반환할 뿐, this 변수를 바꾸지 않는다.
    // 예) String replace = clone.replace("0", "");

// 이해 (이진변환 문제)
// x의 모든 0 제거 후, x의 길이가 c일 때, 길이 c를 2진법으로 표현한 문자열로 x를 바꾼다.
// 0111010
// 1111  길이 4를 2진법으로 표현->  100(2) -> 이것을 1이 될 때까지 변환하는 횟수와, 변환 중 제거된 0의 갯수를 배열로 리턴.
// s 길이 15만 이하
// 최소 1개 이상 1이 포함.

// 아이디어
// - 0 제거 (removeZeroCnt++)-> 1인지 체크 -> 길이를 이진 변환 -> 1인지 체크 (roundCnt++)
public class prg_이진변환 {
    public int[] solution(String s) {
        int removeZeroCnt = 0;
        int roundCnt = 0;

        while (!isOne(s)) {
            roundCnt++;
             System.out.println("몇판?" +roundCnt+ ", 0제거횟수?"+removeZeroCnt);
            // 0 제거
            String replace = s.replace("0", "");
            removeZeroCnt += s.length() - replace.length();

            if (isOne(replace)) {
                break;
            }
            // 길이를 2진법
            int len = replace.length();
            s = changeLenToTwo(len);
        }
        return new int[]{removeZeroCnt, roundCnt};
    }

    private String changeLenToTwo(int len) {
        StringBuilder sb = new StringBuilder();
        while (len != 1) {
            int mod = len % 2;
            sb.append(mod);
            len/=2;
        }
        return sb.append(1).reverse().toString();
    }

    private boolean isOne(String str) {
        return str.equals("1");
    }

    public static void main(String[] args) {
        prg_이진변환 t = new prg_이진변환();
//        int[] solution = t.solution("01110");
        int[] solution2 = t.solution("1111111");
        System.out.println(Arrays.toString(solution2));
    }
}