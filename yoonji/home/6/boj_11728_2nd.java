import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 1차. 이분할 => 정렬되어있는 두 배열이니까 이분할은 최악의 경우가 됨.
// 2차. 정렬되어있는 두 배열 앞에서부터 비교
public class boj_11728_2nd {
    public static void main(String[] args) throws IOException {
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
        int idxOfM = 0;
        int findNum;
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
                    break;
                } else {
                    arr.add(i, findNum);
                    break;
                }
            }
        }
/*        //1차
        Loop1:
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
        }*/
        StringBuilder answerSB = new StringBuilder();
        arr.forEach(v -> answerSB.append(v).append(" "));
        System.out.println(answerSB);
    }
}