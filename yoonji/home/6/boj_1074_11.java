import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 직접 코드를 그림으로 그려보기
// Z 문제
public class boj_1074_11 {
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int findR = Integer.parseInt(st.nextToken());
        int findC = Integer.parseInt(st.nextToken());
        int size = (int) Math.pow(2, N);
        conquer(size, findR, findC);
        // count 분석하기!
        System.out.println(count);  // size=8인 경우, count: 48 - 60 - 63
    }

    private static void conquer(int size, int row, int col) {
        if (size==1) return;    // size=1, r과 c 모두 1 이하의 수
        // count에는 현재 위치에 기반해서 size에 따른 앞 방문 횟수를 추가한다.
        if (row < size/2 && col < size/2) { // 1사분면
            conquer(size/2, row, col);
        }
        if (row < size/2 && col >= size/2) {
            count += (size * size/4);     // 2사분면 = 1사분면을 거쳐야하므로. size:8-> 8*2 =16(4*4)
            conquer(size/2, row, col - size/2);
        }
        if (row >= size/2 && col < size/2) {
            count += (size * size/4) * 2;    // 3사분면 = 1,2사분면을 거쳐야하므로
            conquer(size/2, row - size/2, col);
        }
        if (row >= size/2 && col >= size/2) {
            count += (size * size / 4) * 3; // 4사분면 = 1,2,3사분면을 거쳐야하므로
            conquer(size/2, row - size/2, col - size/2);    // size를 절반으로 줄임과 동시에 그 길이만큼 row 위치, col 위치 모두 이동
        }
    }
}