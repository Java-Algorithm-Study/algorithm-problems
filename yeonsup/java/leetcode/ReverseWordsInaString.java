package leetcode;

import java.util.Arrays;

public class ReverseWordsInaString {
    public void reverseWords(char[] s) {
        StringBuffer sb = new StringBuffer();
        String[] split = String.valueOf(s).split(" ");
        for (int i = split.length - 1; i >= 0; i--) {
            sb.append(split[i] + " ");
        }

        char[] charArray = sb.toString().substring(0, sb.length() - 1).toCharArray();
        for (int i = 0; i < s.length; i++) {
            s[i] = charArray[i];
        }
    }

    public static void main(String[] args) {
        new ReverseWordsInaString().reverseWords(new char[]{'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'});
        new ReverseWordsInaString().reverseWords(new char[]{'a'});
    }
}
