import java.util.*;
import java.util.stream.Collectors;

public class Pro_더맵게 {
    public int solution(int[] scoville, int K) {
        int calculateCnt = 0;

        Queue<Integer> pq = new PriorityQueue<>();
        for (int i=0; i< scoville.length; i++) {
            pq.offer(scoville[i]);
        }
        while(pq.size()>1) {
            if (pq.peek() >= K) break;
            int first = pq.poll();
            int sec = pq.poll();
            int newScov = first + (sec * 2);
            pq.offer(newScov);
            calculateCnt++;
        }
        if (pq.size() == 1 && pq.peek() < K) calculateCnt = -1;

        return calculateCnt;
    }



    public int solution2(int[] scoville, int K) {
        List<Integer> scovilles = Arrays.stream(scoville).boxed().collect(Collectors.toList());
        int calculateCnt = 0;
        // 힙 생성
        int scovLen = scovilles.size();
        // 1 최초 힙 생성
        for (int i=scovLen/2-1; i>=0; i--) {    // 부모 노드 i를 전달
            heapify(scovilles, scovLen, i);
        }
        // 새 scov 생성
        while (scovilles.size()>1) {
            if (scovilles.get(0) >= K) break;
            int first = scovilles.remove(0);
            int sec = scovilles.remove(0);
            int newScov = first + (sec * 2);
            scovilles.add(newScov);
            // 힙 정렬
            for (int i=scovLen/2-1; i>=0; i--) {    // 부모 노드 i를 전달
                heapify(scovilles, scovilles.size(), i);
            }
            calculateCnt++;
        }
        if (scovilles.size() == 1) {
            if (scovilles.get(0) < K) calculateCnt = -1;
        }
        return calculateCnt;
    }

    private void heapify(List<Integer> scovilles, int scovLen, int originalP) {
        int parent = originalP;
        int childL = originalP*2;
        int childR = originalP*2+1;

        if (childL<scovLen && scovilles.get(childL) < scovilles.get(parent)) {
            parent = childL;
        }
        if (childR<scovLen && scovilles.get(childR) < scovilles.get(parent)) {
            parent = childR;
        }
        if (originalP != parent) {
            swap(scovilles, originalP, parent);
            heapify(scovilles, scovLen, parent);
        }
    }

    private void swap(List<Integer> scovilles, int a, int b) {
        int tmp = scovilles.get(a);
        scovilles.set(a, scovilles.get(b));
        scovilles.set(b, tmp);
    }
}