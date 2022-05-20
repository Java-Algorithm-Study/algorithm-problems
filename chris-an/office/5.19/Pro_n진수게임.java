public class Pro_n진수게임 {
    static public String solution(int n, int t, int m, int p) {
        String answer = "";
        StringBuilder sb = new StringBuilder();

        int len = m * (t-1) + p; // 최대 설정
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
        answer = sb.toString();
        return answer;
    }

    public static void main(String[] args) {
        int[] nArr = {2, 16, 16};
        int[] tArr = {4, 16, 16};
        int[] mArr = {2, 2, 2};
        int[] pArr = {1, 1, 2};

        for (int i = 0; i < nArr.length; i++) {
            System.out.println(solution(nArr[i], tArr[i], mArr[i], pArr[i]));
        }
    }
}
