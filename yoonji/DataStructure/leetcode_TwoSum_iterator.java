package DataStructure;

/**
 * - 출처 : https://leetcode.com/problems/two-sum/
 * - 시간 복잡도 : O(nlog(n))
 * - 로직 고민
 * 타겟 값을 만드는 두 숫자를 반환한다.
 * 동일 값 중복 사용 x
 * 순서 상관없이 반환
 - 레슨런 : HashMap 혹은 key값으로 자동정렬해주는 TreeMap 사용하고자 했으나 key값에는 중복이 들어가면 안되므로 실패.
 결국 이중 for문으로 간단히 해결하면 되는 문제였다.
 */
public class leetcode_TwoSum_iterator {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (sum == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        leetcode_TwoSum_iterator t = new leetcode_TwoSum_iterator();
        int[] ints = t.twoSum(new int[]{3, 3}, 6);
        for (int i : ints) {
            System.out.println(i);
        }
    }
}
