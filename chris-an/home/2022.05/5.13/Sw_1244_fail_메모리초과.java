import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 다른 분 코드
 *
 */

public class Sw_1244_fail_메모리초과 {
    static int[] numberArr;
    static int max = Integer.MIN_VALUE;
    static String strN;
    static int swappingCount;

    public static void dfs(int depth) {
        if(swappingCount == depth) { // dfs 깊이 우선탐색으로 교환횟수 만큼 됐을 경우, in
            String permStr = "";
            for(int i = 0; i < numberArr.length; i++)
                permStr = permStr + numberArr[i];

            max = Math.max(max, Integer.parseInt(permStr)); // 숫자판 최대값 비교
            return;
        }

        for(int i = 0; i < numberArr.length; i++) {
            for(int j = i; j < numberArr.length; j++) {
                // continue case 는 불필요한 로직을 막기 위함. 복잡도 줄이기
                if (i == j) continue;
                if (numberArr[i] == numberArr[j]) continue;

                if(numberArr[i] < numberArr[j]) { // 큰 자릿수가 작은 자릿수보다 수가 작을 경우
                    swap(numberArr[i],numberArr[j],i,j); // 숫자 스왑
                    dfs(depth+1);
                    swap(numberArr[i],numberArr[j],i,j);
                }
            }
        }
    }


    // 스왑과정
    public static void swap(int a, int b, int i, int j) {
        numberArr[j] = a;
        numberArr[i] = b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int TC = 0; TC < T; TC++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            strN = st.nextToken();
            swappingCount = Integer.parseInt(st.nextToken()); // 교환 횟수
            numberArr = new int[strN.length()]; // 숫자판
            for(int i = 0; i < strN.length(); i++) {
                numberArr[i] = Integer.parseInt(strN.substring(i, i+1));
            }
            dfs(0);
            System.out.println("#" + (TC + 1) + " " + max);
        }
    }
}