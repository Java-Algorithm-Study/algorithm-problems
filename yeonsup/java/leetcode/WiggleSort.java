package leetcode;

import java.util.*;

public class WiggleSort {

    void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    public void wiggleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if(i % 2 == 0) {
                if (!(nums[i] <= nums[i + 1])) {
                    swap(nums, i, i + 1);
                }
            } else {
                if (!(nums[i] >= nums[i + 1])) {
                    swap(nums, i, i + 1);
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        new WiggleSort().wiggleSort(new int[] {3,5,2,1,6,4});
        new WiggleSort().wiggleSort(new int[] {6,6,5,6,3,8});
    }
}
