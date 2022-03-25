public class Pro_12930 {
    public static String solution(String s) {
        var sb = new StringBuilder();
        int count = 0;
        String[] str = s.split("");
        for (String st : str) {
            if (!st.equals(" ")) {
                if (count % 2 == 0) sb.append(st.toUpperCase());
                else sb.append(st.toLowerCase());
                count++;
            }
            else {
                sb.append(' ');
                count = 0;
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(solution("try hello world"));
    }
}
