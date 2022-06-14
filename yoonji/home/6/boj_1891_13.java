import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 사분면
//50 12341234123412341234123412341234123412341234123412
//500000 3000000000
public class boj_1891_13 {
    static long rowLoc = 0;
    static long colLoc = 0;
    static StringBuilder answerSB = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int d = Integer.parseInt(st.nextToken());
        String quadrantInfo = st.nextToken();
        long size = (long)Math.pow(2, d);

        st = new StringTokenizer(br.readLine());
        long moveCol = Long.parseLong(st.nextToken());
        long moveRow = Long.parseLong(st.nextToken());

        //1. 사분면에 따라 위치 찾기
        findLocation(quadrantInfo, size);
        //2. 위치 이동
        rowLoc -= moveRow;   // +1이 위로 이동=> 좌표 상은 -
        colLoc += moveCol;
        // 3. 이동한 위치의 사분면 찾기
        if (outOfBoundary(rowLoc, colLoc, size)) System.out.println("-1");
        else
            findQuadrant(rowLoc, colLoc, size);
    }

    // 위치에 따른 사분면 String을 찾는다.
    private static void findQuadrant(long row, long col, long size) {
        if (size == 1) {
            System.out.println(answerSB);
            return;
        }
        if (row < size / 2 && col >= size / 2) {//1
            answerSB.append(1);
            findQuadrant(row, col - size / 2, size / 2);
        }
        if (row < size / 2 && col < size / 2) {//2
            answerSB.append(2);
            findQuadrant(row, col, size / 2);
        }
        if (row >= size / 2 && col < size / 2) {//3
            answerSB.append(3);
            findQuadrant(row - size / 2, col, size / 2);
        }
        if (row >= size/2 && col >= size/2) {//4
            answerSB.append(4);
            findQuadrant(row - size / 2, col - size / 2, size / 2);
        }
    }

    private static boolean outOfBoundary(long row, long col, long size) {
        return (row<0 || row>= size || col<0 || col>= size);
    }

    private static void findLocation(String quadrantInfo, long size) {
        for (int i=0; i<quadrantInfo.length(); i++) {
            size/=2;
            int quardrant =quadrantInfo.charAt(i) - '0';
            switch (quardrant) {    // 2사분면은 그대로
                case 1 : colLoc += size; break;
                case 3 : rowLoc += size; break;
                case 4 :
                    rowLoc += size;
                    colLoc += size;
            }
        }
    }
}