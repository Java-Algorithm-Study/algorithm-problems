import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Sw_숫자조작 {
    static int max, min;
    static int lineLen;
    static String line;
    static ArrayList<Character> temp;
    static boolean[] visited;

    static void swap(List<Integer> perm) {
        List<Character> copyData = new ArrayList<>();
        copyData.addAll(temp);
        char tt = copyData.get(perm.get(0));
        copyData.set(perm.get(0), copyData.get(perm.get(1)));
        copyData.set(perm.get(1), tt);

        maxCheck(copyData);
    }

    static void maxCheck(List<Character> perm) {
        String strResult = "";
        for (char c : perm) strResult += c;
        int chk = Integer.parseInt(strResult);

        if (String.valueOf(chk).length() == lineLen) {
            max = Math.max(Integer.parseInt(strResult), max);
            min = Math.min(Integer.parseInt(strResult), min);
        }
    }

    static List<Integer> checkPerm() {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < lineLen; i++)
            if (visited[i]) result.add(i);
        return result;
    }

    static void dfs(int start, int depth) {

        // 스왑해야할 인덱스 번호 추출
        if (depth == 2) {
            swap(checkPerm());
            return;
        }

        for (int i = start; i < lineLen; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i + 1,depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        // 테스트 케이스 회전 루프
        for (int tc = 1; tc <= T; tc++) {
            line = br.readLine();
            lineLen = line.length();
            min = max = Integer.parseInt(line);
            temp = new ArrayList<>();
            for (int i = 0; i < lineLen; i++) {
                temp.add(line.charAt(i));
            }
            visited = new boolean[lineLen];
            dfs(0, 0);

            System.out.println("#" + tc + " " + min + " " + max);
        }
    }
}
