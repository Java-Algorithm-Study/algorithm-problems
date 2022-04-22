import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_1991 {
    private static int N;
    private static Map<String, String[]> list = new HashMap<>();
    private static StringBuilder sb = new StringBuilder();
    
    public static void preorderTraversal(String root) {
        if (root == null) return;
    
        sb.append(root);
        String leftChild = list.get(root)[0];
        if (leftChild != null) {preorderTraversal(leftChild);}
        String rightChild = list.get(root)[1];
        if (rightChild != null) {preorderTraversal(rightChild);}
    }
    
    public static void inorderTraversal(String root) {
        if (root == null) return;
        
        String leftChild = list.get(root)[0];
        if (leftChild != null) {inorderTraversal(leftChild);}
        sb.append(root);
        String rightChild = list.get(root)[1];
        if (rightChild != null) {inorderTraversal(rightChild);}

    }
    
    public static void postTraversal(String root) {
        if (root == null) return;
        
        String leftChild = list.get(root)[0];
        if (leftChild != null) {postTraversal(leftChild);}
        String rightChild = list.get(root)[1];
        if (rightChild != null) {postTraversal(rightChild);}
        sb.append(root);
    }
    
    public static void insert(String parent, String leftChild, String rightChild) {
        String[] child = list.getOrDefault(parent, new String[2]);
        if (!".".equals(leftChild)) {
            child[0] = leftChild;
        }
        if (!".".equals(rightChild)) {
            child[1] = rightChild;
        }
        list.put(parent, child);
    }
    
    
    public static void main(String[] args) throws IOException {
        var bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        for (int i = 0; i < N; i++) {
            var st = new StringTokenizer(bf.readLine());
            String parent = st.nextToken();
            String leftChild = st.nextToken();
            String rightChild = st.nextToken();
    
            insert(parent, leftChild, rightChild);
        }
        
        preorderTraversal("A");
        sb.append("\n");
        inorderTraversal("A");
        sb.append("\n");
        postTraversal("A");
        System.out.println(sb);
    }
    
}
