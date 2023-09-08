package yeonsup.java.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {

    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> list = new ArrayList<>();
        /*
        0 ~ 99
        1. nums에 없는 missing numbers의 범위 목록을 구하기.
         - lower, upper 범위가 너무 큼
         - nums 반복을 한다.
            - 0 과 nums의 첫번째 요소와 비교한다.
             - 0 과 첫번째 요소가 차이가 있으면 목록에 담는다.
            - 그 다음 요소와 요소 +1 과 비교한다.
            - 요소 + 1 - 요소 가 2이상이면 범위를 목록에 담는다.

        */
        if(nums.length == 0) {
            list.add(List.of(lower, upper));
            return list;
        }

        if(nums[0] - lower > 1) {
            list.add(List.of(lower, nums[0] - 1));
        }

        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i + 1] - nums[i] > 1) {
                list.add(List.of(nums[i] + 1, nums[i + 1] - 1));
            }
        }

        if(upper - nums[nums.length - 1] > 1) {
            list.add(List.of(nums[nums.length - 1] + 1, upper));
        }
        System.out.println(list.toString());
        return list;
    }

    public static void main(String[] args) {
        new MissingRanges().findMissingRanges(new int[]{0,1,3,50,75}, 0, 99);
        new MissingRanges().findMissingRanges(new int[]{3,5,8,50,75}, 0, 99);
        new MissingRanges().findMissingRanges(new int[]{-1}, -1, -1);
    }
}
