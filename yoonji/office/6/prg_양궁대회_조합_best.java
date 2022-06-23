public class prg_양궁대회_조합_best {
    static int[] result;
    static int max = Integer.MIN_VALUE;
    static int[] ans = { -1 };

    public static int[] solution(int n, int[] info) {
        result = new int[n];
        findBestCase_combination(n,0, 0, info);
        return ans;
    }

    private static void findBestCase_combination(int n, int cnt, int idx, int[] apeach) {
        // 1. n발 모두 쏜 경우
        if (cnt == n) {
            int totalApeach = 0;
            int totalLion = 0;

            int[] lion = new int[11];
            // 1-1. result 이용해서 lion에 횟수 증가시키기
            for (int i = 0; i < n; i++) {
                lion[10 - result[i]]++;
            }
            // 1-2. 배열 돌면서 점수 계산하기
            for (int i = 0; i < 11; i++) {
                if (apeach[i] == 0 && lion[i] == 0) continue;

                if (apeach[i] >= lion[i]) totalApeach += 10 - i;
                else totalLion += 10 - i;
            }
            // 1-3. 총점높으면 조건 처리.
            if (totalLion > totalApeach) {
                if (max < totalLion - totalApeach) {
                    ans = lion;
                    max = totalLion - totalApeach;
                }
                else if (max == totalLion - totalApeach) {
                    // 더 낮은 점수를 많이 맞춘 경우가 answer.
                    for (int i = 10; i >= 0; i--) {
                        if (lion[i] < ans[i]) {
                            break;
                        }
                        if (lion[i] > ans[i]) {
                            ans = lion;
                            break;
                        }
                    }
                }
            }
            return;
        }
        // 2. n발 덜 쏜 경우: result[n] 배열에 0~10점수 맞추는 경우의 수 완탐.
        for (int i = idx; i < 11; i++) {
            result[cnt] = i;
            findBestCase_combination(n,cnt + 1, i, apeach);
        }
    }
}