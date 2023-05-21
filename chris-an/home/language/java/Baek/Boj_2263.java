package language.java.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2263 {
    static int[] inorder, inIdx, postorder;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        inorder = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++)
            inorder[i] = Integer.parseInt(st.nextToken());

        postorder = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++)
            postorder[i] = Integer.parseInt(st.nextToken());

        // inorder 인덱스
        inIdx = new int[n + 1];
        for (int i = 1; i <= n; i++)
            inIdx[inorder[i]] = i;

        solve(1, n, 1, n);
        System.out.println(sb.toString());
    }

    static void solve(int inorderStart, int inorderEnd, int postStart, int postEnd) {

        // 탈출 조건 (idx 위치가 start 가 end 보다 클 경우)
        if (inorderEnd < inorderStart || postEnd < postStart) {
            return;
        }

        int root = postorder[postEnd];
        int rIdx = inIdx[root];
        sb.append(root + " ");


        // 분할 정복
        int len = rIdx - inorderStart;
        solve(inorderStart, rIdx - 1, postStart, postStart + len - 1);
        solve(rIdx + 1, inorderEnd, postStart + len, postEnd - 1);
    }
}