import java.util.Arrays;

/**
 * [43238] 입국 심사
 * https://programmers.co.kr/learn/courses/30/lessons/43238
 *
 * -아이디어
 * 1. 무엇(start, mid, end)을 이분 탐색 할 것인지, 어떤 것과 비교하여 다음 구간을 정할 것인지를 정한다.
 * -> 입국 심사에 걸리는 최소 시간을 구해야 되니까 최소 시간(무엇)을 탐색하고, n명(입국 심사 해야 되는 인원)과 비교해서 다음 구간을 정한다.
 * 2. mid 시간 동안 심사할 수 있는 사람의 수 sum을 구해서 n과 비교한다.
 * 3. sum < n 이라면 mid 시간보다 더 많은 시간이 필요하다.
 * -> start = mid + 1
 * 4. sum > n 이라면 mid 시간보다 더 적은 시간으로 총 인원을 검사할 수 있다.
 * -> end = mid - 1
 *
 */

public class Pro43238 {
    public static void main(String[] args) {
        int n = 6;
        int[] input = {7, 10};
        System.out.println(solution(n, input));

    }
    private static long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        Arrays.sort(times);

        long start = 0; // 최소 소요 시간
        long end = (long) n * times[times.length - 1]; // 최대 소요 시간

        while (start <= end) {
            long mid = (start + end) / 2;
            long sum = 0;

            // 심사는 병렬로 일어나기 때문에 
            // ex) mid = 30분이면 7분 걸리는 심사관은 30분 동안 4명
            // 10분 걸리는 심사관은 30분 동안 3명 가능 -> 총 7명
            for (int i = 0; i < times.length; i++) {
                sum += mid / times[i];
            }

            // 시간 내에 모든 인원 심사 못 함.
            // 시간이 부족함 -> 30(mid)분보다 더 걸리니까 이보다 더 뒤를 기준으로 다시 탐색해야 됨
            if (sum < n) {
                start = mid + 1;
            }
            
            // 시간 내에 모든 인원 심사하고도 남음
            // 시간이 남음 -> 30(mid)분보다 덜 걸리니까 이보다 앞을 기준으로 다시 탐색해야 됨
            else {
                end = mid - 1;
                answer = Math.min(answer, mid);
            }
        }

        return answer;
    }
}
