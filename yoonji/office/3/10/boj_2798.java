import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
// 완전 탐색
public class boj_2798 {
    static boolean[] visited;
    static int maxSum = 0;

    public static void main(String[] args) throws IOException {
/*        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] MN = br.readLine().split(" ");
        int N = Integer.parseInt(MN[0]);    // 카드갯수
        int M = Integer.parseInt(MN[1]);    // 제한 수
        int[] num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        visited = new boolean[N];

        for (int i=0; i<N; i++)
            recursion(i, M, maxSum);

        // 반복문
        *//*for (int i=0; i<N-2; i++) {
            for (int j=i+1; j<N-1;j++) {
                for (int k=j+1; k<N; k++) {
                    int sum = num[i] + num[j] + num[k];
                }
            }
        }*//*
    }
    public static int recursion(int cnt, int , int sum) {
        if (cnt == M)
            if (maxSum == sum) {

            }*/
    }
}
