import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [2263] 트리의 순회
 * https://www.acmicpc.net/problem/2263
 *
 * -아이디어
 * 1. 전위(pre): root - left - right
 * 2. 중위(in): left - root - right
 * 3. 후위(post): left - right - root
 * ----------------------------------
 * 1. 후위 배열 맨 마지막 값이 루트 값이다.
 * 2. 후위 배열에서 알아낸 루트 값으로 중위 배열에서 root의 인덱스를 찾는다.
 * 3. 중위 배열에서 root를 기준으로 왼쪽에 있는 노드의 개수를 구한다. 이때 root를 기준으로 왼쪽 노드 / 오른쪽 노드를 알 수 있다.
 * 4. 노드 개수만큼 중위 배열의 왼쪽, 후위 배열의 왼쪽을 메소드로 호출한다.
 * 5. 전체에서 왼쪽 노드 개수를 빼면 오른쪽 노드 개수도 알 수 있으니까 이걸 기준으로 중위, 후위 배열에서 오른쪽을 호출한다.
 *
 */

public class Boj2263 {
    private static int[] inOrder, postOrder, inOrderIdx;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        inOrder = new int[n];
        postOrder = new int[n];
        inOrderIdx = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            inOrder[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            postOrder[i] = Integer.parseInt(st.nextToken());
        }

        // 중위 순회(in)에서 root의 인덱스를 찾아야 돼서 중위 순회 인덱스 배열을 만들어 준다
        for (int i = 0; i < n; i++) {
            inOrderIdx[inOrder[i]] = i;
        }

        getPreOrder(0, n - 1, 0, n - 1);
        System.out.println(sb);
    }

    private static void getPreOrder(int inOrderStart, int inOrderEnd, int postOrderStart, int postOrderEnd) {
        if (inOrderStart > inOrderEnd || postOrderStart > postOrderEnd) {
            return;
        }
        int root = postOrder[postOrderEnd];

        sb.append(root).append(' ');

        // 중위 순회(in)에서 root의 인덱스를 찾고
        int rootIdx = inOrderIdx[root];

        // 중위 순회(in)에서 루트를 기준으로 왼쪽에 노드 개수 구하기
        int leftLength = rootIdx - inOrderStart;

        // left node
        getPreOrder(inOrderStart, rootIdx - 1, postOrderStart, postOrderStart + leftLength - 1);

        // right node
        getPreOrder(rootIdx + 1, inOrderEnd, postOrderStart + leftLength, postOrderEnd - 1);
    }
}
