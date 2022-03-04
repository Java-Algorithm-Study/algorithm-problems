import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 단어뒤집기 2
public class boj_17413 {
    public static void main(String[] args) {
        // 1. 태그 < 이냐?
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        StringBuilder reversedSB = new StringBuilder();

        char[] charArr = sc.nextLine().toCharArray();
        boolean isTag = false;
        for (char c : charArr) {
            switch (c) {
                // 2. < 인 경우, reversedSB 추가 후 < 추가
                case'<' :
                    sb.append(reversedSB.reverse()).append(c);
                    reversedSB.setLength(0);
                    isTag=true;
                    break;
                // 3. >인 경우, reversedSB 추가 후 > 추가
                case'>' :
                    sb.append(reversedSB.reverse()).append(c);
                    reversedSB.setLength(0);
                    isTag = false;
                    break;
                // 4. 문자, 숫자, ' '인 경우
                default:
                    // 4-1. 태그 이면
                    if (isTag) sb.append(c);
                        // 4-2. 태그 밖이면
                    else {
                        if (c == ' ') {  // 태그와 단어 사이에는 공백이 없으니, 공백이면 기존의 단어 reverse 후 추가
                            sb.append(reversedSB.reverse()).append(c);
                            reversedSB.setLength(0);
                        } else {  // 문자나 숫자이면
                            reversedSB.append(c);
                        }
                    }
            }
        }
        // 남은 reversed가 있으면 추가
        if (reversedSB.length() != 0) sb.append(reversedSB.reverse());
        System.out.println(sb);
    }
}
