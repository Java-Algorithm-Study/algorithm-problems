import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 트리의 순회
// postOrder와 inOrder를 이용해서 preOrder를 구하라
// postOrder의 매 subtree의 가장 마지막 index가 루트
// 그 루트를 inOrder의 index 기준으로 postOrder도 나눠주면 subtree가 생성된다.
// TEST
// 9
//7 4 8 2 5 1 3 9 6
//7 8 4 5 2 9 6 3 1
public class boj_2263_10 {
    static StringBuilder sb = new StringBuilder();
    static List<Integer> inOrder = new ArrayList<>();
    static List<Integer> postOrder = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<n; i++) {
            inOrder.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<n; i++) {
            postOrder.add(Integer.parseInt(st.nextToken()));
        }
        getPreOrder(0, n-1, 0, n-1);
        System.out.println(sb);
    }
    // - preOrder 만드는 방식
    // 1.root를 sb에 append하는 방법
    // 2.매 메서드에서 left, right를 구해서 그 값이 있을 떄는 재귀를, 그값이 없으면 마지막에 return left+right+root
    private static void getPreOrder(int inS, int inE, int postS, int postE) {
        if (inS > inE || postS > postE) {
//            System.out.println(inS+ ", "+ inE + ", " + postS+ ", "+postE);
            return;
        }
        int root = postOrder.get(postE);
        sb.append(root).append(" ");
        int rootIdx = inOrder.indexOf(root);
//        System.out.println("root "+root+"의 인덱스= "+ rootIdx);
        int leftSubTreeLen = rootIdx - inS;
        /*System.out.println("inOrder의 left subTree");
        for (int i=inS; i<=rootIdx-1; i++) {
            System.out.print(inOrder.get(i));
        }
        System.out.println("\n=====================");
        System.out.println("inOrder의 right subTree");
        for (int i=rootIdx+1; i<=inE; i++) {
            System.out.print(inOrder.get(i));
        }
        System.out.println("=====================");
        System.out.println("postOrder의 left subTree");
        for (int i=postS; i<=leftSubTreeLen-1; i++) {
            System.out.print(postOrder.get(i));
        }
        System.out.println("=====================");
        System.out.println("postOrder의 right subTree");
        for (int i=postS+leftSubTreeLen; i<=postE-1; i++) {
            System.out.print(postOrder.get(i));
        }
        System.out.println("=====================");*/

        getPreOrder(inS, rootIdx-1, postS, postS + leftSubTreeLen - 1);
        getPreOrder(rootIdx+1, inE, postS + leftSubTreeLen, postE-1);   // postE가 root가됐으니
    }
}
