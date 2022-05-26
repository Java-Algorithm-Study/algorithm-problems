package swExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 팔씨름
public class sw_13547_24 {
    static final int WIN_LIMIT = 8;
    static final int TOTAL_GAME_CNT = 15;
    static final char WIN = 'o';
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder answerSB = new StringBuilder();
        for (int t=1; t<=T; t++) {
            answerSB.append("#"+t+" ");
            int winCnt = 0;
            char[] result = br.readLine().toCharArray();
            for (int i=0; i<result.length; i++) {
                if (result[i] == WIN) winCnt++;
            }
            if (isTherePossibility(result.length, winCnt)) answerSB.append("YES\n");
            else answerSB.append("NO\n");
        }
        System.out.println(answerSB);
    }
    private static boolean isTherePossibility(int gameCnt, int winCnt) {
        return TOTAL_GAME_CNT - gameCnt + winCnt >= WIN_LIMIT;
    }
}
