import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


/**
 * [1991] 트리 순회
 * https://www.acmicpc.net/problem/1991
 *
 * -아이디어
 * 1. 자식 왼쪽 노드, 오른쪽 노드로 이루어진 노드 클래스를 만든다.
 * 2. 노드를 넣는 list 배열을 만들어서 자식 노드를 넣는다.
 * 3. 전위, 중위, 후위로 탐색하는 메소드를 생성해서 출력한다.
 *
 * -시간 복잡도
 * 1.
 *
 * -자료 구조
 * 1.
 */


class Node {
    int left;
    int right;

    public Node(int left, int right) {
        this.left = left;
        this.right = right;
    }
}

public class Boj1991 {
    private static List<Node>[] list;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        list = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int data = input[0].charAt(0) - 'A';
            int left = input[1].charAt(0) - 'A';
            int right = input[2].charAt(0) - 'A';
            list[data].add(new Node(left, right));
        }

        preOrder(0);
        sb.append("\n");
        inOrder(0);
        sb.append("\n");
        postOrder(0);
        sb.append("\n");
        System.out.println(sb.toString());
    }

    private static void preOrder(int x) {
        for (Node node : list[x]) {
            int left = node.left;
            int right = node.right;

            sb.append((char)(x + 'A'));
            if (left != -19) {
                preOrder(left);
            }
            if (right != -19) {
                preOrder(right);
            }
         }
    }

    private static void inOrder(int x) {
        for (Node node : list[x]) {
            int left = node.left;
            int right = node.right;

            if (left != -19) {
                inOrder(left);
            }
            sb.append((char) (x + 'A'));
            if (right != -19) {
                inOrder(right);
            }
        }
    }

    private static void postOrder(int x) {
        for (Node node : list[x]) {
            int left = node.left;
            int right = node.right;

            if (left != -19) {
                postOrder(left);
            }
            if (right != -19) {
                postOrder(right);
            }

            sb.append((char) (x + 'A'));
        }
    }
}
