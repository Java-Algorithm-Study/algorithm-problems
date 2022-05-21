import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Pro_72411 {
    private static Map<String, Integer>[] menu;
    public static void dfs(int start, int depth, String target, int course, StringBuilder sb) {
        if (depth == course) {
            System.out.println(sb);
            return;
        }
    
        for (int i = start; i < target.length(); i++) {
            sb.append(target.charAt(i));
            dfs(i + 1, depth + 1, target, course, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    
    public static String[] solution(String[] orders, int[] course) {
        String[] answer = {};
    
        menu = new Map[course.length];
        for (int i = 0; i < course.length; i++) {
            menu[i] = new HashMap<>();
        }
        
        menu[1].put("A", 1);
        
//        for (int i = 0; i < course.length; i++) {
//            for (int j = 0; j < orders.length; j++) {
//                StringBuilder sb = new StringBuilder();
//                dfs(0, 0, orders[j], course[i], sb);
//            }
//        }
        System.out.println(Arrays.toString(menu));
        return answer;
    }
    
    public static void main(String[] args) {
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2,3,4};
        System.out.println(solution(orders, course));
    }
}
