/**
 * [92342] 양궁대회
 * https://programmers.co.kr/learn/courses/30/lessons/92342
 *
 * -아이디어
 * 1. 11 C r (여기에서는 n) 11개 점수에서 n개 만큼의 중복 포함해서 선택하는 조합을 만든다.
 * 2. 조합을 만들고 그 조합대로 점수를 계산해 본다.
 * 3. 나온 점수가 어피치보다 크다면
 * 4. 점수를 max로 갱신하고, 갱신된 max값의 조합을 배열에 담는다.
 * 5. max가 동일한 값이 나오면 조합을 비교해서 max값 나온 배열을 업데이트한다.
 * 6. max값이 어피치보다 작거나 같다면 -1을 리턴한다.
 *
 * -시간 복잡도
 * 1. O(n^r) 보다 작음
 * 2. 정확도 시간 : 10초 이내
 *
 */

public class Pro92342 {
    private static int[] result;
    private static int max = Integer.MIN_VALUE;
    private static int[] ans;

    public static void main(String[] args) {
        int n = 10;
        int[] input = {0,0,1,2,0,1,1,1,1,1,1};
        System.out.println(solution(n, input));
    }

    public static int[] solution(int n, int[] info) {
        result = new int[n];
        ans = new int[] {-1};
        combination(n,0, 0, info);
        return ans;
    }

    private static void combination(int n, int cnt, int idx, int[] apeach) {
        if (cnt == n) {
            int totalApeach = 0;
            int totalLion = 0;

            int[] lion = new int[11];

            for (int i = 0; i < n; i++) {
                lion[10 - result[i]]++;
            }

            for (int i = 0; i < 11; i++) {
                if (apeach[i] == 0 && apeach[i] == lion[i]) {
                    continue;
                }
                if (apeach[i] >= lion[i]) {
                    totalApeach += 10 - i;
                }
                else {
                    totalLion += 10 - i;
                }
            }

            if (totalLion > totalApeach) {
                if (max < totalLion - totalApeach) {
                    ans = lion;
                    max = totalLion - totalApeach;
                }

                else if (max == totalLion - totalApeach) {
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

        for (int i = idx; i < 11; i++) {
            result[cnt] = i;
            combination(n,cnt + 1, i, apeach);
        }
    }
}
