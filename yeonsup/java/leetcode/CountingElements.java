package yeonsup.java.leetcode;

public class CountingElements {

    public int countElements(int[] arr) {
        int[] nums = new int[1002];
        int count = 0;

        for (int i : arr) {
            nums[i]++;
        }

        for (int i : arr) {
            if(nums[i] >= 1 && nums[i + 1] >= 1) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(new CountingElements().countElements(new int[]{1,1,3,3,5,5,7,7}));
        System.out.println(new CountingElements().countElements(new int[]{1,2,3}));
        System.out.println(new CountingElements().countElements(new int[]{1000,1,0,999,555}));
    }
}
