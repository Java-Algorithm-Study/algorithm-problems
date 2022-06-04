import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * [1339] 단어 수학
 * https://www.acmicpc.net/problem/1339
 *
 * -아이디어
 * 1. 입력 받은 알파벳을 ArrayList 저장한다.
 * 2. ArrayList 완탐으로 돌리면서 0부터 9까지 넣어 준다.
 * 3. 넣은 값들에 대해 각 자리수만큼 더하면서 MAX값을 찾는다.
 *
 * -시간 복잡도
 * 1.
 *
 * -자료 구조
 * 1.
 */

public class Boj1339 {
    private static String[] input;
    private static boolean[] visited;
    private static int[] value;
    private static int max = Integer.MIN_VALUE;
    private static ArrayList<Character> arrayList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        input = new String[n];

        for (int i = 0; i < n; i++) {
            input[i] = br.readLine();
            for (char ch : input[i].toCharArray()) {
                if (!arrayList.contains(ch)) {
                    arrayList.add(ch);
                }
            }
        }

        visited = new boolean[10];
        value = new int[arrayList.size()];

        dfs(0);
        System.out.println(max);
    }

    private static void dfs(int level) {
        if (level == arrayList.size()) {
            int sum = 0;
            for (int i = 0; i < input.length; i++) {
                int num = 0;
                for (int j = 0; j < input[i].length(); j++) {
                    num *= 10;
                    num += value[arrayList.indexOf(input[i].charAt(j))];
                }
                sum += num;
            }
            max = Math.max(sum, max);
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            value[level] = i;
            dfs(level + 1);
            visited[i] = false;
            value[level] = 0;
        }
    }
}
