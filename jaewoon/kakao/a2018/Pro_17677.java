package kakao.a2018;


import java.util.*;

/**
 * [17677] 뉴스 클러스터링
 * https://school.programmers.co.kr/learn/courses/30/lessons/17677
 *
 * -아이디어
 * 1. HashMap 으로 중복 문자열을 계산한다.
 *
 * -시간복잡도
 * O(n)
 */

public class Pro_17677 {
    public static void main(String[] args) {
        System.out.println(solution("FRANCE", "french"));
    }

    public static int solution(String str1, String str2) {
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

        HashMap<String, Integer> hm1= new HashMap<>();
        HashMap<String, Integer> hm2= new HashMap<>();

        for(int i=0; i<str1.length()-1; i++){
            if(Character.isAlphabetic(str1.charAt(i))&& Character.isAlphabetic(str1.charAt(i+1))){
                hm1.put(str1.substring(i, i+2), hm1.getOrDefault(str1.substring(i, i+2),0)+1);
            }
        }
        for(int i=0; i<str2.length()-1; i++){
            if(Character.isAlphabetic(str2.charAt(i))&& Character.isAlphabetic(str2.charAt(i+1))){
                hm2.put(str2.substring(i, i+2), hm2.getOrDefault(str2.substring(i, i+2),0)+1);
            }
        }


        //hm1, hm2 정렬
        int res1 = 0; //교집합
        int res2 = 0; //합집합
        for(String s : hm1.keySet()){
            int a = hm1.get(s);
            int b = hm2.getOrDefault(s, 0);
            res1+= Math.min(a, b);
            res2+= Math.max(a, b);
            hm1.put(s, 0);
            hm2.put(s, 0);
        }
        for(String s : hm2.keySet()){
            int a = hm2.get(s);
            int b = hm1.getOrDefault(s, 0);
            res1+= Math.min(a, b);
            res2+= Math.max(a, b);
            hm1.put(s, 0);
            hm2.put(s, 0);
        }


        if(res1 == 0 && res2 == 0) return 65536;
        else return (int)((double)res1/res2*65536);
    }
}
