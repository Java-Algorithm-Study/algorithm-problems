package language.java.Programmers;

import java.util.*;
/*
* 소요 시간 20분.
* */
public class Pro_짝지어제거하기 {
    public int solution(String s) {
        String words = s;
        while(true) {
            Stack<Character> stk = new Stack<>();
            boolean flag = false;
            for(int i = 0; i < words.length(); i++) {
                char letter = words.charAt(i);
                if(!stk.isEmpty()) {
                    if(stk.peek() == letter) {
                        stk.pop();
                        flag = true;
                        continue;
                    }
                }
                stk.push(letter);
            }

            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < stk.size(); i++) {
                sb.append(stk.pop());
            }

            words = sb.reverse().toString();
            System.out.println(words);
            if(!flag) break;
        }


        if(words.length() > 0) return 0;
        else return 1;
    }
}