// 프로그래머스 모음사전
// https://programmers.co.kr/learn/courses/30/lessons/84512

public class Pro_84512 {
    private static char[] vowels = {'A', 'E', 'I', 'O', 'U'};
    private static StringBuilder sb = new StringBuilder();
    private static int count;
    private static String target;
    private static boolean flag;
    
    
    public static void dfs(int depth) {
        
        if (target.equals(sb.toString())) {
            flag = true;
            return;
        }
        
        if (depth == 5) return;


        for (int i = 0; i < vowels.length; i++) {
            if (flag) break;
            count++;
            sb.append(vowels[i]);
            dfs(depth + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    
    public static void main(String[] args) {
        target = "AAAAE";
        dfs(0);
        System.out.println(count);
    }
}
