package language.java.Baek;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_1929 {

    /*
        백준 1929번 - 소수구하기 문제
        문제 : M 이상 N 이하의 소수를 모두 출력하는 프로그램을 작성하시오. 최대 100만까지,
     */


    // 약수의 중간값을 이용하여, 소수판별법을 할필요없는 걸 배제시키고 돌린다. 시간복잡도는 O(루트N) // 대략 1000만 이상 가능.
    public static boolean isPrime (int n) {
        if(n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // 가장 기본적인 소수 판별법. O(n) *해당 수를 모두 확인해야함 // 대략 10만개 이상부터 계산하는 게 버거워진다.
    public static boolean isPrime2(int n) { // 시간초과
        for (int i = 2; i <= n; i++) {
            if (n % i == 0) return false; // 소수가 아님, 합성수 임
        }
        return true; // 소수
    }

    // 소수 판별 중에, 앞에서 나온 비교할 수를 가지고 뒤에 나올 비교할 수를 소수판별 예측을 할 수 있다.
    // 이 계산은, 절반 이상의 숫자들은 확인할 필요가 없는 숫자이기 때문이다.
    // 시간복잡도는 O(n/2) -> O(n) 이다. 기본적인 소수 판별법보다는 빠를 다.
    public static boolean isPrime3(int n) { // 대략 100만개 미만,
        for (int i = 2; i <= n/2; i++) {
            if (n % i == 0) return false; // 소수가 아님
        }
        return true;
    }



    public static void isPrime4(int n) {
        boolean [] chk = new boolean[n+1];
        for (int i = 2; i < n ; i++) {
            if (chk[i] == false) System.out.println(i);
            for (int j = i * 2; j <= n; j += i) chk[j] = true;
        }
    }

    public static void main(String[] args) throws IOException {
        //Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        for (int i = M; i <= N; i++) {

            if (isPrime(i))
                //System.out.println(i);
                sb.append(i).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
