import java.util.LinkedList;
import java.util.Queue;

public class prg_다리를지나는트럭 {
    Queue<Integer> bridgeQue = new LinkedList<>();
    int nowWeight = 0;
    int answer = 0;
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        for (int truckW : truck_weights) {
            while (true) {
                // 다리에 트럭이 없는 경우
                if (bridgeQue.isEmpty()) {
                    pushTruck(truckW);
                    break;
                    // 다리에 트럭이 가득 찬 경우 빼야한다.
                } else if (bridgeQue.size() == bridge_length) {
                        nowWeight -= bridgeQue.poll();
                }
                // 수정 : 큰 ifelse를 세개로 나누어 다리가 가득 찬 경우 빼기만하고 다시 wile문을 돌도록 한다.
                // 다리가 가득 차지 않은 경우
                else {
                    // 트럭이 올 수 있는 무게인 경우, 트럭 push
                    if (nowWeight + truckW <= weight) {
                        pushTruck(truckW);
                        break;
                    // 다리는 안찼는데 트럭이 올 수 없는 경우, 트럭 이동
                    }else {
                        moveTruck();
                    }
                }
            }
        }
        return answer + bridge_length;  // 다리에 올라탄 트럭이 내려오기까지 걸리는 시간 추가
    }
    // 다리에 트럭을 올린다.
    private void pushTruck(int truck) {
        bridgeQue.add(truck);
        nowWeight += truck;
        answer++;
    }
    // 다리 위의 트럭을 이동시킨다.
    private void moveTruck() {
        bridgeQue.add(0);
        answer++;
    }

    public static void main(String[] args) {
        prg_다리를지나는트럭 t = new prg_다리를지나는트럭();
        System.out.println(t.solution(2, 10, new int[]{7, 4, 5, 6}));
        System.out.println(t.solution(100, 100, new int[]{10,10,10,10,10,10,10,10,10,10}));
    }
}