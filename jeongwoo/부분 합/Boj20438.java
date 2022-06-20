import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [20438] 출석 체크
 * https://www.acmicpc.net/problem/20438
 *
 *  ** 부분 합 **
 *
 * -아이디어
 * 1. 출석 체크 못 한 학생들의 총 합을 구해야 되니까 출석 못 한 학생은 1로 둔다. 일단 전체를 다 1로 초기화
 * 2. 자는 학생들은 따로 배열에 true로 저장
 * 3. 코드 받은 학생이 자는 학생이라면 그 배수들도 코드를 받지 못하니까 배수를 구하지 않고 넘긴다.
 * 4. 코드 받은 학생이 깨어 있는 학생이라면 그 배수들은 코드를 받을 수 있으니까 출석 체크 가능하므로 0으로 변경한다.
 * 5. 코드 받은 학생 중의 배수 코드인 학생 중 조는 학생이 있다면 그 학생은 1로 둔다.
 * 6. 그러나 5번에서 조는 학생의 뒷 번호들은 코드 받은 학생이 넘겨 주니까 출석 체크 가능하므로 0으로 변경한다.
 *
 * -자료 구조
 * 1. int[] totalStudent : 전체 학생 중 출석 체크 못 한 학생만 1 -> 마지막에는 부분 합에 사용
 * 2. boolean[] sleepingStudent : 자는 학생 true
 */

public class Boj20438 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());

        // 총 학생 수
        int n = Integer.parseInt(st.nextToken());
        // 조는 학생 수
        int k = Integer.parseInt(st.nextToken());
        // 출석 코드 보낼 학생 수
        int q = Integer.parseInt(st.nextToken());
        // 구간 개수
        int m = Integer.parseInt(st.nextToken());

        int[] totalStudent = new int[n + 3];

        // 모든 학생을 1로 초기화 후, 출석한 학생들만 0으로 변경 예정.
        for (int i = 3; i < n + 3; i++) {
            totalStudent[i] = 1;
        }

        // 자는 학생 입력 받기
        // 자는 학생은 sleepingStudent = true
        // 출석 못 한 학생 수(자는 학생 수)를 카운트해야 돼서 전체 학생에서 자는 학생은 1 처리
        boolean[] sleepingStudent = new boolean[n + 3];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int studentNumber = Integer.parseInt(st.nextToken());
            sleepingStudent[studentNumber] = true;
        }

        // 코드 받은 학생 입력 받기
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < q; i++) {
            int codeStudent = Integer.parseInt(st.nextToken());
            // 코드 받은 학생이 자는 학생인 경우, 그 배수 학생들은 받지 못하니까 다 1로 둬야 한다 -> 넘어감
            if (sleepingStudent[codeStudent]) {
                continue;
            }
            // 자는 학생이 아니면 배수 확인
            for (int j = codeStudent; j < n + 3; j += codeStudent) {
                // 코드 받은 학생이 자는 학생이 아닌 경우, 출석 체크 가능하니까 0으로 변경
                if (!sleepingStudent[j]) {
                    totalStudent[j] = 0;
                }
            }
        }

        // 부분 합
        for (int i = 4; i < n + 3; i++) {
            totalStudent[i] += totalStudent[i - 1];
        }

        // 구간 내에서 출석 못 한 학생 구하기
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(totalStudent[end] - totalStudent[start - 1]).append('\n');
        }

        System.out.println(sb);

    }
}
