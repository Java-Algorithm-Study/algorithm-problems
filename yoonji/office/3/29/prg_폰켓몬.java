public class prg_폰켓몬 {
}
import java.util.Set;
        import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n: nums) {
            set.add(n);
        }
        int size = set.size();
        // 최소 N/2마리만 선택해야하므로 비교
        int limit = nums.length / 2;
        return Math.min(limit, size);
    }
}
