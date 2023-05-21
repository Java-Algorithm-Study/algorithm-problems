package language.java.Programmers;

import java.util.Arrays;
import java.util.Comparator;

public class Pro_42746 {
    public static void main(String[] args) {
        Integer[] arr2 = {3, 30, 34, 5, 9};
        var sb = new StringBuffer();

        Arrays.sort(arr2, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return Integer.parseInt(String.valueOf(b) + String.valueOf(a)) - Integer.parseInt(String.valueOf(a) + String.valueOf(b));
            }
        });

        for(int i : arr2) {
            sb.append(i);
        }
        System.out.println(sb);
    }
}