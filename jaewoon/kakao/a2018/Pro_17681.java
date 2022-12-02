package kakao.a2018;

/**
 * [17681] 비밀지도
 * https://school.programmers.co.kr/learn/courses/30/lessons/17681?language=java
 *
 * -아이디어
 * 1. 2진수값을 문자열화 시킨다.
 *
 * -시간복잡도
 * O(n^2)
 */


public class Pro_17681 {
    public static void main(String[] args) {

        int n = 5;
        int arr1[] = {9, 20, 28, 18, 11};
        int arr2[] = {30, 1, 21, 17, 28};

        String[] answer = new String[n];

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();

        for(int i=0; i<n; i++){
            sb1.setLength(0);
            sb2.setLength(0);
            sb3.setLength(0);

            sb1.append(Integer.toString(arr1[i], 2));
            sb2.append(Integer.toString(arr2[i], 2));
            sb1.reverse();
            sb2.reverse();
            for(int j=0; j<n; j++){
                Boolean flag = false;
                if(sb1.length() > j){
                    if(sb1.charAt(j) == '1') flag =true;
                }
                if(sb2.length() > j){
                    if(sb2.charAt(j) == '1') flag =true;
                }

                if(flag) sb3.append('#');
                else sb3.append(' ');
            }
            answer[i] = sb3.reverse().toString();
        }

        for(int i=0; i<n; i++){
            System.out.println(answer[i]);
        }
    }
}

/*
테스트 1 〉	통과 (0.21ms, 74.3MB)
테스트 2 〉	통과 (0.61ms, 67.4MB)
테스트 3 〉	통과 (0.08ms, 77.8MB)
테스트 4 〉	통과 (0.23ms, 75.7MB)
테스트 5 〉	통과 (0.10ms, 74MB)
테스트 6 〉	통과 (0.52ms, 72.9MB)
테스트 7 〉	통과 (0.09ms, 72.6MB)
테스트 8 〉	통과 (0.11ms, 75.9MB)
 */