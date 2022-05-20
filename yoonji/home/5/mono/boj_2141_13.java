import java.io.BufferedReader;
import java.io.InputStreamReader;

// 우체국
public class boj_2141_13 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N= Integer.parseInt(br.readLine());
        if (N==1) {
            System.out.println(1);
            return;
        }
//        long[] towns = new long[N+1];
        long[] pplNum = new long[N + 1];
        for (int i=1; i<=N; i++) {
            pplNum[i] = Integer.parseInt(br.readLine().split(" ")[1]);
        }
        // 이진 탐색을 하며 앞과 뒤의 사람수가 비슷한 위치를 찾는다.
        int startIdx = 1;
        int endIdx = N;
        int midIdx = N/2;
        int frontNum = 0;
        int behindNum = 0;
        while (startIdx<=endIdx) {
            for (int i=1; i<midIdx; i++) {
                frontNum+= pplNum[i];
            }
            for (int i=N; i>midIdx; i--) {
                behindNum += pplNum[i];
            }
//            if (frontNum )
        }

        /*
        long min = Long.MAX_VALUE;
        int minTownIdx = 0;
        for (int i=1; i<=N; i++) {
            for (int j=1; j<=N; j++) {
                if (i==j) continue;
                towns[i] += Math.abs(i - j) * pplNum[j];
            }
            if (min>towns[i]) {
                min = towns[i];
                minTownIdx = i;
            }
        }
        System.out.println(minTownIdx);*/
    }
}
