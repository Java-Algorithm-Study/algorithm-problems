import java.util.PriorityQueue;
// 프로그래머스 더맵게
public class Pro_42626 {
    public static int solution(int[] scoville, int K) {
        
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    
        for (int j : scoville) {
            priorityQueue.add(j);
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