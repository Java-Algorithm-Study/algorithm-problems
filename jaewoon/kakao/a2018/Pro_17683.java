import java.util.*;

/**
 * [17683] 방금그곡
 * https://school.programmers.co.kr/learn/courses/30/lessons/17683
 *
 * -아이디어
 * 1. 총 재생 시간을 분 단위로 계산해 준다.
 * 2. 가사 길이를 총 재생 시간만큼 재갱신 해준다. #이 있기 때문에 [재갱신된 가사 길이 != 재생 시간] 임을 주의
 * 3. indexOf를 통해 m이 포함되는 인덱스를 찾는다. 찾은 문자열 다음 인덱스 문자가 #이라면 일치하지 않음을 주의
 * 4. 문제 조건에 따라 라디오에서 재생된 시간이 제일 긴것을 변수로 둔다.
 *
 *
 * -예외
 * 1. 끝난 시각이 00:00인 경우는 시작 시간이 00:00일 경우 뿐이다.
 *    즉, 끝난 시각이 24:00라면 00:00이라 유추하면 안된다.
 */

public class Pro_17683 {


    public static void main(String[] args) {

        String m = "ABCDEFG";
        String[] musicinfos = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};


        String answer = "";
        int cur_time = 0;
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<musicinfos.length; i++){
            String info[] = musicinfos[i].split(",");
            String start = info[0];
            String end = info[1];
            // if(end.equals("00:00")) end = "24:00";
            if(end.equals("00:00")) continue;
            int start_hour = Integer.parseInt(start.substring(0,2));
            int end_hour = Integer.parseInt(end.substring(0,2));
            int start_minute = Integer.parseInt(start.substring(3));
            int end_minute = Integer.parseInt(end.substring(3));
            if(start_minute > end_minute){
                end_minute+=60;
                end_hour-=1;
            }
            int time = (end_hour-start_hour)*60 + (end_minute-start_minute);

            //가사(sb)를 재생시간에 맞춰 재갱신 해준다.
            int sharp_cnt=0;
            for(int j=0; j<info[3].length(); j++){
                if(info[3].charAt(j) == '#') sharp_cnt++;
            }
            sb.setLength(0);
            int init_len = info[3].length()-sharp_cnt; //실제 음 개수

            if(time >= init_len){ // 반복재생 하는 경우
                int q = time/init_len;
                while(q>=1){
                    sb.append(info[3]);
                    q--;
                }
                int r = time%init_len;
                int index = 0;
                while(r>=1 && index<info[3].length() ){
                    sb.append(info[3].charAt(index));
                    index++;
                    if(index<info[3].length() && info[3].charAt(index) == '#'){
                        sb.append('#');
                        index++;
                    }
                    r--;
                }
            }
            else { //가사보다 재생시간이 작은 경우
                int index = 0;
                for(int j=0; j<time; j++){
                    sb.append(info[3].charAt(index));
                    index++;
                    if( info[3].charAt(index) == '#'){
                        sb.append('#');
                        index++;
                    }
                }
            }

            //sb => 재생시간에 맞춰 설정되어있는 상태다.
            //이제 일치하는지 찾아야 한다.
            int sb_len = sb.length();
            if(cur_time < time){ //정답이 여러개인 경우, 재생시간 긴 것으로 결정
                int tmp = 0;
                while(tmp<sb_len){
                    tmp = sb.indexOf(m, tmp);
                    if(tmp>=0){
                        if(tmp+m.length() < sb_len && sb.charAt(tmp+m.length()) =='#'){ // 확인 필요
                            tmp = tmp + m.length()+1;
                        }
                        else{ //정답
                            answer = info[2];
                            cur_time=time;
                            break;
                        }
                    }
                    else break;
                }
            }
        }

//
//        if(answer.equals("")){
//            return "(None)";
//        }
//        return answer;
    }
}
