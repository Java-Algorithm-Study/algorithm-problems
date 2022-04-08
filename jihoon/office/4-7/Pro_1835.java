public class Pro_1835 {
    public static String[] data = {"N~F=0", "R~T>2"};
    public static String[] s = {"A", "C", "F", "J", "M", "N", "R", "T"};
    public static String[] permutations = new String[40320];
    public static String[] arr = new String[8];
    public static boolean[] visit = new boolean[8];
    public static int index = 0;
    
    public static void dfs(int depth) {
        if (depth == 8) {
            StringBuilder sb = new StringBuilder();
            for (String str : arr)
                sb.append(str);
            permutations[index++] = sb.toString();
            return;
        }
        
        for (int i = 0; i < s.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = s[i];
                dfs(depth + 1);
                visit[i] = false;
            }
        }
    }
    
    public static void main(String[] args) {
        dfs(0);
    
        for (int i = 0; i < permutations.length; i++) {
            for (String str : data) {
                char start = str.charAt(0);
                char finish = str.charAt(2);
                char sign = str.charAt(3);
                int num = Integer.parseInt(String.valueOf(str.charAt(4)));
        
                int startIdx = permutations[i].indexOf(start);
                int finishIdx = permutations[i].indexOf(finish);
                int diff = Math.abs(startIdx - finishIdx);
    
                switch (sign) {
                    case '=':
                        if (diff != num + 1) permutations[i] = "";
                        break;
                    case '>':
                        if (diff <= num + 1) permutations[i] = "";
                        break;
                    case '<':
                        if (diff >= num + 1) permutations[i] = "";
                        break;
                }
            }
        }
        int count = 0;
        for (String permutation : permutations) {
            if (!permutation.equals(""))
                count++;
        }
        System.out.println(count);
    }
}
