import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1107 {
    static boolean[] broken = new boolean[10];

    private static int check (int i) {
        int len = 0;

        if(i == 0) {
            if(broken[0]) len = 0; // 채널 0 예외 잡아줍니다.
            else len = 1;

            return len;
        }

        while(i > 0){
            // 고장났을 땐 return 0 즉, 채널이동 X
            if(broken[i % 10]){
                len = 0;
                return len;
            }
            len++;
            i /= 10;
        }
        return len;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int channel = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 고장났니, true
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(st.nextToken());
            broken[num] = true;
        }

        // 초기 채널은 100번이므로 +와 -번으로만 이동 가능한 것이 최대 이동 횟수이다.
        // 초기값 세팅을 해줍니다.
        int result = Math.abs(channel - 100);

        // 입력될 수 있는 채널의 최댓값이 50만에서, 숫자(0~9)로 누를 수 있는 최대값은 999,999 까지 반복을 진행합니다.
        // 0부터 1000000 까지 모든 채널을 돌면서 N으로 가장 적은 버튼을 눌러 이동할 수 있는 채널을 찾는다.
        for(int i = 0; i < 1000000; i++) {
            int len = check(i);

            if(len != 0){
                // cnt는 숫자만 눌러서 근접한 숫자에서 몇번의 +나 -를 눌러야 하는지 나타낸다.
                int cnt = Math.abs(i - channel);
                if(result > len + cnt) result = len + cnt;
            }
        }
        System.out.println(result);
    }
}






