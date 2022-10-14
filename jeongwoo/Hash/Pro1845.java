import java.util.HashSet;
import java.util.Set;

/**
 * [1845] 폰켓몬
 * https://programmers.co.kr/learn/courses/30/lessons/1845
 *
 * -아이디어
 * 1. 폰켓몬의 종류를 set에 넣는다.
 * 2. 종류가 x개, 폰켓몬 총 n마리일 때,
 * 3. x >= n/2 return n/2
 * 4. x < n/2 return x
 *
 */

public class Pro1845 {
    public static void main(String[] args) {
        int[] input = {3, 1, 2, 3};
        System.out.println(solution(input));
    }
    public static int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        
        if (set.size() >= (nums.length/2)) {
            return nums.length/2;
        }
        return set.size();
    }
}
