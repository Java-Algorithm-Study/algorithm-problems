package DataStructure;
import java.util.*;
// 기능 진도 100% 서비스 반영
// 뒤 기능이 먼저 개발되면 앞 기능이 배포될 때 함께 배포
// 작업의 진도율 progresses, 개발속도 speeds
// 길이 100개 이하
// 작업 진도는 100미만, 속도는 100이하
// 하루에 1번 배포! ex) 진도율95%인 작업의 개발속도가 4% => 2일 뒤에 배포됨
// 앞 기능의 일자와 뒷 기능의 일자 비교해서
// 1. 앞 기능의 소요일 >= 뒷 기능의 소요일 : 앞 기능 끝나면 함께 진행
// 2. 앞 기능의 소요일 < 뒷 기능의 소요일 : 앞 기능 꺼내서 처리
// 배포 마다 몇 개의 기능이 배포되는지 return

// - 아이디어
// 1. progresses만큼 순회하면서
// 2. 작업 소요 시간 계산하면서
//   2-1. 큐의 top이 현재 작업 소요 시간보다 작거나 같으면, 꺼내서 answer에 추가하고 현재 작업의 소요 시간을 큐에 넣는다.
//   2-2. 크면, 꺼내지 않고 추가한다.
// 자료구조 Queue 이용
public class prg_기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> que = new LinkedList<>();
        int lastMaxNode = 0;

        for (int i=0; i<progresses.length; i++) {
            int remainProcess = 100 - progresses[i];    // 70/30=몫2 + 나머지있으니까+1
            int remainDays = (remainProcess / speeds[i]) + (remainProcess%speeds[i]==0 ? 0:1);
            if (que.isEmpty()) {
                que.add(remainDays);
                lastMaxNode = remainDays;
                continue;
            }
            // 앞 기능이 더 작으면, 먼저 처리
            if (lastMaxNode < remainDays) {
                answer.add(que.size());
                que.clear();
                que.add(remainDays);
                lastMaxNode = remainDays;
                // 앞 기능이 더 크거나 같으면, 큐에 추가+작업갯수 추가+ lastMaxNode는 수정X
            } else {
                que.add(remainDays);
            }
        }

        if (!que.isEmpty()) {
            answer.add(que.size());
        }
        return answer.stream().mapToInt(i->i).toArray();
    }
}