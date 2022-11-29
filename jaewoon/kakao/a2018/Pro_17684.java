import java.util.*;

/**
 * [17684] 압축
 * https://school.programmers.co.kr/learn/courses/30/lessons/17684
 *
 * -아이디어
 * 1. 출력 가능한 인덱스 찾는다.
 * 2. 0~인덱스+1 의 문자열은 list 에 없으므로 추가해준다.
 * 3. 출력한 문자열 고려해 msg 재갱신 한다.  이후 1번으로 다시 반복
 */

public class Pro_17684 {

    public static void main(String[] args) {

        String msg = "KAKAO";

        ArrayList<String> list = new ArrayList<>();
        list.add("");
        for(char i='A'; i<='Z'; i++){
            list.add(String.valueOf(i));
        }

        ArrayList<Integer> answer = new ArrayList<>();
        while(true){
            int index = 1;
            while(index<=msg.length()){ //자리수 확인 필요
                String s = msg.substring(0, index);
                if(!list.contains(s)) break;
                index++;
            }

            index--;
            String add_str = msg.substring(0, index);
            answer.add(list.indexOf(add_str));

            if(index==msg.length()) break;

            list.add(msg.substring(0, index+1));
            msg=msg.substring(index);
        }


//        return answer.stream().mapToInt(i->i).toArray();
    }
}