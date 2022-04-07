import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 다음 순열
// 값을 정렬하고 중복되지 않은 자릿수를 조건으로 하나씩 증가시킬 떄..
// 1. 각 자릿수에 대해서 가장 마지막 순열은 그 뒤의 수들이 내림차순이다. ex) 1,2,3,4에서 3,1 자릿수의 마지막 순열은 3,1,"4,2" (자릿수 바뀜-> 3,2,1,4)
// 2. 결국 그 자릿수 i의 값 a와 뒤의 수들 중 a보다 크면서 뒤 수들 중 최솟값을 swap하고,
// 3. swap되고 나면 뒤 수들을 오름차순으로 reverse해야 해당 swap된 수가 자릿수 i일 때의 첫번째 순열이 된다.
public class boj_10972 {
    private static int[] beforeNum;
    public static void main(String[] args) throws IOException {
        input();
        if (hasNextNum()) {
            StringBuilder answer = new StringBuilder();
            for (int n: beforeNum) answer.append(n).append(" ");
            System.out.println(answer);
        }
        else System.out.println(-1);
    }
    private static void input() {
        FastReader scan = new FastReader();
        int N = scan.nextInt(); // 1~N
        beforeNum = new int[N];
        // 이전 숫자 입력
        for (int i=0; i<N; i++) {
            beforeNum[i] = scan.nextInt();
        }
    }

    private static boolean hasNextNum() {
        // 1.뒤에서부터 가면서 beforeNum[i-1]<beforeNum[i]인 값 찾기.
        int i= beforeNum.length-1;
        while (i > 0 && beforeNum[i-1] >= beforeNum[i])   //뒤에서부터 찾으므로 bN[i-1]보다 큰 가장 최소의 값
            i--;
        // i가 0될 때까지 i-1보다 큰 값이 없으면 모두 내림차순인 것이므로 마지막 순열!
        if (i<=0) return false;

        // 2. i<=j이면서 beforeNum[i-1] < beforeNum[j]이면서 최솟값 찾아서 둘이 swap하기
        int j = beforeNum.length-1;
        while (beforeNum[i-1] >= beforeNum[j]) {
            j--;
        }
        swap(i-1, j);
        // i부터 끝까지 순열 reverse
        // i는 뒤로, right는 뒤에서 앞으로. 둘이 같아지거나 엇갈리면 종료
        int right = beforeNum.length-1;
        while (i<right) {
            swap(i, right);
            i++; right--;
        }
        return true;
    }

    private static void swap(int s, int b) {
        int tmp = beforeNum[s];
        beforeNum[s] = beforeNum[b];
        beforeNum[b] = tmp;
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