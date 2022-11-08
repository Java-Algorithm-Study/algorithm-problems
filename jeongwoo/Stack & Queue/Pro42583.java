import java.util.LinkedList;
import java.util.Queue;

 /**
  * [42583] 다리를 지나는 트럭
  * https://programmers.co.kr/learn/courses/30/lessons/42583
  *
  * -아이디어
  * 1. 트럭 한 대 태울 때마다 시간++
  * 2-1. 다리가 비어 있으면 다리 큐에 트럭 넣는다.
  * 2-2. 다리가 비어 있지 않는데
  * 2-2-1. 다리가 꽉 차 있으면 맨 앞에 트럭을 내린다 -> 시간 들지 않음
  * 2-2-2. 다리 꽉 차 있지 않으면 다음 트럭 넣을 수 있는지 판단한다 -> 무게 && 길이 확인해서 넣을 수 있음 넣고 시간++
  * 2-2-3. 다음 트럭을 못 넣는다면 원래 있던 트럭을 한 칸 앞으로 보낸다. -> 다리에 0을 넣어서 보냄. 시간++
  *
  * */
  
public class Pro42583 {
    public static void main(String[] args) {
        System.out.println(solution(2, 10, new int[] {7,4,5,6}));
    }

    private static int solution(int bridge_length, int weight, int[] truck_weights) {
        int sum = 0;
        int time = 0;

        Queue<Integer> bridge = new LinkedList<>(); // 다리 건너는 트럭

        for (int x : truck_weights) {
            while (true) {
                // 다리가 비어 있으면 -> 시간++, 무게 더하고, 다리에 넣는다
                if (bridge.isEmpty()) {
                    bridge.add(x);
                    sum += x;
                    time++;
                    break;
                }

                // 다리에 트럭 꽉 참
                else if (bridge.size() == bridge_length) {
                    sum -= bridge.poll();
                }

                // 다리에 트럭 있는데 꽉 차진 않음
                else {
                    // 넣을 수 있음
                    // 넣고 시간, 무게 추가
                    if (sum + x <= weight) {
                        bridge.add(x);
                        sum += x;
                        time++;
                        break;
                    }
                    // 다리에 무게 or 정원 초과로 못 들어가면
                    // 맨 앞에 있는 트럭 뺀다. 내릴 때는 시간이 걸리지 않는다.
                    else {
                        bridge.add(0);
                        time++;
                    }
                }
            }
        }

        return time + bridge_length;
    }
}
