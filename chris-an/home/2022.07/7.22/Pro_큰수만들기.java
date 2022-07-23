public class Pro_큰수만들기 {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder("");
        int len = number.length() - k;
        int start = 0;

        while(start < number.length()) {
            if(answer.length() == len) break;

            int changingLastIdx = k + answer.length() + 1;
            int max = 0;
            for (int i = start; i < changingLastIdx; i++) {
                int currentNum = number.charAt(i) - '0';
                if (max < currentNum) {
                    max = currentNum;
                    start = i + 1;
                }
            }
            answer.append(max);
        }
        return answer.toString();
    }
}
