import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * [10815] 숫자 카드
 * https://www.acmicpc.net/problem/10815
 *
 * -아이디어
 * 1. cards 원소들이 nums에 있는지를 파악하고자 하니까 이분 탐색을 위해 nums를 오름차순으로 정렬한다.
 * 2. cards의 각 원소들을 for문으로 돌면서 lt, rt, mid를 정한다.
 * 3. cards[i]가 nums의 중간값보다 크다면 lt = mid + 1로 해서 왼쪽에 있는 작은 값들은 다 날려 버린다.
 * 4. cards[i]가 nums의 중간값보다 작다면 rt = mid - 1로 해서 오른쪽에 있는 큰 값들을 날려서 탐색을 안 하도록 한다.
 * 5. 찾으면 cards[i] = 1로 하고, while문이 다 끝날 때까지도 못 찾는다면 0으로 한다.
 *
 * -시간 복잡도
 * 1. O(logN * M)
 *
 */

public class Boj10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int nums[] = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int cards[] = new int[m];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        for (int i = 0; i < cards.length; i++) {
            int lt = 0;
            int rt = nums.length - 1;
            int target = cards[i];
            boolean flag = false;

            while (lt <= rt) {
                int mid = (lt + rt) / 2;
                if (nums[mid] == target) {
                    cards[i] = 1;
                    flag = true;
                    break;
                }
                if (nums[mid] > target) {
                    rt = mid - 1;
                }
                else {
                    lt = mid + 1;
                }
            }

            if (!flag) {
                cards[i] = 0;
            }
        }

        for (int x : cards) {
            System.out.print(x + " ");
        }

    }
}
