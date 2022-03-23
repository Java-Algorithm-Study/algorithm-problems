public class Pro_12899 {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        while(n != 0) {
            int remain = n % 3;
            if (remain == 0) {
                remain = 4;
                sb.append(remain);
                n = (n / 3) - 1;
            }else {
                sb.append(remain);
                n = (n / 3);
            }
        }
        return sb.reverse().toString();
    }
}
