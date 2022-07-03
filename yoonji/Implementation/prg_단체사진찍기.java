package Implementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// dfs 돌면서 경우의 수를 채워나가는데
// 만약 조건에 해당하는 프렌즈들이 true체크되어있으면 조건을 매번 체크해준다.
// data를 돌면서 조건에 대해 처리해준다.  <data의 0번째(key), 클래스 -> 상대방(2번째), 거리(4번쨰), 초과|미만|같음(3번쨰)>
// 만약 예제2처럼 A가 B에 대한 거리와 B가 A에 대한 거리가 다르면 0을 리턴한다.
// - 기존 방식
// 1. HashMap을 통해 프렌즈들 간의 거리 정보를 넣는다.
// 2. dfs를 돌면서 조건에 맞는지 체크한다.
// - 새 방식
// 일단 dfs를 돌면서 8칸을 다 채우면,
// 그렇게 만들어진 case가 조건에 일치하는지 체크한다.
public class prg_단체사진찍기 {
    int answer = 0;
    // String[] FRIENDS = {"A", "C", "F", "J", "M", "N", "R", "T"};

    char[] FRIENDS = new char[]{'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    public int solution(int n, String[] data) {
        String[] copiedData = data.clone();
        boolean[] visited = new boolean[8];
        makeCase_dfs(copiedData, "", visited);
        return answer;
    }

    private void makeCase_dfs(String[] data, String names, boolean[] visited) {
        if (names.length()==8) {
            if (checkCondition(data, names))
                answer++;
            return;
        }
        for (int i=0; i<8; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            makeCase_dfs(data, names+FRIENDS[i], visited);
            visited[i] = false;
        }
    }
    // ACFJMNRT
    // N~F=0, R~T>2
    private boolean checkCondition(String[] conditions, String names) {
        // 조건에 맞는지 체크
        for (String condition : conditions) {
            int diffOfCondition = condition.charAt(4) - '0';
            int posOfFriend1 = names.indexOf(condition.charAt(0));   //N
            int posOfFriend2 = names.indexOf(condition.charAt(2));   //F
            int realPosDiff = Math.abs(posOfFriend1 - posOfFriend2)-1;    // index 간의 차 -1 == 실제 프렌즈 간 거리
//            System.out.println("현재 위치: "+ line +"\n 두 프렌즈 인덱스: "+ posOfFriend1 + ", "+ posOfFriend2 + "두 프렌즈 간 거리"+ realPosDiff+ "지켜야하는 거리"+ condition.charAt(3)+ diffOfCondition);
            char sign = condition.charAt(3);
            if (sign == '=' && !(realPosDiff == diffOfCondition)) return false;
            if (sign == '>' && !(realPosDiff > diffOfCondition)) return false;    // 초과: 현재 거리가 조건 거리보다 크지 않으면 false
            if (sign == '<' && !(realPosDiff < diffOfCondition)) return false;    // 미만: 현재 거리가 조건 거리보다 작지 않으면

            /* switch case는 return해도 break를 붙여야한다.
            switch(sign) {
                case '=':
                    if (!(realPosDiff == diffOfCondition)) return false;
                    break;
                case '>':   //초과
                    if (!(realPosDiff > diffOfCondition)) return false;
                    break;
                case '<':   //미만
                    if (!(realPosDiff < diffOfCondition)) return false;
            }
             */
        }
        return true;
    }

    public static void main(String[] args) {
        prg_단체사진찍기 t = new prg_단체사진찍기();
        System.out.println(t.solution(2, new String[]{"N~F=0", "R~T>2"}));
        System.out.println(t.solution(2, new String[]{"M~C<2", "C~M>1"}));
    }
}
