package leetcode.premiumalgo100.hasing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindAnagramMappings {

    public int[] anagramMappings(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }

        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        FindAnagramMappings findAnagramMappings = new FindAnagramMappings();

        int[] ints = findAnagramMappings.anagramMappings(new int[]{12, 28, 46, 32, 50}, new int[]{50, 12, 32, 46, 28});
        System.out.println(Arrays.toString(ints));
        ints = findAnagramMappings.anagramMappings(new int[]{84, 46}, new int[]{84, 46});
        System.out.println(Arrays.toString(ints));
    }
}
