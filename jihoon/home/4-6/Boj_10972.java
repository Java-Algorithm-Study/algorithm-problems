import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_10972 {
    public static int N;
    public static int[] nums;
    public static int[] ans;
    public static StringBuilder sb = new StringBuilder();
    
    public static int findFirstDescending() {
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) return i - 1;
        }
        return -1;
    }
    
    public static void swap(int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public static void main(String[] args) throws IOException {
        var bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        var st = new StringTokenizer(bf.readLine(), " ");
        nums = new int[N];
        ans = new int[N];
        
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
    
        // 오른쪽에서 왼쪽으로 이동하면서 처음으로 내림차순이 되는 인덱스 번호를 찾고 없으면 -1
        int firstDescending = findFirstDescending();
        
        if (firstDescending >= 0 ) {
            // 오른쪽에서 왼쪽으로 이동하면서 아까 찾은 수보다 클 때 swap한다
            for (int i = nums.length - 1; i >= firstDescending; i--) {
                if (nums[firstDescending] < nums[i]) {
                    swap(firstDescending, i);
                    break;
                }
            }
        
            for (int i = 0; i <= firstDescending; i++) {
                ans[i] = nums[i];
            }
            
            // 오름차순 정렬
            int[] last = Arrays.copyOfRange(nums, firstDescending + 1, nums.length);
            Arrays.sort(last);
        
            for (int i = 0; i < last.length; i++) {
                ans[firstDescending + 1 + i] = last[i];
            }
    
            for (int n : ans) {
                sb.append(n).append(' ');
            }
        } else {
            sb.append(-1);
        }
        
        System.out.println(sb);

        bf.close();
    }
}
