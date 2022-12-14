package kakao.a2019;

import java.util.*;

/**
 * [42890] 후보키
 * https://school.programmers.co.kr/learn/courses/30/lessons/42890
 *
 * -아이디어
 * 1. 유일성은 조합으로 구한다.
 * 2. 최소성은 2차 반복문으로 구한다.
 */

public class Pro_42890 {
    public static void main(String[] args) {
        System.out.println(solution(new String[][] {{"100","ryan","music","2"},
                {"200","apeach","math","2"},{"300","tube","computer","3"},
                {"400","con","computer","4"},{"500","muzi","music","3"},
                {"600","apeach","music","2"}}));
    }

    public static int solution(String[][] relation) {
        cal = relation[0].length;
        row = relation.length;

        for(int i=1; i<=cal; i++){
            check = new int[i+1];
            DFS(0, i, 0, relation);
        }

        int answer = 1;
        for(int i=1; i<list.size(); i++){
            boolean flag = true;
            String origin = list.get(i);

            for(int j=0; j<i; j++){
                for(int k=0; k<origin.length(); k++){
                    String tmp = origin.substring(0,k) + origin.substring(k+1);
                    if(list.get(j).equals(tmp)){
                        System.out.println(origin +" "+tmp);
                        flag = false; break;
                    }
                }

                if(!flag) break;
                if(j==i-1) answer++;
            }
        }

        return answer;
    }

    static int cal = 0;
    static int row = 0;
    static int answer = 0;
    static int check[];
    static ArrayList<String> list = new ArrayList<>();

    static public void DFS(int level, int n, int s, String[][] relation){
        if(level == n){
            Set<String> set = new HashSet<>();
            for(int i=0; i<row ;i++){
                String str = "";
                for(int j=0; j<n; j++){
                    str+=relation[i][check[j]];
                }
                set.add(str);
            }

            if(set.size() == row){
                String n_str = "";
                for(int j=0; j<n; j++){
                    n_str += String.valueOf(check[j]);
                }
                list.add(n_str);
            }
        }
        else{
            for(int i=s; i<cal; i++){
                check[level] = i;
                DFS(level+1, n, i+1, relation);
            }
        }
    }
}

/*
테스트 1 〉	통과 (8.90ms, 78.9MB)
테스트 2 〉	통과 (8.58ms, 78.9MB)
테스트 3 〉	통과 (8.93ms, 74.1MB)
테스트 4 〉	통과 (8.55ms, 76.3MB)
테스트 5 〉	통과 (2.06ms, 85.3MB)
테스트 6 〉	통과 (1.33ms, 72.1MB)
테스트 7 〉	통과 (9.87ms, 80.2MB)
테스트 8 〉	통과 (1.85ms, 80.9MB)
테스트 9 〉	통과 (9.73ms, 78.8MB)
테스트 10 〉	통과 (12.17ms, 80.2MB)
테스트 11 〉	통과 (9.69ms, 81.2MB)
테스트 12 〉	통과 (21.11ms, 74.6MB)
테스트 13 〉	통과 (12.55ms, 74.2MB)
테스트 14 〉	통과 (8.80ms, 79.2MB)
테스트 15 〉	통과 (10.88ms, 78.3MB)
테스트 16 〉	통과 (10.44ms, 78.8MB)
테스트 17 〉	통과 (8.90ms, 79.9MB)
테스트 18 〉	통과 (57.49ms, 107MB)
테스트 19 〉	통과 (36.23ms, 93.6MB)
테스트 20 〉	통과 (31.66ms, 86.3MB)
테스트 21 〉	통과 (5.36ms, 81.2MB)
테스트 22 〉	통과 (14.33ms, 80.5MB)
테스트 23 〉	통과 (9.21ms, 80.2MB)
테스트 24 〉	통과 (38.91ms, 94.1MB)
테스트 25 〉	통과 (64.33ms, 89.5MB)
테스트 26 〉	통과 (33.97ms, 87.1MB)
테스트 27 〉	통과 (15.32ms, 78.2MB)
테스트 28 〉	통과 (10.84ms, 75.4MB)
 */