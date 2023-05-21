package language.java.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_15661 {
    static boolean[] visited;
    static int N;
    static int min = Integer.MAX_VALUE;
    static int[][] inputDataArr;

    static void backTracking(int numberOfTeamMembers, int start, int depth) {
        if(depth == numberOfTeamMembers) {
            twoTeamStatsRoof();
            return;
        }


        for(int i = start; i < N; i++) {
            if(!visited[i]) {
                visited[i]=true;
                backTracking(numberOfTeamMembers,i + 1,depth + 1);
                visited[i]=false;
            }
        }
    }

    static void twoTeamStatsRoof() {

        int startTeam = 0;
        int linkTeam = 0;

        for(int i = 0; i < N; i++) {
            for(int j = i + 1; j < N; j++) { // 다음 사람은 i와 중복되지 않게 다음 사람부터 탐색
                if(visited[i] && visited[j]) { 
                    startTeam += inputDataArr[i][j];
                    startTeam += inputDataArr[j][i];
                }
                else if(!visited[i] && !visited[j]){ 
                    linkTeam += inputDataArr[i][j];
                    linkTeam += inputDataArr[j][i];
                }
            }
        }

        min = Math.min(min, Math.abs(startTeam-linkTeam));

        // 최소가 0이니, 0 일 경우 stop
        if(min == 0) {
            System.out.println(0);
            System.exit(0);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        inputDataArr = new int[N][N];
        visited = new boolean[N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N;j++) {
                inputDataArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 팀의 인원수는 최소 한명이기 때문에 1 ~ n-1이 팀일 경우를 모투 탐색
        for(int i = 1; i < N; i++) {
            backTracking(i,0,0);
        }

        System.out.println(min);
    }
}