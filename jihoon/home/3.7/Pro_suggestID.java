import java.util.Locale;
import java.util.Stack;

public class Pro_suggestID {
    public static void main(String[] args) {
        String str = "...!@BaT#*..y.abcdefghijklm";
        String toLowerCase = str.toLowerCase();
        String newStr = toLowerCase.replaceAll("\\.+", ".");
        System.out.println(newStr);

//        String line = "...!@BaT#*..y.abcdefghijklm";
//        StringBuffer ans = new StringBuffer();
//        ans.append(' ');
//
//        for (int i = 0; i < line.length(); i++) {
//            if (line.charAt(i) == '.') {
//                if (ans.charAt(ans.length() - 1) != '.') {
//                    ans.append('.');
//                }
//            }  else {
//                ans.append(line.charAt(i));
//            }
//        }
//        System.out.println(ans);
    }
}
