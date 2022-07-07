import java.util.PriorityQueue;

public class Pro_더맵게 {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
            pq.add(scoville[i]);
        }

        while (pq.size() > 1) {
            if(pq.peek() >= K) {
                return answer;
            }else {
                int leastSpicy = pq.poll();
                int secondLeastSpicy = pq.poll();
                int mixScoville = leastSpicy + (secondLeastSpicy*2);

                pq.add(mixScoville);
                answer++;
            }
        }
        if (pq.size() == 1 && pq.peek() > K) return answer;

        return -1;
    }
}
