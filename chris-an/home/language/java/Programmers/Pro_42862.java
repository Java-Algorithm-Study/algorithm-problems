package language.java.Programmers;

public class Pro_42862 {

    /*
    도난 당한 학생
    여유 체육복이 있는 학생
    그대로 자기 옷이 있는 학생

    배열을 생성해서, for문을 통해 순서대로,
    도난당한 학생에 인덱스 위치에 -1
    여유 체육복이 있는 학생은 +1
    그 이후에 마지막에 for문을 한 번 더 돌려서,
    인덱스 값이 0 이상이면 카운트를 해주기

    */

    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] arr = new int[n];

        for (int i = 0; i < reserve.length; i++) {
            arr[reserve[i] -1]++;
        }

        for (int i = 0; i < lost.length; i++) {
            arr[lost[i] -1]--;
        }

        for (int i = 0; i < arr.length; i++) {
            // 체육복 없는 경우
            if (arr[i] == -1) {
                // 앞
                if (i != 0 &&arr[i - 1] == 1) {
                    arr[i-1]--;
                    arr[i]++;
                    answer++;
                    // 뒤
                }else if (i != arr.length-1 && arr[i + 1] == 1) {
                    arr[i+1]--;
                    arr[i]++;
                    answer++;
                }
                // 체육복 있는 경우
            }else {
                answer++;
            }
        }
        return answer;
    }
}
