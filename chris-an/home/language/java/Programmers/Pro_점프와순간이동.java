package language.java.Programmers;

public class Pro_점프와순간이동 {
    public int solution(int n) {
        int ans = 0;
        while(n != 0) { // 0이면 종료
            if(n % 2 == 1) {
                ans++;
                n--;
            }
            n/=2;
        }
        return ans;
    }
}