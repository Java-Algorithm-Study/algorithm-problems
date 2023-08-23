package yeonsup.java.leetcode;

import java.util.HashMap;

public class SingleRowKeyboard {

    public int calculateTime(String keyboard, String word) {
        int result = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        char[] charArray = keyboard.toCharArray();
        char c = charArray[0];

        for (int i = 0; i < charArray.length; i++) {
            map.put(charArray[i], i);
        }

        for (int i = 1; i < word.length(); i++) {
            result += Math.abs(map.get(c) - map.get(word.charAt(i)));
            c = word.charAt(i);
        }
        System.out.println(result);
        return result;
    }
    public static void main(String[] args) {
        new SingleRowKeyboard().calculateTime("abcdefghijklmnopqrstuvwxyz", "cba");
    }
}
