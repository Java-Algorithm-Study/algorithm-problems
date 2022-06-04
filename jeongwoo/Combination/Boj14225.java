import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * [14225] 부분수열의 합
 * https://www.acmicpc.net/problem/14225
 *
 * -아이디어
 * 1. nums 배열에서 2 ~ nums.length 개의 조합을 만든다.
 * 2. 조합을 HashSet에 담는다.
 * 3. 나온 조합들을 ArrayList 넣는다.
 * 4. ArrayList를 오름차순으로 정렬한다.
 * 5. ArrayList를 돌면서 get(i+1) - get(i) >= 2라면 ans = get(i) + 1을 출력한다.
 * 6. 1이 포함되어 있지 않으면 ans = 1
 * 7. ans == 0이면 ArrayList 마지막 숫자에 +1을 하고 출력한다.
 *
 * -시간 복잡도
 * 1.
 *
 * -자료 구조
 * 1.
 */

public class Boj14225 {
    private static int[] nums;
    private static HashSet<Integer> hashSet = new HashSet<>();
    private static ArrayList<Integer> arrayList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        nums = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            hashSet.add(nums[i]);
        }

        for (int i = 2; i <= nums.length; i++) {
            combination(0, 0, i, 0);
        }

        Iterator iter = hashSet.iterator();
        while(iter.hasNext()) {
            for (int i = 0; i < hashSet.size(); i++) {
                arrayList.add((Integer) iter.next());
            }
        }

        Collections.sort(arrayList);
        int ans = 0;
        for (int i = 0; i < arrayList.size() - 1; i++) {
            if (arrayList.get(i + 1) - arrayList.get(i) >= 2 ) {
                ans = arrayList.get(i) + 1;
                break;
            }
        }

        if (!arrayList.contains(1)) {
            ans = 1;
        }

        if (ans == 0) {
            ans = arrayList.get(arrayList.size() - 1) + 1;
        }
        System.out.println(ans);
    }

    private static void combination(int start, int level, int r, int sum) {
        if (level == r) {
            hashSet.add(sum);
        }

        for (int i = start; i < nums.length; i++) {
            combination(i + 1, level + 1, r, sum + nums[i]);
        }
    }
}
