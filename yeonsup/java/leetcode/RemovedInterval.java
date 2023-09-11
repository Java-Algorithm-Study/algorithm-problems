package yeonsup.java.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemovedInterval {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> result = new ArrayList<>();

        for (int[] interval : intervals) {

            if (interval[0] < toBeRemoved[0]) {
                result.add(Arrays.asList(interval[0], Math.min(interval[1], toBeRemoved[0])));
            }

            if (interval[1] > toBeRemoved[1]) {
                result.add(Arrays.asList(Math.max(interval[0], toBeRemoved[1]), interval[1]));
            }

        }

        return result;
    }

    public static void main(String[] args) {
        new RemovedInterval().removeInterval(new int[][]{{0,5}}, new int[]{2,3});
    }
}
