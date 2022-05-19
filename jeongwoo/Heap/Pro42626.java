import java.util.PriorityQueue;

/**
 * [42626] 더 맵게 
 * https://programmers.co.kr/learn/courses/30/lessons/42626
 *
 * -아이디어
 * 1. 우선순위 큐로 최솟값을 O(1) 시간으로 찾을 수 있다.
 * 2. 입력값을 우선순위 큐에 넣어 준다.
 * 3. while문으로 큐가 비어 있지 않을 때 계속 돌려 준다. 
 * 4. 큐에서 최솟값을 뽑고 K 이상인지 체크한다. K 이상이라면 모든 음식이 K 이상이니까 break
 * 5. 뽑은 후에 큐 사이즈가 0인데, 최솟값이 K 이하라면 바꿀 수 없으니까 -1
 * 6. 위 조건에 걸리지 않는다면 큐에서 다시 뽑고 새로 mix
 *
 */
 
public class Pro42626 {
    public static void main(String[] args) {
        int[] input = {1};
        int k = 7;
        System.out.println(solution(input, k));
    }

    public static int solution(int[] scoville, int K) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int i = 0; i < scoville.length; i++) {
            priorityQueue.add(scoville[i]);
        }
        int cnt = 0;

        while (!priorityQueue.isEmpty()) {
            int min1 = priorityQueue.poll();

            if (min1 >= K) {
                break;
            }

            if (priorityQueue.size() < 1) {
                cnt = -1;
                break;
            }

            int min2 = priorityQueue.poll();
            int mixed = min1 + (min2 * 2);
            priorityQueue.add(mixed);
            cnt++;
        }

        return cnt;
    }
}
