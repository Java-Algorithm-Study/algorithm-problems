import java.util.*;

/**
 * [87390] n^2 배열 자르기
 * https://programmers.co.kr/learn/courses/30/lessons/87390
 *
 * -아이디어
 * 1. (x, y)에서 x, y 중 큰 값이 arr[x][y]의 값이 된다.
 * 2. 행 하나씩 잘라서 한 줄로 붙이는 거니까 left ~ right를 n만큼 자르면 된다.
 * 3. n = 6, left가 15라면 15 / 6 = 2, 15 % 6 = 3 -> (2, 3)인데 문제에서는 (1, 1)부터 값을 넣으니까 +1을 해 준다.
 * 4. (2, 3)은 (1, 3) (2, 3) (3, 3) (3, 1) (3, 2)까지 다 4가 들어간다. 행과 열 번호 중 큰값에 +1 하면 원하는 값이 나온다.
 *
 */

class Solution {
    public int[] solution(int n, long left, long right) {    
        List<Integer> list = new ArrayList<>();
    
        for (long i = left; i <= right; i++) {
            int col = (int) (i / n);
            int row = (int) (i % n);
            int max = Math.max(col, row) + 1;
            list.add(max);
        }
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}
