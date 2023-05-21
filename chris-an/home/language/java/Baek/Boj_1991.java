package language.java.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1991 {

    static int N;
    static Node[] arr;
    static StringBuilder sb = new StringBuilder();

    static class Node {
        char data;
        Node left;
        Node right;

        public Node(char node) {
            this.data = node;
        }
    }

    static void preorder(Node node) {
        sb.append(node.data);
        if (node.left != null) preorder(node.left);
        if (node.right != null) preorder(node.right);
    }

    static void inorder(Node node) {
        if (node.left != null) inorder(node.left);
        sb.append(node.data);
        if (node.right != null) inorder(node.right);
    }

    static void postorder(Node node) {
        if (node.left != null) postorder(node.left);
        if (node.right != null) postorder(node.right);
        sb.append(node.data);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new Node[N];

        // A부터 차례대로 알파벳 초기화
        for (int i = 0; i < N; i++) {
            arr[i] = new Node((char)(i + 'A'));
        }

        // 연결 노드 세팅
        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            char node = line.charAt(0);
            char left = line.charAt(2);
            if (left != '.') arr[node - 'A'].left = arr[left - 'A'];
            char right = line.charAt(4);
            if (right != '.') arr[node - 'A'].right = arr[right - 'A'];
        }

        preorder(arr[0]);
        sb.append('\n');

        inorder(arr[0]);
        sb.append('\n');

        postorder(arr[0]);
        sb.append('\n');

        System.out.println(sb);
    }
}
