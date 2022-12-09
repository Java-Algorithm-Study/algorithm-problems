package boj;
import java.io.*;
import java.util.*;

/**
 * [16234] 인구이동 (골드 5)
 * https://www.acmicpc.net/problem/16234
 *
 * 결과: 214008KB	592ms
 *
 * -아이디어
 * 1. BFS
 *
 */
public class boj_16234 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int n, l, r;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        int arr[][] =new int[n][n];
        for(int i=0; i<n; i++){
            st= new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        Queue<Node> q = new LinkedList<>();
        boolean[][] check;
        boolean out = true;
        int result = -1;
        ArrayList<Node> list = new ArrayList<>();
        while(out){
            out = false;
            check = new boolean[n][n];
            result++;

            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    list.clear();

                    if(!check[i][j]) {
                        boolean flag = false;
                        int cnt = 0;
                        int sum = 0;

                        q.offer(new Node(i, j));
                        while (!q.isEmpty()) {
                            Node poll = q.poll();

                            for (int k = 0; k < 4; k++) {
                                int nx = poll.x + dx[k];
                                int ny = poll.y + dy[k];
                                if (nx >= 0 && ny >= 0 && nx < n && ny < n && !check[nx][ny]) {
                                    int num = Math.abs(arr[poll.x][poll.y] - arr[nx][ny]);
                                    if (num >= l && num <= r) {
                                        if (!flag) {
                                            out=true;
                                            check[i][j] = true;
                                            flag = true;
                                            list.add(new Node(i, j));
                                            cnt++;
                                            sum+=arr[i][j];
                                        }

                                        q.offer(new Node(nx, ny));
                                        check[nx][ny] = true;
                                        cnt++;
                                        sum += arr[nx][ny];
                                        list.add(new Node(nx, ny));
                                    }
                                }
                            }
                        } // q 종료
                        if (flag) {
                            sum = sum / cnt;
                            for (int k = 0; k < list.size(); k++) {
                                Node node = list.get(k);
                                arr[node.x][node.y] = sum;
                            }
                        }
                    }
                }
            }
        }

        System.out.println(result);
    }
    static class Node {
        int x, y;
        public Node(int a,int b){
            x=a; y=b;
        }
    }
    static int dx[] = {-1,1,0,0}, dy[]={0,0,-1,1};
}
