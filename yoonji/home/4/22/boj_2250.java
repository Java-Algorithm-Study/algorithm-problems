import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 트리의 높이와 너비
public class boj_2250 {
    static int N;
    static List<Node> tree;
    static int[] levelMin;
    static int[] levelMax;
    static int point = 1;   // x좌표. 노드 방문마다 point++ (-> 중위순회 필요)
    static int treeHight = 0;  // 트리 높이
    private static class Node{
        private int parent;
        private int left;
        private int right;
        public Node(int left, int right) {
            this.parent = -1;   // 루트 노드가 1이라고 지정안되어있다는 점!
            this.left = left;
            this.right = right;
        }
    }
    public static void main(String[] args) throws IOException {
        makeTree();
        int root = findRoot();
        midSearch(root, 1);
        findMaxDistance();
    }

    private static void makeTree() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tree = new ArrayList<>();
        levelMin = new int[N+1];
        levelMax = new int[N+1];
        // 숫자로 트리 생성
        for (int i=0; i<=N; i++) {
            tree.add(new Node(-1, -1));
            levelMin[i] = N;
        }
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int data = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            tree.get(data).left = left;
            tree.get(data).right = right;
            if (left != -1) tree.get(left).parent = data;
            if (right != -1) tree.get(right).parent = data;
        }
    }
    private static int findRoot() {
        int root = 0;
        for (int i=1; i<=N; i++)
            if (tree.get(i).parent == -1) {
                root = i;
                break;
            }
        return root;
    }
    // 중위순회를 돌며 각 level의 min, max값 구하기
    private static void midSearch(int node, int level) {
        Node n = tree.get(node);
        if (treeHight < level) treeHight = level;
        if (n.left != -1) midSearch(n.left, level+1);   // 왼쪽
        // 노드 처리
        levelMin[level] = Math.min(levelMin[level], point);
        levelMax[level] = point++;
        if (n.right != -1) midSearch(n.right, level+1); // 오른쪽
    }
    private static void findMaxDistance() {
        int maxDistance = levelMax[1] - levelMin[1] + 1;
        int answerLevel = 1;
        for (int i=2; i<=treeHight; i++) {
            int dist = levelMax[i] - levelMin[i] + 1;
            if (maxDistance < dist) {
                answerLevel = i;
                maxDistance = dist;
            }
        }
        System.out.println(answerLevel+" "+maxDistance);
    }
}