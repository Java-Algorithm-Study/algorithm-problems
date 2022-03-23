import java.util.ArrayList;
import java.util.Arrays;

public class prg_로또 {
    public static void main(String[] args) {
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};
        int[] solution = prg_로또.solution(lottos, win_nums);
        System.out.println(solution);
    }
    public static int[] solution(int[] lottos, int[] win_nums) {
        int cnt = 0;
        int zeroCnt = 0;
        int[] answer = new int[2];
        ArrayList<Integer> lottosArr = new ArrayList<>();
        // 1. list로 옮긴다.
        for (int i: lottos) {
            lottosArr.add(i);
        }
        // 2. 문제 수만큼 반복문을 돌면서 일치하는 답 있을 시 ++
        for (int i=0; i<win_nums.length; i++) {
            if(lottosArr.contains(win_nums[i]))
                cnt++;
            //3. 0의 갯수가 최저갯수가 된다.
            if (lottos[i] == 0) zeroCnt++;
        }
        // 최저 (0,1개 맞출 시 6등)
        if (cnt<=1) answer[1] = 6;
        else {
            answer[1] = 6 - cnt + 1;
        }
        // 최고= 0갯수 + 답 일치한 갯수 (0,1개 맞출 시 6등)
        int sum = cnt + zeroCnt;
        if (sum<=1) answer[0] = 6;
        else {
            answer[0] = 6 - sum + 1;
        }
        return answer;
    }
}
