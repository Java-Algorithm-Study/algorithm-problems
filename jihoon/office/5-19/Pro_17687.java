import java.util.ArrayList;

public class Pro_17687 {
    private static ArrayList<Integer> arrayList = new ArrayList<>();
    
    public static void main(String[] args) {
        System.out.println(solution(16, 16, 2, 1));
    }
    
    public static String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        int cnt = t * m;
        
        convert(n, cnt);
        
        for (int i = p - 1; i < arrayList.size(); i += m) {
            int num = arrayList.get(i);
            
            if (num >= 10) {
                char ch = (char) (arrayList.get(i) + 55);
                sb.append(ch);
            } else {
                sb.append(arrayList.get(i));
            }
            
        }
        
        return sb.substring(0, t);
    }
    
    private static void convert(int n, int cnt) {
        arrayList.add(0);
        int start = 0;
        
        while (arrayList.size() < cnt) {
            int s = start;
            ArrayList<Integer> temp = new ArrayList<>();
            
            while (s != 0) {
                temp.add(s % n);
                s = s / n;
            }
            
            for (int i = temp.size() - 1; i >= 0; i--) {
                arrayList.add(temp.get(i));
            }
            start++;
        }
    }
}
