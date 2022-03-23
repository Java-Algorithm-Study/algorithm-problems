import java.util.Stack;

public class Pro_72410 {
    
    public static String removeRepetitive(String str) {
        String[] line = str.split("");
        var sb = new StringBuilder();
        
        for (char ch : str.toCharArray()) {
            if (sb.length() == 0) sb.append(line[0]);
            else {
                if (sb.charAt(sb.length() - 1) != ch) {
                    sb.append(ch);
                }
            }
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        String str = "...bat..y.abcdefghijklm";
        System.out.println(removeRepetitive(str));
    }
}
