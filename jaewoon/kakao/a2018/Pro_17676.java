package kakao.a2018;

import java.util.*;
import java.text.*;

/**
 * [17676] 추석 트래픽
 * https://school.programmers.co.kr/learn/courses/30/lessons/17676?language=java
 *
 * -아이디어
 * 1. 날짜 및 시간계산 Date 활용
 * 2. 응답순으로 정렬돼있다면, 각 응답 끝지점부터 1초간의 기간만 고려해도 최대값과 동일
 *
 * - 시간복잡도
 * O(n^2)이하
 */

public class Pro_17676 {

    public static void main(String[] args) throws ParseException {
        System.out.println(solution(new String[]{"2016-09-15 01:00:04.001 2.0s",
                "2016-09-15 01:00:07.000 2s"}));
    }

    public static int solution(String[] lines) throws ParseException{

        Date[] start_date = new Date[lines.length];
        Date[] end_date = new Date[lines.length];

        for(int i=0; i<lines.length; i++){
            String[] str = lines[i].split(" ");

            end_date[i] = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(str[0]+" "+str[1]);

            //문자열  2.0s -> ms로 변환
            Double tmp1 = Double.parseDouble(str[2].replace("s", ""));
            String tmp2 = String.format("%05.3f", tmp1); //3.222
            long tmp3 = Long.parseLong(tmp2.replace(".", ""));

            start_date[i] = new Date(end_date[i].getTime() - tmp3 + 1);
        }

        int max = 1; //마지막 응답을 고려해서 미리 1
        for(int i=0; i<lines.length-1; i++){
            int cnt = 1;

            for(int j=i+1; j<lines.length; j++){

                if(end_date[i].getTime() + 999 >= start_date[j].getTime() ){
                    cnt++;
                }
            }
            max = Math.max(max, cnt);
        }

        return max;
    }
}
