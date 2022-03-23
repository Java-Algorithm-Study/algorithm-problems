public class prg_124나라의숫자 {
    public static void main(String[] args) {
        prg_124나라의숫자 k = new prg_124나라의숫자();
        System.out.println(k.solution(6));  // 14
    }
    public String solution(int n) {
        StringBuilder answer = new StringBuilder();
        // 0이 되는 경우는 다 3의 배수이니 배열로 선언하지 않아도 될듯함.
         int[] mod = {4,1,2};    // 0, 1, 2

        // 3의 배수일 때
        while (n != 0) {
            int r = n % 3;
            n = n / 3;
            // 3의 배수일 때는 -1을 하고 계산 진행해야함
            if (r == 0) n -= 1;  // 189/3= 63-1
            answer.append(mod[r]);
        }
        return answer.reverse().toString();
    }
}
