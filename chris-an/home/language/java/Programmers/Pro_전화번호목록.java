package language.java.Programmers;

import java.util.*;
public class Pro_전화번호목록 {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for (int i = 1; i < phone_book.length; i++) {
            if(phone_book[i].startsWith(phone_book[i-1])) {
                return false;
            }
        }
        return true;
    }
}