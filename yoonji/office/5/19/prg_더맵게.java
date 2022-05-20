import java.util.*;
import java.util.stream.Collectors;
/* white board
    1. ArrayList - 오름차순 정렬
    2.  1번째 min이 K보다 작으면, 1, 2번째 index 제거 + 1번째min + (두번째min*2) 를 계산해서 ArrayList 앞에서부터 비교하다가 알맞은 위치에 삽입.
    3. 다시 2번
     if 원소가 1개가 됐을 때 종료 (그 원소가 K보다 작으면 -1)
     if 최솟값(1번쨰 index)이 K 이상이 되면 종료 (min >= K)
     => XXXXXX!!!!! 우선순위 큐를 이용하여 min heap 정렬
 */
public class prg_더맵게 {
    public int solution(int[] scoville, int K) {
        int calculateCnt = 0;
        Queue<Integer> pq = new PriorityQueue<>();
        for (int i=0; i< scoville.length; i++) {
            pq.offer(scoville[i]);
        }
        // scoville 지수 맞추기
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

    /**
     * 직접 min heap으로 구조화하며 답구하기 (효율성 : 시간초과)
     * @param scoville 스코빌지수 배열
     * @param K 목표 스코빌 지수
     * @return calculateCnt 연산 횟수
     */
    public int solution2(int[] scoville, int K) {
        List<Integer> scovilles = Arrays.stream(scoville).boxed().collect(Collectors.toList());
        int calculateCnt = 0;
        // 힙 생성
        int scovLen = scovilles.size();
        // 1. 최초 힙 생성
        for (int i=scovLen/2-1; i>=0; i--) {    // 부모 노드 i를 전달
            heapify(scovilles, scovLen, i);
        }
        // 2. 새 scov 생성하면서 heapify로 min max 유지하기
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
    // min heap 정렬
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

    public static void main(String[] args) {
        prg_더맵게 t = new prg_더맵게();
        System.out.println(t.solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
    }
}