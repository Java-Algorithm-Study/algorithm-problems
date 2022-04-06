import java.util.*;

public class Pro_42583 {
    Queue<Integer> bridgeQue = new LinkedList<>();
    int nowWeight = 0;

    public void pushTruck(int truck) {
        bridgeQue.add(truck);
        nowWeight += truck;
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        for (int i=0; i<truck_weights.length;i++) {
            while (true) {
                // 트럭이 빈 경우
                if (bridgeQue.isEmpty()) {
                    pushTruck(truck_weights[i]);
                    answer++; // *추가코드
                    break; // *추가코드
                    // 트럭이 비지 않을 경우
                } else {
                    // 일단 브릿지에 다 있을 경우는 무조건 폴
                    if (bridgeQue.size() == bridge_length) {
                        nowWeight -= bridgeQue.poll();
                    } else {
                        if (nowWeight + truck_weights[i] <= weight) {
                            pushTruck(truck_weights[i]); // *코드 실수
                            answer++;
                            break;
                        }else {
                            bridgeQue.add(0);
                            answer++; // * 코드 위치변경
                        }
                    }
                }
            }
        }
        answer = answer + bridge_length;
        return answer;
    }
}
