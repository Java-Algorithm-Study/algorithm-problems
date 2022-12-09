package kakao.a2018;

import java.time.*;
import java.time.format.DateTimeFormatter;


/**
 * [17676] 추석 트래픽
 * https://school.programmers.co.kr/learn/courses/30/lessons/17676
 *
 * -아이디어 수정
 * Date -> LocalDateTime 변경
 */

public class Pro_17676_2 {

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"2016-09-15 01:00:04.001 2.0s",
                "2016-09-15 01:00:07.000 2s"}));
    }

    public static int solution(String[] lines){

        LocalDateTime[] start_date = new LocalDateTime[lines.length];
        LocalDateTime[] end_date = new LocalDateTime[lines.length];


        for(int i=0; i<lines.length; i++){
            String[] str = lines[i].split(" ");

            end_date[i] = LocalDateTime.parse(str[0]+" "+str[1], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));

            Double tmp1 = Double.parseDouble(str[2].replace("s", ""));
            String tmp2 = String.format("%05.3f", tmp1); //3.222
            long tmp3 = Long.parseLong(tmp2.replace(".", "")); //밀리초

            start_date[i] = end_date[i].minusNanos((tmp3-1)*1000000);
        }

        int max = 1; //마지막 응답을 고려해서 미리 1
        for(int i=0; i<lines.length-1; i++){
            int cnt = 1;

            for(int j=i+1; j<lines.length; j++){
                if(end_date[i].plusNanos(1000*1000000).isAfter(start_date[j])){
                    cnt++;
                }
            }
            max = Math.max(max, cnt);
        }

        return max;
    }
}
