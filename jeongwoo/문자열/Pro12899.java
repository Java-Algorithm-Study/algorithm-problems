import java.util.*;

class Pro12899 {
    public String solution(int n) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int[] arr = {1, 2, 4};
        List<Integer> list = new ArrayList<>();
        
        while (n > 0) {
            n-=1;
            int x = n % 3;
            list.add(arr[x]);
            n /= 3;
        }
        
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i));
        }
        
        return sb.toString();
    }
}
