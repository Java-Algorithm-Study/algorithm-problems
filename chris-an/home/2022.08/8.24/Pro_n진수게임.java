public class Pro_n진수게임 {
    static public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();

        int len = m * t;
        int num = 0;
        while (sb.length() < len) {
            sb.append(Integer.toString(num, n).toUpperCase());
            num++;
        }
        String s = sb.toString();
        sb.setLength(0);
        for (int i = 0; i < t; i++) {
            sb.append(s.charAt(m * i + p - 1));
        }

        return sb.toString();
    }
}