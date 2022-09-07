/**
 * [12952] N-Queen
 * https://programmers.co.kr/learn/courses/30/lessons/12952
 *
 * -아이디어
 * 1. col[i] = n : i열 n행에 퀸이 존재한다는 뜻
 * 2. depth++을 하면서 해당 열에 i를 놓는다
 * 3. 놓고 나서 check로 대각선과 행에 퀸이 있는지 판단한다
 * 4. 안 되면 i++로 col[depth]를 i로 갱신한다
 * 5. 퀸을 n개 다 놓으면 count++
 *
 */

class Solution {
    private static int[] col;
    private static int count;
    
    public int solution(int n) {
        int answer = 0;
        col = new int[n];
        
        
        permutation(n, 0);
        
        return count;
    }
    
    private void permutation(int n, int depth) {
        if (n == depth) {
            count++;
            return;
        }
        
        for (int i = 0; i < n; i++) {
            col[depth] = i;
            
            if (check(depth)) {
                permutation(n, depth + 1);
            }
        }
    }
    
    private boolean check(int depth) {
        for (int i = 0; i < depth; i++) {
            if (depth - i == Math.abs(col[depth] - col[i])) {
                return false;
            }
            if (col[i] == col[depth]) {
                return false;
            }
        }
        return true;
    }
}
