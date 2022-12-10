import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * [42889] 실패율 
 * https://programmers.co.kr/learn/courses/30/lessons/42889
 *
 * -아이디어
 * 1. 각 단계별로 몇 명이 진행하는지 배열에 담는다.
 * 2. 전체에서 현재 단계 진행 인원을 빼면서 실패율을 구한다.
 * 3. 정렬 조건에 맞게 커스텀한다.
 *
 * -시간 복잡도
 * 1. O(n)
 *
 * -자료 구조
 * 1. success[] : 각 단계별 현황 담을 배열
 * 2. Stage Class : 단계, 실패율
 */
 
public class Pro42889 {
    public static void main(String[] args) {
        System.out.println(solution(5, new int[] {2, 1, 2, 6, 2, 4, 3, 3}));
    }
    
    static class Stage implements Comparable<Stage> {
        int stage;
        double rate;

        public Stage(int stage, double rate) {
            this.stage = stage;
            this.rate = rate;
        }

        @Override
        public int compareTo(Stage s) {
            // 1. 실패율 내림차순
            // 2. 실패율 같다면 스테이지 번호 내림차순
            if (this.rate > s.rate) {
                return -1;
            }
            else if (this.rate == s.rate) {
                return 0;
            }
            return 1;

        }
    }

    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] success = new int[N + 2];
        List<Stage> list = new ArrayList<>();

        for (int i = 0; i < stages.length; i++) {
            success[stages[i]]++;
        }

        int total = stages.length;
        for (int i = 1; i < success.length - 1; i++) {
            if (total == 0) {
                list.add(new Stage(i, 0));
            }
            else {
                double temp = (double) success[i] / total;
                list.add(new Stage(i, temp));
            }
            
            total -= success[i];
        }

        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).stage;
        }

        return answer;
    }
}
