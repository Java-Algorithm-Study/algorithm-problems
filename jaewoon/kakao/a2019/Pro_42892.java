package kakao.a2019;


import java.util.*;
/**
 * [42892] 길 찾기 게임
 * https://school.programmers.co.kr/learn/courses/30/lessons/42892
 *
 * -아이디어
 *  1. BST 구현
 *  2. 다차원 배열을 문자열 출력 시 Arrays.deepToString() 이용
 *
 */

public class Pro_42892 {

    public static void main(String[] args) {
        int[][] solution = solution(new int[][]{{5, 3}, {11, 5}, {13, 3}, {3, 5},
                {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}});
        System.out.println(Arrays.deepToString(solution));
    }

    static int cnt=0;
    static int[][] answer;
    public static int[][] solution(int[][] nodeinfo) {
        answer = new int[2][nodeinfo.length];

        ArrayList<Node> list = new ArrayList<>();
        for(int i=0; i<nodeinfo.length; i++){
            list.add(new Node(nodeinfo[i][0], nodeinfo[i][1], i+1));
        }
        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node a, Node b){
                return b.y-a.y;
            }
        });


        Tree tree = new Tree();
        for(int i=0; i<list.size(); i++){
            tree.insert(new Node(list.get(i).x, list.get(i).y, list.get(i).index));
        }

        tree.preorder(tree.root);
        cnt=0;
        tree.postorder(tree.root);

        return answer;
    }

    static class Tree{
        Node root;

        void insert(Node node){
            Node newNode = new Node(node.x, node.y, node.index);

            if(root == null){
                root = newNode;
                return;
            }

            Node cur = root;
            Node parent = null;
            while(true){
                parent = cur;

                if(node.x < cur.x){
                    cur = cur.left;
                    if(cur == null){
                        parent.left = newNode;
                        return;
                    }
                }
                else{
                    cur = cur.right;
                    if(cur == null){
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }


        void preorder(Node node){
            if(node==null) return;
            answer[0][cnt++] = node.index;
            preorder(node.left);
            preorder(node.right);
        }
        void postorder(Node node){
            if(node==null) return;
            postorder(node.left);
            postorder(node.right);
            answer[1][cnt++] = node.index;
        }
    }

    static class Node{
        int x, y, index;
        Node left, right;

        public Node(int xx, int yy, int indexx){
            x=xx; y=yy; index=indexx;
            this.left = null;
            this.right = null;
        }
    }
}

/*
테스트 1 〉	통과 (1.06ms, 77MB)
테스트 2 〉	통과 (1.35ms, 75.7MB)
테스트 3 〉	통과 (0.79ms, 68.6MB)
테스트 4 〉	통과 (1.00ms, 77.4MB)
테스트 5 〉	통과 (0.77ms, 65MB)
테스트 6 〉	통과 (5.79ms, 75.8MB)
테스트 7 〉	통과 (4.71ms, 68.3MB)
테스트 8 〉	통과 (11.91ms, 82.5MB)
테스트 9 〉	통과 (22.78ms, 91.7MB)
테스트 10 〉	통과 (4.57ms, 81.9MB)
테스트 11 〉	통과 (20.06ms, 109MB)
테스트 12 〉	통과 (28.02ms, 106MB)
테스트 13 〉	통과 (1.48ms, 81.6MB)
테스트 14 〉	통과 (3.40ms, 82.2MB)
테스트 15 〉	통과 (9.42ms, 97.2MB)
테스트 16 〉	통과 (15.14ms, 96MB)
테스트 17 〉	통과 (3.30ms, 73.3MB)
테스트 18 〉	통과 (16.64ms, 101MB)
테스트 19 〉	통과 (5.97ms, 90.3MB)
테스트 20 〉	통과 (10.05ms, 82.9MB)
테스트 21 〉	통과 (12.68ms, 94.6MB)
테스트 22 〉	통과 (18.30ms, 105MB)
테스트 23 〉	통과 (20.34ms, 91.8MB)
테스트 24 〉	통과 (0.74ms, 74MB)
테스트 25 〉	통과 (0.71ms, 76.1MB)
테스트 26 〉	통과 (9.06ms, 89.6MB)
테스트 27 〉	통과 (0.99ms, 76.6MB)
테스트 28 〉	통과 (0.91ms, 76.1MB)
테스트 29 〉	통과 (0.75ms, 72.7MB)
 */
