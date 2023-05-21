package language.java.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1476 {
    static int E, S, M; // 입력 값
    static int eTemp, sTemp, mTemp; // 카운트 될 temp 변수
    static final int eRange = 15;
    static final int sRange = 28;
    static final int mRange = 19;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        E = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int cnt = 0;
        eTemp = sTemp = mTemp = 0;
        while(true) {
            if (eTemp == eRange) eTemp = 0;
            eTemp++;
            if (sTemp == sRange) sTemp = 0;
            sTemp++;
            if (mTemp == mRange) mTemp = 0;
            mTemp++;

            cnt++;

            if (eTemp == E && sTemp == S && mTemp == M) break;
        }

        System.out.println(cnt);
    }
}