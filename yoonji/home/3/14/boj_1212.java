import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// 8진수 2진수
public class boj_1212 {
    static Map<Character, int[]> map = new HashMap<>();
    public static void main(String[] args) {
        makeMap();
        // 값 입력받기
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        StringBuilder answer = new StringBuilder();
        // 각 자리수 반복
        for (int i=0; i<input.length();i++) {
            int[] tmp = map.get(input.charAt(i));
            // 8진수에 해당하는 2진수를 배열에서 찾아서 append
            for (int j=0; j<3; j++) {
                answer.append(tmp[j]);
            }
            if (i==0) {   // 첫번째 문자의 앞 0을 지워야함. string을 int로 바꾸면 0이 있을 경우 자동으로 지워짐
                int forNoFirstZero = Integer.parseInt(answer.toString());
                answer.setLength(0);
                answer.append(forNoFirstZero);
            }
        }
        System.out.println(answer);
    }

    private static void makeMap() {
        map.put('0', new int[]{0,0,0});
        map.put('1', new int[]{0,0,1});
        map.put('2', new int[]{0,1,0});
        map.put('3', new int[]{0,1,1});
        map.put('4', new int[]{1,0,0});
        map.put('5', new int[]{1,0,1});
        map.put('6', new int[]{1,1,0});
        map.put('7', new int[]{1,1,1});
    }
}
