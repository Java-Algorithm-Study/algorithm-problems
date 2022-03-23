public class Pro_77484 {
    public int getNumber(int n) {
        int cnt = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                cnt++;
                if (i * i != n)
                    cnt++;
            }
        }
        return cnt;
    }

    public int solution(int left, int right) {
        int answer = 0;

        for (int i = left; i <= right; i++) {
            if(getNumber(i) % 2 == 0) answer += i;
            else answer -= i;
        }
        return answer;
    }
}