/**
 * [17687] N진수 게임
 * https://programmers.co.kr/learn/courses/30/lessons/17687
 *
 * -아이디어
 * 1. 미리 구할 숫자 t <= 1000, 게임 참가 인원 m <= 100 -> 총 1000*100 = 100,000개의 문자열을 다 구한다.
 * 2. 구한 문자열에서 튜브 순서에 해당하는 문자열만 뽑는다.
 *
 * -- 문자열 구하는 방법
 * 1. Integer.toString(int, n진법)을 사용해서 10진법에 해당하는 숫자를 n진법으로 변환한다.
 * 2. 변환된 숫자를 배열에 담는다.
 *
 * -시간 복잡도
 * 1. O(t * m) 이하 즉, <= 100,000
 *
 * -자료 구조
 * 1. arr[] : 말할 문자열
 * 2. sb : 리턴값
 */

public class Pro17687_Again {
    public static void main(String[] args) {
        System.out.println(solution(16,30,2,1));
    }
  
    public static String solution(int n, int t, int m, int p) {
        String[] arr = new String[t * m];

        // 배열 꽉 찼는지?
        boolean flag = false;
        // str 관리할 index
        int idx = 0;
        // (t * m)까지 구하기 전에 끝남
        for (int i = 0; i < t * m; i++) {
            String str = Integer.toString(i, n).toUpperCase();
            String[] temp = str.split("");
            for (int j = 0; j < temp.length; j++) {
                if (idx >= arr.length) {
                    flag = true;
                    break;
                }
                arr[idx++] = temp[j];
            }

            if (flag) {
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        
        for (int i = p - 1; i < arr.length; i = i + m) {
            sb.append(arr[i]);
        }

        return sb.toString();
    }
}
