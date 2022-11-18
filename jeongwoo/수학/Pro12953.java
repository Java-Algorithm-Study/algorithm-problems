/**
 * [12953] N개의 최소공배수 
 * https://programmers.co.kr/learn/courses/30/lessons/12953
 *
 * -아이디어
 * 1. 처음엔 arr[0], arr[1]의 최대 공약수와 최소 공배수를 구한다.
 * 2. 위에서 구한 최소 공배수와 그 다음 arr[i]의 최대 공약수를를 구한 후, 최대 공약수로 최소 공배수를 구한다..
 *
 */
 
public class Pro12953 {
    public int solution(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }

        int g = GCD(arr[0], arr[1]);
        int l = arr[0] * arr[1] / g;

        for (int i = 2; i < arr.length; i++) {
            g = GCD(l, arr[i]);
            l = l * arr[i] / g;
        }

        return l;
    }

    public int GCD(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return GCD(b, a % b);
    }
}
