import java.util.*;

public class Pro_H_Index {
    public int solution(int[] citations) {
        int answer = 0;
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

        //통과
        for (int i = 0; i < array.length; i++) {
            if(array[i] >= i+1) {
                answer += 1;
            }else if(array[i] < i+1) {
                break;
            }
        }
        return answer;
    }

}
