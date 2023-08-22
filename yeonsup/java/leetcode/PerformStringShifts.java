package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class PerformStringShifts {
    public String stringShift(String s, int[][] shift) {
        Deque<String> queue = new ArrayDeque<>();
        String[] arr = s.split("");
        for(String str : arr) {
            queue.offer(str);
        }

        for (int[] info: shift) {
            if(info[0] == 1) {
                // right
                for (int i = 0; i < info[1]; i++) {
                    queue.offerFirst(queue.pollLast());
                }
            } else {
                // left
                for (int i = 0; i < info[1]; i++) {
                    queue.offerLast(queue.pollFirst());
                }
            }
        }


        
        return queue.toString().replaceAll("[\\[\\]\\,\\s]", "");
    }

    public static void main(String[] args) {
        System.out.println(new PerformStringShifts().stringShift("abcdefg", new int[][] {{1,1},{1,1},{0,2},{1,3}}));
    }
}
