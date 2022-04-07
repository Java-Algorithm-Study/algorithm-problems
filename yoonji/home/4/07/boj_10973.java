import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 이전 순열
public class boj_10973 {
    private static int[] afterNum;
    public static void main(String[] args) {
        input();
        if (hasBeforeNum()){
            StringBuilder answer = new StringBuilder();
            for (int n: afterNum) answer.append(n).append(" ");
            System.out.println(answer);
        }
        else System.out.println(-1);
    }
    // 이전 순열 구하기
    private static boolean hasBeforeNum() {
        // 1. 뒤에서부터 앞으로 가면서, afterNum[i-1] > afterNum[i] 찾으면 종료
        int i= afterNum.length-1;
        while (i>0 && afterNum[i-1] <= afterNum[i]) {
            i--;
        }
        // 2. i가 0이 될 때까지 뒤에 더 작은 값이 없다면 오름차순 정렬된 것이므로 가장 첫번째 수열이다. 즉, 이전 수열이 없다는 뜻.
        if (i<=0) return false;
        // 3. 다시 afterNum[i-1]보다 작은 afterNum[j]를 찾는다. 그 작은 값이랑 바꾸어야 이전 값이 됨
        int j = afterNum.length-1;
        while (afterNum[i-1] <= afterNum[j]) {
            j--;
        }
        swap(i-1, j);

        // 4. i부터 끝까지 뒤집는다.
        int right = afterNum.length-1;
        while (i<right) {
            swap(i, right);
            right--; i++;
        }
        return true;
    }

    private static void input() {
        FastReader scan = new FastReader();
        int N = scan.nextInt(); // 1~N
        afterNum = new int[N];
        // 이전 숫자 입력
        for (int i=0; i<N; i++) {
            afterNum[i] = scan.nextInt();
        }
    }
    private static void swap(int s, int b) {
        int tmp = afterNum[s];
        afterNum[s] = afterNum[b];
        afterNum[b] = tmp;
    }

    // 사용자 input을 처리하는 클래스
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
