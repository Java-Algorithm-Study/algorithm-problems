import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class prg_모의고사 {
    public int[] solution(int[] answers) {
        int[][] checkPattern = new int[][] {
                {1,2,3,4,5}, {2,1,2,3,2,4,2,5},
                {3,3,1,1,2,2,4,4,5,5}
        };
        int[] cnt = new int[3];
        // 수포자
        for (int j=0; j<checkPattern.length; j++) { // 수포자마다 채점
            for (int i=0; i<answers.length; i++) {
                int numIdx = i % checkPattern[j].length; //나머지를 이용
                if (checkPattern[j][numIdx] == answers[i]) cnt[j]++; // 맞는지 체크
            }
        }
        //max 구하기 변형
        int max = Math.max(cnt[0], Math.max(cnt[1], cnt[2]));
        // max로 맞춘 수포자번호를 반환
        List<Integer> ret = new ArrayList<>();
        for (int i=0; i<cnt.length; i++) {
            if (cnt[i] == max) {
                ret.add(i+1);
            }
        }
        return ret.stream().mapToInt(i-> i.intValue()).toArray();
    }
    public static void main(String[] args) {
        int[] answers = new int[]{1, 3, 2, 4, 2};
        int[] answers2 = new int[]{1, 2,3,4,5};
        prg_모의고사 k = new prg_모의고사();
        int[] solution = k.solution(answers);
        System.out.println(Arrays.toString(solution));
    }
}