// 이진변환 반복하기

public class Pro_70129 {
    
    public static int[] solution(String s) {
        int[] answer = new int[2];
        int countExecution = 0;
        int countZero = 0;
        
        while (!s.equals("1")) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0')
                    countZero++;
            }
            s = toBinary(s);
            countExecution++;
        }
        answer[0] = countExecution;
        answer[1] = countZero;
        return answer;
    }
    
    public static String toBinary(String s) {
        int numberOf1 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1')
                numberOf1++;
        }
        return Integer.toBinaryString(numberOf1);
    }
    
    public static void main(String[] args) {
        System.out.println(solution("110010101001"));
    }
}
