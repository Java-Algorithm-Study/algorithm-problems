import java.util.*;

public class Pro_H_Index {
    static public int solution(int[] citations) {
        Integer[] array = new Integer[citations.length];


        for (int i = 0; i < citations.length; i++) {
            array[i] = citations[i];
        }
        Arrays.sort(array, new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return i2 - i1;
            }
        });
        int h = 0;
        boolean flag = true;
        for (int i = 1; i < array.length; i++) {
            if (flag && array[i] != 0) flag = false;
            if (array[i] <= i) {
                h = i;
                break;
            }
        }

        if (h == 0) h = citations.length;
        return flag && array[0] == 0 ? 0 : h;
    }
}
