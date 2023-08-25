package leetcode.premiumalgo100.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MaxConsecutiveOnes2 {

    public int findMaxConsecutiveOnes(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                map.put(i, 0);
            }
        }

        if (map.size() == 0) return nums.length;

        map.forEach((key,value) -> {
            int cnt = 1;
            int l = key;
            int r = key;

            for (int i = l - 1; i >= 0; i--) {
                if(nums[i] == 0) break;

                cnt++;
            }

            for (int i = l + 1; i < nums.length; i++) {
                if(nums[i] == 0) break;

                cnt++;
            }

            map.put(key, cnt);
        });


        return map.values().stream().max(Integer::compareTo).get();
    }


    public static void main(String[] args) {
        System.out.println(new MaxConsecutiveOnes2().findMaxConsecutiveOnes(new int[]{1,0,1,1,0}));;
        System.out.println(new MaxConsecutiveOnes2().findMaxConsecutiveOnes(new int[]{1,0,1,1,0,1}));;
        System.out.println(new MaxConsecutiveOnes2().findMaxConsecutiveOnes(new int[]{1, 1}));
        System.out.println(new MaxConsecutiveOnes2().findMaxConsecutiveOnes(new int[]{1, 1}));
    }
}
