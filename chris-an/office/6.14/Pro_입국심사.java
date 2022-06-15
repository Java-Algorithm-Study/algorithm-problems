import java.util.Arrays;


/**
 * https://programmers.co.kr/learn/courses/30/lessons/43238
 *
 * Lv3 - 이분탐색
 *
 * 이분 탐색을 어떤 부분에서 적용을 해야하는 지? 가 생각이 안났던 문제.
 * mid(target) 을 확인하면서 left(최저) right(최고) 일 때의 시간을 확인하면서 가능한한 최소를 탐색
 * 또한, long = int * int 가 불가..
 * 즉, long = int * long 이던? 해야하는데
 * 초반에 right 부분에서 n을 long 으로 형변환을 해주어, long right 변수에 담을 수 있게끔 해야함.
 */
public class Pro_입국심사 {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);

        long left = 1;
        long right = (long) (n) * times[times.length-1];
        long mid  = 0;  //30

        while (left <= right) {
            mid  = (left+right) / 2;
            long sum = 0;
            for (int time: times) {
                sum += mid/time;
            }
            if (n <= sum) {
                right = mid-1;
                answer = mid;
            }
            else {
                left = mid+1;
            }
        }
        return answer;
    }
}
