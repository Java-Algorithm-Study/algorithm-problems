package language.java.Baek;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_14889 {

    static int N;
    static boolean[] visited;
    static int[] arrTemp;
    static int[][] inputDataArr;

    static List<ArrayList<Integer>> twoTeamStatsList = new ArrayList<>();
    static int composeTeam;

    static int min = Integer.MAX_VALUE;
    static int sum;

    static void backtracking(int start, int depth) {
        if (depth == N/2) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int i : arrTemp) {
                list.add(i);
            }
            twoTeamStatsList.add(list);
            return;
        }

        for (int i = start; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arrTemp[depth] = i + 1;
                backtracking(i + 1, depth+1);
                visited[i] = false;
            }
        }
    }

    static void teamStatsRoof(List<Integer> list, int idx, int depth) {
        if (depth == 2) {
            sum +=  inputDataArr[arrTemp[0]-1][arrTemp[1]-1];
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                arrTemp[depth] = twoTeamStatsList.get(idx).get(i);
                teamStatsRoof(list, idx,depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        inputDataArr = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                inputDataArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        arrTemp = new int[N/2];
        visited = new boolean[N];

        backtracking(0, 0);

        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < twoTeamStatsList.size(); i++) {
            sum = 0;
            visited = new boolean[twoTeamStatsList.get(0).size()];
            arrTemp = new int[2];
            teamStatsRoof(twoTeamStatsList.get(i), i, 0);
            temp.add(sum);
        }

        composeTeam = twoTeamStatsList.size() / 2; // 절반 루프
        for (int i =0; i < composeTeam; i++) {
            int startTeam = temp.get(i);
            int linkTeam = temp.get(twoTeamStatsList.size() - 1 - i);

            min = Math.min(min, Math.abs(startTeam - linkTeam));
        }

        System.out.println(min);
    }
}