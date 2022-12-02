package kakao.a2018;

import java.util.*;

/**
 * [17680] 캐시
 * https://school.programmers.co.kr/learn/courses/30/lessons/17680
 *
 * -아이디어
 * 1. LRU 캐시 교체 알고리즘을 ArrayList(Queue) 로 구현한다.
 *
 * -시간복잡도
 * O(n^2) -> ArrayList 의 contains 는 n이다.
 */

public class Pro_17680 {
    public static void main(String[] args) {
        int cacheSize = 2;
        String[] cities = {"Jeju", "Pangyo", "NewYork", "newyork"};

        int answer = 0;
        if(cacheSize == 0) {
//            return cities.length * 5;
            System.out.println(cities.length * 5);
        }

        Queue<String> q = new LinkedList<>();
        for(String s : cities){
            s = s.toUpperCase();

            if(q.contains(s)) {
                answer+=1;
                q.remove(s);
                q.offer(s);
            }
            else{
                answer+=5;
                if(q.size()==cacheSize){
                    q.poll();
                    q.offer(s);
                }
                else q.offer(s);
            }
        }

//        return answer;
        System.out.println(answer);
    }
}


/*
테스트 1 〉	통과 (0.18ms, 73.2MB)
테스트 2 〉	통과 (0.14ms, 79.1MB)
테스트 3 〉	통과 (0.19ms, 77.6MB)
테스트 4 〉	통과 (0.21ms, 70MB)
테스트 5 〉	통과 (0.14ms, 67MB)
테스트 6 〉	통과 (0.01ms, 73.3MB)
테스트 7 〉	통과 (0.02ms, 77.5MB)
테스트 8 〉	통과 (0.24ms, 80.8MB)
테스트 9 〉	통과 (0.22ms, 72.6MB)
테스트 10 〉	통과 (0.56ms, 79.6MB)
테스트 11 〉	통과 (35.76ms, 121MB)
테스트 12 〉	통과 (0.48ms, 81.2MB)
테스트 13 〉	통과 (0.68ms, 77.7MB)
테스트 14 〉	통과 (1.20ms, 74.9MB)
테스트 15 〉	통과 (1.66ms, 76.6MB)
테스트 16 〉	통과 (1.51ms, 78MB)
테스트 17 〉	통과 (0.02ms, 77.4MB)
테스트 18 〉	통과 (1.76ms, 79.8MB)
테스트 19 〉	통과 (2.06ms, 78.5MB)
테스트 20 〉	통과 (2.34ms, 77.4MB)
 */