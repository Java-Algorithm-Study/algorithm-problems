import java.util.Arrays;
// - 아이디어
// 이분 탐색으로 범위를 좁혀나가는 기준은, "심사 전체 소요 시간"
// 처음 left = 0분, right = 전체 고객수 * 심사소요시간 중 최댓값
// mid = 각 심사관이 심사할 수 있는 고객수. => n과 비교하며 이분탐색.

// - 후기
// 어떤 심사관을 고객과 연결시켜야 최소가 될지 고민하다보니 해결방법을 찾지 못함.
// 이분 탐색으로 최소의 값을 찾는 문제
public class prg_입국심사 {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
       long left = 1;
       long right = (long)n * times[times.length-1];
       long mid  = 0;  //30
        while (left <= right) {
            mid  = (left+right) / 2;
            long possiblePplCount = 0;
            for (int takenTime: times) {
                possiblePplCount += mid / takenTime;
            }
            if (n <= possiblePplCount) {
                right = mid-1;
                answer = mid;
            }
            else left = mid+1;
        }
        return answer;
    }
}