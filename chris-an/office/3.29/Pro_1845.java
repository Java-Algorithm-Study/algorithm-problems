import java.util.HashSet;

public class Pro_1845 {
    public int solution(int[] nums) {
        int limitCount = nums.length / 2;
        HashSet<Integer> hm = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            hm.add(nums[i]);
        }
        System.out.println(hm.size());
        return limitCount > hm.size() ? hm.size() : limitCount;
    }
}
