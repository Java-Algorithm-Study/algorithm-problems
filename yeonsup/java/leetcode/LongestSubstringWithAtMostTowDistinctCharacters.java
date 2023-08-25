package leetcode.premiumalgo100.slidingwindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostTowDistinctCharacters {

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int max = 0;
//        int[] visited = new int[s.length()];
        Map<Character, Integer> visited = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int cnt = 1;
            visited.put(c, 1);
            for (int k = i + 1; k < s.length(); k++) {
                visited.put(s.charAt(k), 1);
                if(visited.values().stream().filter(v -> v == 1).count() <= 2) {
                    cnt++;
                } else {
                    break;
                }
            }

            max = Math.max(max, cnt);
            visited = new HashMap<>();

        }
        System.out.println(max);
        return max;
    }

    public static void main(String[] args) {
        new LongestSubstringWithAtMostTowDistinctCharacters().lengthOfLongestSubstringTwoDistinct("eceba");
        new LongestSubstringWithAtMostTowDistinctCharacters().lengthOfLongestSubstringTwoDistinct("ccaabbb");
        new LongestSubstringWithAtMostTowDistinctCharacters().lengthOfLongestSubstringTwoDistinct("abcabcabc");
        new LongestSubstringWithAtMostTowDistinctCharacters().lengthOfLongestSubstringTwoDistinct("abcccabc");
        new LongestSubstringWithAtMostTowDistinctCharacters().lengthOfLongestSubstringTwoDistinct("abccbbcccaaacaca");
    }
}
