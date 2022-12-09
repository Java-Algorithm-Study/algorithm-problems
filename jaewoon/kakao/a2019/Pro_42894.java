package kakao.a2019;


import java.util.*;


/**
 * [42894] 블록게임
 *  https://school.programmers.co.kr/learn/courses/30/lessons/42894
 *
 *  -아이디어
 *  1. 파괴 가능한 블록의 모양은 5가지이다.
 *  2. 주어진 input 에 파괴 가능한 모양만 추린다.
 *  3. 반복: 파괴 가능한 모양이 실제로 파괴 되는지 체크한다.
 *
 */

public class Pro_42894 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 4, 0, 0, 0},
                {0, 0, 0, 0, 0, 4, 4, 0, 0, 0},
                {0, 0, 0, 0, 3, 0, 4, 0, 0, 0},
                {0, 0, 0, 2, 3, 0, 0, 0, 5, 5},
                {1, 2, 2, 2, 3, 3, 0, 0, 0, 5},
                {1, 1, 1, 0, 0, 0, 0, 0, 0, 5}
        }));
    }

    public static int solution(int[][] board) {
        int answer = 0;

        int n = board.length;
        Queue<Node> q = new LinkedList<>();

        //파괴 가능한 블록 초기화
        for(int i=0; i<n; i++){
            for(int j=0; j<n ;j++){
                if(board[i][j]!=0){
                    possible(board[i][j], i, j, board, q, n);
                }
            }
        }


        //파괴 불능 나올때까지 반복
        boolean flag = true;
        while(flag){
            flag = false;

            int size = q.size();
            for(int i=0; i<size; i++){
                Node node = q.poll();

                if(func(node.num, node.x, node.y, board, node)){ //파괴 가능 시
                    answer++; flag =true;
                }
                else q.offer(node); //파괴 안되면 다음 반복문에 다시 확인
            }
        }
        return answer;
    }

    static int case1_x[] ={1,1,1}, case1_y[]={0,1,2}; //빨간색3번째
    static int case2_x[] ={1,2,2}, case2_y[]={0,0,-1}; //빨간색4번째
    static int case3_x[] ={1,2,2}, case3_y[]={0,0,1}; //주황색2번째
    static int case4_x[] ={1,1,1}, case4_y[]={0,-1,-2}; //주황색3번째
    static int case5_x[] ={1,1,1}, case5_y[]={0,-1,1}; //파란색1번째
    static class Node{
        int x, y;
        int num; //1,2,3,4,5

        public Node(int a, int b, int c){
            x=a; y=b; num=c;
        }
    }


    //파괴 가능한 모양인지 확인용 함수
     static void possible(int eq, int x, int y, int[][] board, Queue<Node> q, int n){
        //빨간색3번째
        if(x+1<n && y+2<n){
            if(eq == board[x+1][y] && eq == board[x+1][y+1] && eq == board[x+1][y+2]){
                q.offer(new Node(x,y,1));
                return;
            }
        }

        //빨간색4번째
        if(x+2<n && y-1>=0){
            if(eq==board[x+1][y] && eq==board[x+2][y] && eq==board[x+2][y-1]){
                q.offer(new Node(x,y,2));
                return;
            }
        }

        //주황색2번째
        if(x+2<n && y+1<n){
            if(eq==board[x+1][y] && eq==board[x+2][y] && eq==board[x+2][y+1]){
                q.offer(new Node(x,y,3));
                return;
            }
        }

        //주황색3번째
        if(x+1<n && y-2>=0){
            if(eq==board[x+1][y] && eq==board[x+1][y-1] && eq==board[x+1][y-2]){
                q.offer(new Node(x,y,4));
                return;
            }
        }


        //파란색1번째
        if(x+1<n && y+1<n && y-1>=0){
            if(eq==board[x+1][y] && eq==board[x+1][y-1] && eq==board[x+1][y+1]){
                q.offer(new Node(x,y,5));
                return;
            }
        }

    }

    //파괴 할 수 있다면 파괴하기
    static boolean func(int num, int x, int y, int[][] board, Node node){
        if(num==1){//빨간색3번째
            for(int i=0; i<=node.x; i++){
                if(board[i][node.y+1]!=0 || board[i][node.y+2]!=0) return false;
            }
            board[x][y] = 0;
            for(int i=0; i<3; i++){
                board[x+case1_x[i]][y+case1_y[i]] = 0;
            }
            return true;
        }
        else if(num==2){//빨간색4번째
            for(int i=0; i<=node.x+1; i++){
                if(board[i][node.y-1]!=0) return false;
            }
            board[x][y] = 0;
            for(int i=0; i<3; i++){
                board[x+case2_x[i]][y+case2_y[i]] = 0;
            }
            return true;
        }
        else if(num==3){//주황색2번째
            for(int i=0; i<=node.x+1; i++){
                if(board[i][node.y+1]!=0) return false;
            }
            board[x][y] = 0;
            for(int i=0; i<3; i++){
                board[x+case3_x[i]][y+case3_y[i]] = 0;
            }
            return true;
        }
        else if(num==4){//주황색3번째
            for(int i=0; i<=node.x; i++){
                if(board[i][node.y-1] !=0 || board[i][node.y-2]!=0) return false;
            }
            board[x][y] = 0;
            for(int i=0; i<3; i++){
                board[x+case4_x[i]][y+case4_y[i]] = 0;
            }
            return true;
        }
        else if(num==5){//파란색1번째
            for(int i=0; i<=node.x; i++){
                if(board[i][node.y-1]!=0 || board[i][node.y+1]!=0) return false;
            }
            board[x][y] = 0;
            for(int i=0; i<3; i++){
                board[x+case5_x[i]][y+case5_y[i]] = 0;
            }
            return true;
        }

        return false;
    }
}

/*
테스트 1 〉	통과 (0.27ms, 71.3MB)
테스트 2 〉	통과 (0.42ms, 73.5MB)
테스트 3 〉	통과 (0.47ms, 73.4MB)
테스트 4 〉	통과 (0.31ms, 71.6MB)
테스트 5 〉	통과 (0.35ms, 72.7MB)
테스트 6 〉	통과 (0.31ms, 75.5MB)
테스트 7 〉	통과 (0.44ms, 76.1MB)
테스트 8 〉	통과 (0.32ms, 74.4MB)
테스트 9 〉	통과 (0.28ms, 77.1MB)
테스트 10 〉	통과 (0.36ms, 76.1MB)
테스트 11 〉	통과 (0.44ms, 69.3MB)
테스트 12 〉	통과 (0.80ms, 73MB)
테스트 13 〉	통과 (0.70ms, 72.2MB)
테스트 14 〉	통과 (0.92ms, 76.1MB)
테스트 15 〉	통과 (1.01ms, 75.9MB)
테스트 16 〉	통과 (1.12ms, 71.7MB)
테스트 17 〉	통과 (0.84ms, 65.4MB)
테스트 18 〉	통과 (0.46ms, 81.4MB)
테스트 19 〉	통과 (0.74ms, 77.3MB)
테스트 20 〉	통과 (0.30ms, 75.9MB)
 */