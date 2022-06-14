import java.util.LinkedList;
import java.util.Queue;

/**
 * [42583] 다리를 지나는 트럭
 * https://programmers.co.kr/learn/courses/30/lessons/42583
 */

public class Pro42583 {
    public static void main(String[] args) {
        System.out.println(solution(4, 2, new int[]{1, 1, 1, 1}));

    }

    private static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int sum = 0;
        int cnt = 0;

        Queue<Integer> waiting = new LinkedList<>(); // 대기 트럭
        Queue<Integer> bridge = new LinkedList<>(); // 다리 건너는 트럭

        for (int i = 0; i < truck_weights.length; i++) {
            waiting.add(truck_weights[i]);
        }

        for (int i = 0; i < bridge_length; i++) {
            bridge.add(0);
        }


        while (!waiting.isEmpty()) {
            int temp = waiting.peek();

            // 대기 트럭에서 빼고, sum에 추가, bridge에 추가
            if (temp + sum <= weight) {
                sum += waiting.poll();
                bridge.poll();
                bridge.add(temp);
                cnt++; // 1초 추가
            }

            if (waiting.isEmpty()) {
                break;
            }

            // 다음 대기 트럭에 있는 거 빼와서 브릿지에 넣을 수 있는지 확인
            temp = waiting.peek();

            // 대기 트럭 하나가 브릿지에 같이 들어갈 수 있으면 대기 트럭에서 브릿지로 넣어 주고, 1초 추가
            if (bridge.size() + 1 <= bridge_length && sum + temp <= weight) {
                sum += temp;
                bridge.poll();
                bridge.add(waiting.poll());
                cnt++;
            }

            // 브릿지에 트럭이 있는데, 대기 트럭이 브릿지에 같이 못 들어가는 경우 -> 브릿지에 있는 트럭을 다리를 건너게 한다 -> 브릿지에서 빼고, 다리 건너는 시간 추가
            else {
                int w = bridge.peek();
                sum -= w;
                cnt += bridge_length - bridge.size();
                bridge.add(0);
                bridge.poll();
            }
        }

        cnt += bridge_length;

        return cnt;
    }
}
