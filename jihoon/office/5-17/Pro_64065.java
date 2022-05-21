import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Pro_64065 {
    
    public static int[] solution(String s) {
        int[] answer = {};
        int count = 0;
        for (int i = 1; i < s.length() - 1; i++) {
            if (s.charAt(i) == '{') count++;
        }
        ArrayList<String> numbers = new ArrayList<>();
        int preIdx = 2;
        for (int i = 2; i < s.length() - 1; i++) {
            if (s.charAt(i) == '}') {
                numbers.add(s.substring(preIdx, i));
                System.out.println(i);
                preIdx = i;
            }
        }
        System.out.println(numbers);
        return answer;
    }
    
    public static void main(String[] args) {
        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        System.out.println(solution(s));
    }
}
