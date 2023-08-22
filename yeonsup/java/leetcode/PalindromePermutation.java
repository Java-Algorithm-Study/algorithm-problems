package yeonsup.java.leetcode;

import java.util.HashSet;

public class PalindromePermutation {
    public boolean canPermutePalindrome(String s) {
        HashSet<Character> set = new HashSet<>();

        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                set.remove(c);
            } else {
                set.add(c);
            }
        }

        return set.size() <= 1;
    }

    public static void main(String[] args) {
        boolean b = new PalindromePermutation().canPermutePalindrome("aab");
        System.out.println(b);
    }
}
