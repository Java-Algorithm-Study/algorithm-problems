import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        StringBuilder sb = new StringBuilder();
        
        String[] arr = s.split(" ");

        for (String x : arr) {
            int target = Integer.parseInt(x);

            max = Math.max(target, max);
            min = Math.min(target, min);
        }
        
        sb.append(min).append(' ').append(max);
        return sb.toString();
    }
}
