package kakao.a2018;

import java.util.*;

/**
 * [17678] 셔틀버스
 * https://school.programmers.co.kr/learn/courses/30/lessons/17678
 *
 * -아이디어
 * 1. 먼저 9시 버스에 타는 경우, 남은 버스에 타는경우로 분리한다.
 * 2. 9시에 타는 경우에 발생할 수 있는 여러 경우들을 구한다.
 *    - 총 버스가 한대뿐인데, 대기자들로만 만석되는 경우 return
 * 3. 남은 버스에 타는 경우 발생할 수 있는 여러 경우들을 구한다.
 *    - 마지막 대기자보다 마지막 버스가 늦게오는 경우 return
 *    - 현재 버스가 마지막 버스인데, 대기자들로만 만석되는 경우 return
 *    - 더 이상 대기자가 없는 경우, 마지막 버스에 타는걸로 return
 */


public class Pro_17678 {
    public static void main(String[] args) {
        System.out.println(solution(1,1,5, new String[]{"08:00", "08:01", "08:02", "08:03"}));
    }

    public static String solution(int n, int t, int m, String[] timetable) {

        Arrays.sort(timetable); //정렬 후 큐 변환
        Queue<String> q = new LinkedList<>();
        for(int i=0; i<timetable.length; i++){
            q.offer(timetable[i]);
        }

        int limit = m; //9시 정각에 태울 수 있는 한계
        while(!q.isEmpty() && limit>0){
            if(q.peek().compareTo("09:00") <=0){
                String poll = q.poll();
                limit--;
                if(q.isEmpty() && n==1 && limit==0) return minusOneMin(poll); //9시 전에 타야하는 경우
            }
            else break;
        }

        //대기자 없는 경우
        if(q.isEmpty()) return end_time((n-1)*t);

        //대기자가 남은경우 새로운 로직이 필요하다.
        int origin_n = n;
        n--; //이미 한번 셔틀을 출발했다.
        int cur = m;
        String bus_time = nTos(9*60 + t);
        while(!q.isEmpty() && n >=1){          //cur 초기화는 도착마다해야한다.

            if(q.peek().compareTo(bus_time) > 0 ){ //맨 앞 대기자가 다음 버스 타야하는 경우
                int min = Integer.parseInt(bus_time.substring(0,2))*60 + Integer.parseInt(bus_time.substring(3));
                bus_time = nTos(min + t);
                n--; cur = m;
                continue;
            }
            String poll = q.poll();
            cur--;
            if( n==1 && (cur==0 ||  (!q.isEmpty() && q.peek().compareTo(bus_time) > 0))) {
                //마지막 버스인데 마지막 자리이거나 다음 대기자가 늦게와 못타는 경우.
                return minusOneMin(poll);
            }
            if(cur==0){ //만석이면 다음 버스 타야한다.
                int min = Integer.parseInt(bus_time.substring(0,2))*60 + Integer.parseInt(bus_time.substring(3));
                bus_time = nTos(min + t);
                n--; cur=m;
            }
        }

        return end_time((origin_n-1)*t); //대기자 모두 셔틀을 탔는데, 자리가 남은 경우
    }


    static String minusOneMin(String s){
        int min = Integer.parseInt(s.substring(0,2))*60 + Integer.parseInt(s.substring(3));
        min--;
        return nTos(min);
    }

    static String end_time(int plus){
        int n = 9*60 + plus;
        return nTos(n);
    }

    static String nTos(int n){
        int hour = n/60;
        n = n - hour*60;
        String str_hour = String.valueOf(hour);
        String str_min = String.valueOf(n);
        if(str_hour.length() == 1){
            str_hour = "0"+str_hour;
        }
        if(str_min.length() == 1){
            str_min = "0"+str_min;
        }
        return str_hour+":"+str_min;
    }
}

/*
테스트 1 〉	통과 (10.20ms, 87.5MB)
테스트 2 〉	통과 (16.25ms, 82.2MB)
테스트 3 〉	통과 (17.83ms, 71.6MB)
테스트 4 〉	통과 (14.38ms, 78.9MB)
테스트 5 〉	통과 (11.21ms, 78.9MB)
테스트 6 〉	통과 (12.01ms, 81.2MB)
테스트 7 〉	통과 (11.14ms, 73.2MB)
테스트 8 〉	통과 (9.49ms, 79MB)
테스트 9 〉	통과 (11.19ms, 77.5MB)
테스트 10 〉	통과 (8.97ms, 77.3MB)
테스트 11 〉	통과 (10.50ms, 79.4MB)
테스트 12 〉	통과 (12.11ms, 80.6MB)
테스트 13 〉	통과 (12.70ms, 67.4MB)
테스트 14 〉	통과 (14.99ms, 85MB)
테스트 15 〉	통과 (8.68ms, 78.1MB)
테스트 16 〉	통과 (13.63ms, 75.3MB)
테스트 17 〉	통과 (9.69ms, 78MB)
테스트 18 〉	통과 (9.49ms, 80.2MB)
테스트 19 〉	통과 (11.83ms, 77.1MB)
테스트 20 〉	통과 (11.15ms, 77MB)
테스트 21 〉	통과 (12.73ms, 86.5MB)
테스트 22 〉	통과 (13.95ms, 78.2MB)
테스트 23 〉	통과 (12.00ms, 84.3MB)
테스트 24 〉	통과 (10.95ms, 80.4MB)
 */