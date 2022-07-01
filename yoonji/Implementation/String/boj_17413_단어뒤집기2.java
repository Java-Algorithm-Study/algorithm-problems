package Implementation.String;

import java.util.Scanner;
// 실버 3
public class boj_17413_단어뒤집기2 {
    public static void main(String[] args) {
        // 태그 만나면 닫는 태그 만날 때까지 sb에 추가
        // 공백 만나면 그 사이의 sb를 바꿔서 추가
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        StringBuilder answer = new StringBuilder();
        StringBuilder tmpSB = new StringBuilder();
        for(int i = 0; i<str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '<') {
                if (tmpSB.length() != 0) {
                    answer.append(tmpSB.reverse());
                    tmpSB.setLength(0);
                }
                answer.append(ch);
                i++;
                while (str.charAt(i) != '>') {
                    answer.append(str.charAt(i));
                    i++;
                }
                answer.append('>');
            }
            else if (ch == ' ') {
                if (tmpSB.length() != 0) {
                    answer.append(tmpSB.reverse());
                    tmpSB.setLength(0);
                }
                answer.append(' ');
            } else { // 문자
                tmpSB.append(ch);
            }
        }
        if (tmpSB.length() != 0) answer.append(tmpSB.reverse());
        System.out.println(answer);
    }
}