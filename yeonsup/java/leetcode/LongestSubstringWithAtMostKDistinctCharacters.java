package yeonsup.java.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostKDistinctCharacters {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int max = 0;
        int value = 0;
//        int[] visited = new int[s.length()];
        Map<Character, Integer> visited = new HashMap<>();
        int i = 0;
        int j = 0;

        while (i < s.length()) {
            if (visited.size() <= k) {
                char c = s.charAt(i);
                if(visited.containsKey(c)) {
                    visited.put(c, visited.get(c) + 1);
                } else {
                    visited.put(c, 1);
                }
                i++;
                value++;
            }
            if (visited.size() > k){
                char c = s.charAt(j);
                if(visited.get(c) - 1 <= 0) {
                    visited.remove(c);
                } else {
                    visited.put(c, visited.get(c) - 1);
                }
                j++;
                value--;
            }
            max = Math.max(max, value);
        }
        System.out.println(max);
        return max;
    }

    public static void main(String[] args) {
        new LongestSubstringWithAtMostKDistinctCharacters().lengthOfLongestSubstringKDistinct("eceba", 2);
        new LongestSubstringWithAtMostKDistinctCharacters().lengthOfLongestSubstringKDistinct("aa", 1);
        new LongestSubstringWithAtMostKDistinctCharacters().lengthOfLongestSubstringKDistinct("a", 0);
        new LongestSubstringWithAtMostKDistinctCharacters().lengthOfLongestSubstringKDistinct("abcccabc", 2);
        new LongestSubstringWithAtMostKDistinctCharacters().lengthOfLongestSubstringKDistinct("abccbbcccaaacaca", 2);
    }
}
