//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.*;
//
//
//class Coordinate {
//    int x, y;
//    Coordinate(int x, int y) {
//        this.x = x;
//        this.y = y;
//    }
//}
//
//public class Boj_2667 {
//    /*
//        단지번호 붙이기
//            1. BFS 로 문제를 푼다는 생각을 하기
//            2. 칸은 N이 N*N의 크기 map 을 형성 함
//            3. 2차원 map 을 형성합니다.
//            4. Flood fill 를 진행합니다.
//     */
//    static int[] dx = {-1, 0, 1, 0}; // 북 -> 동 -> 남 - > 서 (index 순서)
//    static int[] dy = {0, 1, 0, -1};
//    static int N; // 지도 크기 설정 N*N
//    static int[][] map;
//    static boolean[][] visited;
//    static ArrayList<Integer> numOfArea = new ArrayList<>();
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//        N = Integer.parseInt(br.readLine());
//
//        // map 선언 및 초기화
//        map = new int[N][N];
//        // 입력값 세팅
//        for (int i = 0; i < N; i++) {
//            String line = br.readLine();
//            for (int j = 0; j < N; j++) {
//                map[i][j] = line.charAt(j) - '0';
//            }
//        }
//
//        visited = new boolean[N][N];
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                // 집이 존재하는 노드(집)이여야 하며, 그 집에 방문한 적이 없어야 함.
//                if (map[i][j] == 1 && !visited[i][j]) {
//                    numOfArea.add(bfs(i, j));
//                }
//            }
//        }
//
//        Collections.sort(numOfArea);
//
//        sb.append(numOfArea.size()).append('\n');
//        for (int i : numOfArea) {
//            sb.append(i).append('\n');
//        }
//
//        System.out.println(sb);
//    }
//
//    private static int bfs(int x, int y) {
//        int range = 1;
//
//        Queue<Coordinate> qu = new LinkedList<>();
//        visited[x][y] = true;
//        qu.offer(new Coordinate(x, y)); // 큐에 노드의 좌표 저장
//
//        while (!qu.isEmpty()) {
//            Coordinate point = qu.poll(); // 해당 위치 값
//
//            // 사방면 탐색 시작
//            for (int i = 0; i < 4; i++) {
//                int newX = point.x + dx[i];
//                int newY = point.y + dy[i];
//
//                if (newX >= 0 && newX < N && newY >= 0 && newY < N &&
//                        map[newX][newY] == 1 && !visited[newX][newY]) {
//                    qu.offer(new Coordinate(newX, newY));
//                    visited[newX][newY] = true;
//                    range++;
//                }
//            }
//        }
//        return range;
//    }
//}
