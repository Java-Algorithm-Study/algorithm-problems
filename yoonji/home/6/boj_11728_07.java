import java.util.*;
import java.io.*;

// 1차. 이분할 => 정렬되어있는 두 배열이니까 이분할은 최악의 경우가 됨.
// 2차. 앞에서부터 비교
// 3차. ArrayList 넣고 Sort
public class boj_11728_07 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Integer> arr = new ArrayList<>(N+M);
        st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<N; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine(), " ");
        // 3차
        for (int i=0; i<M; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }
        // Tim Sort = 삽입 + merge
        Collections.sort(arr);
        /*2차
        int idxOfM = 0;
        int findNum=0;
//        int findNum = Integer.parseInt(st.nextToken());
        for (int i=0; i<N+M-1; i++) {
            if (idxOfM++ >= M) break;
            findNum = Integer.parseInt(st.nextToken());
            while (true){
                int coparedNum = arr.get(i);
                if (coparedNum < findNum) {
                    i++;
                    if (i>=N+M) {
                        arr.add(findNum);
                        break;
                    }
                } else if (coparedNum > findNum) {
                    arr.add(i, findNum);
//                    findNum = Integer.parseInt(st.nextToken());
                    break;
                } else {
                    arr.add(i, findNum);
//                    findNum = Integer.parseInt(st.nextToken());
                    break;
                }
            }
        }*/
/*        //1차
        int findNum = Integer.parseInt(st.nextToken());
        int start = 0;
        int end = N+i-1;  // 초기화된 만큼?
        while (start <= end) {
            int mid = (start+end) / 2;
            int midNum = arr.get(mid);
            if (findNum == midNum) {
                arr.add(mid, findNum);
                continue Loop1;
            } else if (findNum < midNum) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        arr.add(end+1, 0), findNum);*/
        /*Loop1:
        for (int i=0; i<M; i++) {
            int findNum = Integer.parseInt(st.nextToken());
            int start = 0;
            int end = N+i-1;  // 초기화된 만큼?
            while (start <= end) {
                int mid = (start+end) / 2;
                int midNum = arr.get(mid);
                if (findNum == midNum) {
                    arr.add(mid, findNum);
                    continue Loop1;
                } else if (findNum < midNum) {
                    end = mid-1;
                } else {
                    start = mid+1;
                }
            }
            arr.add(end+1, findNum);
            //searchAndInsertNum(Integer.parseInt(st.nextToken()));
        }*/
        StringBuilder answerSB = new StringBuilder();
        arr.forEach(v -> answerSB.append(v).append(" "));
        System.out.println(answerSB);
    }
//    private void searchAndInsertNum(int num) {
//        int start = 0;
//        int end = arr.length-1;  // 초기화된 만큼?
//    }
}