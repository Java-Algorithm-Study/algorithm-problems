
/**
 * [43162] 네트워크 
 * https://programmers.co.kr/learn/courses/30/lessons/43162
 *
 * -아이디어
 * 1. checked 배열을 만들어서 한 행씩 체크한다.
 * 2. (i, j)에 1이 있다면 checked[i] = true로 하고 (j, x)를 본다.
 * 3. j행과 또 연결된 게 있으면 타고 들어간다.
 *
 */
 
public class Pro43162 {
    public static void main(String[] args) {
        int n = 5;
        int[][] input = {{1, 0, 1, 1, 1},{0, 1, 0, 0, 0}, {1, 0, 1, 0, 0}, {1, 0, 0, 1, 1}, {1,0,0,1,1}};
        System.out.println(solution(n, input));
    }
    
    public static int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] checked = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!checked[i]) {
                answer++;
                dfs(i, checked, computers);
            }
        }

        return answer;
    }

    private static void dfs(int x, boolean[] checked, int[][] computers) {
        checked[x] = true;

        for (int i = 0; i < computers.length; i++) {
            if (i != x && !checked[i] && computers[x][i] == 1) {
                dfs(i, checked, computers);
            }
        }
    }
}
