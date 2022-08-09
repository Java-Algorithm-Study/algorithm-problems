package DataStructure;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class prg_전화번호목록_hash {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);    // edge case
        // System.out.println(Arrays.toString(phone_book));

        Set<String> set = new HashSet<>();
        for (String phone : phone_book) {
            for (int i=0; i<phone.length(); i++) {
                // System.out.println(phone.substring(0,i+1));
                if (set.contains(phone.substring(0,i+1))) {
                    return false;
                }
            }
            set.add(phone);
        }
        return true;
    }
}
