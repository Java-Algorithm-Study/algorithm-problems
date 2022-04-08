import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_10973 {
    public static int[] nums;
    public static int N;
    
    public static void swap(int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public static boolean prevPermutations() {
        int i = nums.length - 1;
        while (i > 0 && nums[i - 1] < nums[i]) {
            i--;
        }
        if (i <= 0) return false;
    
        int j = nums.length - 1;
        while (j > 0 && nums[i - 1] < nums[j]) {
            j--;
        }
    
        swap(i - 1, j);
        j = nums.length - 1;
        while (i < j) {
            swap(i, j);
            i++;
            j--;
        }
        return true;
    }
    
    public static void main(String[] args) throws IOException {
        var bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        nums = new int[N];
        var st = new StringTokenizer(bf.readLine(), " ");
    
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        if (prevPermutations()) {
            for (int i = 0; i < N; i++) {
                System.out.print(nums[i] + " ");
            }
        } else {
            System.out.println(-1);
        }
    }
}
