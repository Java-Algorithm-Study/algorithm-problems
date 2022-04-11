import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
// 부등호
public class boj_2529 {
    static List<String> answers = new ArrayList<>();
    static char[] inputInequalitys;
    static boolean[] visited;
    static int k;
    public static void main(String[] args) throws IOException {
        // 1.초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        inputInequalitys = new char[k];
        for (int i=0; i<k; i++) inputInequalitys[i] = st.nextToken().charAt(0);
        visited = new boolean[10];  // 0~9까지의 정수 사용 여부 체크

        dfs(0, "");
        System.out.println(answers.get(answers.size()-1));  // 최댓값. 0~9까지 반복하기 때문에 자동으로 오름차순 정렬이 된다.
        System.out.println(answers.get(0)); // 최솟값
    }
    // 부등호에 일치하는 관계인지 확인한다.
    private static boolean checker(char inequality, char left, char now) {
        if (inequality == '>' && left > now) return true;
        if (inequality == '<' && left < now) return true;
        return false;
    }
    // 2. 0부터 9까지 반복문을 도는데, depth기준으로 방문하면서 부등호 관계에 알맞는 수를 추가해나간다.
    private static void dfs(int depth, String tmpNum) {
        if (depth == k+1) {
            answers.add(tmpNum.toString());
//            num.setLength(0);     // 초기화하지않아야, 돌아간 메서드 내 변수에서 String이 추가됨
            return; // 재귀끝내고 돌아갔을 떄 초기화된 상태에서 반복문이 마저 돌아감.
        }
        for (int i=0; i<=9; i++) {
            if (visited[i]) continue;
            // 수정. left, now, nowInequality로 미리 선언 -> 미리 선언하지 않는게 간결함.
            // 현재 depth가 0이면 바로 if문 실행, 0이 아니면 checker를 통해 비교.
            // 관계가 맞지 않으면 if문 실행 X
            if (depth == 0 || checker(inputInequalitys[depth-1], tmpNum.charAt(depth-1), (char)(i+'0'))) {  // ★ int를 char로 바꾸기 : (char)(int + '0')
                visited[i] = true;
                dfs(depth+1, tmpNum+i);    // 현재 값 추가
                visited[i] = false;
            }
        }
    }
}
