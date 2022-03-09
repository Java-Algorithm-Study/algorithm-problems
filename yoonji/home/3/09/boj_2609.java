
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
// 최대공약수와 최소공배수
// 10,000이하의 자연수 2개가 주어지면, 최대공약수/최소공배수를 구한다.
public class boj_2609 {
    static List<Integer> divisor;
    public static void main(String[] args) {
        int bigger;
        int smaller;
        Scanner sc = new Scanner(System.in);
        int[] num = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        // 1. 대소 비교
        if (num[0] >= num[1]) {
            bigger = num[0];
            smaller = num[1];
        }
        else {
            bigger = num[1];
            smaller = num[0];
        }
        System.out.println(solveGCD(bigger, smaller));
        System.out.println(solveLCM(bigger, smaller));
    }

    // Greatest Common Divisor 최대 공약수
    public static int solveGCD(int bigger, int smaller) {
        // 만약 같다면
        if (bigger % smaller == 0) return smaller;
        // B의 약수를 List에 추가하고 A에 가장 큰값부터 약수인지 체크
        else {
            divisor = new ArrayList<>(Arrays.asList(1));
            for (int i= 2; i<smaller; i++) {
                if (smaller % i == 0) divisor.add(i);
            }
            // smaller의 약수들 중 bigger의 약수 체크
            int div = 0;
            for (int i=divisor.size()-1; i>=0; i--) {
                div = divisor.get(i);
                if (bigger % div == 0) break;
            }
            return div;
        }
    }

    // Largest Common Multiple 최소 공배수
    public static int solveLCM(int bigger, int smaller) {
        int multiple = 0;
        int i=1;
        // A의 배수가 B의 배수인지 체크
        while(multiple <= bigger*smaller) {
            multiple = bigger * i;
            if (multiple % smaller == 0) break;
            i++;
        }
        return multiple;
    }
}
