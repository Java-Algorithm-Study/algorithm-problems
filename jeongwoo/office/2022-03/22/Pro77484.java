import java.util.*;

/**
 * [77484] 로또의 최고 순위와 최저 순위
 * https://programmers.co.kr/learn/courses/30/lessons/77484
 */

class Solution {
        public int[] solution(int[] lottos, int[] win_nums) {
        int cnt = 0;
        int zeroCnt = 0;
        int[] answer = new int[2];
        ArrayList<Integer> lottosArr = new ArrayList<>();
          
        for (int i : lottos) {
            lottosArr.add(i);
        }
        
        for (int i = 0; i < win_nums.length; i++) {
            if(lottosArr.contains(win_nums[i])) { 
              cnt++;
            }
            if (lottos[i] == 0) {
              zeroCnt++;
            }
        }
          
        // 최저
        if (cnt <= 1) { 
          answer[1] = 6;
        }
        else {
            answer[1] = 6 - cnt + 1;
        }
          
        // 최고
        int sum = cnt + zeroCnt;
        if (sum <= 1) {
          answer[0] = 6;
        }
        else {
            answer[0] = 6 - sum + 1;
        }
        return answer;
    }            
}
