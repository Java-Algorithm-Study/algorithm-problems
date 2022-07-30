package Implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
// - 문제이해
// 쿠폰 적립
// 쿠폰 -> 상품 교환 : 몇개 상품 얻을까?
// 쿠폰으로 얻을 수 있는 상품 계산!
// N개의 한정음료 쿠폰, M개의 일반음료 쿠폰
// 조건: 12장 쿠폰. 최소 5장이 한정음료여야한다.(N>=5)
// - input
// T 테스트케이스갯수
// N,M: 0이상의 정수
// 최대 상품 갯수를 구하라.
// 예) N=12, M=0 .
// 교환 못하면 0개.
// 규칙을 찾지않고 풀면 효율성에서 불통.
public class 구름_사은품교환하기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for (int i=0; i<TC; i++) {
            long possibleGoodsCnt = 0;
            String[] input = br.readLine().split(" ");
            long N = Long.parseLong(input[0]);
            long M = Long.parseLong(input[1]);

            // 1.M/7과 N/5 중 최소값으로 해서 최소로 가능한 경우를 cnt ++
            possibleGoodsCnt += Math.min(N/5, M/7);
            N -= possibleGoodsCnt * 5;
            M -= possibleGoodsCnt * 7;

            // 2. M이 남은 경우 (최소의 N과 나머지 M으로 가능하면 ++)
            if (N>=5 && M+N>=12) {
                N -= (12 - M);
//                M=0;
                possibleGoodsCnt++;
            }

            // 3. N이 남은 경우 (12개가 안되면 0)
            possibleGoodsCnt += N/12;

            System.out.println(possibleGoodsCnt);
        }
        /*  처음 내 풀이 : tc 4개 통과X
        for (int i=0; i<TC; i++) {
            int needCoupon = 12;
            int possibleGoodsCnt = 0;
            String[] input = br.readLine().split(" ");
            long N = Long.parseLong(input[0]);
            long M = Long.parseLong(input[1]);

            while (N>=5 && N+M >= 12) {
                needCoupon = 12;
                N-=5;
                needCoupon -=5;
                // M이 나머지 쿠폰 갯수 이상인 경우
                if (M>=needCoupon) {
                    M-=needCoupon;
                    needCoupon = 0;
                    possibleGoodsCnt++;
                    continue;
                }
                // M이 0보단 크지만 쿠폰이 부족한 경우
                if (M>0){
                    needCoupon -= M;
                    M=0;
                }
                // 쿠폰 갯수를 못채웠고 N으로 채울 수 있는 경우
                if (N >= needCoupon) {
                    N -= needCoupon;
                    needCoupon = 0;
                }
                if(needCoupon==0) {
                    possibleGoodsCnt++;
                }
                else break;
            }//while문 end
            System.out.println(possibleGoodsCnt);
        }*/
    }
}