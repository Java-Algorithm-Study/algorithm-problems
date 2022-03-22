import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        Integer[] array = new Integer[numbers.length];

        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.valueOf(numbers[i]);
        }
        
        Arrays.sort(array, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return Integer.parseInt(String.valueOf(b) + String.valueOf(a)) - Integer.parseInt(String.valueOf(a) + String.valueOf(b));
            }
        });
        
        String answer = "";
        
        for (int i = 0; i < array.length; i++) {
            answer += array[i];
        }

        if (answer.startsWith("0")) {
            answer = "0";
        }
    
        return answer;
    }
}
