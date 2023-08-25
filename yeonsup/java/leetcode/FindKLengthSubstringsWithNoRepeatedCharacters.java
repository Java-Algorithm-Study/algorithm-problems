package yeonsup.java.leetcode;

import java.util.ArrayList;

public class FindKLengthSubstringsWithNoRepeatedCharacters {


    public int numKLenSubstrNoRepeats(String s, int k) {
        StringBuffer sb = new StringBuffer();
        ArrayList<String> substrings = new ArrayList<>();
        String[] sArr = s.split("");

        for (int i = 0; i <= s.length() - k; i++) {
            for (int j = 0; j < k; j++) {
                if(sb.indexOf(sArr[j + i]) >= 0) break;
                sb.append(sArr[j + i]);

                if(j == k - 1) substrings.add(sb.toString());
            }

            sb.setLength(0);
        }

        return substrings.size();
    }

    public static void main(String[] args) {
        System.out.println(new FindKLengthSubstringsWithNoRepeatedCharacters().numKLenSubstrNoRepeats("havefunonleetcode", 5));
        System.out.println(new FindKLengthSubstringsWithNoRepeatedCharacters().numKLenSubstrNoRepeats("home", 5));

    }
}
