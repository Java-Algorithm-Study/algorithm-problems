import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
// 최대공약수와 최소공배수
// 10,000이하의 자연수 2개가 주어지면, 최대공약수/최소공배수를 구한다.

// 수정 : gcd_withEuclideanAlgorithm(), solveLCM_withGCD()
public class boj_2609 {
    static List<Integer> divisor;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] num = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        // 1. 대소 비교 (Math 라이브러리 이용하도록 수정)
        int bigger = Math.max(num[0], num[1]);
        int smaller = Math.min(num[0], num[1]);

        int gcd = gcd_withEuclideanAlgorithm(bigger, smaller);  // 유클리드 호제법을 이용하여 구하는 메서드
        System.out.println(gcd);
//        System.out.println(solveGCD(bigger, smaller));
//        System.out.println(solveLCM(bigger, smaller));
        System.out.println(solveLCM_withGCD(bigger, smaller, gcd));
    }
    // 추가
    private static int solveLCM_withGCD(int bigger, int smaller, int gcd) {
        // 최소 공배수의 수학적 성질 : 두 수 a,b를 곱한 m을 최대공약수 gcd로 나누면 최소 공배수가 된다.
        return (bigger * smaller) / gcd;
    }

    // 추가
    private static int gcd_withEuclideanAlgorithm(int bigger, int smaller) {
        // 두 자연수 a를 b로 나눈 나머지가 r이면, a,b의 최대 공약수 == b와 r의 최대공약수
        // gcd(a, b)=gcd(b, r)
        int r;
        while (smaller != 0) {
            r = bigger % smaller;
            bigger = smaller;
            smaller = r;
        }
        // smaller가 0이 되면
        return bigger;
    }

    // Greatest Common Divisor 최대 공약수
    public static int solveGCD(int bigger, int smaller) {
        int gcd=1;  // 공약수 1
        // 만약 같다면
        if (bigger % smaller == 0) return smaller;
        // 두 수의 공약수를 한번에 구한다. (수정)
        else {
            divisor = new ArrayList<>(Arrays.asList(1));
            for (int i= 2; i<smaller; i++) {
                if (smaller % i == 0 && bigger % i == 0) {
                    gcd = i;
                    break;
                }
            }
        }
        return gcd;
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
