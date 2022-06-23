import java.util.*;

// 어피치보다 커야 라이언이 점수를 획득한다.
// 몇발을 쏴도 1발에 대한 점수만 인정된다.
// 둘다 쏘지못한 (0점) 점수는 아무도 가져가지 않는다.
// n발을 모두 쏴야한다.
// 어피치와 라이언의 점수차가 가장 큰 경우를 정답으로 여긴다.
// 라이언이 우승할 수 없는 경우는 [-1]을 리턴한다.
public class prg_양궁대회_dfs {
    public static void main(String[] args) {
        prg_양궁대회_dfs t = new prg_양궁대회_dfs();
        int[] solution = t.solution(10, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3});
        System.out.println(Arrays.toString(solution));
    }
    static int[] lion = new int[11];   // 전역으로 두어도 되는구나
    static int maxDiffScore = -1;
    static List<int[]> maxCases = new ArrayList<>();
    public int[] solution(int n, int[] info) {
// 1. 경우의 수를 dfs로 탐색- n발을 모두 쐈을 때 조건에 맞는 지 체크.
        findBestCase_dfs(info, n);
        if (maxDiffScore == -1) return new int[]{-1};
        maxCases.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                for (int i = 10; i >= 0; i--) {
                    if (o1[i] != o2[i]) return o2[i] - o1[i];    // 내림차순
                }
                return 0;
            }
        });
        return maxCases.get(0);
    }
    private void findBestCase_dfs(int[] info, int possibleCnt) {
        // 2. 가지치기 -> 조건에 부합하는지 체크
        if (possibleCnt <= 0) {
            // 2-1. lion, apeach 점수 체크
            int lionScore = 0;
            int apeachScore = 0;
            for (int i=0; i<11; i++) {
                if (lion[i] == 0 && info[i] == 0) continue;
                if (lion[i] > info[i]) lionScore+= 10-i;
                else apeachScore+= 10-i;
            }
            if (lionScore > apeachScore) {
                int diffScore = lionScore - apeachScore;
                if (maxDiffScore < diffScore) {
                    maxDiffScore = diffScore;
                    maxCases.clear();
                    maxCases.add(lion.clone());
                }
                if (maxDiffScore == diffScore) {
                    maxCases.add(lion.clone());
                }
            }
            return;
        }
        // n발을 아직 다 안쏜 경우
        for (int i=0; i<11 && lion[i] <= info[i]; i++) {
            // if (lion[i] > info[i]+1) break;
            lion[i]++;
            findBestCase_dfs(info, possibleCnt-1);
            lion[i]--;
        }
    }
/* my Try
    static List<ScoreInfo> scores = new ArrayList<>();
    public int[] solution(int n, int[] info) {
        int[] ans;
        int[] lion = new int[11];
        ans = lion;
        // dfs
        getLionsScore_dfs(n, info, 0, new int[11]);
        // 정답 반환
        for (ScoreInfo score: scores)
            System.out.println(Arrays.toString(score.scores));
        if (scores.isEmpty()) return new int[]{-1};
        else {
            Collections.sort(scores);
            return scores.get(0).scores;
        }
    }
    private void getLionsScore_dfs(int n, int[] info, int idx, int[] lionsScore) {        // n을 초과하지 않으면서 골고루 뿌리면서 info[i]+1이어야함
        if (n<=0) {
            int lionsTotalScore = 0;
            int apeachTotalScore = 0;
            for (int i=0; i<11; i++) {
                if (info[i] < lionsScore[i]) lionsTotalScore++;
                else apeachTotalScore++;
            }
            if (lionsTotalScore > apeachTotalScore)
                scores.add(new ScoreInfo(lionsTotalScore - apeachTotalScore, lionsScore));
            return;
        }
        for (int i=idx; i<11; i++) {
            if (n<=info[i]) continue;
            if (i==10) lionsScore[i] = n;
            else lionsScore[i] = info[i]+1;
            int tmp = info[i];
            info[i] = 0;
            getLionsScore_dfs(n-lionsScore[i], info, i+1, lionsScore);
            lionsScore[i] = 0;
            info[i] = tmp;
        }
    }
    private static class ScoreInfo implements Comparable<ScoreInfo> {
        int totalScoreDiff;
        int[] scores;

        ScoreInfo (int totalScoreDiff, int[] scores) {
            this.totalScoreDiff = totalScoreDiff;
            this.scores = scores;
        }
        @Override
        public int compareTo (ScoreInfo s) {
            if (this.totalScoreDiff > s.totalScoreDiff) return 1;
            else {
                for (int i=10; i>=0; i--) {
                    if (this.scores[i] > s.scores[i]) return 1;
                    return 0;
                }
            }
            return 0;
        }
    }
*/
}
