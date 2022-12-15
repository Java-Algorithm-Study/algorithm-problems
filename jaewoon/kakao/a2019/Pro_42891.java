package kakao.a2019;
import java.util.*;


/**
 * [42891] 무지의 먹방 라이브
 * https://school.programmers.co.kr/learn/courses/30/lessons/42891
 *
 * -아이디어
 * 1. 음식 양으로 오름차순 우선순위 큐를 생성한다.
 * 2. [(맨 앞 큐의 음식 양 - 이전에 pop한 큐의 음식 양) * 전체 큐 사이즈]가 k보다 작다면 pop 하고 q도 줄인다.
 *  - k보다 작다는 의미는 시간 내 음식 양을 다 섭취한다는 것이므로 삭제해도 된다는 것이다.
 *  - k보다 크거나 같다는 의미는 시간이 종료되어도 섭취중인 음식이다.
 * 3. 남은 음식들을 index 오름차순으로 재정렬해서, 남은 시간 k 사용해 연산
 */

public class Pro_42891 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3,1,2}, 5));
    }

    public static int solution(int[] food_times, long k) {
        long sum = 0;
        PriorityQueue<Food> q = new PriorityQueue<>();
        for(int i=0; i<food_times.length; i++){
            q.offer(new Food(i+1, food_times[i]));
            sum += food_times[i];
        }
        if(sum <= k) return -1;

        long prev = 0;
        while(true){
            Food peek = q.peek();
            if((peek.remainder - prev) * q.size() <= k ){
                k -= (peek.remainder - prev) * q.size();
                prev = peek.remainder;
                q.poll();
            }
            else break;
        }

        ArrayList<Food> list = new ArrayList<>(q);
        Collections.sort(list, (a, b) -> a.index-b.index);
        return list.get((int)(k % list.size())).index;
    }

    static class Food implements Comparable<Food>{
        int index, remainder;
        public Food(int a, int b){
            index=a; remainder=b;
        }

        @Override
        public int compareTo(Food o){
            if(remainder==o.remainder) return index-o.index;
            return remainder - o.remainder;
        }
    }
}

/*
정확성  테스트
테스트 1 〉	통과 (1.04ms, 74.1MB)
테스트 2 〉	통과 (0.99ms, 75.8MB)
테스트 3 〉	통과 (1.00ms, 72.9MB)
테스트 4 〉	통과 (1.30ms, 77.2MB)
테스트 5 〉	통과 (1.00ms, 71.8MB)
테스트 6 〉	통과 (3.16ms, 76.6MB)
테스트 7 〉	통과 (1.03ms, 71.2MB)
테스트 8 〉	통과 (1.24ms, 78.7MB)
테스트 9 〉	통과 (1.51ms, 77.3MB)
테스트 10 〉	통과 (1.10ms, 77.2MB)
테스트 11 〉	통과 (1.01ms, 76.5MB)
테스트 12 〉	통과 (1.51ms, 77MB)
테스트 13 〉	통과 (1.11ms, 78MB)
테스트 14 〉	통과 (1.18ms, 78.6MB)
테스트 15 〉	통과 (1.07ms, 75.8MB)
테스트 16 〉	통과 (0.66ms, 71.1MB)
테스트 17 〉	통과 (1.16ms, 77MB)
테스트 18 〉	통과 (1.09ms, 77.9MB)
테스트 19 〉	통과 (0.77ms, 76.4MB)
테스트 20 〉	통과 (0.48ms, 72.8MB)
테스트 21 〉	통과 (1.34ms, 74MB)
테스트 22 〉	통과 (1.53ms, 71.9MB)
테스트 23 〉	통과 (0.72ms, 74.7MB)
테스트 24 〉	통과 (2.91ms, 76.7MB)
테스트 25 〉	통과 (3.00ms, 84MB)
테스트 26 〉	통과 (4.55ms, 78.9MB)
테스트 27 〉	통과 (5.34ms, 79.7MB)
테스트 28 〉	통과 (1.29ms, 72.5MB)
테스트 29 〉	통과 (1.37ms, 66.7MB)
테스트 30 〉	통과 (1.12ms, 75.5MB)
테스트 31 〉	통과 (1.00ms, 72MB)
테스트 32 〉	통과 (1.20ms, 77.5MB)
효율성  테스트
테스트 1 〉	통과 (165.99ms, 72.4MB)
테스트 2 〉	통과 (36.46ms, 70.8MB)
테스트 3 〉	통과 (140.53ms, 71.4MB)
테스트 4 〉	통과 (185.85ms, 71.7MB)
테스트 5 〉	통과 (158.74ms, 73.5MB)
테스트 6 〉	통과 (176.82ms, 73.7MB)
테스트 7 〉	통과 (157.67ms, 72.2MB)
테스트 8 〉	통과 (151.70ms, 73.4MB)
 */