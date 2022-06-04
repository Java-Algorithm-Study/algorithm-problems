import java.util.*;
import java.io.*;
public class boj_10815_04 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        int M = Integer.parseInt(br.readLine());
        // 탐색
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<M; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (numsContainsCheck(nums, num)) sb.append(1);
            else sb.append(0);
            sb.append(" ");
        }
        System.out.println(sb);
    }
    public static boolean numsContainsCheck(int[] nums, int num) {
        int start = 0;
        int end = nums.length-1;
        while (end >= start) {
            int mid = (start+end) / 2;
            if (num == nums[mid]) {
                return true;
            }
            else if (num < nums[mid]) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return false;
    }
}