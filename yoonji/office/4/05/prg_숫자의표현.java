public class prg_숫자의표현 {
    public int solution(int n) {
        int answer = 0;
        int sum = 0;
        for (int i=1; i<=n; i++) {
            sum = 0;
            for (int j=i; j<=n; j++) {
                sum += j;
                if (sum >= n) { // 합이 같거나 큰 경우
                    if (sum == n) answer++; // 같은 경우에만 count한다.
                    break;  // 반복문 종료
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        prg_숫자의표현 t = new prg_숫자의표현();
        System.out.println(t.solution(15));
    }
}
