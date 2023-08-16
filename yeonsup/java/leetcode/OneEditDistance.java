package leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;

public class OneEditDistance {

    int diffST(String s, String t) {
        int cnt = 0;
        if(s.length() == t.length()) {
            for (int i = 0; i < s.length(); i++) {
                if(s.charAt(i) != t.charAt(i)) {
                   cnt++;
                }
            }
        } else if(s.length() < t.length()) {
            for (int i = 0; i < s.length(); i++) {
                if(s.charAt(i) != t.charAt(i)) {
                    String postS1 = s.substring(i);
                    String postS2 = t.substring(i + 1);
                    if(postS1.equals(postS2)) {
                        cnt = 1;
                    } else {
                        cnt = 2;
                    }
                    break;
                }
            }
        } else {
            for (int i = 0; i < t.length(); i++) {
                if(s.charAt(i) != t.charAt(i)) {
                    String postS1 = t.substring(i);
                    String postS2 = s.substring(i + 1);
                    if(postS1.equals(postS2)) {
                        cnt = 1;
                    } else {
                        cnt = 2;
                    }
                    break;
                }
            }
        }
        return cnt == 0 ? Math.abs(s.length() - t.length()) : cnt;
    }
    public boolean isOneEditDistance(String s, String t) {
        if (diffST(s, t) == 1) return true;

        return false;
    }

    public static void main(String[] args) {
//        System.out.println(new OneEditDistance().isOneEditDistance("ab", "acb"));
//        System.out.println(new OneEditDistance().isOneEditDistance("", ""));
//        System.out.println(new OneEditDistance().isOneEditDistance("aaaabb", "aaabb"));
//        System.out.println(new OneEditDistance().isOneEditDistance("aaaabcbc", "aaaabbc"));
//        System.out.println(new OneEditDistance().isOneEditDistance("aaaa", "aaaa"));
        System.out.println(new OneEditDistance().isOneEditDistance("a", ""));
        System.out.println(new OneEditDistance().isOneEditDistance("teacher", "teach"));
    }
}
