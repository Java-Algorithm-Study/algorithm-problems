public class Pro_다음큰숫자 {
    // 2진수 변환
    public String transferRadix (int n, int radix) {
        return Integer.toString(n, radix);
    }

    // 원하는 숫자 갯수 count
    public int countNumberInString (String s, int targetNumber) {
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            int word = s.charAt(i) - '0';

            if (word == targetNumber) result++;
        }

        return result;
    }


    public int solution(int n) {
        int answer = n;
        int target = countNumberInString(transferRadix(answer++, 2), 1);

        while(true) {
            int countNumber =  countNumberInString(transferRadix(answer, 2), 1);
            if (target == countNumber) break;

            answer++;
        }
        return answer;
    }
}