/**
 * [17681] 비밀지도
 * https://programmers.co.kr/learn/courses/30/lessons/17681
 *
 * -아이디어
 * 1. 십진수를 이진수로 변환 후, 각각 배열의 원소를 비교하면서 OR 연산을 한다.
 * 2. 나온 이진수를 1 -> # 0 -> 공백으로 변환한다.
 *
 * -시간 복잡도
 * 1. O(n)
 *
 * -자료 구조
 * 1. String[] : 이진수 변환 후 OR 연산 결과 담을 배열
 */

public class Pro17681_Again {
    public static void main(String[] args) {
//        System.out.println(solution(5, new int[] {9, 20, 28, 18, 11}, new int[] {30, 1, 21, 17, 28}));
        System.out.println(solution(6, new int[] {46, 33, 33 ,22, 31, 50}, new int[] {27 ,56, 19, 14, 14, 10}));
    }
    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] binary = new String[n];

        for (int i = 0; i < n; i++) {
            binary[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
        }

        // 11110 -> 011110으로 부족한 자릿수를 앞에 0으로 채워 주기
        for (int i = 0; i < n; i++) {
            int zero = n - binary[i].length();
            String temp = "";
            while (zero-- > 0) {
                temp += "0";
            }

            binary[i] = temp + binary[i];
        }

        for (int i = 0; i < n; i++) {
            binary[i] = binary[i].replace('1', '#');
            binary[i] = binary[i].replace('0', ' ');
        }

        return binary;
    }
}
