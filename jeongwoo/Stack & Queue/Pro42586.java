import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * [42586] 기능 개발  
 * https://programmers.co.kr/learn/courses/30/lessons/42586
 *
 * -아이디어
 * 1. 큐에 남은 작업 일자(= (전체 - 현재 진행 속도) / 스피드)를 차례대로 넣는다.
 * 2. 큐에서 poll한 값이 poll 후에 peek한 값보다 크다면 poll 했을 때 같이 배포할 수 있으니까 cnt++
 * 3. 큐가 사라질 때까지 계속 돌린다.
 *
 * -자료 구조
 * 1. Queue<Integer> : 남은 작업 일자
 * 2. List<Integer> : 정답
 */
 
public class Pro42586 {
    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

        System.out.println(solution(progresses, speeds));
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {
            double temp = (100 - progresses[i]) / (double) speeds[i];
            int tmp = (int) Math.ceil(temp);
            q.add(tmp);
        }

        while (!q.isEmpty()) {
            int temp = q.poll();
            int cnt = 1;

            while (!q.isEmpty() && temp >= q.peek()) {
                cnt++;
                q.poll();
            }

            list.add(cnt);
        }

        int[] answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
