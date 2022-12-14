package kakao.a2019;

import java.util.*;

/**
 * [43889] 실패율
 * https://school.programmers.co.kr/learn/courses/30/lessons/42889
 *
 */


public class Pro_42889 {
    public static void main(String[] args) {
        System.out.println(solution(5, 	new int[]{2, 1, 2, 6, 2, 4, 3, 3}));
    }

    public static int[] solution(int N, int[] stages) {
        int[] arr = new int[N+2]; //도달한 플레이어수
        int[] brr = new int[N+2]; //클리어 못한 플레이어 수
        for(int i=0; i<stages.length; i++){
            int num = stages[i];
            for(int j=1; j<=num; j++){
                arr[j]++;
            }
            brr[num]++;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int i=1; i<=N; i++){
            if(arr[i] == 0 ) pq.offer(new Node(i, 0.0));
            else pq.offer(new Node(i, (double)brr[i]/arr[i]));
        }

        int[] answer = new int[N];
        for(int i=1; i<=N;i++){
            answer[i-1] = pq.poll().index;
        }
        return answer;
    }

    static class Node implements Comparable<Node>{
        int index;
        double fail;
        public Node(int a, double b){
            index=a; fail=b;
        }

        @Override
        public int compareTo(Node o){
            if(o.fail == fail) return index-o.index;
            if(o.fail>fail) return 1;
            return -1;
        }
    }
}

/*
테스트 1 〉	통과 (0.56ms, 74.1MB)
테스트 2 〉	통과 (0.64ms, 67.1MB)
테스트 3 〉	통과 (9.24ms, 85.9MB)
테스트 4 〉	통과 (17.75ms, 81.3MB)
테스트 5 〉	통과 (64.06ms, 84.3MB)
테스트 6 〉	통과 (1.27ms, 67.5MB)
테스트 7 〉	통과 (6.28ms, 71.9MB)
테스트 8 〉	통과 (17.56ms, 89.6MB)
테스트 9 〉	통과 (46.61ms, 101MB)
테스트 10 〉	통과 (16.13ms, 82.6MB)
테스트 11 〉	통과 (13.54ms, 94.3MB)
테스트 12 〉	통과 (10.13ms, 87.4MB)
테스트 13 〉	통과 (27.94ms, 97.2MB)
테스트 14 〉	통과 (1.05ms, 67.6MB)
테스트 15 〉	통과 (9.59ms, 76.7MB)
테스트 16 〉	통과 (3.46ms, 78MB)
테스트 17 〉	통과 (6.61ms, 78.8MB)
테스트 18 〉	통과 (3.70ms, 84.4MB)
테스트 19 〉	통과 (1.05ms, 74.2MB)
테스트 20 〉	통과 (3.10ms, 79.7MB)
테스트 21 〉	통과 (4.03ms, 86.3MB)
테스트 22 〉	통과 (67.41ms, 89.1MB)
테스트 23 〉	통과 (6.70ms, 98.5MB)
테스트 24 〉	통과 (7.83ms, 83.7MB)
테스트 25 〉	통과 (0.67ms, 77.3MB)
테스트 26 〉	통과 (0.71ms, 74.4MB)
테스트 27 〉	통과 (0.51ms, 70MB)
 */