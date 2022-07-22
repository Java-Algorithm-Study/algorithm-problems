package Greedy;

// k개 수 제거 시 가장 큰 숫자
// 2<= number <= 1백만
// 1<= k < number 자릿수
// 1924
// 94
// 숫자 이동 X
// 수가 매우 크기 때문에 모든 범위에서 큰 수를 구해서 앞에 수를 지워나가는 방법은 X
// 문자length - k개의 큰 숫자값을 뽑는다는 생각으로 접근해야한다.
// 1. 최소한으로 남겨야하는 number.length()-k 개를 뺀 나머지 수들에서 max값을 찾고 그 외의 앞에 있는 값들은 지운다.
// 2. max값까지를 제거하고, 다시 최소한으로 남겨야하는 수를 제외한 나머지 수들에서 1번을 반복한다.
// 4177252841(10개니까 6개 뽑아야함),  k=4
// 뒤 5자리 남겨놔야 무사히 6개 뽑을 수 있음 => ★이때 어느 범위에서 max를 고를지, 그 범위를 결정하는 변수 구하는 것이 까다로움..
// 뒷자리 5 -> 4 -> 3 -> 2 -> 1자리

public class prg_큰수만들기 {
    public String solution(String number, int k) {
        int len = number.length()-k;
        StringBuilder answer = new StringBuilder();
//        예1)
//         /192/4 => 9 추가 =>24
//         19/24/ => 4추가 => x
//        예2)
//         41772/52841 : leftNum = 4+0+1=5 => 7추가 => 7252841
//         417/725/2841  :leftNum = 4+1+1=6 => 7추가 => 252841
//         4177/252/841  :leftNum = 4+2+1=7 => 5추가 => 2841
//         417725/28/41  :leftNum = 4+3+1=8 => 8추가 => 41
//         41772528/4/1  :leftNum = 4+4+1=9 => 4추가 => 1
//         417725284/1/  :leftNum = 4+5+1=10 => 1추가 => x
//         k개를 제외한 length됐으니 끝. => 775841
        // leftnum= 3+1=4 : 0~3: 3추가 => 1234
        // = 3+2=5, 3~4 : 2추가 => 34
        // = 3+3=6, 5~5 : 3추가 => 4
        // = 3+4=7, 6~6 : 4추가 => x

        int startIdx = 0;
        while (startIdx < number.length() && answer.length() != len) {
            int leftNum = k + answer.length() + 1;
            int maxNum = -1;
            for (int i=startIdx; i<leftNum; i++) {
                int comparedNum = number.charAt(i) - '0';
                if (maxNum < comparedNum) {
                    maxNum = comparedNum;
                    startIdx = i+1;
                }
            }
            answer.append(maxNum);
        }
        return answer.toString();
    }
}