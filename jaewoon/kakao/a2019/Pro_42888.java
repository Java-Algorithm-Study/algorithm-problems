package kakao.a2019;

import java.util.*;

/**
 * [42888] 오픈채팅방
 * https://school.programmers.co.kr/learn/courses/30/lessons/42888
 *
 * -아이디어
 * 1. <고정아이디, 최종닉네임>의 k-v맵을 계속 갱신한다.
 */

public class Pro_42888 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"}));
    }

    public static String[] solution(String[] record) {
        HashMap<String, String> id_name_mapping = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
        ArrayList<Boolean> bool = new ArrayList<>();

        for(int i=0; i<record.length; i++){
            String[] tmp = record[i].split(" ");
            if(tmp.length>=3) {
                id_name_mapping.put(tmp[1], tmp[2]);
            }
            if(tmp[0].equals("Enter")){
                list.add(tmp[1]);
                bool.add(true);
            }
            if(tmp[0].equals("Leave")){
                list.add(tmp[1]);
                bool.add(false);
            }
        }


        String[] result = new String[list.size()];
        for(int i=0; i< list.size(); i++){
            if(bool.get(i)) result[i] = id_name_mapping.get(list.get(i)) + "님이 들어왔습니다.";
            else result[i] = id_name_mapping.get(list.get(i)) + "님이 나갔습니다.";
        }

        return result;
    }
}

/*
테스트 1 〉	통과 (2.70ms, 81.5MB)
테스트 2 〉	통과 (2.67ms, 80.5MB)
테스트 3 〉	통과 (2.79ms, 72.8MB)
테스트 4 〉	통과 (2.96ms, 83.8MB)
테스트 5 〉	통과 (7.04ms, 74.8MB)
테스트 6 〉	통과 (7.11ms, 82.3MB)
테스트 7 〉	통과 (6.94ms, 81.5MB)
테스트 8 〉	통과 (6.49ms, 85MB)
테스트 9 〉	통과 (6.13ms, 84.2MB)
테스트 10 〉	통과 (8.81ms, 71.2MB)
테스트 11 〉	통과 (6.31ms, 78.7MB)
테스트 12 〉	통과 (5.58ms, 83.8MB)
테스트 13 〉	통과 (6.86ms, 71.3MB)
테스트 14 〉	통과 (5.54ms, 85.4MB)
테스트 15 〉	통과 (3.03ms, 81.2MB)
테스트 16 〉	통과 (2.17ms, 74.8MB)
테스트 17 〉	통과 (3.65ms, 70.5MB)
테스트 18 〉	통과 (2.95ms, 78.1MB)
테스트 19 〉	통과 (8.27ms, 70.1MB)
테스트 20 〉	통과 (6.86ms, 82.7MB)
테스트 21 〉	통과 (5.99ms, 72.7MB)
테스트 22 〉	통과 (5.59ms, 80.5MB)
테스트 23 〉	통과 (5.98ms, 86.1MB)
테스트 24 〉	통과 (5.66ms, 78.4MB)
테스트 25 〉	통과 (129.18ms, 152MB)
테스트 26 〉	통과 (107.20ms, 150MB)
테스트 27 〉	통과 (111.58ms, 167MB)
테스트 28 〉	통과 (106.32ms, 150MB)
테스트 29 〉	통과 (153.44ms, 154MB)
테스트 30 〉	통과 (138.93ms, 149MB)
테스트 31 〉	통과 (124.27ms, 141MB)
테스트 32 〉	통과 (98.99ms, 153MB)
 */