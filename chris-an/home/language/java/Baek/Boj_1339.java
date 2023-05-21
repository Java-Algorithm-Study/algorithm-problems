package language.java.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
    브루트포스 10팩토리얼 3628800
 */

public class Boj_1339 {
    static int N;
    static int max = Integer.MIN_VALUE;
    static List<String> inputDataArr = new ArrayList<>();
    static HashSet<Character> alphabet = new HashSet<>();
    static List alphaList;
    static int[] arr;
    static boolean[] visited = new boolean[10];

    private static void dfs(int depth) {
        if (depth == alphaList.size()) {
            int sum = 0;
            for (int i = 0; i < N; i++) {
                int num = 0;
                for (int j = 0; j < inputDataArr.get(i).length(); j++) {
                    num *= 10;
                    num += arr[alphaList.indexOf(inputDataArr.get(i).charAt(j))];
                }
                sum += num;
            }
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            arr[depth] = i;
            dfs(depth + 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 단어의 개수

        // 단어를 리스트에 담아 놓습니다.
        for (int i = 0; i < N; i++) inputDataArr.add(br.readLine());

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < inputDataArr.get(i).length(); j++) {
                alphabet.add(inputDataArr.get(i).charAt(j));
            }
        }

        alphaList = new ArrayList(alphabet);
        arr = new int[alphaList.size()];
        dfs(0);
        System.out.println(max);
    }
}
