import java.util.*;

/**
 * [87946] 배열 합치기 - 투 포인터
 * https://school.programmers.co.kr/learn/courses/30/lessons/87946
 *
 * -아이디어
 * 1. 0 ~ 배열 길이까지 순열을 구한다.
 * 2. 순열이 정해지면 BASE CASE에서 피로도를 계산한다.
 * 3. 최소 피로도 조건에 만족한다면 전체 피로도에서 소모 피로도만큼 뺀다.
 * 4. 던전 개수를 max에 저장한다.
 *
 */

public class Pro87946Again {
    private static int max = 0;
    private static int[] permutations;
    private static boolean[] visited;
    
    public static int solution(int k, int[][] dungeons) {

        int length = dungeons.length;
        permutations = new int[length];
        visited = new boolean[length];
        
        permutation(0, k, dungeons);
        return max;
    }
    
    private static void permutation(int depth, int k, int[][] dungeons) {
        if (depth == permutations.length) {
            max = Math.max(max, calcualteDungeons(k, permutations, dungeons));
            return; 
        }
        
        for (int i = 0; i < permutations.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            permutations[depth] = i;
            
            permutation(depth + 1, k, dungeons);
            visited[i] = false;
        }
    }
    
    private static int calcualteDungeons(int k, int[] permutations, int[][] dungeons) {
        int total = k;
        int count = 0;
        
        for (int x : permutations) {
            // 최소 필요 피로도 조건 체크
            if (total < dungeons[x][0]) {
                return count;
            }
            // 최소 조건에 만족하면 소모 피로도만큼 빼기
            total -= dungeons[x][1];
            count++;
            
        }
        return count;
    }
}
