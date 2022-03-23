public class prg_약수개수와덧셈 {
    public static void main(String[] args) {
        prg_약수개수와덧셈 t = new prg_약수개수와덧셈();
        System.out.println(t.solution(13, 17));
    }
    public int solution(int left, int right) {
        int answer = 0;

        for (int i = left; i <= right; i++) {
            int cnt = 0;
            // ★ 제곱근만큼만 돈다!!
            for (int j = 1; j * j <= i; j++) {
                if (j * j == i) cnt++;  // 동일 수 ex) 6*6
                else if (i % j == 0) cnt+=2;  // 그외의 수 ex) 3*12 (12까지 가지 않고 +=2로 해결!)
            }
            // 약수가 짝수면 +, 홀수면 -
            if (cnt % 2 == 0) answer += i;
            else answer -= i;
        }
        return answer;
    }
}
