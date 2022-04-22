import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
// A~G(65~71) 대신 숫자(1~7)로 관리하고 마지막에 +64하여 알파벳으로 출력
public class boj_1991 {
    static StringBuilder sb = new StringBuilder();
    static List<Node>[] tree;
    private static class Node {
        int left;
        int right;
        public Node(int l, int r) {
            this.left = l;
            this.right = r;
        }
    }
    public static void main(String[] args) throws IOException {
        // 1. 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        tree = new List[N+1];
        for (int i = 1; i <= N; i++) tree[i] = new ArrayList<>();
        StringTokenizer st;
        while (N-- > 0) {
            String[] input = br.readLine().split(" ");
            int node = input[0].charAt(0)-64;
            tree[node].add(new Node(input[1].charAt(0)-64, input[2].charAt(0)-64));
        }
        // 2. 전위, 중위, 후위 순회
        beforeSearch(1); sb.append("\n");
        midSearch(1); sb.append("\n");
        afterSearch(1); sb.append("\n");
        System.out.println(sb);
    }
    // 후위 탐색
    private static void afterSearch(int nodeIdx) {
        for (Node sub : tree[nodeIdx]) {
            int l = sub.left;
            int r = sub.right;
            if (l != -18) afterSearch(l);// 왼쪽 탐색
            if (r != -18) afterSearch(r);// 오른쪽 탐색
            sb.append((char) (nodeIdx + 64));
        }
    }
    // 중위 탐색
    private static void midSearch(int nodeIdx) {
        for (Node sub : tree[nodeIdx]) {
            int l = sub.left;
            int r = sub.right;
            if (l != -18) midSearch(l);// 왼쪽 탐색
            sb.append((char) (nodeIdx + 64));
            if (r != -18) midSearch(r);// 오른쪽 탐색
        }
    }
    // 전위 탐색
    static void beforeSearch(int nodeIdx) {
        for (Node sub : tree[nodeIdx]) {
            int l = sub.left;
            int r = sub.right;
            sb.append((char) (nodeIdx + 64));// 먼저 탐색
            if (l != -18) beforeSearch(l);// 왼쪽 탐색
            if (r != -18) beforeSearch(r);// 오른쪽 탐색
        }
    }
}