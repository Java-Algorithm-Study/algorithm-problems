package language.java.Programmers;

import java.util.*;

public class Pro_기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> workingDays = new LinkedList<>();

        // 작업 진도 각 프로세스 스피드에 맞게 얼마나 걸리는 지 데이터 뽑기
        for (int i = 0; i < progresses.length; i++) {
            int percent = progresses[i];
            int days = 0;
            while(100 > percent) {
                percent += speeds[i];
                days++;
            }
            workingDays.add(days);
        }

        // result 값 계산
        ArrayList<Integer> list = new ArrayList<>();
        int pre = workingDays.poll();
        int count = 1;
        while(!workingDays.isEmpty()) {
            int tmp = workingDays.poll();
            if(pre >= tmp) {
                count++;
            }else {
                list.add(count);
                count = 1;
                pre = tmp;
            }

            if(workingDays.isEmpty()) {
                break;
            }
        }

        list.add(count);
        int[] answer = new int[list.size()];
        int idx = 0;
        for (int i : list) {
            answer[idx++] = i;
        }

        return answer;
    }
}
