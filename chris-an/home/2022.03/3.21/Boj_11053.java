import java.io.*;
import java.util.*;

public class Boj_11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int target[] = new int[N + 1]; // 입력 받은 수열의 길이 +1
        int DP[] = new int[N + 1];
        Arrays.fill(DP, 1); // 최소 배열은 길이가 1이니 전체 초기화

        for (int i = 1; i < target.length; i++) {
            target[i] = Integer.parseInt(st.nextToken());
        }

        int max = 1;
        for (int i = 2; i < DP.length; i++) {
            for (int j = 1; j < i; j++) { // 차례대로 idx i의 전 j들을 비교하여 길이를 + 시켜줍니다.
                if (target[i] > target[j] && DP[j]+1 > DP[i]) { // 값을 비교 해주고, 길이도 비교를 해줘야합니다. 현재 저장된 수열의 길이보다 작아야합니다.
                    DP[i] = DP[j] + 1;
                }
            }
            max = Math.max(max, DP[i]); //max 값을 갱신해줍니다
        }
        System.out.println(max);
    }
}


// 다른 방법

//public class Boj_11053 {
//
//    static int [] dp;
//    public static void main(String args[]) throws IOException {
//    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//    int N = Integer.parseInt(bf.readLine());
//    dp = new int[N];
//    Arrays.fill(dp , 1); // 초기 세팅, 수열의 길이 default 는 1입니다.
//
//    StringTokenizer st = new StringTokenizer(bf.readLine());
//
//    int[] target = new int[N];
//
//    for(int i = 0; i < N; i++) {
//        target[i] = Integer.parseInt(st.nextToken());
//    }
//
//    for(int i = 0; i < N; i++) {
//        for(int j = i+1; j < N; j++) {
//            // 순차적으로 비교를해서 카운트 1씩 증가해주면, 각 수열의 길이를 알 수 있음.
//            if(target[i] < target[j]) {
//                dp[j] = Math.max(dp[j], dp[i] + 1); // 수열 A1 부터 A2~ 전체 수열비교
//                                                    // 수열 A2 부터 A3~ 전체 수열비교
//                                                    // 수열 A3 부터 A4~ 전체 수열비교 ...
//            }
//        }
//    }
//
//    int max = 0;
//    for(int i = 0; i < N; i++) {
//        if(max < dp[i]) max = dp[i];
//    }
//
//    System.out.print(max);
//    }
//}
