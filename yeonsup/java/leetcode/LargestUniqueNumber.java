package yeonsup.java.leetcode;

import java.util.concurrent.ConcurrentHashMap;

public class LargestUniqueNumber {

    public int largestUniqueNumber(int[] nums) {
        ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();


        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];
            if(map.get(key) != null) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }

        map.forEach((key, value) -> {
            if(value >= 2) map.remove(key);
        });

        return map.keySet().stream().max(Integer::compareTo).orElse(-1);
    }

    public static void main(String[] args) {
        System.out.println(new LargestUniqueNumber().largestUniqueNumber(new int[]{5,7,3,9,4,9,8,3,1}));
        System.out.println(new LargestUniqueNumber().largestUniqueNumber(new int[]{9,9,8,8}));
    }
}
