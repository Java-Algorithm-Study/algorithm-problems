package DataStructure;

import java.util.*;

// 스코빌 지수 K이상일 때까지 반복
// 가장 낮은 2개 음식 섞어서 새 음식  가장 적은 지수 + (두번째 적은 지수 *2)
// scoville 길이 100만 이하, K: 0~10억
// K이상으로 만들 수 없으면 -1, or 섞은 횟수 리턴
// - 아이디어
// 1. scoville 순회하면서 min, granterThanMin을 찾는다.
//   - 두 값으로 지정되지 않은 값은 다시 힙에 넣는다.ㅐㅐ
// 2. 두 값이 k 이상이면 answer return한다.
// heapify
// 1. 자식노드와 부모노드 비교 (왼->오)
//   - 왼쪽 자식노드 : index*2+0
//   - 오른쪽 자식노드 : index*2+1
//   - 자식이 더 작으면 change
// 2. 그렇게 끝까지 비교해서 heapify 완성
// scovile 지수는 1,2 번째만 보면 됨
public class prg_더맵게 {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i=0; i<scoville.length; i++) {
            pq.offer(scoville[i]);
        }
        int answer = 0;
        // 스코빌 지수 체크
        int min = pq.peek();
        while (pq.peek() < K) {
            min = pq.poll();
            int secMin = pq.poll();
            int newScov = min + (secMin * 2);
            pq.offer(newScov);
            answer++;
            if (pq.size() == 1) {
                if (pq.peek() < K) return -1;
                else break;
            }
        }
        return answer;
    }
    /*
    int[] heapifiedScoville;
    public int solution(int[] scoville, int K) {
        heapifiedScoville = new int[scoville.length+1];
        // 1. init
        for (int i=0; i<scoville.length; i++) {
            heapifiedScoville[i+1] = scoville[i];
        }

        // 2. heapify
        heapify();
        // 3. 루트 노드와 그 바로 뒤 노드의 scoville 지수 확인
        if (heapifiedScoville[1] < K || heapifiedScoville[2] < K) {

        }
    }
    private void heapify() {
        for (int i=1; i<heapifiedScoville.length; i++) {
            int node = heapifiedScoville[i];
            int leftChild = heapifiedScoville[i*2];
            int rightChild = heapifiedScoville[i*2+1];
            // left
            if (leftChild < node) {
                swap(i, i*2);
            }
            if (rightChild < heapifiedScoville[i]) {
                swap(i, i*2+1);
            }
        }
    }
    private void swap(int idx, int idx2) {
        int tmp = heapifiedScoville[idx];
        heapifiedScoville[idx] =  heapifiedScoville[idx2];
        heapifiedScoville[idx2] = tmp;
    }*/
}