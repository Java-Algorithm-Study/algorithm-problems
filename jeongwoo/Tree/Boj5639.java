import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * [5639] 이진 검색 트리
 * https://www.acmicpc.net/problem/5639
 *
 * -아이디어
 * 1. 전위(pre): root - left - right
 * 2. 중위(in): left - root - right
 * 3. 후위(post): left - right - root
 * ---
 * 1. 전위가 주어지면 후위 순회를 출력해야 한다.
 * 2. 전위는 루트가 먼저니까 제일 먼저 나온 게 루트, 그 다음에 나오는 것들 중에서 루트보다 작은 값들이 왼쪽 노드, 큰 값들이 오른쪽 노드다.
 * 3. 왼쪽 노드들 중에서도 맨 앞에 있는 게 루트고, 루트보다 작은 값들이 왼쪽 노드, 큰 값들이 오른쪽 노드다.
 * 4. 이런 식으로 쭉 내려가다 보면 노드가 하나인 게 서브 노드가 된다. 이 값이 루트보다 작으면 왼쪽, 크면 오른쪽 서브 노트가 된다.
 * 5. 오른쪽 노드들 중에서도 맨 앞에 있는 게 루트고, 루트보다 작은 값들이 왼쪽 노드, 큰 값들이 오른쪽 노드다.
 * 6. 위와 같이 왼쪽과 오른쪽을 구분해서 노드가 하나가 될 때까지 반복한다.
 *
 */

public class Boj5639 {
    private static ArrayList<Integer> arrayList = new ArrayList<>();
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";

        // 입력 받기
        while ((input = br.readLine()) != null && input.length() != 0) {
            arrayList.add(Integer.parseInt(input));
        }

        getPostOrder(0, arrayList.size() - 1);

        System.out.println(sb);
    }

    private static void getPostOrder(int start, int end) {
        if (start > end) {
            return;
        }

        int mid = start + 1;
        while (mid <= end && arrayList.get(mid) < arrayList.get(start)) {
            mid++;
        }

        getPostOrder(start + 1, mid - 1);
        getPostOrder(mid, end);
        sb.append(arrayList.get(start)).append('\n');
    }
}
