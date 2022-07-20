package Sort;

import java.util.Arrays;
// - 아이디어
//1. 정렬
//2. hindex=0부터 최대 원소값까지 탐색
// - 원소 c 이상인 갯수는 전체길이-현재인덱스
// - 조건에 맞는지 체크 후 맞으면 종료.
//※ 최소 인용횟수 값보다 hindex가 작은 경우가 있을 수 있으므로, 0부터 탐색해야한다.
public class prg_HIndex {
    public int solution(int[] citations) {
        int hindex=0;
        Arrays.sort(citations);
        // for (int i: citations)
        //     System.out.print(i);

        int len = citations.length;

        // hindex는 0부터 시작.
        for (int i=0; i<=citations[len-1]; i++) {
            for (int j=0; j<len; j++) {
                if (citations[j] >= i) {
                    int overHCnt = len-j;
                    if (i <= overHCnt) {
                        hindex = i;
                        break;
                    }
                }
            }
        }
        return hindex;
    }
}