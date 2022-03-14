import java.util.Scanner;
// 메모리:80196
// 2진수 8진수
// 1. 뒤에서 앞으로 3자리씩 나눠서
// 2. 2^0, 2^1, 2^2를 각 자리와 곱하고 더한게 => 8진수 1자리
// 주어지는 N은 1,000,000을 넘지 x
public class boj_1373 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        String two = sc.next();

        for (int i=two.length(); i> 0; i-=3) {  // 0을 포함하면 sb에 0이 추가됨 -> Runtime Error
            String tmp;
            if (i-3 < 0) {
                tmp =two.substring(0, i);
            } else {
                tmp = two.substring(i - 3, i);
            }
            int strLength = tmp.length();
            int sum = 0;
            // 2진수 -> 8진수 전환 & 각 자리구하면 ++
            for (int j=0; j<strLength; j++) {
                int num = Integer.parseInt(String.valueOf(tmp.charAt(strLength-1-j)));  // char를 그대로 곱하면 char가 아스키코드로 변환되서 곱해짐
                sum += num * Math.pow(2, j);
            }
            sb.append(sum);
        }
        System.out.println(sb.reverse());
    }
}
