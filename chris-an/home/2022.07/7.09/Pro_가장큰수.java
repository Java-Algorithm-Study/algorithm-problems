import java.util.*;

public class Pro_가장큰수 {
    public String solution(int[] numbers) {
        String[] num = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            num[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(num, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                System.out.println(Arrays.toString(num));
                return (o2 + o1).compareTo(o1 + o2);

            }
        });

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < num.length; i++) {
            sb.append(num[i]);
        }
        String answer = sb.toString();
        if(answer.charAt(0) == '0') {
            return "0";
        }

        return answer;
    }
}
